<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 14.02.2017
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product Category</title>
    <meta charset="utf-8">
    <meta name="description" content="New Product Category">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/adminHeader.jspf" %>
<div class="container">
    <form action="/admin/add/product/category" method="post" enctype="multipart/form-data">

        <input id="productCategoryId" type="hidden" name="id" value="${productCategory.id}"/>

        <div class="form-group">
            <label for="productCategory">Категория товара</label>
            <input type="text" class="form-control" id="productCategory" name="productCategory" value="${productCategory.category}"/>
        </div>

        <div class="form-group">
            <label for="productCategoryPhoto">Выберите фото категории товара</label>
            <input id="productCategoryPhoto" type="file" name="photoCategory" accept="image"/>
        </div>

        <button type="submit" class="btn btn-success">Сохранить</button>
        <a href="/admin" class="btn btn-warning" style="margin-left: 10px;">Отмена</a>
    </form>
</div>
</body>
</html>
