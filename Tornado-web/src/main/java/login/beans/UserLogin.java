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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Johan
 */
@ManagedBean
@RequestScoped
public class UserLogin {

    private UserService userService;
    private String name;
    private String password;
    private String bienvenida;

    public UserLogin() {
        ServiceFactory sf = ServiceFactory.getInstance();
        this.userService = sf.getUserService();
    }

    public String login() {
        UserDTO dto = new UserDTO(name, password);
        System.out.println("name: " + name);
        try {
            UserDTO userToLog = userService.findByName(dto);
            this.encrypthPassword();
            if (!userToLog.getPassword().equals(password)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos incorrectos"));
                return "login";
            } else {
                if (userToLog.getRol() == Rol.ADMINISTRADOR) {
                    return "admin";
                } else if (userToLog.getRol() == Rol.DISENADOR) {
                    return "disenador";
                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos incorrectos"));
        }

        return "login";
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
        this.password = password;
    }

    public void encrypthPassword() {
        HashSHA256 hash = new HashSHA256();
        this.password = hash.getHash(password);
    }

}
