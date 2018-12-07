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
public class ActividadSimpleBacking implements Serializable {

    private ActividadSimple actividad;
    private Impacto impacto;

    @PostConstruct
    public void init() {
        this.actividad = new ActividadSimple();
        this.impacto = new Impacto();
    }

    @EJB
    private ActividadSimpleDAO actividadSimpleDAO;

    @EJB
    private ODSDAO objetivoDao;

    public List<ActividadSimple> getAs() {
        return actividadSimpleDAO.traerAct();
    }

    public List<ODS> getObjetivos() {
        return objetivoDao.traerOds();
    }

    public void agregarImpacto() {
        impacto.setActividad(actividad);
        if (actividad.getImpactos() == null) {
            actividad.setImpactos(new ArrayList<Impacto>());
        }
        this.actividad.getImpactos().add(impacto);
        impacto = new Impacto();
    }

    public void quitarImpacto(Impacto impacto) {
        this.actividad.getImpactos().remove(impacto);
    }

    public String create() {
        try {
            actividadSimpleDAO.agregarAct(actividad);
            return "/actividades_simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            actividadSimpleDAO.modificarAct(actividad);
            return "/actividades_simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(ActividadSimple actividad) {

        actividadSimpleDAO.borrarAct(actividad);

    }

    public ActividadSimple getActividad() {
        return actividad;
    }

    public void setActividad(ActividadSimple actividad) {
        this.actividad = actividad;
    }

    public Impacto getImpacto() {
        return impacto;
    }

    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
    }
}
