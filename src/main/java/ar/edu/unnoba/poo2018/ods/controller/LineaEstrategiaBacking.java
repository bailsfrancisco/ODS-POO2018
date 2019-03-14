package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.LineaEstrategicaDAO;
import ar.edu.unnoba.poo2018.ods.model.LineaEstrategica;
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
public class LineaEstrategiaBacking implements Serializable {

    private LineaEstrategica linea_estrategica;

    @Inject
    private transient PropertyResourceBundle bundle;

    @PostConstruct
    public void init() {
        this.linea_estrategica = new LineaEstrategica();
    }

    @EJB
    private LineaEstrategicaDAO lineaEstrategicaDAO;

    public List<LineaEstrategica> getLineaEstrategica() {
        return lineaEstrategicaDAO.getAll();
    }

    public String create() {
        try {
            lineaEstrategicaDAO.create(linea_estrategica);
            return "/lineas_estrategicas/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            lineaEstrategicaDAO.update(linea_estrategica);
            return "/lineas_estrategicas/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(LineaEstrategica linea_estrategica) {
        try {
            lineaEstrategicaDAO.delete(linea_estrategica);
        } catch (DatabaseException | ConstraintViolationException | EJBException de) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(bundle.getString("errorLineaEstrategica"));
            context.addMessage(null, message);
        }
    }

    public LineaEstrategica getLinea_estrategica() {
        return linea_estrategica;
    }

    public void setLinea_estrategica(LineaEstrategica linea_estrategica) {
        this.linea_estrategica = linea_estrategica;
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
