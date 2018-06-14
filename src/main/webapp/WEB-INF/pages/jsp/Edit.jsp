<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 20.04.2018
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <style><%@include file="/WEB-INF/pages/css/Edit.css"%></style>
</head>
<body>
<%@include file="Header.jsp"%>
<div class="editpanel">
    <div class="hr">
        <div></div>
        <div>Editing</div>
        <div></div>
    </div>
    <c:url var="edit" value="/user/edit"/>
    <form:form action="${edit}" commandName="user">
        <div class="txt">
            <p>EMail:</p>
            <form:input path="email" size="16" required="true"/>
        </div>
        <div class="txt">
            <p>Username:</p>
            <form:input path="name" size="16" required="true"/>
        </div>
        <%--<button type="submit" class="btn">Edit</button>--%>
        <input type="submit" value="Edit" />
    </form:form>
    <c:url var="editPass" value="/user/editPass"/>
    <form:form action="${editPass}">
        <div class="hr">
            <div></div>
            <div>Change password</div>
            <div></div>
        </div>
        <div class="txt">
            <input type="password" id="password" size="16" name="password" placeholder="Enter password" required=""/>
            <input type="password" id="newPass" size="16" name="newPass" placeholder="Enter new password" required=""/>
        </div>
        <%--<button type="submit" class="btn">Update password</button>--%>
        <input type="submit" value="Update password" />
    </form:form>
</div>
</body>
</html>
