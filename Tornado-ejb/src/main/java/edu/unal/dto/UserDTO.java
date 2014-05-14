/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.dto;

import edu.unal.model.User;

/**
 *
 * @author migueldiaz
 */
public class UserDTO {

    private String userName;
    private String password;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User dtoToModel() {
        User model = new User(
                this.getUserName(),
                this.getPassword());
        return model;
    }

    public UserDTO modeltToDTO(User model) {
        this.userName = model.getUserName();
        this.password = model.getPassword();
        return this;
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
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" userName: ").append(this.userName);
        str.append(" password: ").append(this.password);
        return str.toString();
    }

}
