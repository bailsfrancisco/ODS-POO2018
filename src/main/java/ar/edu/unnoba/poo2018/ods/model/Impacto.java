package ar.edu.unnoba.poo2018.ods.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "impacto")
@NamedQueries({
    @NamedQuery(name = "impacto.allImpactos",
            query = "Select i From Impacto i"),})
public class Impacto extends AbstractEntity {

    private Integer peso;

    @ManyToOne
    @JoinColumn(name = "actividad_id")
    private ActividadSimple actividad;

    /*
    @JoinColumn(name = "objetivo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)*/
    @ManyToOne
    @JoinColumn(name = "objetivo_id")
    private ODS objetivo;

    public Impacto() {
    }

    public Impacto(Integer peso, ODS objetivo) {
        this.peso = peso;
        this.objetivo = objetivo;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public ODS getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ODS objetivo) {
        this.objetivo = objetivo;
    }

    public ActividadSimple getActividad() {
        return actividad;
    }

    public void setActividad(ActividadSimple actividad) {
        this.actividad = actividad;
    }

}
