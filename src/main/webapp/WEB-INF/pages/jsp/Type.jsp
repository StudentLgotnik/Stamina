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
<script>
    let started = Boolean(false);
    let charPrint = 0;

    function end(){
        started = false;
        document.getElementById('score').value = charPrint;
        document.typeform.submit();
        alert('Result: ' + charPrint);
        charPrint = 0;
        let expected = document.getElementById('expected');
        expected.value = '${text}';
    }

    document.addEventListener('keydown', function(event) {
        let x = event.keyCode;
        if (started) {
            // alert('Code: ' + x + ' Value: '+ String.fromCharCode(x) + ' Expected: ' + document.getElementById('expected').value[13].toUpperCase());
            let expected = document.getElementById('expected');
            if (expected.value[13].toUpperCase() === String.fromCharCode(x)) {
                expected.value = expected.value.substr(1, expected.value.length);
                charPrint++;
            }
            else alert('Wrong! ' + charPrint)
        }
        if (x === 32 && !started){
            started = true;
            setTimeout(end, 60000);
        }

    });
</script>
<body>
<%@include file="Header.jsp"%>
<div class="typepanel">
    <input type="text" id="expected" name="test" value="${text}">
    <c:url var="type" value="/type"/>
    <form:form name="typeform" action="${type}" commandName="type">
        <form:input id="score" type="hidden" path="score" value=""/>
        <form:input id="land" type="hidden" path="language" value="${lang}"/>
    </form:form>
</div>
</body>
</html>
