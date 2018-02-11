<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 10/02/2018
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
        <h1>List Countries</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="country" items="${request.countries}">
                <tr>
                    <td>
                            <c:out value="${country.id}"/>
                    </td>
                    <td><c:out value="${country.name}"/></td>
                    <td>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="regions">Region List</a></p>

</body>
</html>
