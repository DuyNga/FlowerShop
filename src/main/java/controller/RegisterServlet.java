package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    ObjectMapper mapper = new ObjectMapper();

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
//        String json = req.getParameter("userNew");
//        User userNew = mapper.readValue(req.getParameter("userNew"), User.class);

        UserDao userDb = (UserDao) getServletContext().getAttribute("userDb");
        if (userDb.addUser(userName, passWord, fullName, email, address, phone)) {
            //if (userDb.addUser(userNew.getUserName(), userNew.getPassWord(), userNew.getFullName(), userNew.getEmail(), userNew.getAddress(), userNew.getPhone())) {
            Cookie cookie1 = new Cookie("username", userName);
            cookie1.setMaxAge(3600);
            Cookie cookie2 = new Cookie("password", passWord);
            cookie2.setMaxAge(3600);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            req.getSession().setAttribute("username", userName);
            req.getSession().setAttribute("username_label", userName);
            resp.sendRedirect("/profile");
        } else {
            req.setAttribute("error_register", "This username is exists.");
            req.setAttribute("username", userName);
            req.setAttribute("email", email);
            req.setAttribute("fullname", fullName);
            req.setAttribute("address", address);
            req.setAttribute("phone", phone);
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
        }
    }
}
