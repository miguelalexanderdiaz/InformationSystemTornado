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
import edu.unal.sessionhandler.SessionHandler;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Johan
 */
@ManagedBean
@SessionScoped
public class UserLogin implements Serializable{

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
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", name);

        try {
            UserDTO userToLog = userService.findByName(dto);

            if (!userToLog.getPassword().equals(password)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos incorrectos", "Inténtalo de Nuevo"));
                return "fail_login";
            } else {
                new SessionHandler();
                if (userToLog.getRol() == Rol.ADMINISTRADOR) {
                    return "admin";
                } else if (userToLog.getRol() == Rol.DISENADOR) {
                    return "designer";
                } else if (userToLog.getRol() == Rol.RECURSOS_HUMANOS) {
                    return "resourcesh";
                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos incorrectos", "Inténtalo de Nuevo"));
        }

        return "fail_login";
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
        this.password = HashSHA256.getHash(password);;
    }


    
    
}
