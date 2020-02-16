<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="departments" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<h1>Departments</h1>
<h4><a href="<c:url value="/departments?action=add"/>">Add new department</a></h4>
<table border="1" cellpadding="5">
    <tr>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="dep" items="${departments}">
        <tr>
            <td>${dep.name}</td>
            <td><a href="<c:url value="/departments?action=remove&id=${dep.id}"/>">remove</a>
            <a href="<c:url value="/departments?action=edit&id=${dep.id}&name=${dep.name}"/>">edit</a>
            <a href="<c:url value="/employees?departmentId=${dep.id}"/>">view employees</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
