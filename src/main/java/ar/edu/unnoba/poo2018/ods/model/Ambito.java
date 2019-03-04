package ar.edu.unnoba.poo2018.ods.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ambito")
@NamedQueries({
    @NamedQuery(name = "a.allAmbito",
            query = "Select a From Ambito a"),})
public class Ambito extends AbstractEntity{
    
    private String nombre;
    private String descripcion;

    public Ambito() {
    }

    public Ambito(String nombre, String descripcion) {
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
