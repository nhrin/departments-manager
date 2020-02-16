<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Department form</title>
</head>
<body>
<h1>Department</h1>
<form action="<c:url value="/departments"/>" method="post">
    <table border="1" cellpadding="5">
    <input type="hidden" name="id" value="${param.get("id")}">
        <tr>
            <th>Name: </th>
            <td>
                <input type="text" name="name" value="${param.get("name")}">
            </td>
        </tr>
        <tr>
            <th>Press "ok": </th>
            <td>
                <input type="submit" value="ok">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
