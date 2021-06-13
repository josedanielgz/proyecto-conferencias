/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import facade.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Convocatoria;

/**
 *
 * @author anyusername
 */
public class insertarConvocatoria extends HttpServlet {

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
            out.println("<title>Servlet insertarConvocatoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertarConvocatoria at " + request.getContextPath() + "</h1>");
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
        String msg = "Lmao";
        Convocatoria c = new Convocatoria();
        Facade facade = new Facade();
        try {//processRequest(request, response);

            // Mensaje para mostrar al final
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

            c = new Convocatoria(codigo, nombre, descripcion, fechains, fechaini, fechafin, "Abierta", requisitos);
            msg = facade.insertarConvocatoria(c);
            
//
//            Period tiempoDeInscripcion = Period.between(fechains, fechaini);
//            Period duracionConvocatoria = Period.between(fechaini, fechafin);
//
//            if (tiempoDeInscripcion.getDays() >= 8) {
//                if (!duracionConvocatoria.isNegative()) {
//
//                    // Si hay tiempo para presentar los requisitos y la convocatoria dura un tiempo lógico
//                    // Estado abierta por defecto
//                    c = new Convocatoria(codigo, nombre, descripcion, fechains, fechaini, fechafin, "Abierta", requisitos);
//                    msg = facade.insertarConvocatoria(c);
//
//                } else {
//
//                    msg = "Verifique que la fecha de inicio y finalización de la convocatoria sean válidas";
//                }
//            } else {
//
//                msg = "Debe haber un lapso de al menos una semana para presentar los requisitos. Verifique la fecha de inscripción";
//            }
        } catch (Exception e) {
            msg = e.toString();
        }

        request.setAttribute("msj", msg);
        request.setAttribute("convocatoria", c);
        request.getRequestDispatcher("secciones/resp/guardarConvocatoria.jsp").forward(request, response);
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
