package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.NameRefactorer;
import ru.itis.models.User;
import ru.itis.util.UserUtil;

import javax.naming.Name;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/buyers")
public class BuyersServlet extends HttpServlet {

    private UserUtil userUtil;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.userUtil = (UserUtil) context.getAttribute("userUtil");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/ourBuyers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("\nbuyers doPost\n");

        NameRefactorer name = objectMapper.readValue(req.getReader(), NameRefactorer.class);
        System.out.println("name" + name);
        List<User> allUsers = userUtil.getBuyers();
        List<User> usersForName = searchByString(name.getName(), allUsers);

        String usersAsJson = objectMapper.writeValueAsString(usersForName);
        System.out.println("usersAsJson: " + usersAsJson);
        resp.setContentType("application/json");
        resp.getWriter().println(usersAsJson);
    }

    private static List<User> searchByString(String subString, List<User> users) {
        List<User> out = new ArrayList<>();
        for (User user : users)
            if (startStringEquals(user.getName(), subString))
                out.add(user);
        return out;
    }

    private static boolean startStringEquals(String name, String substring) {
        if (name.length() < substring.length())
            return false;
        for (int i = 0; i < substring.length(); i++)
            if (name.charAt(i) != substring.charAt(i))
                return false;
        return true;
    }
}
