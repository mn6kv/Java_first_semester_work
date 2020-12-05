<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.itis.models.*" %><%--
  Created by IntelliJ IDEA.
  User: under
  Date: 11.11.2020
  Time: 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="style/css/products_page.css">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>

    <%--    <script src="script/products.js"></script>--%>

    <script>
        function toBasket(productClass, type) {

            let data = {
                "productClass": productClass,
                "type": type
            };

            $.ajax({
                type: "POST",
                url: "/products",
                data: JSON.stringify(data),
                // success: function (response) {
                //     renderTable(response, $('#table'))
                // },
                success: function (response) {
                    console.log(response)
                },
                dataType: "json",
                contentType: "application/json"
            });
        };</script>

    <%--    <script>--%>
    <%--                function toBasket(productClass, type) {--%>

    <%--                $.ajax({--%>
    <%--                    type: "POST",--%>
    <%--                    url: "/products",--%>
    <%--                    data: {--%>
    <%--                        param1: productClass,--%>
    <%--                        param2: type--%>
    <%--                    },--%>
    <%--                    dataType: "json",--%>
    <%--                    contentType: "application/json"--%>
    <%--                });--%>
    <%--                }--%>
    <%--    </script>--%>

    <%--    <title>Products</title>--%>
</head>
<%--<body>--%>
<%--<center>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>Type</th>--%>
<%--        <th>Product</th>--%>
<%--        <th>Price</th>--%>
<%--    </tr>--%>

<%--    <% List<Door> doors = (List<Door>) request.getAttribute("door");--%>
<%--    <% List<Casement> casements = (List<Casement>) request.getAttribute("casement");--%>
<%--    <% List<Partition> partitions = (List<Partition>) request.getAttribute("partition");--%>

<%--    Integer generalSize = doors.size() + casements.size() + partitions.size();--%>
<%--    for (int i = 0; i < doors.size(); i++) {%>--%>
<%--    <tr>--%>
<%--        <td><%=doors.get(i).getProductClass()%></>--%>
<%--        <td><%=doors.get(i).getPrice()%></>--%>

<%--        <td><%=casements.get(i).getProductClass()%></>--%>
<%--        <td><%=casements.get(i).getPrice()%></>--%>

<%--        <td><%=partitions.get(i).getProductClass()%></>--%>
<%--        <td><%=partitions.get(i).getPrice()%></>--%>
<%--    </tr>--%>
<%--        <%}%>--%>


<%--&lt;%&ndash;    <% List<Product> products = (List<Product>)request.getAttribute("productsForJSP");&ndash;%&gt;--%>
<%--&lt;%&ndash;        for (int i = 0; i < products.size(); i++){%>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><%=products.get(i).getProductClass()%></>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><%=products.get(i).getPrice()%></>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <%}%>&ndash;%&gt;--%>

<%--</table>--%>
<%--</center>--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <form action="/main" method="post">
        <a class="navbar-brand" href="#">Двери от Мишки</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </form>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <!--            <li class="nav-item active">-->
            <!--                    <a class="nav-link" href="#">Список товаров <span class="sr-only">(current)</span></a>-->
            <!--            </li>-->
            <li class="nav-item">
                <a class="nav-link" href="">Информация о моем магазине </a>
            </li>
            <form action="/basket" method="post">
                <li class="nav-item">
                    <a class="nav-link" href="/basket">Корзина<span class="sr-only">(current)</span></a>
                </li>
            </form>
            <li class="nav-item">
                <a class="nav-link active" href="/products">Продукты<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form action="/signIn" method="post">
            <li class="nav-item active">
                <a class="nav-link" href="/signIn">Войти<span class="sr-only">(current)</span></a>
            </li>
        </form>
        <form action="/signUp" method="post">
            <li class="nav-item active">
                <a class="nav-link" href="/signUp">Зарегистрироваться<span class="sr-only">(current)</span></a>
            </li>
        </form>
    </div>
</nav>

<c:forEach items="${productForJSP}" var="product">
    <div class="products">
            <%--        <img id="product-pic" src="${product.doorPicture}">--%>
        <h2 id="products-class">${product.productClass}</h2>
        <p id="products-price" style="max-width: 380px">${product.price}</p>
        <p id="products-type" style="max-width: 380px">${product.type}</p>
        <form action="/products?productClass=${product.productClass}&type=${product.type}&id=${product.id}"
              method="post">
            <button type="submit" id="btnBuy">В корзину</button>
        </form>
            <%--        <input type="button" id="btnBuy" onclick="toBasket($('#products-class').val(), $('#products-type').val())">--%>
    </div>
</c:forEach>
<footer>
    <hr>
    <p style="margin-left: 20px">ВВЕДИТЕ СВОЙ НОМЕР И МЫ ВАМ ПЕРЕЗВОНИМ</p>
    <div>
        <form action="/products" method="post">
            <input type="text" name="number" placeholder="Ваш номер">
            <input type="submit">
        </form>
        <hr>
    </div>
</footer>
</body>
</html>
