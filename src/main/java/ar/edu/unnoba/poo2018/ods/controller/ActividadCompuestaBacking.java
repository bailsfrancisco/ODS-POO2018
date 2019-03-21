package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ActividadCompuestaDAO;
import ar.edu.unnoba.poo2018.ods.dao.ActividadSimpleDAO;
import ar.edu.unnoba.poo2018.ods.dao.AmbitoDAO;
import ar.edu.unnoba.poo2018.ods.dao.ConvocatoriaDAO;
import ar.edu.unnoba.poo2018.ods.dao.LineaEstrategicaDAO;
import ar.edu.unnoba.poo2018.ods.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.ods.model.Actividad;
import ar.edu.unnoba.poo2018.ods.model.ActividadCompuesta;
import ar.edu.unnoba.poo2018.ods.model.ActividadSimple;
import ar.edu.unnoba.poo2018.ods.model.Ambito;
import ar.edu.unnoba.poo2018.ods.model.Convocatoria;
import ar.edu.unnoba.poo2018.ods.model.LineaEstrategica;
import ar.edu.unnoba.poo2018.ods.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ActividadCompuestaBacking implements Serializable {

    private ArrayList<Actividad> actividades;

    private ActividadCompuesta actividadC;
    private ActividadCompuesta actividadC2;

    private Usuario usuario;
    private Usuario usuario2;

    private ActividadSimple actividadSimple;
    private ActividadSimple actividadSimple2;

    private Ambito ambito;
    private Convocatoria convocatoria;
    private LineaEstrategica lineaEstrategica;

    @PostConstruct
    public void init() {
        this.actividadC = new ActividadCompuesta();
        this.actividades = new ArrayList<>();
        this.ambito = new Ambito();
        this.convocatoria = new Convocatoria();
        this.lineaEstrategica = new LineaEstrategica();
    }

    @EJB
    private ActividadSimpleDAO actividadSimpleDAO;

    @EJB
    private LineaEstrategicaDAO lineaEstrategicaDAO;

    @EJB
    private ConvocatoriaDAO convocatoriaDAO;

    @EJB
    private AmbitoDAO ambitoDAO;

    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private ActividadCompuestaDAO actividadCompuestaDAO;

    public List<ActividadCompuesta> getActividades() {
        return actividadCompuestaDAO.getAll();
    }

    public List<Convocatoria> getConvocatorias() {
        return convocatoriaDAO.getAll();
    }

    public List<Ambito> getAmbitos() {
        return ambitoDAO.getAll();
    }

    public List<LineaEstrategica> getLineasEstategicas() {
        return lineaEstrategicaDAO.getAll();
    }

    public String agregarUsuario(Usuario u, ActividadCompuesta ac) {
        if (actividadC.getResponsables() == null) {
            actividadC.setResponsables(new ArrayList<Usuario>());
        }
        this.actividadC.getResponsables().add(u);
        try {
            actividadCompuestaDAO.update(actividadC);
            return "/asignaciones/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void asignarActividadC_a_Usuario(ActividadCompuesta ac, Usuario u) {
        if (actividadC2 == null && usuario2 == null) {
            actividadC2 = ac;
            usuario2 = u;
        }
        u.getActividades().add(ac);
        usuarioDAO.update(u);
    }

    public void quitarActividad_a_Usuario(ActividadCompuesta ac, Usuario u) {
        u.getActividades().remove(ac);
        ac.getResponsables().remove(u);
        usuarioDAO.update(u);
        actividadCompuestaDAO.update(ac);
    }

    public String agregarActividadSimple(ActividadCompuesta ac, ActividadSimple as) {
        actividadCompuestaDAO.update(ac);
        return "/actividades_compuestas/index?faces-redirect=true";
    }

    public void agregarActividadSimple_a_compuesta(ActividadSimple as, ActividadCompuesta ac) {
        if (actividadSimple2 == null && this.actividades == null) {
            actividadSimple2 = as;
            this.actividades = new ArrayList<>();
        }
        ac.getActividades().add(as);
        as.getCompuestas().add(ac);
    }

    public void quitarActividad_a_Compuesta(ActividadSimple as, ActividadCompuesta ac) {
        ac.getActividades().remove(as);
        as.getCompuestas().remove(ac);
        actividadSimpleDAO.update(as);
        actividadCompuestaDAO.update(ac);
    }

    public String create() {
        try {
            this.actividadC.setAmbito(this.getAmbito());
            this.actividadC.setConvocatoria(this.getConvocatoria());
            this.actividadC.setLineaEstrategica(this.getLineaEstrategica());
            actividadCompuestaDAO.create(actividadC);
            return "/actividades_compuestas/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            this.actividadC.setAmbito(this.getAmbito());
            this.actividadC.setConvocatoria(this.getConvocatoria());
            this.actividadC.setLineaEstrategica(this.getLineaEstrategica());
            actividadCompuestaDAO.update(actividadC);
            return "/actividades_compuestas/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete_compuesta(ActividadCompuesta actividad_compuesta) {
        actividadCompuestaDAO.delete(actividad_compuesta);
    }

    public void delete_simple(ActividadSimple actividad) {
        actividadSimpleDAO.delete(actividad);
    }

    public ActividadSimple getActividadSimple() {
        return actividadSimple;
    }

    public void setActividadSimple(ActividadSimple actividadSimple) {
        this.actividadSimple = actividadSimple;
    }

    public ActividadCompuesta getActividadCompuesta() {
        return actividadC;
    }

    public void setActividadCompuesta(ActividadCompuesta actividadC) {
        this.actividadC = actividadC;
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
}
