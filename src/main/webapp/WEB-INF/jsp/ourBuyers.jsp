<%--
  Created by IntelliJ IDEA.
  User: under
  Date: 05.12.2020
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
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
    function sendUser(name) {

        let data = {
            "name": name,
        };

        $.ajax({
            type: "POST",
            url: "/buyers",
            data: JSON.stringify(data),
            success: function (response) {
                renderTable(response, $('#table'))
            },
            dataType: "json",
            contentType: "application/json"
        })

    }

    function renderTable(users, table) {
        let innerHtml = '<tr>\n' +
            '               <th>Name</th>' +
            '            </tr>';

        for (let i = 0; i < users.length; i++) {
            innerHtml += '<tr>';
            innerHtml += '  <td>' + users[i]['name'] + '</td>';
            innerHtml += '</tr>';
        }

        table.html(innerHtml);
    }
</script>
<div>
        <input type="text" id="name" onkeyup="sendUser($('#name').val())">
</div>
<div>
    <table id="table"></table>
</div>
</body>
</html>
