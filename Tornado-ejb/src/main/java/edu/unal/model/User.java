/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author migueldiaz
 */
@Document
public class User {

    @Id
    private String id;
    private String userName;
    private String password;
    private Rol rol;
    //Salario por hora
    private int salary;

    public User(String userName, String password, Rol rol, int salary) {
        this.userName = userName;
        this.password = password;
        this.rol = rol;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("id: ").append(this.id);
        str.append(" userName: ").append(this.userName);
        str.append(" password: ").append(this.password);
        str.append(" rol: ").append(this.rol);
        str.append(" salary: ").append(this.salary);
        return str.toString();
    }

}
