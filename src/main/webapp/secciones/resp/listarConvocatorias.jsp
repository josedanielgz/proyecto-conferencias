<%-- 
    Document   : ListaConvocatoria
    Created on : 13 may. 2021, 09:35:39
    Author     : Usuario
--%>
<%@page import="modelo.Convocatoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="facade" class="facade.Facade" scope="page"></jsp:useBean>
<%
    HttpSession sesion = request.getSession(false);
    List<Convocatoria> convocatorias = facade.buscarConvocatorias();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Convocatorias</title>
        <link href='https://ww2.ufps.edu.co/assets/img/ico/favicon.ico' rel='Shortcut icon'>

        <!--
        <link href="../../css/dataTable/jquery.dataTables.min.css" type="text/css" rel="stylesheet">
        <link href="../../css/dataTable/dataTables.bootstrap4.min.css" type="text/css" rel="stylesheet">
        -->

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- JQuery -->
        <script type="text/javascript" src="../../vendor/jquery/jquery.min.js"></script>
        <!--
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/general.js"></script>
        -->

        <!-- Bootstrap core CSS -->
        <link href="../../vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="../../vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--
        <link href="../../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="../../css/dataTable/buttons.dataTables.min.css" rel="stylesheet">
        -->

        <!--https://github.com/jayanthbabu123/how-to-convert-html-web-pages-to-pdf-in-javascript/blob/master/pdf.html-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.js"></script>
        <script src="../../js/ajax/convocatoria.js"></script>

    </head>
    <body>

        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">

            <div class="container">

                <%
                    if (sesion != null) {

                        Integer s = (Integer) sesion.getAttribute("documento");
                        if (s != null) {
                %>

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
                            <a class="nav-link" href="${pageContext.request.contextPath}/listaInscripciones">Inscripciones disponibles</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/cerrarSesion">Cerrar sesión</a>
                        </li>

                        <%} else {%>

                        <a class="navbar-brand" href="${pageContext.request.contextPath}">Menú Convocatoria</a>

                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarResponsive">

                            <ul class="navbar-nav ml-auto">


                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/secciones/forms/registrarUsuario.html">Registro de usuario</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/secciones/forms/login.html">Iniciar sesion</a>
                                </li>

                                <%}
                                    }%>

                                <li class="nav-item">
                                    <a class="nav-link" href="#" onclick="window.location.reload(false)">Listar convocatorias</a>
                                </li>

                            </ul>

                        </div>
                </div>
        </nav>

        <div class="container" id="imprimir">
            <table class="table table-stripped">
                <thead>
                    <tr>
                        <th scope="col">#</td>
                        <th scope="col">Nombre</td>
                        <th scope="col">Fecha Inicio</td>
                        <th scope="col">Fecha Final</td>
                        <th scope="col">Estado</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Convocatoria c : convocatorias) {
                    %>

                    <tr>
                        <td><%=c.getId()%></td>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getFecha_inicio()%></td>
                        <td><%=c.getFecha_final()%></td>
                        <td><%=c.getEstado()%></td>


                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <button class="btn btn-primary" id="descargarCSV"> Descargar CSV</button>
        <button class="btn btn-primary" id="descargarPDF"> Descargar PDF</button>


        <div id="resultado"></div>
        <!--
                <script src="js/dataTable/jquery.dataTables.min.js"></script>
                <script src="js/dataTable/dataTables.buttons.min.js"></script>
                <script src="js/dataTable/buttons.flash.min.js"></script>
                <script src="js/dataTable/jszip.min.js"></script>
                <script src="js/dataTable/pdfmake.min.js"></script>
                <script src="js/dataTable/vfs_fonts.js"></script>
                <script src="js/dataTable/buttons.html5.min.js"></script>
                <script src="js/dataTable/buttons.print.min.js"></script>
        
                <script type="text/javascript">
                    $(document).ready(function () {
                        $('#tblConvocatorias').DataTable({
                            dom: 'Bfrtip',
                            buttons: [
                                'copy', 'csv', 'excel', 'pdf', 'print'
                            ],
                        });
                    });
                </script>
        -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Grupo 9. 2021</p>
            </div>
        </footer>
    </body>
</html>
