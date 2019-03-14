package ar.edu.unnoba.poo2018.ods.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "convocatoria")
@NamedQueries({
    @NamedQuery(name = "c.allConvocatorias",
            query = "Select c From Convocatoria c"),})
public class Convocatoria extends AbstractEntity{
    
    private String nombre;
    private String descripcion;

    public Convocatoria() {
    }

    public Convocatoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
}
