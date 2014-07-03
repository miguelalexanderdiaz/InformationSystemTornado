/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.designer.controller;

import edu.unal.model.Rol;

/**
 *
 * @author Johan
 */
public class UserConHoras {
        private String userName;
    private String password;
    private Rol rol;
    private int salary;
    private int horas;

    public UserConHoras(String userName, String password, int salary, Rol rol, int horas) {
        this.userName = userName;
        this.password = password;
        this.salary = salary;
        this.rol = rol;
        this.horas = horas;
    }

    public UserConHoras() {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    
}
