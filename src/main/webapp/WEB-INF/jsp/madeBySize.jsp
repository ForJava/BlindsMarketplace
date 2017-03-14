<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Жалюзи по размерам</title>
    <meta charset="utf-8">
    <meta name="description" content="MadeBySize">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/header.jspf" %>
<div class="container">
    <div class="row">
        <c:forEach var="category" items="${categories}">
            <div class="col-sm-6 col-md-3 text-center">
                <div class="thumbnail" style="height: 360px">
                    <img src="/getCategoryImage/${category.id}" alt="100%x200" style="height: 200px; width: 250px;">
                    <div class="caption">
                        <h3>${category.category}</h3>
                        <p><a href="/order/form/${category.id}" class="btn btn-primary" role="button">Заказать</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
<%@include file="../jspf/footer.jspf" %>
</html>
