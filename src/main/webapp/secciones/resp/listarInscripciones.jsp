<%-- 
    Document   : listarInscripciones
    Created on : 12/06/2021, 02:11:27 AM
    Author     : anyusername
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Inscripcion"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="facade" class="facade.Facade" scope="page"></jsp:useBean>
<%
    List<Inscripcion> inscripciones = facade.buscarInscripciones();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revisión de inscripciones vigentes</title>
        <script src="../../js/ajax/inscripcion.js"></script>
    </head>
    <body>
        <h1>Lista de inscripciones a la fecha <%=LocalDate.now()%></h1>

        <div class="container">
            <%=inscripciones%>
            <table class="table table-stripped">
                <thead>
                    <tr>
                        <th scope="col">Fecha de Inscripción</td>
                        <th scope="col">Documento</td>
                        <th scope="col">Convocatoria</td>
                        <th scope="col">Archivo</td>
                    </tr>
                </thead>
                <tbody>
                    <%--
                    <%

                        for (Inscripcion c : inscripciones) {
                    %>

                    <tr>
                        <td><%=c.getFecha_inscripcion()%></td>
                        <td><%=c.getDocumento()%></td>
                        <td><%=c.getConvocatoria()%></td>
                        <td><a onclick="alert('En progreso');"><%=c.getNombre_archivo()%></a></td>

                    </tr>
                    <%
                        }
                    %>
                    --%>

                </tbody>
            </table>

    </body>
</html>
