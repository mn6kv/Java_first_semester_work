package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.*;
import ru.itis.services.BasketService;
import ru.itis.util.ProductsUtil;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private ProductsUtil productsUtil;
    private BasketService basketService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<Door> doors = productsUtil.getDoors();
//        List<Casement> casements = productsUtil.getCasements();
//        List<Partition> partitions = productsUtil.getPartitions();

        List<Product> products = productsUtil.getAllProducts();
        req.setAttribute("productForJSP", products);

//        req.setAttribute("doorForJSP", doors);
//        req.setAttribute("casementForJSP", casements);
//        req.setAttribute("partitionForJSP", partitions);

        req.getRequestDispatcher("/WEB-INF/jsp/products.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.productsUtil = (ProductsUtil) context.getAttribute("productsUtil");
        this.basketService = (BasketService) context.getAttribute("basketService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProductClassRefactor productClassRefactor = objectMapper.readValue(req.getReader(), ProductClassRefactor.class);
//        System.out.println(productClassRefactor);
//        System.out.println(resp.getContentType());
//        Long userId = (Long) req.getSession().getAttribute("userId");
        User user = (User) req.getSession().getAttribute("user");
        Long userId = null;

        if (user != null)
            userId = user.getId();
        System.out.println(user);

        if (userId == null)
            resp.sendRedirect("/signIn");

        else {
            Long productId = Long.valueOf(req.getParameter("id"));
            System.out.println(productId);
            System.out.println(userId);

            basketService.saveById(productId, userId);
            resp.sendRedirect("/products");
        }
    }
}