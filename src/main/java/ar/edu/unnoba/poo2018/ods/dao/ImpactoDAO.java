package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Impacto;
import javax.ejb.Stateless;

@Stateless
public class ImpactoDAO extends AbstractDAO<Impacto>{
    
    public ImpactoDAO() {
        super(Impacto.class);
    }
    
}
