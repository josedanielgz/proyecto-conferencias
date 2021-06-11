package capadatos.dao;

import capadatos.Conexion;
import modelo.Convocatoria;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//Sebastian

public class ConvocatoriaDAO {

    public boolean insertarConvocatoria(Convocatoria convocatoria) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("convocatoriaDAO.insertarConvocatoria()");
        String sql = "INSERT INTO convocatoria VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, convocatoria.getId());
        ps.setString(2, convocatoria.getNombre());
        ps.setString(3, convocatoria.getDescripcion());
        ps.setDate(4, Date.valueOf(convocatoria.getFecha_inscripcion()));
        ps.setDate(5, Date.valueOf(convocatoria.getFecha_inicio()));
        ps.setDate(6, Date.valueOf(convocatoria.getFecha_final()));
        ps.setString(7, convocatoria.getEstado());
        ps.setString(8, convocatoria.getRequisito());

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public Convocatoria buscarConvocatoria(String codigo) throws Exception {
        Convocatoria c = new Convocatoria();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("convocatoriaDAO.buscarConvocatoria()");
        String sql = "SELECT * FROM convocatoria WHERE id=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, codigo);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) {

            c.setId(rst.getString(1));
            c.setNombre(rst.getString(2));
            c.setDescripcion(rst.getString(3));
            c.setFecha_inscripcion(rst.getDate(4).toLocalDate());
            c.setFecha_inicio(rst.getDate(5).toLocalDate());
            c.setFecha_final(rst.getDate(6).toLocalDate());
            c.setEstado(rst.getString(7));
            c.setRequisito(rst.getString(8));

        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return c;
    }

    public List<Convocatoria> buscarConvocatorias() throws Exception {

        List<Convocatoria> convocatoria = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("convocatoriaDAO.buscarConvocatorias()");
        String sql = "SELECT * FROM convocatoria";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            Convocatoria c = new Convocatoria();
            c.setId(rst.getString(1));
            c.setNombre(rst.getString(2));
            c.setDescripcion(rst.getString(3));
            c.setFecha_inscripcion(rst.getDate(4).toLocalDate());
            c.setFecha_inicio(rst.getDate(5).toLocalDate());
            c.setFecha_final(rst.getDate(6).toLocalDate());
            c.setEstado(rst.getString(7));
            c.setRequisito(rst.getString(8));

            convocatoria.add(c);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return convocatoria;
    }

    public static void main(String[] args) {
        try {
            ConvocatoriaDAO n = new ConvocatoriaDAO();
            List<Convocatoria> c =n.buscarConvocatorias();
            for(Convocatoria x : c){
                
                System.out.println(x);
            }
        } catch (Exception ex) {
            Logger.getLogger(ConvocatoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
