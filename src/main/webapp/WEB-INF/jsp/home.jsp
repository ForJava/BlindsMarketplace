<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 27.12.2016
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
    <meta charset="utf-8">
    <meta name="description" content="HomePage">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/header.jspf" %>

WELCOME To HOME PAGE
<div class="container">
    <div class="row">
        <c:forEach var="productSort" items="${sorts}">
            <div class="col-sm-6 col-md-3 text-center">
                <div class="thumbnail" style="height: 360px">
                    <img src="/getSortImage/${productSort.id}" alt="100%x200" style="height: 200px; width: 250px;">
                    <div class="caption">
                        <h3>${productSort.sort}</h3>
                        <p><a href="/product/by/sort/${productSort.id}" class="btn btn-primary" role="button">Просмотреть</a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
<%@include file="../jspf/footer.jspf" %>
</html>
