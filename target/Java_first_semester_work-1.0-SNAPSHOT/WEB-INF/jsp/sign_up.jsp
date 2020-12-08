<%--
  Created by IntelliJ IDEA.
  User: under
  Date: 04.11.2020
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="style/css/products_page.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
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
        <form action="/signIn" method="post">
            <li class="nav-item active">
                <a class="nav-link" href="/signIn">Войти<span class="sr-only">(current)</span></a>
            </li>
        </form>
    </div>
</nav>

<%--<script>--%>
<%--    function checkEmail() {--%>
<%--        const email = document.getElementById("email")--%>
<%--        const xhr = new XMLHttpRequest()--%>

<%--        if (email.value.length > 4) {--%>
<%--            document.getElementById("email").disable = false--%>
<%--            document.getElementById("email-error").style.display = "none"--%>
<%--        } else {--%>
<%--            document.getElementById("email").disable = true--%>
<%--            document.getElementById("email-error").style.display = "block"--%>
<%--        }--%>

<%--        xhr.open("GET", "http://localhost:8080//emailCheck?email=" + email.value, false)--%>
<%--        xhr.send()--%>

<%--        const result = xhr.responseText--%>

<%--        if (result === "true") {--%>
<%--            document.getElementById("email").disable = false--%>
<%--            document.getElementById("email-error").style.display = "none"--%>
<%--        }--%>

<%--        if (xhr.status !== 200) {--%>
<%--            document.getElementById("email").disable = true--%>
<%--            document.getElementById("email-error").style.display = "block"--%>
<%--        } else {--%>
<%--            if (result === "false") {--%>
<%--                document.getElementById("email").disable = true--%>
<%--                document.getElementById("email-error").style.display = "block"--%>
<%--            }--%>
<%--        }--%>
<%--    }--%>
<%--// </script>--%>
<form action="/signUp" method="post">
    <input type="email" name="email" placeholder="Email">
    <br>
    <%--    <span class="error" id="email-error">Почтовый адрес уже занят</span>--%>
    <input type="text" name="name" placeholder="Name">
    <br>
    <input type="password" name="password" placeholder="Password">
    <br>
    <input type="submit">
    <span class="error" id="emailExists">${emailExist}</span>
</form>

<%--<style>--%>
<%--    .form-group{--%>
<%--        margin-bottom: 15px;--%>
<%--    }--%>
<%--    label{--%>
<%--        margin-bottom: 15px;--%>
<%--    }--%>
<%--    input,--%>
<%--    input::-webkit-input-placeholder {--%>
<%--        font-size: 11px;--%>
<%--        padding-top: 3px;--%>
<%--    }--%>
<%--    .form-control {--%>
<%--        height: auto!important;--%>
<%--        padding: 8px 12px !important;--%>
<%--    }--%>
<%--    .input-group {--%>
<%--        box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.21)!important;--%>
<%--    }--%>
<%--    #button {--%>
<%--        border: 1px solid #ccc;--%>
<%--        margin-top: 28px;--%>
<%--        padding: 6px 12px;--%>
<%--        color: #666;--%>
<%--        text-shadow: 0 1px #fff;--%>
<%--        cursor: pointer;--%>
<%--        border-radius: 3px 3px;--%>
<%--        box-shadow: 0 1px #fff inset, 0 1px #ddd;--%>
<%--        background: #f5f5f5;--%>
<%--        background: -moz-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);--%>
<%--        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f5f5f5), color-stop(100%, #eeeeee));--%>
<%--        background: -webkit-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);--%>
<%--        background: -o-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);--%>
<%--        background: -ms-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);--%>
<%--        background: linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);--%>
<%--        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f5f5f5', endColorstr='#eeeeee', GradientType=0);--%>
<%--    }--%>
<%--    .main-form{--%>
<%--        margin-top: 30px;--%>
<%--        margin: 0 auto;--%>
<%--        max-width: 400px;--%>
<%--        padding: 10px 40px;--%>
<%--        background:#009edf;--%>
<%--        color: #FFF;--%>
<%--        text-shadow: none;--%>
<%--        box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.31);--%>
<%--    }--%>
<%--    span.input-group-addon i {--%>
<%--        color: #009edf;--%>
<%--        font-size: 17px;--%>
<%--    }--%>
<%--    .login-button{--%>
<%--        margin-top: 5px;--%>
<%--    }--%>
<%--</style>--%>

<%--<form action="/signUp" method="post">--%>
<%--<div class="container">--%>
<%--    <div class="row main-form">--%>
<%--        <form  class="" method="post" action="/signUp">--%>

<%--            <div class="form-group">--%>
<%--                <label for="email" class="cols-sm-2 control-label">Your Email</label>--%>
<%--                <div class="cols-sm-10">--%>
<%--                    <div class="input-group">--%>
<%--                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>--%>
<%--                        <input type="text" class="form-control" name="email" id="email" placeholder="Enter your Email"/>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="form-group">--%>
<%--                <label for="name" class="cols-sm-2 control-label">Username</label>--%>
<%--                <div class="cols-sm-10">--%>
<%--                    <div class="input-group">--%>
<%--                        <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>--%>
<%--                        <input type="text" class="form-control" name="name" id="name" placeholder="Enter your Username"/>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="form-group">--%>
<%--                <label for="password" class="cols-sm-2 control-label">Password</label>--%>
<%--                <div class="cols-sm-10">--%>
<%--                    <div class="input-group">--%>
<%--                        <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>--%>
<%--                        <input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password"/>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="form-group ">--%>
<%--                <a href="#" target="_blank" type="button" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</a>--%>
<%--            </div>--%>

<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</form>--%>
</body>
</html>
