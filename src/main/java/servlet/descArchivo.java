/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import facade.Facade;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Inscripcion;

/**
 *
 * @author anyusername
 */
public class descArchivo extends HttpServlet {

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

        //Colocar un try-catch aquí sería una buena idea, pero quiero probar algo en el
        //front (ver inscripcion.js)
        Integer documento = Integer.parseInt(request.getParameter("documento"));
        String convocatoria = request.getParameter("convocatoria");

        Facade in = new Facade();
        Inscripcion aux = in.devolverArchivo(documento, convocatoria);
        byte[] archivo = aux.getArhivo();
        String nombre = aux.getNombre_archivo();

        response.setContentType("application/zip");
        response.setHeader("filename", nombre);
        response.setHeader("Content-Disposition", "attachment; filename=" + nombre);
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        bos.write(archivo, 0, archivo.length);
        bos.close();

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
