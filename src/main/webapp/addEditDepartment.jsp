<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Department form</title>
</head>
<body>
<form action="<c:url value="/departments"/>" method="post">
    <label>
        <input type="hidden" name="id" value="${param.get("id")}">
        <input type="text" name="name" value="${param.get("name")}">
        <input type="submit" value="ok">
    </label>
</form>
</body>
</html>
