/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class ODSDAO extends AbstractDAO<ODS> {

    private ODS ods;

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    public ODSDAO() {
        super(ODS.class);
    }

    public boolean agregarOds() throws Exception {
        try {
            em.persist(ods);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean borrarOds() throws Exception {
        try {
            em.remove(ods);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean modificarOds() throws Exception {
        try {
            em.merge(ods);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public List findAll() {
        Query query = em.createNamedQuery("ods.allODS");
        List<ODS> ODS = null;
        try {
            ODS = query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
        return ODS;
    }
}


