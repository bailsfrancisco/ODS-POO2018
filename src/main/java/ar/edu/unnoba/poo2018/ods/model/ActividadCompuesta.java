package ar.edu.unnoba.poo2018.ods.model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actividad_compuesta")
public class ActividadCompuesta extends Actividad {
    
    @JoinColumn(name = "actividades_id")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad_compuesta")
    private ArrayList<Actividad> actividades; 

    public ActividadCompuesta(String nombreActividad, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Ambito ambito, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, ArrayList<Usuario> responsables) {
        super(nombreActividad, fechaInicio, fechaFin, resolucion, expediente, ambito, convocatoria, lineaEstrategica, responsables);
    }
}