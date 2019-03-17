package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ActividadCompuestaDAO;
import ar.edu.unnoba.poo2018.ods.dao.ActividadSimpleDAO;
import ar.edu.unnoba.poo2018.ods.dao.AmbitoDAO;
import ar.edu.unnoba.poo2018.ods.dao.ConvocatoriaDAO;
import ar.edu.unnoba.poo2018.ods.dao.LineaEstrategicaDAO;
import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import ar.edu.unnoba.poo2018.ods.dao.UsuarioDAO;
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
public class ActividadCompuestaBacking implements Serializable{
    
   private List<ActividadSimple> actividades;
   
   private ActividadCompuesta actividadC;

    private Usuario usuario;
    private Usuario usuario2;

    private Ambito ambito;
    private Convocatoria convocatoria;
    private LineaEstrategica lineaEstrategica;

    @PostConstruct
    public void init() {
        this.actividades = new ArrayList<>();
        this.ambito = new Ambito();
        this.convocatoria = new Convocatoria();
        this.lineaEstrategica = new LineaEstrategica();
    }

    @EJB
    private ActividadSimpleDAO actividadSimpleDAO;

    @EJB
    private ODSDAO odsDAO;

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

    public List<ActividadSimple> getActividades() {
        return actividadSimpleDAO.getAll();
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

    public String create() {
        try {
            this.actividadC.setAmbito(this.getAmbito());
            this.actividadC.setConvocatoria(this.getConvocatoria());
            this.actividadC.setLineaEstrategica(this.getLineaEstrategica());
            actividadCompuestaDAO.create(actividadC);
            return "/actividades_simples/index?faces-redirect=true";
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
            return "/actividades_simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }


    public void delete(ActividadSimple actividad) {
        actividadSimpleDAO.delete(actividad);
    }

    public ActividadCompuesta getActividad() {
        return actividadC;
    }

    public void setActividad(ActividadCompuesta actividadC) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
