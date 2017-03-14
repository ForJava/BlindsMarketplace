<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NewProduct</title>
    <meta charset="utf-8">
    <meta name="description" content="NewProduct">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/adminHeader.jspf" %>
<div class="container">
    <form action="/admin/add/product" method="post" enctype="multipart/form-data">

        <input id="productId" type="hidden" name="id" value="${product.id}"/>

        <div class="form-group">
            <label for="productName">Название товара</label>
            <input type="text" class="form-control" id="productName" name="name" value="${product.name}"/>
        </div>

        <div class="form-group">
            <label for="productDescription">Oписание товара</label>
            <input type="text" class="form-control" id="productDescription" name="description"
                   value="${product.description}"/>
        </div>

        <div class="form-group">
            <label for="productPrice">Цена товара</label>
            <input type="text" class="form-control" id="productPrice" name="price" value="${product.price}"/>
        </div>

        <div class="form-group">
            <label for="productPhoto">Фото товара</label>
            <input id="productPhoto" type="file" name="photo" accept="image"/>
        </div>

        <div class="form-group">
            <label for="productCategory">Категория товара</label>
            <select class="form-control" id="productCategory" name="categoryId" style="width: 15%">
                <c:choose>
                    <c:when test="${not empty product.category.id}">
                        <option value="${product.category.id}" selected>${product.category.category}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="0" selected disabled>Выберите категорию товара</option>
                    </c:otherwise>
                </c:choose>
                <c:forEach items="${productCategories}" var="productCategory">
                    <option value="${productCategory.id}">${productCategory.category}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="productSort">Вид товара</label>
            <select class="form-control" id="productSort" name="sortId" style="width: 15%">
                <c:choose>
                    <c:when test="${not empty product.sort.id}">
                        <option value="${product.sort.id}" selected>${product.sort.sort}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="0" selected disabled>Выберите вид товара</option>
                    </c:otherwise>
                </c:choose>
                <c:forEach items="${productSorts}" var="productSort">
                    <option value="${productSort.id}">${productSort.sort}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Сохранить</button>
        <a href="/admin" class="btn btn-warning" style="margin-left: 10px;">Отмена</a>
    </form>
</div>
</body>
<%@include file="../jspf/footer.jspf" %>
</html>
