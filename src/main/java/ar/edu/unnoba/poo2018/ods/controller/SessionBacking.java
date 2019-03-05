package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.ods.model.Usuario;
import java.io.Serializable;
import java.util.PropertyResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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

    @Inject
    private transient PropertyResourceBundle bundle;

    @PostConstruct
    public void init() {
    }

    public String login() {
        usuario = usuarioDAO.login(email, password);
        if (usuario == null) {
            //mensaje de error
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(bundle.getString("userLoginInvalid"));
            //FacesMessage message = new FacesMessage("Datos incorrectos");
            context.addMessage(null, message);
            return null;
        }
        if (usuario.getAdmin() != true){
            return "actividades/index?faces-redirect=true";
        }
        return "actividades_simples/index?faces-redirect=true";
    }

    public String logout() {
        usuario = null;
        return "index?faces-redirect=true";
    }
}
