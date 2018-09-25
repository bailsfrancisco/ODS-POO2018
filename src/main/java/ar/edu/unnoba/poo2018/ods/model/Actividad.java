package ar.edu.unnoba.poo2018.ods.model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Actividad {

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