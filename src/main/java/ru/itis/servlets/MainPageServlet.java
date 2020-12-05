package ru.itis.servlets;

import ru.itis.util.CallsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    CallsUtil callsUtil;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        callsUtil = (CallsUtil) servletContext.getAttribute("callsUtil");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/html/home_page.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        System.out.println(CallsUtil.checkNumber(number));
        if (CallsUtil.checkNumber(number)) {
            callsUtil.addNumber(number);
            resp.sendRedirect("/main");
        }
    }
}
