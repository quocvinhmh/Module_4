<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Máy tính cá nhân</h1>
<form action="${pageContext.request.contextPath}/calculate" method="POST">
    <input name="x" type="number" >
    <input name="y" type="number" >
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(X)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
</form>
<c:if test="${not empty result}">
    <p>${result}</p>
</c:if>
</body>
</html>