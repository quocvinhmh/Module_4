<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Từ điển Anh-Việt</title></head>
<body>
<h2>Nhập từ tiếng Anh để dịch:</h2>
<form action="translate" method="post">
    <input type="text" name="word" required />
    <input type="submit" value="Dịch" />
</form>

<c:if test="${not empty result}">
    <p>Kết quả: ${result}</p>
</c:if>
</body>
</html>
