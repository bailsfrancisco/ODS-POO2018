/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.ods.poo2018.ods.dao;

import ar.edu.unnoba.poo2018.ods.model.Impacto;
import javax.ejb.Stateless;

/**
 *
 * @author bailsfrancisco
 */
@Stateless
public class ImpactoDAO extends AbstractDAO<Impacto>{
    
    public ImpactoDAO() {
        super(Impacto.class);
    }
    
}
