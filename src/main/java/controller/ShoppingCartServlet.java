package controller;

import dao.ShoppingCartDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {
    private ShoppingCartDao shoppingCartDao;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        shoppingCartDao.addFlower(Integer.parseInt(req.getParameter("flowerId")));
        resp.setContentType("text/plain");
        resp.getWriter().write(Integer.toString(shoppingCartDao.getMyCart().size()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/shopping-cart.jsp");
        req.setAttribute("myCart", shoppingCartDao.getMyCart());
        requestDispatcher.forward(req, resp);
    }
}
