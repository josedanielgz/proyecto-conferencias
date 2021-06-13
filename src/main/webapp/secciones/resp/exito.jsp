<%-- 
    Document   : exito
    Created on : 21/05/2021, 3:30:09 p. m.
    Author     : anyusername
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>No hubo errores al completar la operación</h1>
        <h1>Esto es lo que está llegando</h1>
        ${requestScope.msj}
        <a href="${pageContext.request.contextPath}">Volver al inicio</a>
    </body>
</html>
