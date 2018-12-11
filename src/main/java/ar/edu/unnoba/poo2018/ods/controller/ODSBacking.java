package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ODSBacking implements Serializable {

    private ODS ods;

    @PostConstruct
    public void init() {
        this.ods = new ODS();
    }

    @EJB
    private ODSDAO odsDAO;

    public List<ODS> getOds() {
        return odsDAO.getAll();
    }

    public String create() {
        try {
            odsDAO.create(ods);
            return "/objetivos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            odsDAO.update(ods);
            return "/objetivos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(ODS ods) {

        odsDAO.delete(ods);

    }

    public ODS getODS() {
        return ods;
    }

    public void setODS(ODS ods) {
        this.ods = ods;
    }

    public String Agregar() {
        return "new?faces-redirect=true";
    }

    public String Modificar() {
        return "edit?faces-redirect=true";
    }

    public String Borrar() {
        return "index?faces-redirect=true";
    }
}
