<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <meta charset="utf-8">
    <meta name="description" content="Products">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
    <link href="/resources/css/modal-style.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/adminHeader.jspf" %>
<div class="container">
    <ul class="nav navbar-nav">
        <li><a href="/admin/add/product">Добавить продукт</a></li>
    </ul>
    <table id="productsTable" class="table table-hover">
        <thead>
        <tr>
            <th>Название</th>
            <th>Описание</th>
            <th>Цена</th>
            <th>Категория товара</th>
            <th>Вид товара</th>
            <th>Фото</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
        <tr id="${product.id}">
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.category.category}</td>
            <td>${product.sort.sort}</td>
            <td>
                <a href="#win5"><img title="Фото" src="/getProductImage/${product.id}" width="100" height="100"/></a>
            </td>
            <td>
                <a href="/admin/edit/product?id=${product.id}" class="btn btn-warning">Править</a>
                <button type="button" class="btn btn-danger deleteBtn">Удалить</button>
            </td>
            </c:forEach>
        </tbody>
    </table>
    <a href="#x" class="overlay" id="win5"></a>
    <div class="popup">
        <img class="is-image" title="Фото" src="/getProductImage/${product.id}"/>
        <a class="close" title="Закрыть" href="#close"></a>
    </div>
</div>
</div>

</body>
<%@include file="../jspf/footer.jspf" %>
</html>
