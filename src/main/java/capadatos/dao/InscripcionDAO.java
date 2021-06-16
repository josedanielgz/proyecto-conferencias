/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos.dao;

import capadatos.Conexion;
import java.io.ByteArrayOutputStream;
import modelo.Inscripcion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Esteban
public class InscripcionDAO {

    public Inscripcion buscarInscripcion(Integer documento, String convocatoria) throws SQLException {

        Inscripcion i = new Inscripcion();
        Conexion con = new Conexion();
        Connection conexion = con.conectar("");
        String sql = "SELECT fecha_inscripcion, documento, convocatoria, nombre_archivo"
                + " FROM inscripcion WHERE documento = ? AND convocatoria = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, documento);
        ps.setString(2, convocatoria);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            i.setFecha_inscripcion(rs.getDate("fecha_inscripcion").toLocalDate());
            i.setDocumento(rs.getInt("documento"));
            i.setConvocatoria(rs.getString("convocatoria"));
            i.setNombre_archivo(rs.getString("nombre_archivo"));
        }
        ps.close();
        conexion.close();

        ps = null;
        conexion = null;

        return i;
    }

    public boolean insertarInscripcion(Inscripcion i) throws SQLException {

        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("");
        String sql = "INSERT INTO inscripcion (fecha_inscripcion, documento, convocatoria, nombre_archivo) VALUES (?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setDate(1, java.sql.Date.valueOf(i.getFecha_inscripcion()));
        ps.setInt(2, i.getDocumento());
        ps.setString(3, i.getConvocatoria());
        ps.setString(4, i.getNombre_archivo());
        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;

    }

    public ArrayList<Inscripcion> listaDeInscripciones() throws SQLException {

        ArrayList<Inscripcion> il = new ArrayList<>();
        Conexion con = new Conexion();
        PreparedStatement ps;
        try (Connection conexion = con.conectar("")) {
            String sql = "SELECT fecha_inscripcion, documento, convocatoria, nombre_archivo"
                    + " FROM inscripcion;";
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion i = new Inscripcion();
                i.setFecha_inscripcion(rs.getDate(1).toLocalDate());
                i.setDocumento(rs.getInt(2));
                i.setConvocatoria(rs.getString(3));
                i.setNombre_archivo(rs.getString(4));
                il.add(i);

            }

            ps.close();
        }

        ps = null;

        return il;
    }

    public void escribirArchivo(String nombre, InputStream lectorDeBytes, Integer documento, String convocatoria) throws SQLException, IOException {
        //Este codigo funciona pero no en java 11, versiones anteriores no tienen problema

        Conexion con = new Conexion();
        Connection conexion = con.conectar("");
        PreparedStatement ps = conexion.prepareStatement("UPDATE inscripcion SET archivo = ?, nombre_archivo = ?"
                + "WHERE documento = ? AND convocatoria = ?;");
        //Le pasa los bytes del archivo a Postgres

        //Para JDK9 +
        //byte [] archivo = lectorDeBytes.readAllBytes();
        //Para JDK8
        //https://stackoverflow.com/a/1264737
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = lectorDeBytes.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        ps.setBytes(1, buffer.toByteArray());
        ps.setString(2, nombre);
        ps.setInt(3, documento);
        ps.setString(4, convocatoria);

        ps.executeUpdate();
        ps.close();
        conexion.close();

        lectorDeBytes.close();
        conexion.close();

        ps = null;
        conexion = null;

    }

    //No encontré una forma más elegante de recuperar el nombre y los bytes del archivo al mismo tiempo.
    public Inscripcion devolverArchivo(Integer documento, String convocatoria) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Conexion conX = new Conexion();
        Connection con = conX.conectar("");
        Inscripcion i = new Inscripcion();
        PreparedStatement ps = con.prepareStatement("SELECT nombre_archivo, archivo FROM inscripcion"
                + " WHERE documento=? AND convocatoria=?;");
        ps.setInt(1, documento);
        ps.setString(2, convocatoria);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        if (rs.next()) {
                i.setNombre_archivo(rs.getString(1));
                i.setArhivo(rs.getBytes(2));
            
        } else {
            return null;
        }

        con.close();
        ps.close();
        rs.close();
        rs = null;
        ps = null;
        con = null;

        return i;

    }

    public static void main(String[] args) {
        try {
//            System.out.println(new InscripcionDAO().devolverArchivo(1, "1"));
            System.out.println(new InscripcionDAO().listaDeInscripciones());
        } catch (SQLException ex) {
//            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex));
        }
    }

}
