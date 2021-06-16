<%-- 
    Document   : perfil
    Created on : 15/06/2021, 07:58:36 PM
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
        <%
//allow access only if session exists
            String u = null;
            if (session.getAttribute("documento") == null) {
                response.sendRedirect("../..");
            } else {
                u = session.getAttribute("documento").toString();
            }
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("u")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>
        <h1>Perfil de usuario de prueba, a ver si funciona</h1>
        
        Hola, este es el usuario <%=u%> y la sesión <%=sessionID%>
        
        <a href="../../cerrarSesion">Volver al inicio</a>
    </body>
</html>
