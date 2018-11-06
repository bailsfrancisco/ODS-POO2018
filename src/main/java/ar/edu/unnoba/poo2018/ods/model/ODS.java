package ar.edu.unnoba.poo2018.ods.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ods")
public class ODS extends AbstractEntity{
    
    private String nombre;

    public ODS() {
    }

    public ODS(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
