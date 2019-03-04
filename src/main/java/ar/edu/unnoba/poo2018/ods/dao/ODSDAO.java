package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ODSDAO extends AbstractDAO<ODS> {

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    public ODSDAO() {
        super(ODS.class);
    }

    public List<ODS> getAll() {
        Query query = em.createNamedQuery("ods.allODS");
        return query.getResultList();
    }
}
