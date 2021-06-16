/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos.dao;

import capadatos.Conexion;
import capadatos.PasswordManager;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Jose
public class UsuarioDAO {

    public boolean insertarUsuario(Usuario u) throws SQLException {

        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDAO.insertarUsuario()");
        String sql = "INSERT INTO usuario (documento, primer_nombre, primer_apellido, fecha_nacimiento,"
                + "correo_electronico, clave_acceso) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, u.getDocumento());
        ps.setString(2, u.getPrimer_nombre());
        ps.setString(3, u.getPrimer_apellido());
        ps.setDate(4, java.sql.Date.valueOf(u.getFecha_nacimiento()));
        ps.setString(5, u.getCorreo_electronico());
        ps.setString(6, u.getClave_acceso());
        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;

    }

    public boolean inicioDeSesion(Integer documento, String clave_acceso) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {

        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDAO.insertarUsuario()");
        String sql = "SELECT documento, primer_nombre, primer_apellido, fecha_nacimiento, correo_electronico,"
                + "clave_acceso FROM usuario WHERE documento=?;";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, documento);
        ResultSet rs = ps.executeQuery();
        Usuario us = new Usuario();
        while (rs.next()) {
            us.setDocumento(rs.getInt(1));
            us.setPrimer_apellido(rs.getString(2));
            us.setPrimer_apellido(rs.getString(3));
            us.setFecha_nacimiento(rs.getDate(4).toLocalDate());
            us.setCorreo_electronico(rs.getString(5));
            us.setClave_acceso(rs.getString(6));
        }
        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        PasswordManager pm = new PasswordManager();

        return pm.validatePassword(clave_acceso, us.getClave_acceso());

    }

    public Usuario buscaUsuario(Integer documento) throws SQLException {

        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDAO.insertarUsuario()");
        String sql = "SELECT documento, primer_nombre, primer_apellido, fecha_nacimiento, correo_electronico,"
                + "clave_acceso FROM usuario WHERE documento=?;";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, documento);
        ResultSet rs = ps.executeQuery();
        Usuario us = new Usuario();
        while (rs.next()) {
            us.setDocumento(rs.getInt(1));
            us.setPrimer_apellido(rs.getString(2));
            us.setPrimer_apellido(rs.getString(3));
            us.setFecha_nacimiento(rs.getDate(4).toLocalDate());
            us.setCorreo_electronico(rs.getString(5));
            us.setClave_acceso(rs.getString(6));
        }

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return us;

    }

    public ArrayList<Usuario> listaDeUsuarios() throws SQLException {
        ArrayList<Usuario> us = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDAO.listaDeUsuario()");
        String sql = "SELECT * FROM usuario;)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setDocumento(rs.getInt(1));
            u.setPrimer_apellido(rs.getString(2));
            u.setPrimer_apellido(rs.getString(3));
            u.setFecha_nacimiento(rs.getDate(4).toLocalDate());
            us.add(u);
        }

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return us;

    }

    public boolean insertarAdministrador(Integer documento) throws SQLException {

        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDAO.insertarAdministrador()");
        String sql = "INSERT INTO administrador (documento) VALUES (?);";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, documento);

        rta = !ps.execute();

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;

        return rta;
    }

    public boolean esUnAdministrador(Integer documento) throws SQLException {

        boolean rta = false;
        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDAO.insertarUsuario()");
        String sql = "SELECT documento FROM administrador WHERE documento=?;";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, documento);
        ResultSet rs = ps.executeQuery();
        rta = rs.next();
        
        ps.close();
        conexion.close();

        ps = null;
        conexion = null;

        return rta;
    }

    public static void main(String[] args) {

        try {
            UsuarioDAO u = new UsuarioDAO();
            System.out.println(u.esUnAdministrador(4));
            // System.out.println(u.inicioDeSesion(7, "123456"));

            /*
            Usuario x = u.buscaUsuario(7);
            String a = x.getClave_acceso();
            System.out.println(aSystem.out.println(u.inicioDeSesion(7, "123456")););
            PasswordManager pm = new PasswordManager();
            System.out.println(pm.validatePassword("123456", a));
             */
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
