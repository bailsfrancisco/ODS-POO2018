package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.ActividadCompuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ActividadCompuestaDAO extends AbstractDAO<ActividadCompuesta> {

    public ActividadCompuestaDAO() {
        super(ActividadCompuesta.class);
    }

    public List<ActividadCompuesta> getAll() {
        Query query = em.createNamedQuery("actividadCompuesta.getAllActividadCompuesta");
        return query.getResultList();
    }

}
