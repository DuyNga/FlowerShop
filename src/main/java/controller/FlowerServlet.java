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

@WebServlet("/flower")
public class FlowerServlet extends HttpServlet {
    private FlowerDao flowerDao = new FlowerDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramName = "id";
        String paramValue = request.getParameter(paramName);
        Flower product = flowerDao.getFlowerById(Integer.parseInt(paramValue));
        if (product != null){
            request.setAttribute("flower", product);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/flower.jsp");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("error_flower", "Incorrect flower");
            request.getRequestDispatcher("/WEB-INF/jsp/flower.jsp").forward(request,response);
        }
    }
}
