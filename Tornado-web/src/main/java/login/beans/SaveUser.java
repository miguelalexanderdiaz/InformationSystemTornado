/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.beans;

import edu.unal.dto.UserDTO;
import edu.unal.factory.ServiceFactory;
import edu.unal.helper.HashSHA256;
import edu.unal.model.Rol;
import edu.unal.services.UserService;
import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@RequestScoped
public class SaveUser {


    private final UserService userService;
    private String name;
    private String password;
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setRoles(Rol[] roles) {
        this.roles = roles;
    }
    private Rol roles[]=new Rol[2];
    
    public SaveUser() {
        ServiceFactory sf=ServiceFactory.getInstance();
        this.userService=sf.getUserService();
        this.setFixedRoles();
    }
    
    public void saveUser(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        UserDTO dto = new UserDTO(name, password,rol);
        userService.save(dto);
        context.addMessage(null, new FacesMessage("Almacenado en la base de datos"+dto.toString()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        HashSHA256 hash=new HashSHA256();
        this.password = hash.getHash(password);
    }           

    public void setFixedRoles(){
        roles[0]=rol.ADMINISTRADOR;
        roles[1]=rol.DISENADOR;
    }

    public Rol[] getRoles() {
        return roles;
    }
}
