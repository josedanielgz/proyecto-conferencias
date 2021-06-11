/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Esteban
package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Inscripcion {

    private LocalDate fecha_inscripcion;
    private Integer documento;
    private String convocatoria;
    
    private String nombre_archivo;
    private byte[] arhivo;

    public Inscripcion() {
    }

    public Inscripcion(Integer documento, String convocatoria, LocalDate fecha_inscripcion, String nombre_archivo) {
        this.fecha_inscripcion = fecha_inscripcion;
        this.documento = documento;
        this.convocatoria = convocatoria;
        this.nombre_archivo = nombre_archivo;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    
    
    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public byte[] getArhivo() {
        return arhivo;
    }

    public void setArhivo(byte[] arhivo) {
        this.arhivo = arhivo;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "fecha_inscripcion=" + fecha_inscripcion + ", documento=" + documento + ", convocatoria=" + convocatoria + ", nombre_archivo=" + nombre_archivo + ", arhivo=" + arhivo + '}';
    }
  
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.documento);
        hash = 53 * hash + Objects.hashCode(this.fecha_inscripcion);
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
        final Inscripcion other = (Inscripcion) obj;
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        return Objects.equals(this.fecha_inscripcion, other.fecha_inscripcion);
    }
    
    public boolean isNull(){
    
       return this.documento==null || this.convocatoria==null;
    }

}
