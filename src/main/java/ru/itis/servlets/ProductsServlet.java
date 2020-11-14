package ru.itis.servlets;

import ru.itis.models.Casement;
import ru.itis.models.Door;
import ru.itis.models.Partition;
import ru.itis.models.Product;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Door> doors = productsUtil.getDoors();
        List<Casement> casements = productsUtil.getCasements();
        List<Partition> partitions = productsUtil.getPartitions();

        req.setAttribute("doorForJSP", doors);
        req.setAttribute("casementForJSP", casements);
        req.setAttribute("partitionForJSP", partitions);

        req.getRequestDispatcher("/WEB-INF/jsp/products.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        this.productsUtil = (ProductsUtil) context.getAttribute("productsUtil");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
