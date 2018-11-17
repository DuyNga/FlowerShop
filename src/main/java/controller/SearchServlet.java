package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.FlowerDao;
import object.Flower;
import object.SearchItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private FlowerDao flowerDao = new FlowerDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        SearchItem search = mapper.readValue(req.getParameter("searchItem"), SearchItem.class);
        List<Flower> flowers = flowerDao.getFlowerByPrice(Integer.parseInt(search.getFromValue()), Integer.parseInt(search.getToValue()));
        req.setAttribute("flowers", flowers);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
//        requestDispatcher.forward(req, resp);
    }
}
