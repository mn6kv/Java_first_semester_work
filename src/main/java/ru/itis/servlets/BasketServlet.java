package ru.itis.servlets;

import org.apache.commons.logging.Log;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.services.BasketService;

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

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        basketService = (BasketService) context.getAttribute("basketService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/basket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer userId = (Integer) req.getSession().getAttribute("userId");
//        System.out.println(userId);
//        List<Product> productsInBasket = basketService.getForUser(userId);

        User user = (User) req.getSession().getAttribute("user");
        Long userId = null;

        if (user != null) {
            userId = user.getId();
            List<Product> productsInBasket = basketService.getForUser(userId);
            req.setAttribute("productForJSP", productsInBasket);
        }

        System.out.println(user);

    }
}
