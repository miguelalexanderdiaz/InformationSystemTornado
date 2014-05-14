/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.beans;

import edu.unal.dto.UserDTO;
import edu.unal.factory.ServiceFactory;
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
public class Prueba {


    private final UserService userService;
    private String name;

    public Prueba() {
        ServiceFactory sf=ServiceFactory.getInstance();
        this.userService=sf.getUserService();
    }
    
    
    



    public void mostrarMensaje(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        UserDTO dto = new UserDTO("fulanito", "perez");
        userService.save(dto);
        context.addMessage(null, new FacesMessage("Almacenado en la base de datos"+dto.toString()));
        System.out.println(dto.toString());
        System.out.println(dto.getUserName() + " "+ dto.getPassword());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
