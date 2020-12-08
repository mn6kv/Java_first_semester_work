package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.*;
import ru.itis.services.BasketService;
import ru.itis.util.CallsUtil;
import ru.itis.util.ProductsUtil;
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

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private ProductsUtil productsUtil;
    private BasketService basketService;
    private CallsUtil callsUtil;
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
        this.callsUtil = (CallsUtil) context.getAttribute("callsUtil");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProductClassRefactor productClassRefactor = objectMapper.readValue(req.getReader(), ProductClassRefactor.class);
//        System.out.println(productClassRefactor);
//        System.out.println(resp.getContentType());
//        Long user_id = (Long) req.getSession().getAttribute("user_id");

//        TypeRefactorer typeRefactorer = objectMapper.readValue(req.getReader(), TypeRefactorer.class);
//        System.out.println(typeRefactorer);

//        List<Product> productsForType = productsUtil.getByTypeRegex("'^" + typeRefactorer.getType() + "[a-z]*'");
//        System.out.println("productsByRegex" + productsForType);
//        String productsAsJson = objectMapper.writeValueAsString(productsForType);
//        resp.setContentType("application/json");
//        resp.getWriter().println(productsAsJson);
//        System.out.println("productsasJson" + productsAsJson);

//        List<Product> products = productsUtil.getAllProducts();
//        String productsAsJson = objectMapper.writeValueAsString(products);
//        resp.setContentType("application/json");
//        resp.getWriter().println(productsAsJson);
//        System.out.println("prAsJson" + productsAsJson);


//        String number = req.getParameter("number");
//        if (number != null && CallsUtil.checkNumber(number)) {
//            callsUtil.addNumber(number);
//        }

        User user = (User) req.getSession().getAttribute("user");
        Long user_id = null;

        if (user != null)
            user_id = user.getId();
        System.out.println("user" + user);

        if (user_id == null)
            resp.sendRedirect("/signIn");

        else {
            Long product_id = Long.valueOf(req.getParameter("id"));
            System.out.println(product_id);
            System.out.println(user_id);

            basketService.saveById(product_id, user_id);
            resp.sendRedirect("/products");
        }
    }

//    public List<Product> searchBy(String subString, List<Product> products) {
//        return productsUtil.getByTypeRegex("'^" + subString + "[a-z]*'");
//    }
//
//    private static boolean startStringEquals(String type, String substring) {
//        if (type.length() < substring.length())
//            return false;
//        for (int i = 0; i < substring.length(); i++)
//            if (type.charAt(i) != substring.charAt(i))
//                return false;
//        return true;
//    }
}