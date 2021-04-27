<%-- 
    Document   : respInscripcion
    Created on : 2/06/2021, 09:49:40 AM
    Author     : anyusername
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.io.InputStream"%>
<%@page import="negocio.InscripcionNegocio"%>
<%@page import="modelo.Inscripcion"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respuesta a una inscripción</title>
    </head>
    <body>
        <%
//ESTE ARCHIVO ESTÁ PENDIENTE DE REVISIÓN. NO ENCONTRÉ UNA FORMA DE SOLUCIONAR ESTE PROBLEMA SIN USAR UN SERVLET
//https://www.moreofless.co.uk/unable-process-parts-no-multi-part-configuration-provided/
//ver regInscripcion.java para referencia
            Part archivo = request.getPart("archivo");

            try (InputStream lectorDeBytes = archivo.getInputStream()) {

                Integer documento = Integer.parseInt(request.getParameter("documento"));
                String convocatoria = request.getParameter("convocatoria");
                LocalDate fecha_inscripcion = LocalDate.now();
                String nombre_archivo = archivo.getSubmittedFileName();

                Inscripcion i = new Inscripcion(documento, convocatoria, fecha_inscripcion, nombre_archivo);
                InscripcionNegocio in = new InscripcionNegocio();
                String a = in.realizarInscripcion(documento, convocatoria, i);
                String b = in.insertarArchivo(nombre_archivo, lectorDeBytes, documento, convocatoria);

                //PURO DEBUG
                /*
            Enumeration paramNames = request.getParameterNames();
            out.print("<b> Longitud</b>" + paramNames.hasMoreElements());
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                out.print("<tr><td>" + paramName + "</td>\n");
                String paramValue = request.getHeader(paramName);
                out.println("<td> " + paramValue + "</td></tr>\n");
            }
                 */
        %>
        <b>El valor del documento: <%=documento%></b><br>
        <b>Resultado de la primera operación: <%=a%></b><br>
        <b>El archivo: <%=b%></b><br>

        <%} catch (Exception e) {%>

        <b>Ocurrió un error<%=e.getMessage()%></b><br>

        <%}%>

    </body>
</html>
