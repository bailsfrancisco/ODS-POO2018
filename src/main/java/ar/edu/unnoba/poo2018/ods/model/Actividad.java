package ar.edu.unnoba.poo2018.ods.model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "actividad")
public abstract class Actividad extends AbstractEntity {
    
    private String nombreActividad;
    private Date fechaInicio;
    private Date fechaFin;
    private String resolucion;
    private String expediente;
    
    @JoinColumn(name = "ambito_id")
    @ManyToOne(optional = false)
    private Ambito ambito;
    
    @JoinColumn(name = "convocatoria_id")
    @ManyToOne(optional = false)
    private Convocatoria convocatoria;
    
    @JoinColumn(name = "linea_estrategica_id")
    @ManyToOne(optional = false)
    private LineaEstrategica lineaEstrategica;
    
    @JoinColumn(name = "responsables_id")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad")
    private ArrayList<Usuario> responsables;

    public Actividad(String nombreActividad, Date fechaInicio, Date fechaFin, String resolucion, String expediente, Ambito ambito, Convocatoria convocatoria, LineaEstrategica lineaEstrategica, ArrayList<Usuario> responsables) {
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resolucion = resolucion;
        this.expediente = expediente;
        this.ambito = ambito;
        this.convocatoria = convocatoria;
        this.lineaEstrategica = lineaEstrategica;
        this.responsables = responsables;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public LineaEstrategica getLineaEstrategica() {
        return lineaEstrategica;
    }

    public void setLineaEstrategica(LineaEstrategica lineaEstrategica) {
        this.lineaEstrategica = lineaEstrategica;
    }

    public ArrayList<Usuario> getResponsables() {
        return responsables;
    }

    public void setResponsables(ArrayList<Usuario> responsables) {
        this.responsables = responsables;
    }
}