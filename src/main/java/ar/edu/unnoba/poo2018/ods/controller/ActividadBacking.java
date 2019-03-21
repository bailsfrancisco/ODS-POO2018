package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ActividadCompuestaDAO;
import ar.edu.unnoba.poo2018.ods.dao.ActividadDAO;
import ar.edu.unnoba.poo2018.ods.dao.ActividadSimpleDAO;
import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import ar.edu.unnoba.poo2018.ods.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.ods.model.Actividad;
import ar.edu.unnoba.poo2018.ods.model.ActividadCompuesta;
import ar.edu.unnoba.poo2018.ods.model.ActividadSimple;
import ar.edu.unnoba.poo2018.ods.model.Impacto;
import ar.edu.unnoba.poo2018.ods.model.ODS;
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
public class ActividadBacking implements Serializable {

    private ActividadSimple actividadSimple;
    private Impacto impacto;
    private Actividad actividad;

    @EJB
    private ActividadSimpleDAO actividadSimpleDAO;

    @EJB
    private ActividadCompuestaDAO actividadCompuestaDAO;

    @EJB
    private ActividadDAO actividadDAO;

    @EJB
    private ODSDAO ODSDAO;

    @EJB
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        this.actividadSimple = new ActividadSimple();
        this.impacto = new Impacto();
    }

    public List<Actividad> actividadesUsuario(Usuario u) {
        List<ActividadSimple> actividadesTotales = this.getActividades();
        List<ActividadCompuesta> actividadesTotalesC = this.getActividadesC();
        List<Actividad> actividades = new ArrayList<>();
        for (ActividadSimple a : actividadesTotales) {
            if (a.getResponsables().contains(u)) {
                actividades.add(a);
            }
        }
        for (ActividadCompuesta ac : actividadesTotalesC) {
            if (ac.getResponsables().contains(u)) {
                actividades.add(ac);
            }
        }
        return actividades;
    }

    public String actualizar() {
        return "/actividades/index?faces-redirect=true";
    }

    public List<ActividadCompuesta> getActividadesC() {
        return actividadCompuestaDAO.getAll();
    }

    public List<ActividadSimple> getActividades() {
        return actividadSimpleDAO.getAll();
    }

    public List<ODS> getObjetivos() {
        return ODSDAO.getAll();
    }

    public void agregarImpacto() {
        impacto.setActividad(actividadSimple);
        if (actividadSimple.getImpactos() == null) {
            actividadSimple.setImpactos(new ArrayList<Impacto>());
        }
        this.actividadSimple.getImpactos().add(impacto);
        impacto = new Impacto();
    }

    public void quitarImpacto(Impacto impacto) {
        this.actividadSimple.getImpactos().remove(impacto);
    }

    public void quitarActividad_a_Usuario(Actividad a, Usuario u) {
        u.getActividades().remove(a);
        a.getResponsables().remove(u);
        usuarioDAO.update(u);
        actividadDAO.update(a);
    }

    public String create() {
        try {
            actividadSimpleDAO.create(actividadSimple);
            return "/actividades_simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            actividadSimpleDAO.update(actividadSimple);
            return "/actividades_simples/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
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
}
