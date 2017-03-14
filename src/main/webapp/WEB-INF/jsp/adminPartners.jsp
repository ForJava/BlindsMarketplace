<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Партнеры</title>
    <meta charset="utf-8">
    <meta name="description" content="Partners">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/adminHeader.jspf" %>
<ul class="nav navbar-nav">
    <li><a href="/admin/add/user">Добавить пользователя</a></li>
</ul>
<div class="container">
    <table id="partnerTable" class="table table-hover">
        <thead>
        <tr>
            <th>Логин</th>
            <th>Активность</th>
            <th>Роль</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr id="${user.id}">
                <td>${user.login}</td>
                <td>${user.enabled}</td>
                <td>${user.role.authority}</td>
                <td>
                    <a href="/admin/edit/user?id=${user.id}" class="btn btn-warning">Править</a>
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
