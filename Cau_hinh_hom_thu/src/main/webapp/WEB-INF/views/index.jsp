<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Cấu hình email</title></head>
<body>

<h2>Cấu hình hộp thư</h2>

<form:form action="${pageContext.request.contextPath}/update" method="post" modelAttribute="setting">

    Ngôn ngữ:
    <form:select path="language">
        <form:option value="English"/>
        <form:option value="Vietnamese"/>
    </form:select><br>

    Số trang:
    <form:select path="pageSize">
        <form:option value="5"/>
        <form:option value="10"/>
        <form:option value="15"/>
    </form:select><br>

    Bộ lọc spam:
    <form:checkbox path="spamFilter"/> Bật<br>

    Chữ ký:
    <form:input path="signature"/><br>

    <input type="submit" value="Lưu"/>
</form:form>

</body>
</html>
