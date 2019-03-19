package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.ods.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.ods.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioBacking implements Serializable {

    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    @EJB
    private UsuarioDAO usuarioDAO;

    //@Inject
    //private SessionBacking sessionBacking;
    public List<Usuario> getUsuariosNoAdmin() {
        return usuarioDAO.getAllUsersNoAdmin();
    }

    public List<Usuario> getUsuarios() {
        return usuarioDAO.getAllUsers();
    }

    public String create() {
        try {
            usuarioDAO.create(usuario);
            return "/usuarios/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public String update() {
        try {
            usuarioDAO.update(usuario);
            return "/usuarios/index?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
