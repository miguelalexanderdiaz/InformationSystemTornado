/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.userAdmin.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Johan
 */
@ManagedBean
@RequestScoped
public class UserBeanUI {

   private Boolean visibleNewItemDialog = false;

    public UserBeanUI() {
    }

    public void changeVisibilityNewItemDialog() {
        if (visibleNewItemDialog) {
            visibleNewItemDialog = false;
        } else {
            visibleNewItemDialog = true;
        }
        
    }

    public Boolean getVisibleNewItemDialog() {
        return visibleNewItemDialog;
    }

    public void setVisibleNewItemDialog(Boolean visibleNewItemDialog) {
        this.visibleNewItemDialog = visibleNewItemDialog;
    }
    
}
