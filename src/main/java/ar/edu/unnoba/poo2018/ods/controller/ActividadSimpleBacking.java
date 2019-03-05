package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ActividadSimpleDAO;
import ar.edu.unnoba.poo2018.ods.dao.AmbitoDAO;
import ar.edu.unnoba.poo2018.ods.dao.ConvocatoriaDAO;
import ar.edu.unnoba.poo2018.ods.dao.ImpactoDAO;
import ar.edu.unnoba.poo2018.ods.dao.LineaEstrategicaDAO;
import ar.edu.unnoba.poo2018.ods.model.ActividadSimple;
import ar.edu.unnoba.poo2018.ods.model.Impacto;
import ar.edu.unnoba.poo2018.ods.model.ODS;
import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import ar.edu.unnoba.poo2018.ods.model.Actividad;
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
public class ActividadSimpleBacking implements Serializable {

    private ActividadSimple actividadSimple;
    private Impacto impacto;
    private Ambito ambito;
    private Convocatoria convocatoria;
    private LineaEstrategica lineaEstrategica;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.actividadSimple = new ActividadSimple();
        this.impacto = new Impacto();
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
    private ImpactoDAO impactoDAO;

    public List<ActividadSimple> getActividades() {
        return actividadSimpleDAO.getAll();
    }

    public List<Convocatoria> getConvocatorias() {
        return convocatoriaDAO.getAll();
    }

    public List<ODS> getObjetivos() {
        return odsDAO.getAll();
    }

    public List<Ambito> getAmbitos() {
        return ambitoDAO.getAll();
    }

    public List<LineaEstrategica> getLineasEstategicas() {
        return lineaEstrategicaDAO.getAll();
    }

    public void agregarImpacto() {
        impacto.setActividad(actividadSimple);
        if (actividadSimple.getImpactos() == null) {
            actividadSimple.setImpactos(new ArrayList<Impacto>());
        }
        this.actividadSimple.getImpactos().add(impacto);
        impacto = new Impacto();
    }
    
    public void agregarUsuario(Usuario u) {
        if (actividadSimple.getResponsables() == null) {
            actividadSimple.setResponsables(new ArrayList<Usuario>());
        }
        this.actividadSimple.getResponsables().add(u);
        impacto = new Impacto();
    }

    public void quitarImpacto(Impacto impacto) {
        this.actividadSimple.getImpactos().remove(impacto);
    }
    
    public void quitarActividad(Usuario u) {
        this.actividadSimple.getResponsables().remove(u);
    }
    
    public List<ActividadSimple> actividades(Usuario u){
        List<ActividadSimple> actividades = this.getActividades();
        List<ActividadSimple> actividadesUsuario = new ArrayList<>();
        for(ActividadSimple a : actividades){
            if(a.getResponsables().contains(u)){
                actividadesUsuario.add(a);
            }
        }
        return actividadesUsuario;
    }

    public String create() {
        try {
            this.actividadSimple.setAmbito(this.getAmbito());
            this.actividadSimple.setConvocatoria(this.getConvocatoria());
            this.actividadSimple.setLineaEstrategica(this.getLineaEstrategica());
            actividadSimpleDAO.create(actividadSimple);
            return "/actividades_simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            this.actividadSimple.setAmbito(this.getAmbito());
            this.actividadSimple.setConvocatoria(this.getConvocatoria());
            this.actividadSimple.setLineaEstrategica(this.getLineaEstrategica());
            actividadSimpleDAO.update(actividadSimple);
            return "/actividades_simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }
    
    public float promedio(){
        List<Impacto> impactos = impactoDAO.getAll();
        int totalPesoImpactos = 0;
        for(Impacto i : impactos){
            totalPesoImpactos += i.getPeso();
        }
        return totalPesoImpactos;
    }
    public float promedioPorObjetivo(ODS ods){
        List<Impacto> impactos = impactoDAO.getAll();
        int totalPesoImpacto = 0;
        for(Impacto i : impactos){
            if(ods.getNombre().equals( i.getObjetivo().getNombre())){
                totalPesoImpacto += i.getPeso();
            }
        }
        return ((totalPesoImpacto / promedio()) * 100);
    }

    public void delete(ActividadSimple actividad) {
        actividadSimpleDAO.delete(actividad);
    }

    public ActividadSimple getActividad() {
        return actividadSimple;
    }

    public void setActividad(ActividadSimple actividadSimple) {
        this.actividadSimple = actividadSimple;
    }

    public Impacto getImpacto() {
        return impacto;
    }

    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
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
