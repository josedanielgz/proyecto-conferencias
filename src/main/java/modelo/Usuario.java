/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Jose
package modelo;

import java.time.LocalDate;
import java.util.Objects;


public class Usuario {
    private Integer documento;
    private String primer_nombre;
    private String primer_apellido;
    private LocalDate fecha_nacimiento;

    public Usuario() {
        super();
    }

    public Usuario(Integer documento, String primer_nombre, String primer_apellido, LocalDate fecha_nacimiento) {
        this.documento = documento;
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.documento);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        return true;
    }
    
    public boolean isNull(){
    
        return this.documento==null;
    }
}
