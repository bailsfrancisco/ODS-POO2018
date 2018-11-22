/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.i18n;

/**
 *
 * @author gabriel
 */

import java.util.PropertyResourceBundle;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;


@RequestScoped
public class BundleProducer {
    @Produces
    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication()
                .evaluateExpressionGet(context, "#{i18n}",
                        PropertyResourceBundle.class);
    }
}