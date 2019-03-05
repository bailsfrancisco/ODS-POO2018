package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Impacto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ImpactoDAO extends AbstractDAO<Impacto>{
    
    public ImpactoDAO() {
        super(Impacto.class);
    }
    
    public List<Impacto> getAll() {
        Query query = em.createNamedQuery("impacto.allImpactos");
        return query.getResultList();
    }
}
