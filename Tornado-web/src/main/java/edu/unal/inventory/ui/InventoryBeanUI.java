/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.inventory.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@ViewScoped
public class InventoryBeanUI {

    private Boolean visibleNewItemDialog = false;

    public InventoryBeanUI() {
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


