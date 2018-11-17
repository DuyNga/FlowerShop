package controller;


import dao.UserDao;
import object.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = "";
        String passWord = "";

        for (Cookie c : req.getCookies())
            if ("username".equals(c.getName()))
                userName = c.getValue();
            else if ("password".equals(c.getName()))
                passWord = c.getValue();

        if (!userName.isEmpty() && !passWord.isEmpty())
        {
            req.setAttribute("username", userName);
            req.setAttribute("password", passWord);
            req.setAttribute("remember", "checked");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");

        UserDao uDao = (UserDao)getServletContext().getAttribute("userDb");

        if(uDao.checkExistUser(userName, passWord)){
            if(req.getParameter("remember") != null && req.getParameter("remember").equals("yes")){
                Cookie cookie1 = new Cookie("username", userName);
                cookie1.setMaxAge(3600);
                Cookie cookie2 = new Cookie("password", passWord);
                cookie2.setMaxAge(3600);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
            req.getSession().setAttribute("username" , userName);

            if(req.getSession().getAttribute("oldServlet") != null){
                String oldServlet = (String) req.getSession().getAttribute("oldServlet");
                req.getSession().setAttribute("oldServlet", null);
                resp.sendRedirect(oldServlet);
            }else{
                resp.sendRedirect("/flower-list");
            }

            req.getSession().setAttribute("username_label", userName);
        }else{
            req.setAttribute("error_login", "Incorrect username or password");
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
        }
    }
}
