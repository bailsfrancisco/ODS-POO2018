package ar.edu.unnoba.poo2018.ods.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("actividad_compuesta")
@NamedQueries({
    @NamedQuery(name = "actividadCompuesta.getAllActividadCompuesta",
            query = "Select a From ActividadCompuesta a")
})
public class ActividadCompuesta extends Actividad implements Serializable {

    @ManyToMany
    @JoinTable(
            name = "actividad_actividades_compuestas",
            joinColumns = @JoinColumn(name = "actividad_compuesta_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id", referencedColumnName = "id")
    )
    private List<Actividad> actividades;

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public ActividadCompuesta() {
    }

    public ActividadCompuesta(String nombreActividad, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Ambito ambito, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, ArrayList<Usuario> responsables, ArrayList<Actividad> actividades) {
        super(nombreActividad, fechaInicio, fechaFin, resolucion, expediente, ambito, convocatoria, lineaEstrategica, responsables);
        this.actividades = actividades;
    }
}
