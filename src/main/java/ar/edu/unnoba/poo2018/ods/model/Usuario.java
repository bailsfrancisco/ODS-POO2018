package ar.edu.unnoba.poo2018.ods.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "user.findbyEmailAndPassword",
            query = "Select u From Usuario u where u.email = :email and u.password = :password")
})
public class Usuario extends AbstractEntity{

    private String email;
    private String password;
    private Boolean admin;
    private String descripcion;
    
    @ManyToMany(mappedBy = "responsables")
    private List<Actividad> actividades;

    public Usuario() {
    }

    
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    /*
    public Boolean login(){
        return(this.getEmail().equals("poo2018@unnoba.edu.ar") && this.getPassword().equals("unnoba2018!"));
    }*/

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the admin
     */
    public Boolean getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
