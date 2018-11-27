package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.ODSDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ODSBacking implements Serializable{
    
    @EJB
    private ODSDAO odsDAO;
}
