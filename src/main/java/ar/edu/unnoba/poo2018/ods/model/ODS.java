package ar.edu.unnoba.poo2018.ods.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ods")
@NamedQueries({
    @NamedQuery(name = "ods.allODS",
            query = "Select o From ODS o"),})
public class ODS extends AbstractEntity {

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

    @Override
    public String toString() {
        return nombre;
    }

}
