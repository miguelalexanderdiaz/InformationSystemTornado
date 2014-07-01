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

    private String userName;
    private String password;
    private Rol rol;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public UserDTO(String userName, String password, Rol rol, int salary) {
        this.userName = userName;
        this.password = password;
        this.rol = rol;
        this.salary = salary;
    }
    public UserDTO(){}


    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    

    public User dtoToModel() {

        User model = new User(
                this.getUserName(),
                this.getPassword(), this.getRol(),this.getSalary());
        return model;
    }

    public UserDTO modeltToDTO(User model) {
        this.userName = model.getUserName();
        this.password = model.getPassword();
        this.rol = model.getRol();
        this.salary = model.getSalary();
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
        str.append(" userName: ").append(this.userName);
        str.append(" password: ").append(this.password);
        str.append(" rol: ").append(this.rol);
        str.append(" salary: ").append(this.salary);
        return str.toString();
    }

}
