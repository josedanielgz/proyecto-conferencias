/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import capadatos.dao.ConvocatoriaDAO;
import java.time.LocalDate;
import java.time.Month;
import modelo.Convocatoria;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//Sebastian
public class ConvocatoriaNegocio {

    private final ConvocatoriaDAO convocatoriaDAO;

    public ConvocatoriaNegocio() {
        convocatoriaDAO = new ConvocatoriaDAO();

    }

    public String insertarConvocatoria(Convocatoria p) {
//        boolean rta = false;
        try {
            Convocatoria pe = convocatoriaDAO.buscarConvocatoria(p.getId()); //La busca para asegurarse de que no exista
            if (pe == null) {

                boolean res = convocatoriaDAO.insertarConvocatoria(p);

                if (res) {
//                    rta = true;
                    return "La convocatoria se registró exitosamente";
                }
            } else {

                return "Esta convocatoria ya había sido registrada antes";
            }
        } catch (Exception ex) {
            Logger.getLogger(ConvocatoriaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return "Hubo un error: " + ex.toString();
        }
        return null;
    }

    public Convocatoria buscarConvocatoria(String id) {

        try {
            Convocatoria c = new Convocatoria();
            c = convocatoriaDAO.buscarConvocatoria(id);
            return c;
        } catch (Exception ex) {
            Logger.getLogger(ConvocatoriaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Convocatoria> buscarConvocatorias() {
        try {
            List<Convocatoria> convocatorias;
            convocatorias = convocatoriaDAO.buscarConvocatorias();
            return convocatorias;
        } catch (Exception ex) {
            Logger.getLogger(ConvocatoriaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ConvocatoriaNegocio cn = new ConvocatoriaNegocio();
        Convocatoria c = new Convocatoria("3", "Convocatoria 3", "Una descripción", LocalDate.now(), LocalDate.of(2021, Month.AUGUST, 11), LocalDate.of(2021, Month.AUGUST, 13), "Abierta", "");
        System.out.println(cn.insertarConvocatoria(c));
//        try {
//            for (Convocatoria a : cn.buscarConvocatorias()) {
//
//                System.out.println(a);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ConvocatoriaNegocio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
