/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ActividadSimpleDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bailsfrancisco
 */
@Named
@ViewScoped
public class ActividadSimpleBacking implements Serializable{
    
    @EJB
    private ActividadSimpleDAO actividadSimpleDAO;
}
