<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новый пользователь</title>
    <meta charset="utf-8">
    <meta name="description" content="newPartner">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/background-page.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/adminHeader.jspf" %>
<div class="container">
    <form action="/admin/add/user" method="POST">
        <input id="userId" type="hidden" name="id" value="${user.id}"/>

        <div class="form-group">
            <label for="userLogin">Логин</label>
            <input type="text" class="form-control" id="userLogin" name="login" value="${user.login}"/>
        </div>

        <div class="form-group">
            <label for="userPassword">Пароль</label>
            <input type="password" class="form-control" id="userPassword" name="password" value="${user.password}"/>
        </div>

        <div class="form-group">
            <label for="userRole">Роль</label>
            <select class="form-control" id="userRole" name="role.id" style="width: 15%">
                <c:choose>
                    <c:when test="${not empty user.role.id}">
                        <option value="${user.role.id}" selected>${user.role.authority}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="0" selected disabled>Выберите роль</option>
                    </c:otherwise>
                </c:choose>
                <c:forEach items="${roles}" var="role">
                    <option value="${role.id}">${role.authority}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="userEnabled">Активность</label>
            <input type="checkbox" class="form-control" id="userEnabled" name="enabled" value="${user.enabled}"
                   style="width: 18px; height: 18px;"/>
        </div>

        <button type="submit" class="btn btn-success">Сохранить</button>
        <a href="/admin" class="btn btn-warning" style="margin-left: 10px;">Отмена</a>
    </form>
</div>
<%@include file="../jspf/footer.jspf" %>
<script type="text/javascript">
    var enabledCheckBox = $("#userEnabled");
    //    var userLoginInput = $("#userLogin");
    var isUserEditing = $("#userId").val() !== '' ? true : false;

    $(function () {

//        userLoginInput.prop("disabled", isUserEditing);

        if (enabledCheckBox.val()) {
            enabledCheckBox.prop("checked", true);
        }

        enabledCheckBox.click(function () {
            if ($(this).is(':checked')) {
                enabledCheckBox.val(true);
            } else {
                enabledCheckBox.val(false);
            }
        })

    });
</script>
</body>
</html>
