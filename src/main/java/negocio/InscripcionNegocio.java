/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import capadatos.dao.InscripcionDAO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Convocatoria;
import modelo.Inscripcion;
import modelo.Usuario;

//Esteban
public class InscripcionNegocio {

    InscripcionDAO inscripcionDAO;

    public InscripcionNegocio() {

        inscripcionDAO = new InscripcionDAO();
    }

    public String realizarInscripcion(Integer u, String c, Inscripcion i) {
//        boolean rt = false;
//        String rt = "";
        try {
            UsuarioNegocio un = new UsuarioNegocio();
            ConvocatoriaNegocio cn = new ConvocatoriaNegocio();
            Convocatoria ce = cn.buscarConvocatoria(c);
            if (ce.isNull()) {
//                return false;
                return "Está intentando inscribirse a una convocatoria que no existe";
            }

            Usuario us = un.buscarUsuario(u);
            if (us.isNull()) {
//                return false;
                return "No se puede realizar la inscripción, este usuario no existe";
            }
            Inscripcion in = inscripcionDAO.buscarInscripcion(i.getDocumento(), i.getConvocatoria());

            if (!in.isNull()) {
//                return false;
                return "Este usuario ya tiene una inscripción en proceso";
            }

            if (inscripcionDAO.insertarInscripcion(i)) {
                return "Usuario insertado con éxito";
            }

//            rt = "Inscripción realizada con éxito";
        } catch (Exception ex) {
//            rt = "Hubo un error: " + ex.getLocalizedMessage();
            Logger.getLogger(InscripcionNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return "Hubo un error: " + ex.toString();
        }

        return null;
    }

    public Inscripcion buscarInscripcion(Integer documento, String convocatora) {

        try {
            Inscripcion i = new Inscripcion();
            i = inscripcionDAO.buscarInscripcion(documento, convocatora);
            if (i.isNull()) {
                return null;
            }
            return i;
        } catch (Exception ex) {
            Logger.getLogger(InscripcionNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Inscripcion> buscarInscripciones() {

        try {
            ArrayList<Inscripcion> resultado;
            resultado = inscripcionDAO.listaDeInscripciones();
            if (resultado.isEmpty()) {
                return null;
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String insertarArchivo(String nombre, InputStream lectorDeBytes, Integer documento, String convocatoria) {

        try {
            Inscripcion in = inscripcionDAO.buscarInscripcion(documento, convocatoria);
            if (in.isNull()) {
                return "No se puede solicitar el archivo, la convocatoria no existe";
            }
            inscripcionDAO.escribirArchivo(nombre, lectorDeBytes, documento, convocatoria);
            return "Se insertó el archivo sin más incidentes";
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return "Error: " + ex.toString();

        }
    }

    public Inscripcion devolverArchivo(Integer documento, String convocatoria) {

        try {
            return inscripcionDAO.devolverArchivo(documento, convocatoria);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(InscripcionNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        InscripcionNegocio in = new InscripcionNegocio();
        System.out.println(in.buscarInscripciones());
//        Inscripcion x = in.devolverArchivo(1, "1");
//        System.out.println(x.getNombre_archivo());
    }
}
