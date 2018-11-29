package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
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
        return odsDAO.traerOds();
    }

    public String create() {
        try {
            odsDAO.agregarOds(ods);
            return "/objetivos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            odsDAO.modificarOds(ods);
            return "/objetivos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(ODS ods) {

        odsDAO.borrarOds(ods);

    }
    
    public ODS getUser() {
        return ods;
    }

    public void setUser(ODS ods) {
        this.ods = ods;
    }
    

}
