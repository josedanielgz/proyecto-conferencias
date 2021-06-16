/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import capadatos.PasswordManager;
import facade.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anyusername
 */
public class iniciarSesion extends HttpServlet {

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
            out.println("<title>Servlet iniciarSesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet iniciarSesion at " + request.getContextPath() + "</h1>");
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
        String msj = "";
        Integer documento = Integer.parseInt(request.getParameter("usuario"));
        String clave = request.getParameter("clave");
        Boolean es_admin = Boolean.valueOf(request.getParameter("es_admin"));
        HttpSession sesion = request.getSession();

//        PURO DEBUG
//        msj = msj + es_admin.toString();
//        request.setAttribute("error", msj);
//        request.getRequestDispatcher("secciones/resp/error.jsp").forward(request, response);
        PasswordManager pm = new PasswordManager();
        Facade f = new Facade();

        if (f.inicioDeSesion(documento, clave)) {
            msj = "Credenciales validadas.";
            if (es_admin) {
                if (f.esUnAdministrador(documento)) {
                    msj = msj + "Sesión iniciada como administrador.";
                } else {
                    msj = msj + " Pero este usuario no tiene permisos de administrador";
                    request.setAttribute("error", msj);
                    request.getRequestDispatcher("secciones/resp/error.jsp").forward(request, response);
                }
            } else {
                msj = msj + "Sesión iniciada correctamente.";
            }
            request.setAttribute("msj", msj);
            sesion.setAttribute("documento", documento);
            sesion.setMaxInactiveInterval(30 * 60);

            Cookie cookieUsuario = new Cookie("documento", documento.toString());
            cookieUsuario.setMaxAge(30 * 60);
            response.addCookie(cookieUsuario);

            request.getRequestDispatcher("secciones/resp/perfil.jsp").include(request, response);

        } else {
            msj = "Inicio de sesión fallido, verifique las credenciales e intente otra vez";
            request.setAttribute("error", msj);
            request.getRequestDispatcher("secciones/resp/error.jsp").forward(request, response);
        };

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
        processRequest(request, response);
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
