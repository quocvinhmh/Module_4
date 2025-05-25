<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Chuyen Doi Tien Te (USD sang VND)</h2>
<form action="${pageContext.request.contextPath}/convert" method="post">
    Tỉ giá (VD: 23000): <input type="text" name="rate"><br>
    Số tiền USD: <input type="text" name="usd"><br>
    <input type="submit" value="Convert">
</form>

</body>
</html>