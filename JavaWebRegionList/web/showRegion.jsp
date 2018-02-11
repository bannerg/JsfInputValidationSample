<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 03/02/2018
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Region</title>
</head>
<body>
    <p>Region Id: <c:out value="${region.id}"/></p>
    <p>Region Name: <c:out value="${region.name}"/></p>
    <p><a href="regions">List Regions</a></p>
</body>
</html>
