package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ODSDAO extends AbstractDAO<ODS>{
    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    
    public ODSDAO() {
        super(ODS.class);
    }
    
    public List traerOds(){
        Query query = em.createNamedQuery("ods.allODS");
        List<ODS> ods = null;
        try{
            ods = query.getResultList();
        }catch(NoResultException nre){
            return null;
        }
        return ods;
    }
    
    public boolean agregarOds(ODS ods){
        try{
            em.persist(ods);
        }catch(Exception ex){
            return false;
        }
        return true;
     }
    
    public boolean borrarOds(ODS ods){
        try{
            em.remove(ods);
        }catch(Exception ex){
            return false;
        }
        return true;
     }
    
    public boolean modificarOds(ODS ods){
        try{
            em.merge(ods);
        }catch(Exception ex){
            return false;
        }
        return true;
     }
}
