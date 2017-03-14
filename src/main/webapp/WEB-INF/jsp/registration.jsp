<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 12.01.2017
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="description" content="HomePage">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/header.jspf"%>
<div class="container">
    <h1>Добро пожаловать! Пожалуйста, заполните форму:</h1>
    <form action="/registration/user" class="form-horizontal" method="POST">
        <input type="hidden" name="id" value="${users.id}">
        <div class="form-group">
            <label for="mail" class="col-sm-2 control-label">Ваш е-мейл:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="mail" name="mail" style="width: 530px" placeholder="Е-мейл">
            </div>
        </div>
        <div class="form-group">
            <label for="pass" class="col-sm-2 control-label">Придумайте пароль:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="pass" name="pass" style="width: 530px" placeholder="Пароль">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Зарегистрироваться</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
