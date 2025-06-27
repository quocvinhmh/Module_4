<%--
  Created by IntelliJ IDEA.
  User: VINH-PC
  Date: 01/06/2025
  Time: 11:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email save</title>
</head>
<body>
<h1>Email save</h1>
<table style="width:100%">
    <tr>
        <th>Language</th>
        <td>${setting.language}</td>
    </tr>
    <tr>
        <th>Page Size</th>
        <td>${setting.pageSize}</td>
    </tr>
    <tr>
        <th>Spams Filter</th>
        <td>
            ${setting.spamFilter == true ? "Enabled" : "Disabled"}
        </td>



    </tr>
    <tr>
        <th>Signature</th>
        <td>${setting.signature}</td>
    </tr>
</table>
</body>
</html>
