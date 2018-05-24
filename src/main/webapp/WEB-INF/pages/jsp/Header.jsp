<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 19.04.2018
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/pages/css/Header.css"%></style>
</head>
<body>
<div class="header">
    <h2 class="logo">
        <a id="home" href="<c:url value="/Stamina"/>">Stamina</a>
    </h2>
    <c:if test="${!user.current}">
        <a class="signIn" href="<c:url value="/signIn"/>">Sign in</a>
    </c:if>
    <c:if test="${user.current}">
        <c:if test="${user.name.length() > 5}">
            <a class="signUp" href="<c:url value="/signUp"/>">${user.name.substring(0, 5)}.</a>
        </c:if>
        <c:if test="${user.name.length() <= 5}">
            <a class="signUp" href="<c:url value="/signUp"/>">${user.name}</a>
        </c:if>
    </c:if>
</div>
</body>
</html>
