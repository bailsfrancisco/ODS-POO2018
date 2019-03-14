package ar.edu.unnoba.poo2018.ods.converter;

import ar.edu.unnoba.poo2018.ods.model.ODS;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=ODS.class)
public class ODSConverter extends AbstractConverter<ODS>{

    @Override
    public String getDAOName() {
        return "ODSDAO";
    }
}
