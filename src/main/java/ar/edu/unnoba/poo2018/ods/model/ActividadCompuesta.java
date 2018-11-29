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

@Entity
@DiscriminatorValue("actividad_compuesta")
public class ActividadCompuesta extends Actividad implements Serializable {
    
    @ManyToMany
    @JoinTable(
        name="actividadI_actividadC",joinColumns=@JoinColumn(name="actividadI_id", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="actividadC_id", referencedColumnName="id"))
    private List<Actividad> actividades;    

    public ActividadCompuesta() {
    }
    
    
    public ActividadCompuesta(String nombreActividad, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Ambito ambito, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, ArrayList<Usuario> responsables) {
        super(nombreActividad, fechaInicio, fechaFin, resolucion, expediente, ambito, convocatoria, lineaEstrategica, responsables);
    }
}
