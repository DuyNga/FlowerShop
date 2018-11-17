package controller;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        UserDao userDb = (UserDao)getServletContext().getAttribute("userDb");
        if (userDb.addUser(userName, passWord, fullName, email, address, phone))
        {
            Cookie cookie1 = new Cookie("username", userName);
            cookie1.setMaxAge(3600);
            Cookie cookie2 = new Cookie("password", passWord);
            cookie2.setMaxAge(3600);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            req.getSession().setAttribute("username" , userName);
            req.getSession().setAttribute("username_label", userName);
            resp.sendRedirect("/profile");
        }
        else {
            req.setAttribute("error_register", "Incorrect some information.");
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req,resp);
        }


    }
}