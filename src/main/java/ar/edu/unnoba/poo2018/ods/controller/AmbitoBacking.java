package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.AmbitoDAO;
import ar.edu.unnoba.poo2018.ods.model.Ambito;
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
public class AmbitoBacking implements Serializable {

    private Ambito ambito;

    @Inject
    private transient PropertyResourceBundle bundle;

    @PostConstruct
    public void init() {
        this.ambito = new Ambito();
    }

    @EJB
    private AmbitoDAO ambitoDAO;

    public List<Ambito> getAmbitos() {
        return ambitoDAO.getAll();
    }

    public String create() {
        try {
            ambitoDAO.create(ambito);
            return "/ambitos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            ambitoDAO.update(ambito);
            return "/ambitos/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Ambito ambitos) {
        try {
            ambitoDAO.delete(ambitos);
        } catch (DatabaseException | ConstraintViolationException | EJBException de) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(bundle.getString("errorAmbito"));
            context.addMessage(null, message);
        }
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
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
