<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <style><%@include file="/WEB-INF/pages/css/SignIn.css"%></style>

</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="loginpanel">
    <c:url var="doSignIn" value="/doSignIn"/>
    <form:form action="${doSignIn}" commandName="user">
        <div class="txt">
            <form:input id="user" path="name" type="text" placeholder="Username" required="true"/>
            <label for="user" class="entypo-user"></label>
        </div>
        <div class="txt">
            <form:input id="pwd" path="password" type="password" placeholder="Password" required="true"/>
            <label for="pwd" class="entypo-lock"></label>
        </div>
        <span class="errorMess">${errorMess}</span>
        <div class="buttons">
            <input type="submit" value="Login" />
            <span>
                <a href="<c:url value="/Stamina/signUp"/>" class="register">Signup</a>
            </span>
        </div>
    </form:form>
</div>
</body>
</html>