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
    <%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Our great buyers</title>
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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <form action="/buyers"method="post">
        <a class="navbar-brand" href="/main">Двери от Мишки</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </form>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <!--            <li class="nav-item active">-->
            <!--                    <a class="nav-link" href="#">Список товаров <span class="sr-only">(current)</span></a>-->
            <!--            </li>-->
            <li class="nav-item">
                <a class="nav-link" href="/main">Информация о моем магазине </a>
            </li>
            <form action="/basket" method="post">
                <li class="nav-item">
                    <a class="nav-link" href="/basket">Корзина<span class="sr-only">(current)</span></a>
                </li>
            </form>
            <li class="nav-item">
                <a class="nav-link" href="/products">Продукты<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/buyers">Покупатели<span class="sr-only">(current)</span></a>
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

<div>
        <input type="text" id="name" onkeyup="sendUser($('#name').val())">
</div>
<div>
    <table id="table"></table>
</div>

<footer>
    <hr>
    <p style="margin-left: 20px">ВВЕДИТЕ СВОЙ НОМЕР И МЫ ВАМ ПЕРЕЗВОНИМ</p>
    <div>
        <form action="/main" method="post">
            <input type="number" name="number" placeholder="Ваш номер">
            <input type="submit">
        </form>
        <hr>
    </div>
</footer>

</body>
</html>
