<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stamina</title>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/pages/css/Stamina.css"%></style>
</head>
<body>

<div class="container">
    <%--<img src="WEB-INF/pages/css/resources/typingYelloww.png" />--%>
    <%@include file="Header.jsp"%>
    <div class="content">
        <c:url var="langType" value="/langType"/>
        <form:form action="${langType}" commandName="user">
            <input type="submit" class="start" value="Start">
            <%--<a class="start" href="/type">Start</a>--%>
            <h1 class="lantext">Language:</h1>
            <div class="language">
                <select name="language">
                    <option value="English">English</option>
                    <option value="Russian">Русский</option>
                    <option value="Ukrainian">Українська</option>
                </select>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
