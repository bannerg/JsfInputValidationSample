<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 27/01/2018
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC Sample</title>
</head>
<body>
    <%--Bloque de expresion, obtenemos el atributo por SESSION--%>
    <P>There are <%= session.getAttribute("countriesCount") %> countries</P>
</body>
</html>
