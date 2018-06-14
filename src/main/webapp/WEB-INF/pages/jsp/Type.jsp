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
<%@include file="Header.jsp"%>
<div class="typepanel">
    <h1 id="startBtn">Click space to start</h1>
    <div id="typeText">
        <input type="text" id="typed" name="test" value="" readonly>
        <input type="text" id="expected" name="test" value="${text}" readonly>
        <div class="vline" id="vline"></div>
    </div>
    <h1 id="result"></h1>
    <%--<h1 id="result"></h1>--%>
</div>
<c:url var="type" value="/doType"/>
<form:form name="typeform" action="${type}" commandName="type">
    <form:input id="score" type="hidden" path="score" value=""/>
    <form:input id="lang" type="hidden" path="language" value="${lang}"/>
</form:form>
</body>
<script>
    let started = Boolean(false);
    let charPrint = 0;

    function end(){
        started = false;
        document.getElementById('score').value = charPrint;
        document.typeform.submit();
        alert('Result: ' + charPrint);
        let expected = document.getElementById('expected');
        let result = document.getElementById('result');
        expected.value = '${text}';
        // result.innerHTML = "Result: " + charPrint + " characters per minute";
        charPrint = 0;
        submit();
    }


    document.addEventListener('keypress', function(event) {
        let x = event.keyCode;
        let expected = document.getElementById('expected');
        let typed = document.getElementById('typed');
        if (started) {
            // alert('Code: ' + x + ' Value: '+ String.fromCharCode(x) + ' Expected: ' + document.getElementById('expected').value[0]);
            if (expected.value[0] === String.fromCharCode(x)) {
                expected.value = expected.value.substr(1, expected.value.length);
                typed.value += String.fromCharCode(x).toLowerCase();
                if (typed.value.length > 16){
                    typed.value = typed.value.substr(1, typed.value.length);
                }
                charPrint++;
            }
            else alert('Wrong! ' + charPrint)
        }
        let startBtn = document.getElementById('startBtn');
        // let vline = document.getElementById('vline');
        let typeText = document.getElementById('typeText');
        let result = document.getElementById('result');
        if (x === 32 && !started){
            // result.innerHTML = '';
            startBtn.innerHTML = '';
            typeText.style.marginTop = "16px";
            started = true;
            setTimeout(end, 60000);
        }

    });
</script>
</html>
