package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ConvocatoriaDAO;
import ar.edu.unnoba.poo2018.ods.model.Convocatoria;
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
public class ConvocatoriaBacking implements Serializable{
        
    private Convocatoria convocatoria;

    @Inject
    private transient PropertyResourceBundle bundle;

    @PostConstruct
    public void init() {
        this.convocatoria = new Convocatoria();
    }

    @EJB
    private ConvocatoriaDAO convocatoriaDAO;

    public List<Convocatoria> getConvocatorias() {
        return convocatoriaDAO.getAll();
    }

    public String create() {
        try {
            convocatoriaDAO.create(convocatoria);
            return "/convocatorias/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            convocatoriaDAO.update(convocatoria);
            return "/convocatorias/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Convocatoria convocatoria) {
        try {
            convocatoriaDAO.delete(convocatoria);
        } catch (DatabaseException | ConstraintViolationException | EJBException de) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(bundle.getString("errorConvocatoria"));
            context.addMessage(null, message);
        }
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
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
