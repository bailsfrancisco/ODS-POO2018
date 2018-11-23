package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.ods.dao.AbstractDAO;
import ar.edu.unnoba.poo2018.ods.model.AbstractEntity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author poo
 * @param <T>
 */
public abstract class AbstractConverter<T> implements Converter {

    public abstract String getDAOName();

    private AbstractDAO<T> getEntityDAO(FacesContext context) {
        InitialContext ic;
        try {
            ic = new InitialContext();
            return (AbstractDAO<T>) ic.lookup("java:module/" + getDAOName());
        } catch (NamingException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return this.getEntityDAO(context).find(Long.valueOf(value));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Long id = ((AbstractEntity) value).getId();
        return id == null ? "0" : id.toString();
    }
}
