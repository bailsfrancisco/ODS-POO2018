/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.ods.poo2018.dao;

import ar.edu.unnoba.poo2018.ods.model.Actividad;
import javax.ejb.Stateless;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class ActividadDAO extends AbstractDAO<Actividad>{
    
    public ActividadDAO() {
        super(Actividad.class);
    }
    
}
