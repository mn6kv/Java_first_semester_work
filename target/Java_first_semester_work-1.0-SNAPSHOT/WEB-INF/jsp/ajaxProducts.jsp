<%--
  Created by IntelliJ IDEA.
  User: under
  Date: 19.10.2020
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>

<%--НЕ ИСПОЛЬЗУЕТСЯ--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
</head>
<body>
<script>
    function sendProduct(type) {

        let data = {
            "type" : type,
        };

        $.ajax({
            type: "POST",
            url: "/products",
            data: JSON.stringify(data),
            success: function (response) {
                renderTable(response, $('#table'))
            },
            dataType: "json",
            contentType: "application/json"
        })

    }

    function renderTable(products, table) {
        let innerHtml = '<tr>\n' +
            '               <th>Type</th>' +
            '               <th>Class</th>' +
            '               <th>Price</th>' +
            '            </tr>';

        for (let i = 0; i < products.length; i++) {
            innerHtml += '<tr>';
            innerHtml += '  <td>' + products[i]['type'] + '</td>';
            innerHtml += '  <td>' + products[i]['productClass'] +  '</td>';
            innerHtml += '  <td>' + products[i]['price'] +  '</td>';
            innerHtml += '</tr>';
        }

        table.html(innerHtml);
    }
</script>
<div>
    <input type="text" id="type" onkeyup="sendProduct($('#type').val())">
</div>
<div>
    <table id="table"></table>
</div>
</body>
</html>
