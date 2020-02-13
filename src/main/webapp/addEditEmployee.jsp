<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee form</title>
</head>
<body>
<form action="<c:url value="/employees"/>" method="post">
    <label>
        <input type="hidden" name="id" value="${param.get("id")}">
        <input type="hidden" name="departmentId" value="${param.get("departmentId")}">
        <input type="text" name="name" value="${param.get("name")}">
        <input type="text" name="email" value="${param.get("email")}">
        <label for="date">Birthday: </label>
        <input type="date" id="date" name="birthday" value="${param.get("birthday")}">
        <input type="submit" value="ok">
    </label>
</form>
</body>
</html>
