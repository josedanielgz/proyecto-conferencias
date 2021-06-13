
<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@page import="modelo.Convocatoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar Convocatoria</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/modern-business.css" rel="stylesheet">
    </head>

    <jsp:useBean id="facade" class="facade.Facade" scope="page"></jsp:useBean>
    <%
        // Mensaje para mostrar al final
        String msg = "";
        Convocatoria c = new Convocatoria();

        // Puro campo simple
        // Freddy había comentado que el estado se colocaba "Abierto" por Defecto
        // String estado = request.getParameter("estado");
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("desc");
        String requisitos = request.getParameter("requisitos");

        // A Freddy no le gustó que colocáramos la fecha de inscripción como un campo más
        // LocalDate fechains = LocalDate.parse(request.getParameter("fechains"));
        LocalDate fechains = LocalDate.now();

        // También quería que validaramos el tiempo entre las fechas
        LocalDate fechaini = LocalDate.parse(request.getParameter("fechaini"));
        LocalDate fechafin = LocalDate.parse(request.getParameter("fechafinal"));

        Period tiempoDeInscripcion = Period.between(fechains, fechaini);
        Period duracionConvocatoria = Period.between(fechaini, fechafin);

        if (tiempoDeInscripcion.getDays() >= 8) {
            if (!duracionConvocatoria.isNegative()) {

                // Si hay tiempo para presentar los requisitos y la convocatoria dura un tiempo lógico
                // Estado abierta por defecto
                c = new Convocatoria(codigo, nombre, descripcion, fechains, fechaini, fechafin, "Abierta", requisitos);
                msg = facade.insertarConvocatoria(c);

            } else {

                msg = "Verifique que la fecha de inicio y finalización de la convocatoria sean válidas";
            }
        } else {

            msg = "Debe haber un lapso de al menos una semana para presentar los requisitos. Verifique la fecha de inscripción";
        }

    %>
    <body>

        <h1>Guardar convocatoria</h1>
        <div>
            <table>
                <tr>
                    <td>Codigo: <%=c.getId()%></td>                    
                </tr>
                <tr>
                    <td>Nombre: <%=c.getNombre()%></td>                    
                </tr>
            </table>
            <div>
                <%=msg%>
            </div>   
            <input type="button" value="Volver al proceso de Inscripción" onclick="location.href = '${pageContext.request.contextPath}/secciones/forms/insertarConvocatoria.jsp'"/>
        </div>
    </body>




</html>
