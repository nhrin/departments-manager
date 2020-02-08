<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="employees" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<h4><a href="<c:url value="/departments"/>">back to departments</a></h4>
<h4><a href="<c:url value="/employees?action=add&departmentId=${param.get('departmentId')}"/>">add</a></h4>
<table>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.name}</td>
            <td><a href="<c:url value="/employees?action=remove&id=${emp.id}&departmentId=${emp.departmentId}"/>">remove</a></td>
            <td><a href="<c:url value="/employees?action=edit&id=${emp.id}&name=${emp.name}&email=${emp.email}&departmentId=${param.get('departmentId')}"/>">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
