

//Sebastian
package modelo;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


public class Convocatoria implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_inscripcion;
    private LocalDate fecha_final;
    private String estado;
    private String requisito;

    public Convocatoria() {
        super();
    }

    public Convocatoria(String id, String nombre, String descripcion, LocalDate fecha_inicio,
                        LocalDate fecha_inscripcion, LocalDate fecha_final, String estado, String requisito) {
        
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_final = fecha_final;
        this.estado = estado;
        this.requisito = requisito;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(LocalDate fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    @Override
    public String toString() {
        return "Convocatoria{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio + ", fecha_inscripcion=" + fecha_inscripcion + ", fecha_final=" + fecha_final + ", estado=" + estado + ", requisito=" + requisito + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convocatoria other = (Convocatoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public boolean isNull(){
        return this.id == null;
    }
    
}
