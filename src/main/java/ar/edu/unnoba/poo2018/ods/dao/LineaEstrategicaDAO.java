package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.LineaEstrategica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class LineaEstrategicaDAO extends AbstractDAO<LineaEstrategica>{
    
    public LineaEstrategicaDAO() {
        super(LineaEstrategica.class);
    }
    
    public List<LineaEstrategica> getAll() {
        Query query = em.createNamedQuery("le.allLI");
        return query.getResultList();
    }
    
}
