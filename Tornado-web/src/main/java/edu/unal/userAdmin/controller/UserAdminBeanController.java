/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.userAdmin.controller;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.dto.UserDTO;
import edu.unal.helper.HashSHA256;
import edu.unal.model.Rol;
import edu.unal.services.UserService;
import edu.unal.sessionhandler.SessionHandler;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Johan
 */
@ManagedBean
@ViewScoped
public class UserAdminBeanController {

    private List<UserDTO> userList;
    private List<UserDTO> selectedUserList;
    private final UserService userService;
    private UserDTO selectedUser;

    private String userName;
    private String password;
    private Rol rol;
    private int salary;

    //Variable para el caso en que el salario ingresado sea invalido
    private int oldSalary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public UserAdminBeanController() {
        this.userService = SessionHandler.serviceFactory.getUserService();
        loadUsers();
    }

    public void loadUsers() {
        this.userList = userService.findAll();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        HashSHA256 hash = new HashSHA256();
        this.password = hash.getHash(password);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDTO> userList) {
        this.userList = userList;
    }

    public List<UserDTO> getSelectedUserList() {
        return selectedUserList;
    }

    public void setSelectedUserList(List<UserDTO> selectedUserList) {
        this.selectedUserList = selectedUserList;
    }

    public UserDTO getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDTO selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void onEditInit(RowEditEvent event) {
        UserDTO aux = (UserDTO) event.getObject();
        this.selectedUser = new UserDTO();
        this.selectedUser.setUserName(aux.getUserName());
        this.selectedUser.setPassword(aux.getPassword());
        this.selectedUser.setRol(aux.getRol());
        this.selectedUser.setSalary(aux.getSalary());
    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Usuario Editado", ((UserDTO) event.getObject()).toString());
        UserDTO auxDTO=(UserDTO) event.getObject();
        if (auxDTO.getSalary() < 0) {
            msg = new FacesMessage("Salario inválido", ((UserDTO) event.getObject()).toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            userService.update(getSelectedUser(), auxDTO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        loadUsers();
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición cancelada", ((UserDTO) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedItems() {
        for (UserDTO dto : selectedUserList) {
            userService.delete(dto);
        }
        loadUsers();
    }

    public void saveUser() {
        UserDTO dto = new UserDTO(userName, password, rol, salary);
        userService.save(dto);
        loadUsers();
    }

}
