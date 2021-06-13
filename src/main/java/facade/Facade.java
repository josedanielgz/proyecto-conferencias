package facade;

import negocio.ConvocatoriaNegocio;
import modelo.Convocatoria;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inscripcion;
import negocio.InscripcionNegocio;

//Sebastian
public class Facade {

    private final ConvocatoriaNegocio convocatoriaNegocio;
    private final InscripcionNegocio inscripcionNegocio;

    public Facade() {
        convocatoriaNegocio = new ConvocatoriaNegocio();
        inscripcionNegocio = new InscripcionNegocio();
    }

    // Para el manejo de convocatorias
    
    public String insertarConvocatoria(Convocatoria c) {
        return convocatoriaNegocio.insertarConvocatoria(c);
    }

    public Convocatoria buscarConvocatoria(String id) {
        return convocatoriaNegocio.buscarConvocatoria(id);
    }

    public List<Convocatoria> buscarConvocatorias() {
        return convocatoriaNegocio.buscarConvocatorias();
    }
    
    // Para el manejo de inscripciones
    
    public List<Inscripcion> buscarInscripciones(){
        return inscripcionNegocio.buscarInscripciones();
    }

    public Inscripcion devolverArchivo(Integer documento, String convocatoria) {
        return inscripcionNegocio.devolverArchivo(documento, convocatoria);
    }

    public static void main(String[] args) {

        Facade a = new Facade();

        System.out.println(a.buscarInscripciones());

    }
}
