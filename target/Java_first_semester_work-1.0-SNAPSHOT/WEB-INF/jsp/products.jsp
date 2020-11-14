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

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style/css">

    <title>Products</title>
</head>
<body>
<center>
<span>Products</span>
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

    <c:forEach items="${news}" var="news">
    <div class="news">
        <img id="news-pic" src="${news.newsPicture}">
        <h2 id="news-title">${news.title}</h2>
        <p id="news-content" style="max-width: 380px">${news.mainText}</p>
    </div>
    </c:forEach>

</body>
</html>
