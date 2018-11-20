package controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import object.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getParameter("userNew");
        User userNew = mapper.readValue(req.getParameter("userNew"), User.class);

        UserDao userDb = (UserDao) getServletContext().getAttribute("userDb");
        if (userDb.addUser(userNew.getUserName(), userNew.getPassWord(), userNew.getFullName(), userNew.getEmail(), userNew.getAddress(), userNew.getPhone())) {
            Cookie cookie1 = new Cookie("username", userNew.getUserName());
            cookie1.setMaxAge(3600);
            Cookie cookie2 = new Cookie("password", userNew.getPassWord());
            cookie2.setMaxAge(3600);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            req.getSession().setAttribute("username", userNew.getUserName());
            req.getSession().setAttribute("username_label", userNew.getUserName());
        } else {
            userNew.setUserName("");
        }
        PrintWriter out = resp.getWriter();
        try {
            out.print(mapper.writeValueAsString(userNew));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        }
    }
}
