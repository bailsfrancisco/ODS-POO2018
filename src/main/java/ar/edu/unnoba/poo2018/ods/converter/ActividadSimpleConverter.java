/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.ods.model.ActividadSimple;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bailsfrancisco
 */
@FacesConverter(forClass=ActividadSimple.class)
public class ActividadSimpleConverter extends AbstractConverter<ActividadSimple>{

    @Override
    public String getDAOName() {
        return "ActividadSimpleDAO";
    }
    
}
