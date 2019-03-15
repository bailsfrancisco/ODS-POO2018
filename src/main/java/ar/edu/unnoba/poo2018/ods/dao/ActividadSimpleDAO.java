package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.ActividadSimple;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ActividadSimpleDAO extends AbstractDAO<ActividadSimple> {

    public ActividadSimpleDAO() {
        super(ActividadSimple.class);
    }

    public List<ActividadSimple> getAll() {
        Query query = em.createNamedQuery("actividadSimple.getAllActividadSimple");
        return query.getResultList();
    }
}
