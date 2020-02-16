<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee form</title>
</head>
<body>
<h1>Employee</h1>
<form action="<c:url value="/employees"/>" method="post">
    <table border="1" cellpadding="5">
        <input type="hidden" name="id" value="${param.get("id")}">
        <input type="hidden" name="departmentId" value="${param.get("departmentId")}">
        <tr>
            <th>Name: </th>
            <td>
                <input type="text" name="name" value="${param.get("name")}" required>
            </td>
        </tr>
        <tr>
            <th>Email: </th>
            <td>
                <input type="email"  name="email" value="${param.get("email")}">
            </td>
        </tr>
        <tr>
            <th>Birthday: </th>
            <td>
                <label for="date"> </label>
                <input type="date" id="date" name="birthday" value="${param.get("birthday")}" required>
            </td>
        </tr>
        <tr>
            <th>Press "ok": </th>
            <td>
                <input type="submit" value="ok"> </td>
        </tr>
    </table>
</form>
</body>
</html>
