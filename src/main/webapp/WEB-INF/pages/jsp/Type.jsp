<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 14.05.2018
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Typing</title>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/pages/css/Type.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="Header.jsp"%>
    <div class="typepanel">
        <%--<script type="text/javascript" src="../../resources/Type.js"></script>--%>
        <input type="text" id="expected" name="test" value="${text}">
        <input type="text" id="typed" name="test2" onkeyup="check()">
        <%--<button onclick="test()">hello</button>--%>
        <script>
            function check(){
                let a = 'a';
                let b = 'b';
                let p = ' ';
                let expected = document.getElementById('expected');
                let typed = document.getElementById('typed');

                if(expected.value[12] === typed.value.substr(0,1)){
                    expected.value = expected.value.substr(1,expected.value.length);
                    typed.value = '';
                }

            }
        </script>

    </div>
</div>
</body>
</html>
