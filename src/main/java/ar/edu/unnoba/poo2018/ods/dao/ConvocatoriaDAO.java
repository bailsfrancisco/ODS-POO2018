package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Convocatoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ConvocatoriaDAO extends AbstractDAO<Convocatoria>{
    
    public ConvocatoriaDAO() {
        super(Convocatoria.class);
    }
    
     public List<Convocatoria> getAll() {
        Query query = em.createNamedQuery("c.allConvocatorias");
        return query.getResultList();
    }
    
}
