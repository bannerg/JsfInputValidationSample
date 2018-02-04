<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 03/02/2018
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Regions</title>
</head>
<body>
    <h1>List Regions</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="region" items="${regions}">
            <tr>
                <td>
                    <a href="regions?action=show&id=${region.id}">
                        <c:out value="${region.id}"/>
                    </a>
                </td>
                <td><c:out value="${region.name}"/></td>
                <td>
                    <a href="regions?action=edit&id=${region.id}">Edit</a>
                    <a href="regions?action=delete&id=${region.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="regions?action=new">Create</a></p>

</body>
</html>
