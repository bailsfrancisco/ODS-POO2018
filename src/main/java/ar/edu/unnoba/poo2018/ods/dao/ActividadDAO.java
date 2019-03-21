package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Actividad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ActividadDAO extends AbstractDAO<Actividad> {

    public ActividadDAO() {
        super(Actividad.class);
    }

    public List<Actividad> getActividades(Long id) {
        Query query = em.createQuery("SELECT a FROM Actividad a JOIN a.responsables r where r.id=:id");
        query.setParameter("id", id);
        List<Actividad> actividades;
        try {
            actividades = query.getResultList();
            System.out.println(actividades);
        } catch (Exception e) {
            actividades = null;
        }
        return actividades;
    }
}
