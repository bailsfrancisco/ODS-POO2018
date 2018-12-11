package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.ActividadSimple;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ActividadSimpleDAO extends AbstractDAO<ActividadSimple> {

    public ActividadSimpleDAO() {
        super(ActividadSimple.class);
    }

    
    /* IDEM QUE ODSBacking
    public List traerAct() {
        Query query = em.createNamedQuery("ods.allODS");
        List<ActividadSimple> as = null;
        try {
            as = query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
        return as;
    }

    public boolean agregarAct(ActividadSimple as) {
        try {
            em.persist(as);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean borrarAct(ActividadSimple as) {
        try {
            em.remove(as);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean modificarAct(ActividadSimple as) {
        try {
            em.merge(as);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }*/

    public List<ActividadSimple> getAll() {
        Query query = em.createNamedQuery("actividadSimple.getAllActividadSimple");
        return query.getResultList();
    }
}
