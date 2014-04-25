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

    public User(String userName, String password) {
        this.userName=userName;
        this.password=password;
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

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append("id: ").append(this.id);
        str.append(" userName: ").append(this.userName);
        str.append(" password: ").append(this.password);
        return str.toString();
    }

}
