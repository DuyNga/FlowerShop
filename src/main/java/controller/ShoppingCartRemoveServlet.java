package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ShoppingCartDao;
import mapper.FlowerMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shopping-cart/remove")
public class ShoppingCartRemoveServlet extends HttpServlet {
    private ShoppingCartDao shoppingCartDao;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        if (session != null && session.getAttribute("shoppingCartDao") != null) {
            shoppingCartDao = (ShoppingCartDao) session.getAttribute("shoppingCartDao");
        } else {
            shoppingCartDao = new ShoppingCartDao();
            session.setAttribute("shoppingCartDao", shoppingCartDao);
        }
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<FlowerMapper> flowers = mapper.readValue(req.getParameter("flowers"),
                mapper.getTypeFactory().constructCollectionType(List.class, FlowerMapper.class));
        System.out.println("Removed Items: " + flowers.toString());
        List<FlowerMapper> removedFlowers = new ArrayList<>();
        for (FlowerMapper p : flowers) {
            shoppingCartDao.removeFlower(p.getId());
            FlowerMapper removedItem = new FlowerMapper();
            removedItem.setId(p.getId());
            removedFlowers.add(removedItem);
        }
        req.getSession().setAttribute("numItems", shoppingCartDao.getMyCart().size());
        writer.print(mapper.writeValueAsString(removedFlowers));
        System.out.println("flowers: " + flowers.size());
    }
}
