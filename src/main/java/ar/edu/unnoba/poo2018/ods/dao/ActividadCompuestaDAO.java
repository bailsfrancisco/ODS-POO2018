package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.ActividadCompuesta;
import javax.ejb.Stateless;

@Stateless
public class ActividadCompuestaDAO extends AbstractDAO<ActividadCompuesta>{
    
    public ActividadCompuestaDAO() {
        super(ActividadCompuesta.class);
    }
    
}
