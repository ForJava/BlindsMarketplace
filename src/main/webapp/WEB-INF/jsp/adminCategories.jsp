<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 14.02.2017
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Categories</title>
    <meta charset="utf-8">
    <meta name="description" content="Product Categories">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/adminHeader.jspf" %>
<div class="container">
    <ul class="nav navbar-nav">
        <li><a href="/admin/add/product/category">Добавить категорию товара</a></li>
    </ul>
    <table id="productCategoryTable" class="table table-hover">
        <thead>
        <tr>
            <th>Категории товаров</th>
            <th>Фото категории</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="productCategory" items="${productCategories}">
            <tr id="${productCategory.id}">
                <td>${productCategory.category}</td>
                <td><img title="Фото" src="/getCategoryImage/${productCategory.id}" width="100" height="100"/></td>
                <td>
                    <a href="/admin/edit/product/category?id=${productCategory.id}" class="btn btn-warning">Править</a>
                    <button type="button" class="btn btn-danger deleteBtn">Удалить</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<%@include file="../jspf/footer.jspf" %>
</html>