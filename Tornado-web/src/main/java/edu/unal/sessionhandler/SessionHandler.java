/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.sessionhandler;

import edu.unal.factory.ServiceFactory;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@SessionScoped
public class SessionHandler {

    public static ServiceFactory serviceFactory;

    public SessionHandler() {
        serviceFactory = ServiceFactory.getInstance();
    }

}
