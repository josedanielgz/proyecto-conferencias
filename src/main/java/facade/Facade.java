package facade;

import negocio.ConvocatoriaNegocio;
import modelo.Convocatoria;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inscripcion;
import modelo.Usuario;
import negocio.InscripcionNegocio;
import negocio.UsuarioNegocio;

//Sebastian
public class Facade {

    private final ConvocatoriaNegocio convocatoriaNegocio;
    private final InscripcionNegocio inscripcionNegocio;
    private final UsuarioNegocio usuarioNegocio;

    public Facade() {
        convocatoriaNegocio = new ConvocatoriaNegocio();
        inscripcionNegocio = new InscripcionNegocio();
        usuarioNegocio = new UsuarioNegocio();
    }

    // Para el manejo de convocatorias
    public String InsertarUsuario(Usuario u) {
        return usuarioNegocio.insertarUsuario(u);
    }

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
    public List<Inscripcion> buscarInscripciones() {
        return inscripcionNegocio.buscarInscripciones();
    }

    public Inscripcion devolverArchivo(Integer documento, String convocatoria) {
        return inscripcionNegocio.devolverArchivo(documento, convocatoria);
    }

    // Para el manejo de usuarios
    
    public boolean inicioDeSesion(Integer documento, String clave_acceso) {
        return usuarioNegocio.inicioDeSesion(documento, clave_acceso);
    }

    public boolean insertarAdministrador(Integer documento) {
        return usuarioNegocio.insertarAdministrador(documento);
    }

    public static void main(String[] args) {

        Facade a = new Facade();

        System.out.println(a.insertarAdministrador(9));

    }
}
