package ru.itis.servlets;

import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.util.UserUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    UserUtil userUtil;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userUtil = (UserUtil) context.getAttribute("userUtil");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        User user = (User) req.getSession().getAttribute("user");
//
//        if (user != null)
//            req.setAttribute("userForJsp", user);
//        System.out.println(user);

        User user = User.fromOptional(userUtil.getUserById((Long) req.getSession().getAttribute("userId")));

        if (user != null)
            req.setAttribute("userForJsp", user);
        System.out.println(user);


        req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
    }
}
