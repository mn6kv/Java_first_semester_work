<%@ page import="ru.itis.models.User" %>
<%@ page import="ru.itis.dto.UserDto" %><%--
  Created by IntelliJ IDEA.
  User: under
  Date: 09.11.2020
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

<% User user = (User) request.getAttribute("userForJsp"); %>
<p>$<%user.getName();%></p>
<p>$<%user.getEmail();%></p>

</body>
</html>