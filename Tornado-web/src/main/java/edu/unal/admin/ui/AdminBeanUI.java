/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.admin.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@SessionScoped
public class AdminBeanUI {

    private String activePage = "inventory";
    private String goToPage = "/inventory/inventory";

    /**
     * Creates a new instance of AdminBeanUI
     */
    public AdminBeanUI() {
    }

    public String showPage() {
        if (activePage.equals("inventory")) {
            return "/inventory/inventory";
        } else if (activePage.equals("users_admin")) {
            return "/users/designer";
        }
        return "/inventory/inventory";
    }

    public String getActivePage() {
        return activePage;
    }

    public void setActivePage(String activePage) {
        this.activePage = activePage;
    }

    public String getGoToPage() {
        return goToPage;
    }

    public void setGoToPage(String goToPage) {
        this.goToPage = goToPage;
    }

    public void goToInventory() {
        goToPage = "/inventory/inventory";
    }

    public void goToUsers() {
        goToPage = "/usersadmin/usertable";
    }

    public void goToEstimation() {
        goToPage = "/designer/estimation";
    }

    public void goToProjects() {
        goToPage = "/designer/viewprojects";
    }

}
