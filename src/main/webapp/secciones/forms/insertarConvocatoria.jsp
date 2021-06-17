
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Convocatoria</title>
        <link href='https://ww2.ufps.edu.co/assets/img/ico/favicon.ico' rel='Shortcut icon'>

        <!-- JQuery -->
        <script type="text/javascript" src="../../vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap core CSS -->
        <link href="../../vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="../../js/ajax/convocatoria.js"></script>
        <link href="../../css/modern-business.css" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="../../">Menu Convocatoria</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="./inscribirConvocatoria.html">Inscribirse en una convocatoria</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./registrarUsuario.html">Regístrese</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./login.html">Iniciar Sesion</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../resp/listarConvocatorias.jsp">Listado de Convocatorias</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h1 class="m-0 text-center text-black">Registrar Convocatoria</h1>

        <!--
        <div id="resultado"></div>-->

        <div class="m-0 text-center text-black">
            <!-- <form id="frmRegistrar" name="frmRegistrar" onsubmit="insertarConvocatoria(event)" method="post" class="m-0 text-center text-black" > -->
            <form id="frmRegistrar" name="frmRegistrar" action="../../secciones/resp/guardarConvocatoria.jsp" method="post" class="m-0 text-center text-black" >

                <label for="codigo">Código Convocatoria</label><br>                
                <input type="text" id="codigo" name="codigo" placeholder="Digite el codigo de la Convocatoria" required><br><br>

                <label for="nombre">Nombre de la Convocatoria</label><br>                
                <input type="text" id="nombre" name="nombre" placeholder="Digite el Nombre de la Convocatoria" required><br><br>

                <label for="desc">Descripción de la Convocatoria</label><br>                
                <input type="text" id="desc" name="desc" placeholder="Digite la Descripcion de la Convocatoria" required><br><br>

                <!--A Freddy no le gustó que pidiéramos la fecha de inscripción-->
                <!--
                <label for="fechains">Digite la fecha de la inscripcion</label>   <br>             
                <input type="date" id="fechains" name="fechains" placeholder="Digite la fecha de la inscripcion" required> <br><br>
                -->

                <label for="fechaini">Digite la fecha de inicio</label>   <br>             
                <input type="date" id="fechaini" name="fechaini" placeholder="Digite la fecha de inicio" required> <br><br>

                <label for="fechafinal">Digite la fecha de finalización</label>   <br>             
                <input type="date" id="fechafinal" name="fechafinal" placeholder="Digite la fecha final" required> <br><br>

                <!--Freddy había comentado que el estado se colocaba abierto por defecto-->
                <!--
                <label for="estado">Estado de la Convocatoria</label>
                <input type=text list="estado" required>
                <datalist id="estado" >
                    <option> Abierta
                    <option> Cerrada
                    <option> Cancelada
                    <option> Finalizada
                </datalist>
                -->

                <!--
                <label for="estado">Estado de la Convocatoria</label><br>              
                <input type="text" id="estado" name="estado" placeholder="Digite el estado de la Convocatoria" required><br><br> 
                -->

                <label for="requisitos">Requisitos de la Convocatoria</label><br>                
                <input type="text" id="requisitos" name="requisitos" placeholder="Digite los requisitos de la Convocatoria" required><br><br><br>

                <input type="submit" id="btnEnviar" value="Guardar Convocatoria"/>
                <input type="button" id="btnCancelar" value="Cancelar" onclick="location.href = '../../'"/>
            </form>
        </div>

        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Grupo 9; 2021</p>
            </div>
        </footer>

    </body>
</html>