package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Ambito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class AmbitoDAO extends AbstractDAO<Ambito>{
    
    public AmbitoDAO() {
        super(Ambito.class);
    }
    
    public List<Ambito> getAll() {
        Query query = em.createNamedQuery("a.allAmbito");
        return query.getResultList();
    }
    
}
