<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Готовые жалюзи</title>
    <meta charset="utf-8">
    <meta name="description" content="ReadyMade">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/header.jspf" %>
<div class="row">
    <c:forEach var="product" items="${products}">
    <div class="col-sm-6 col-md-3 text-center">
        <div class="thumbnail" style="height: 360px">
                <img src="/getProductImage/${product.id}" alt="100%x200" style="height: 200px; width: 250px;">
                <div class="caption">
                    <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>${product.price}</p>
            <p><a href="#" class="btn btn-primary" role="button">Заказать</a></p>
        </div>
    </div>
</div>
</c:forEach>
</div>
</body>
<%@include file="../jspf/footer.jspf" %>
</html>
