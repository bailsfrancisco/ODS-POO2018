package ar.edu.unnoba.poo2018.ods.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("actividad_simple")
@NamedQueries({
    @NamedQuery(name = "actividadSimple.getAllActividadSimple",
            query = "Select a From ActividadSimple a")
})
public class ActividadSimple extends Actividad implements Serializable {

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "actividad")
    private List<Impacto> impactos;

    public ActividadSimple() {
    }

    public ActividadSimple(String nombreActividad, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Ambito ambito, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, ArrayList<Usuario> responsables) {
        super(nombreActividad, fechaInicio, fechaFin, resolucion, expediente, ambito, convocatoria, lineaEstrategica, responsables);
    }

    public List<Impacto> getImpactos() {
        return impactos;
    }

    public void setImpactos(List<Impacto> impactos) {
        this.impactos = impactos;
    }
    
    
}