package controller;

import dao.UserDao;
import object.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getSession().getAttribute("username").toString();

        UserDao userDb = (UserDao)getServletContext().getAttribute("userDb");
        User user = userDb.getUserByUsername(userName);
        if(user != null)
        {
            req.setAttribute("user", user);
        }
        else
        {
            req.setAttribute("error_profile", "Can not get the user's profile.");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req,resp);
    }
}
