<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="departments" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<h4><a href="<c:url value="/departments?action=add"/>">add</a></h4>
<table>
    <c:forEach var="dep" items="${departments}">
        <tr>
            <td>${dep.name}</td>
            <td><a href="<c:url value="/departments?action=remove&id=${dep.id}"/>">remove</a></td>
            <td><a href="<c:url value="/departments?action=edit&id=${dep.id}&name=${dep.name}"/>">edit</a></td>
            <td><a href="<c:url value="/employees?departmentId=${dep.id}"/>">view employees</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
