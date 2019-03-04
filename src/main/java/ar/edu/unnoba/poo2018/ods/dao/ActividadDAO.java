package ar.edu.unnoba.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Actividad;
import javax.ejb.Stateless;

@Stateless
public class ActividadDAO extends AbstractDAO<Actividad>{
    
    public ActividadDAO() {
        super(Actividad.class);
    }
}
