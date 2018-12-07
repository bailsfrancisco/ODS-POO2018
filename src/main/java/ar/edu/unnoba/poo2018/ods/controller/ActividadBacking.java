package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ActividadSimpleDAO;
import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import ar.edu.unnoba.poo2018.ods.model.ActividadSimple;
import ar.edu.unnoba.poo2018.ods.model.Impacto;
import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
 
@Named
@ViewScoped
public class ActividadBacking implements Serializable {
    private ActividadSimple actividadSimple;
    private Impacto impacto;
    
    @PostConstruct
    public void init(){
        this.actividadSimple = new ActividadSimple();
        this.impacto = new Impacto();
    }
    
    @EJB
    private ActividadSimpleDAO actividadSimpleDAO;
    
    @EJB
    private ODSDAO ODSDAO;
    
    public List<ActividadSimple> getActividades(){
        return actividadSimpleDAO.getAll();
    }
    
    public List<ODS> getObjetivos(){
        return ODSDAO.getAll();
    }
    
    public void agregarImpacto(){
        impacto.setActividad(actividadSimple);
        if(actividadSimple.getImpactos()==null){
            actividadSimple.setImpactos(new ArrayList<Impacto>());
        }
        this.actividadSimple.getImpactos().add(impacto);
        impacto = new Impacto();
    }
    
    public void quitarImpacto(Impacto impacto){
        this.actividadSimple.getImpactos().remove(impacto);
    }
    
    
    public String create(){
        try{
            actividadSimpleDAO.create(actividadSimple);
            return "/actividades/index?faces-redirect=true";
        }catch(Exception e){
            return null;
        }
    }
    
    public String update(){
        try{
           actividadSimpleDAO.update(actividadSimple);
            return "/actividades/index?faces-redirect=true";
        }catch(Exception e){
            return null;
        }
    }
    
    public void delete(ActividadSimple actividad){
       actividadSimpleDAO.delete(actividadSimple);
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
}
