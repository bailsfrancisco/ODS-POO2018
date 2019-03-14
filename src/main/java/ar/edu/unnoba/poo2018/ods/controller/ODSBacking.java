package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ImpactoDAO;
import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.io.Serializable;
import java.util.List;
import java.util.PropertyResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import org.eclipse.persistence.exceptions.DatabaseException;

@ManagedBean
@ViewScoped
public class ODSBacking implements Serializable {

    private ODS ods;

    @Inject
    private transient PropertyResourceBundle bundle;

    @PostConstruct
    public void init() {
        this.ods = new ODS();
    }

    @EJB
    private ODSDAO odsDAO;
    
    @EJB
    private ImpactoDAO impactoDAO;

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
        try {
            odsDAO.delete(ods);
        } catch (DatabaseException | ConstraintViolationException | EJBException de) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(bundle.getString("errorObjetivo"));
            context.addMessage(null, message);
        }
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
