package ar.edu.unnoba.poo2018.ods.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "linea_estrategica")
@NamedQueries({
    @NamedQuery(name = "le.allLI",
            query = "Select le From LineaEstrategica le"),})
public class LineaEstrategica extends AbstractEntity{
    
    private String nombre;
    private String descripcion;

    public LineaEstrategica() {
    }

    public LineaEstrategica(String nombre, String descripcion) {
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
