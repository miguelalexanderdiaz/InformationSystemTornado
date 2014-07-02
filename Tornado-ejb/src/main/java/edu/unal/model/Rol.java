/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.model;

/**
 *
 * @author Johan
 */
public enum Rol {
    ADMINISTRADOR("administrador"),DISENADOR("disenador"),RECURSOS_HUMANOS("recursos humanos");
    private String rol;
    private Rol(String value){
        this.rol=value;
    }   
}
