<%--
  Created by IntelliJ IDEA.
  User: under
  Date: 05.11.2020
  Time: 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <form action="/main"method="post">
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
            <li class="nav-item">
                <a class="nav-link" href="/buyers">Покупатели<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form action="/signUp" method="post">
            <li class="nav-item active">
                <a class="nav-link" href="/signUp">Зарегистрироваться<span class="sr-only">(current)</span></a>
            </li>
        </form>
    </div>
</nav>

<form action="/signIn" method="post">
    <input type="text" name="email" placeholder="Email">
    <br>
    <input type="password" name="password" placeholder="Password">
    <br>
    <input type="submit">
</form>
</body>
</html>
