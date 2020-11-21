<%--
  Created by IntelliJ IDEA.
  User: under
  Date: 09.11.2020
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Basket</title>
    <script>
        function buy(productId) {

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
        }</script>

</head>
<body>
<span>Basket</span>
<c:forEach items="${productForJSP}" var="product">
    <%int price = 0;%>
    <div class="products">
            <%--        <img id="product-pic" src="${product.doorPicture}">--%>
        <h2 id="products-class">${product.productClass}</h2>
        <p id="products-price" style="max-width: 380px">${product.price}</p>
        <p id="products-type" style="max-width: 380px">${product.type}</p>
<%--        <%price += ${product.price};%>--%>
    </div>
</c:forEach>
<form action="/products?buyed=true"
      method="post">
    <button type="submit" id="btnBuy">Купить</button>
</form>
</body>
</html>
