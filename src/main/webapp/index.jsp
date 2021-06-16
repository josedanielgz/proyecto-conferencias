<%-- 
    Document   : index
    Created on : 15/06/2021, 09:23:40 AM
    Author     : anyusername
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Convocatorias UFPS</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/modern-business.css" rel="stylesheet">
    </head>

    <% HttpSession sesion = request.getSession(false);%>

    <body>
        <!-- Navigation -->

        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">


                <%
                    if (sesion != null) {

                        Integer s = (Integer) sesion.getAttribute("documento");
                        if (s != null) {
                %>
                <a class="navbar-brand" href="./">Usuario <%=s%></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="./secciones/forms/inscribirConvocatoria.html">Inscribirse en convocatoria</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="secciones/resp/listarInscripciones.jsp">Inscripciones disponibles</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="./cerrarSesion">Cerrar sesión</a>
                        </li>

                        <%} else {%>

                        <a class="navbar-brand" href="./">Menu convocatorias</a>
                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarResponsive">
                            <ul class="navbar-nav ml-auto">

                                <li class="nav-item">
                                    <a class="nav-link" href="./secciones/forms/registrarUsuario.html">Registro de usuario</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="./secciones/forms/login.html">Iniciar Sesion</a>
                                </li>
                                <%
                                        }
                                    }
                                %>

                                <li class="nav-item">
                                    <a class="nav-link" href="./secciones/forms/insertarConvocatoria.jsp">Registrar convocatoria</a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="nav-link" href="./secciones/resp/listarConvocatorias.jsp">Listar convocatorias</a>
                                </li>
                            </ul>
                        </div>
                </div>
        </nav>

        <header>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">

                    <div class="carousel-item active" style="background-image: url('img/C1.jpg')">
                    </div>

                    <div class="carousel-item" style="background-image: url('img/C1.jpg')">
                    </div>

                    <div class="carousel-item" style="background-image: url('img/C1.jpg')">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </header>

        <div class="container">

            <h1 class="my-4">Bienvenido a las Convocatorias:</h1>


            <div class="row">
                <div class="col-lg-4 mb-4">
                    <div class="card h-100">
                        <h4 class="card-header">info convotaria 1</h4>
                        <div class="card-body">
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary">+ info</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <div class="card h-100">
                        <h4 class="card-header">info convocatoria 2</h4>
                        <div class="card-body">
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis ipsam eos, nam perspiciatis natus commodi similique totam consectetur praesentium molestiae atque exercitationem ut consequuntur, sed eveniet, magni nostrum sint fuga.</p>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary">+ info</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 mb-4">
                    <div class="card h-100">
                        <h4 class="card-header">info convocatoria 3</h4>
                        <div class="card-body">
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary">+ info</a>
                        </div>
                    </div>
                </div>
            </div>
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
