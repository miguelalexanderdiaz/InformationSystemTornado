/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.factory;

import edu.unal.dao.implementation.UserDAOImplementation;

/**
 * Fabrica todos los DAOs necesarios, para la operación de la base de datos
 * @author migueldiaz
 */
public class DAOFactory {
    
    private static DAOFactory INSTANCE = new DAOFactory();
    private UserDAOImplementation userDAO;
    
    
    
    public DAOFactory(){
         this.userDAO=new UserDAOImplementation();
    }
    
    
    public static DAOFactory getInstance(){
        return INSTANCE;
    }

    public UserDAOImplementation getUserDAO() {
        return userDAO;
    }
    


    
    
}
