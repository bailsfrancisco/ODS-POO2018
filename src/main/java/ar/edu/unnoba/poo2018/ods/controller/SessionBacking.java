/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.ods.poo2018.ods.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.ods.model.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SessionBacking implements Serializable {

    private String email;
    private String password;

    private Usuario usuario = null;

    @EJB
    private UsuarioDAO usuarioDAO;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String login() {
        usuario = usuarioDAO.login(email, password);
        if (usuario == null) {
            //mensaje de error
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Datos incorrectos");
            context.addMessage(null, message);
            return null;
        }
        return "welcome?faces-redirect=true";
    }

    public String logout() {
        usuario = new Usuario();
        return "index?faces-redirect=true";
    }
}
