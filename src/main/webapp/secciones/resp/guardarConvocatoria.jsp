
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
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("desc");
        LocalDate fechains = LocalDate.parse(request.getParameter("fechains"));
        LocalDate fechaini = LocalDate.parse(request.getParameter("fechaini"));
        LocalDate fechafin = LocalDate.parse(request.getParameter("fechafinal"));
        String estado = request.getParameter("estado");
        String requisitos = request.getParameter("requisitos");
        
        
        Convocatoria c = new Convocatoria(codigo, nombre, descripcion, fechains, fechaini, fechafin, estado, requisitos);
        
        String msg = facade.insertarConvocatoria(c);        
        
    %>
    <body>
        
    
        
        
        
        
        <h1>Guardar convocatoria</h1>
        <div>
            <table>
                <tr>
                    <td>Codigo: <%= c.getId() %></td>                    
                </tr>
                <tr>
                    <td>Nombre: <%= c.getNombre() %></td>                    
                </tr>
            </table>
            <div>
                <%= msg %>
            </div>   
            <input type="button" value="Volver" onclick="location.href='insertarConvocatoria.jsp'"/>
        </div>
            
            
      
            
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
    
    
    
    
</html>
