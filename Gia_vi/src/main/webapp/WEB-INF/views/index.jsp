<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Gia Vị</h1>
<form action="${pageContext.request.contextPath}/home" method="post">
        <input type="checkbox" name="condiment" value="Lettuce" /> Xà lách<br/>
        <input type="checkbox" name="condiment" value="Tomato" /> Cà chua<br/>
        <input type="checkbox" name="condiment" value="Mustard" /> Mù tạt<br/>
        <input type="checkbox" name="condiment" value="Sprouts" /> Giá đỗ<br/>
        <input type="checkbox" name="condiment" value="Cheese" /> Phô mai<br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>