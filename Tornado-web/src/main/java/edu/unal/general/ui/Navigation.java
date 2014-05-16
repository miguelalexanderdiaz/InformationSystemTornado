/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.general.ui;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@SessionScoped
public class Navigation implements Serializable{

    /**
     * Creates a new instance of Navigation
     */
    public Navigation() {
    }
    
    
    public String indexToTables(){
        return "success";
    }
}
