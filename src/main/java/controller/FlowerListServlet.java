package controller;

import dao.FlowerDao;
import object.Flower;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/flower-list",""})
public class FlowerListServlet extends HttpServlet {
    private FlowerDao flowerDao = new FlowerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flower> flowers = flowerDao.getFlowerList();
        Flower f = flowerDao.getFlowerById(12);
        req.setAttribute("flowers", flowers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
