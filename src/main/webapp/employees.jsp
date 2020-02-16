<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="employees" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<h4><a href="<c:url value="/departments"/>">back to departments</a></h4>
<h1>Employees</h1>
<h4><a href="<c:url value="/employees?action=add&departmentId=${param.get('departmentId')}"/>">Add new employee</a></h4>
<table border="1" cellpadding="5">
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.birthday}</td>
            <td><a href="<c:url value="/employees?action=remove&id=${emp.id}&departmentId=${emp.departmentId}"/>">remove</a>
            <a href="<c:url value="/employees?action=edit&id=${emp.id}&name=${emp.name}&email=${emp.email}&departmentId=${param.get('departmentId')}"/>">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
