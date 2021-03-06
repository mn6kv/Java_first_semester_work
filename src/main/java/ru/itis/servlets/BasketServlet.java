package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.services.BasketService;
import ru.itis.util.UserUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

    BasketService basketService;
    UserUtil userUtil;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        basketService = (BasketService) context.getAttribute("basketService");
        userUtil = (UserUtil) context.getAttribute("userUtil");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in Basket");

        User user = (User) req.getSession().getAttribute("user");
        Long user_id = null;

        System.out.println("user" + user);

        if (user != null) {
            user_id = user.getId();
            List<Product> productsInBasket = basketService.getForUser(user_id);
            System.out.println("productsInBasket\n" + productsInBasket);
            req.setAttribute("productForJSP", productsInBasket);
        }

        System.out.println(user);

        req.getRequestDispatcher("/WEB-INF/jsp/basket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bought = req.getParameter("bought");

        User user = (User) req.getSession().getAttribute("user");
        System.out.println("doPost" + user);

        if (bought.equals("true")) {
            basketService.deleteForUser(user.getId());
            userUtil.addUserToBuyers(user);
            resp.sendRedirect("/basket");
        }
    }
}
