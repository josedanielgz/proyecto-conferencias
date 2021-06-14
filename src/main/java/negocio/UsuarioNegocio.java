/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import capadatos.dao.UsuarioDAO;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Jose
public class UsuarioNegocio {

    private final UsuarioDAO usuarioDAO;

    public UsuarioNegocio() {

        usuarioDAO = new UsuarioDAO();
    }

    public String insertarUsuario(Usuario u) {
//        String rt = "";
//        boolean rt = false;
        try {
            Usuario us = usuarioDAO.buscaUsuario(u.getDocumento());
            if (us.isNull()) {
                if (usuarioDAO.insertarUsuario(u)) {
                    return "Usuario insertado con éxito";
//                    rt = true;
                }
            } else {
                return "El usuario ya existe";
//                return rt;
            }
        } catch (Exception ex) {
// 
            Logger.getLogger(ConvocatoriaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return "Hubo un errror" + ex.toString();
        }
        return null;
    }

    public Usuario buscarUsuario(Integer documento) {

        try {
            Usuario c = new Usuario();
            c = usuarioDAO.buscaUsuario(documento);
            return c;
        } catch (Exception ex) {
//          return "Error: " + ex.toString();
            Logger.getLogger(ConvocatoriaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Usuario> buscarUsuarios() {
        try {
            ArrayList<Usuario> resultado;
            resultado = usuarioDAO.listaDeUsuarios();
            if (resultado.isEmpty()) {
                return null;
            }
            return resultado;
        } catch (Exception ex) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            resultado = null;
            Logger.getLogger(ConvocatoriaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean inicioDeSesion(Integer documento, String clave_acceso) {
        try {
            return usuarioDAO.inicioDeSesion(documento, clave_acceso);
        } catch (Exception ex) {
            
        }
        return false;
    }

    public static void main(String[] args) {
        UsuarioNegocio c = new UsuarioNegocio();
        System.out.println(c.inicioDeSesion(7, "123456"));
    }

}
