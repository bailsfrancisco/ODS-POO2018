package ar.edu.unnoba.poo2018.ods.model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Actividad")
public abstract class Actividad extends AbstractEntity {
    @Id 
    @GeneratedValue
    private String nombreActividad;
    private Date fechaInicio;
    private Date fechaFin;
    private String resolucion;
    private String expediente;
    private Ambito ambito;
    private Convocatoria convocatoria;
    private LineaEstrategica lineaEstrategica;
    private ArrayList<Usuario> responsables;

}