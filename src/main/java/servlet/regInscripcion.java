/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Inscripcion;
import negocio.InscripcionNegocio;

@MultipartConfig(
        fileSizeThreshold = 1024 * 2014 * 1, //1MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 100 //100MB
)
/**
 *
 * @author anyusername
 */
public class regInscripcion extends HttpServlet {

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
            out.println("<title>Servlet regInscripcion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet regInscripcion at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");

        try {
            
//PURO DEBUG
//            PrintWriter out = response.getWriter();
//            Enumeration paramNames = request.getParameterNames();
//            out.print("<b> Longitud</b>" + paramNames.hasMoreElements());
//            while (paramNames.hasMoreElements()) {
//                String paramName = (String) paramNames.nextElement();
//                out.print("<tr><td>" + paramName + "</td>\n");
//                String paramValue = request.getHeader(paramName);
//                out.println("<td> " + paramValue + "</td></tr>\n");
//            }
//            out.print("<b>" + request.getParameter("documento"));

//CODIGO FINAL
            Part archivo = request.getPart("archivo");
            InputStream lectorDeBytes = archivo.getInputStream();
            Integer documento = Integer.parseInt(request.getParameter("documento"));
            String convocatoria = request.getParameter("convocatoria");
            LocalDate fecha_inscripcion = LocalDate.now();
            String nombre_archivo = archivo.getSubmittedFileName();
            Inscripcion i = new Inscripcion(documento, convocatoria, fecha_inscripcion, nombre_archivo);
            InscripcionNegocio in = new InscripcionNegocio();
            String a = in.realizarInscripcion(documento, convocatoria, i);
            String b = in.insertarArchivo(nombre_archivo, lectorDeBytes, documento, convocatoria);

            PrintWriter out = response.getWriter();
            out.write("<b>El valor del documento: " + documento + "</b><br>");
            out.write("<b>Resultado de la primera operación: </b>" + a+"<br>");
            out.write("<b>El archivo: </b>" + b);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.write("<b>Ocurrió un error: </b>" + e);
        }
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
