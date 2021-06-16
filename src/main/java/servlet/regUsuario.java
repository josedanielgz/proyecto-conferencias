/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import capadatos.PasswordManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import facade.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author anyusername
 */
public class regUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet regUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet regUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode resp = mapper.createObjectNode();
        String msj = "";

        try {

            Usuario u = new Usuario();

            // https://stackoverflow.com/questions/5338943/read-json-string-in-servlet
            Map<String, Object> data = mapper.readValue(request.getParameter("data"), Map.class);
            PasswordManager pm = new PasswordManager();

            u.setDocumento(Integer.parseInt(data.get("documento").toString()));
            u.setPrimer_nombre(data.get("primer_nombre").toString());
            u.setPrimer_apellido(data.get("primer_apellido").toString());
            u.setFecha_nacimiento(LocalDate.parse(data.get("fecha_nacimiento").toString()));
            u.setCorreo_electronico(data.get("correo_electronico").toString());
            u.setClave_acceso(pm.generateStrongPasswordHash(data.get("clave").toString()));
            
            Facade f = new Facade();
            Boolean esAdmin = (Boolean) data.get("es_admin");
            msj = f.InsertarUsuario(u);
            if (esAdmin) {
                f.insertarAdministrador(u.getDocumento());
                msj = msj + ", se le asignó correctamente el cargo de administrador";
            }

        } catch (Exception ex) {
            msj = ex.toString() + ", " + ex.getLocalizedMessage();
        }
        resp.put("msj", msj);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resp);
        writer.write(json);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
