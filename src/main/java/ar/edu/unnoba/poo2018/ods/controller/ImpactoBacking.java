package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ImpactoDAO;
import ar.edu.unnoba.poo2018.ods.model.Impacto;
import ar.edu.unnoba.poo2018.ods.model.ODS;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

public class ImpactoBacking implements Serializable {
    
    @EJB
    private ImpactoDAO impactoDAO;
    
    public List<Impacto> getImpactos() {
        return impactoDAO.getAll();
    }
}
