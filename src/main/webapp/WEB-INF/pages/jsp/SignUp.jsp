<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 14.04.2018
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <style><%@include file="/WEB-INF/pages/css/SignUp.css"%></style>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="user">
    <!--<div class="image"><img src="../../Resourses/login.png"></div>-->

    <c:url var="doSignUp" value="/doSignUp"/>
    <form:form action="${doSignUp}" commandName="user">
        <c:if test="${!user.current}">
            <div class="hr">
                <div></div>
                <div>Sign Up</div>
                <div></div>
            </div>
            <div class="txt">
                <p>Email:</p>
                <form:input path="email" placeholder="Enter Email*" required="true"/>
            </div>
            <span class="errorMess">${errorEmail}</span>
            <div class="txt">
                <p>Username:</p>
                <form:input path="name" placeholder="Enter Username*" required="true"/>
            </div>
            <span class="errorMess">${errorName}</span>
            <div class="txt">
                <p id="password">Password:</p>
                <form:input type="password" path="password" placeholder="Enter Password*" required="true"/>
            </div>
            <form:input type="hidden" value="true" path="current"/>
            <div class="buttons">
                <input type="submit" value="Sign Up" />
                <%--<button type="submit" class="btn">Sign Up</button>--%>
            </div>

        </c:if>
        <c:if test="${user.current}">
            <div class="hr">
                <div></div>
                <div>Profile</div>
                <div></div>
            </div>
            <div class="txt">
                <p id="email">Email:</p>
                <p class="value">${user.email}</p>
            </div>
            <div class="txt">
                <p id="username">Username:</p>
                <p class="value">${user.name}</p>
            </div>
            <div class="txt">
                <p id="record">Record:</p>
                <p class="value">${user.record}</p>
            </div>
            <div class="buttons">
                <a id="edit" href="<c:url value='/Stamina/edit/${user.id}'/>" class="edit">Edit</a>
                <a id="loguot" href="<c:url value='/user/logout/${user.id}'/>" class="logout">Log out</a>
            </div>
        </c:if>
    </form:form>
</div>
</body>
</html>
