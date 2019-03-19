package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Actividad;
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
    
    /*
    public List<ActividadSimple> getActividades(Long id) {
        Query query = em.createNativeQuery("SELECT * from Actividad a where a.id IN (select r.actividad_id from Responsables r where r.usuario_id=?) and a.id IN (select s.id from Actividades_Simples s)", ActividadSimple.class);
        query.setParameter(1, id);
        List<ActividadSimple> simples;
        try {
            simples = query.getResultList();
        } catch (Exception e) {
            simples = null;
        }
        return simples;
    }*/
}
