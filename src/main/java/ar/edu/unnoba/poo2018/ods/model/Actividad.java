package ar.edu.unnoba.poo2018.ods.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "actividad")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipo_actividad",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Actividad extends AbstractEntity {

    private String nombreActividad;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
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

    @ManyToMany
    @JoinTable(
            name = "responsables",
            joinColumns = @JoinColumn(name = "actividad_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    )
    private List<Usuario> responsables;

    @ManyToMany(mappedBy = "actividades")
    private List<ActividadCompuesta> compuestas;

    public Actividad() {
    }

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

    public List<Usuario> getResponsables() {
        return responsables;
    }

    public void setResponsables(ArrayList<Usuario> responsables) {
        this.responsables = responsables;
    }
}
