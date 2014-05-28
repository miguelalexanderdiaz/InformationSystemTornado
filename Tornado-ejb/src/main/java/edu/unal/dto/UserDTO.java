/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.dto;

import edu.unal.model.Rol;
import edu.unal.model.User;

/**
 *
 * @author migueldiaz
 */
public class UserDTO {

    private String id;
    private String userName;
    private String password;
    private Rol rol;

    public UserDTO(String userName, String password, Rol rol) {
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }
    
    public UserDTO(){}

    public User dtoToModel() {

        User model = new User(
                this.getUserName(),
                this.getPassword(), this.getRol());
        return model;
    }

    public UserDTO modeltToDTO(User model) {
        this.userName = model.getUserName();
        this.password = model.getPassword();
        this.rol = model.getRol();
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" id: ").append(this.id);
        str.append(" userName: ").append(this.userName);
        str.append(" password: ").append(this.password);
        str.append(" rol: ").append(this.rol);
        return str.toString();
    }

}
