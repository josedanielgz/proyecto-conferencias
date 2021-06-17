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
    HttpSession sesion = request.getSession(false);

    if (sesion == null || (sesion.getAttribute("documento") == null)) {

        request.getRequestDispatcher("../../index.jsp").forward(request, response);

    } else {

        List<Inscripcion> inscripciones = facade.buscarInscripciones();
        Integer s = (Integer) sesion.getAttribute("documento");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revisión de inscripciones vigentes</title>
        <link href='https://ww2.ufps.edu.co/assets/img/ico/favicon.ico' rel='Shortcut icon'>

        <script src="../../vendor/jquery/jquery.min.js"></script>

        <link href="../../vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="../../vendor/bootstrap/js/bootstrap.min.js"></script>

        <script src="../../js/ajax/inscripcion.js"></script>

    </head>
    <body>
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">

            <div class="container">

                <a class="navbar-brand" href="${pageContext.request.contextPath}">Usuario <%=s%></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/secciones/forms/inscribirConvocatoria.html">Inscribirse en convocatoria</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/secciones/resp/listarInscripciones.jsp">Inscripciones disponibles</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/cerrarSesion">Cerrar sesión</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/secciones/resp/listarConvocatorias.jsp">Listar convocatorias</a>
                        </li>

                    </ul>

                </div>

            </div>

        </nav>

        <h1>Lista de inscripciones a la fecha <%=LocalDate.now()%> para el Usuario</h1>

        <div class="container">
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

                    <%
                        for (Inscripcion c : inscripciones) {
                    %>

                    <tr>
                        <td><%=c.getFecha_inscripcion()%></td>
                        <td><%=c.getDocumento()%></td>
                        <td><%=c.getConvocatoria()%></td>
                        <td><a href="#" id="<%=c.getDocumento()%>-<%=c.getConvocatoria()%>" onclick="descargarArchivoSeleccionado(event);"><%=c.getNombre_archivo()%></a></td>

                    </tr>
                    <%
                            }
                        }
                    %>

                </tbody>
            </table>
        </div>
    </body>
</html>
