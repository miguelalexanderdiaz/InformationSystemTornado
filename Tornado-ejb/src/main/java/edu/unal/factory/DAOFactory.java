/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.factory;

import edu.unal.dao.implementation.InventoryItemDAOImpl;
import edu.unal.dao.implementation.UserDAO;


/**
 * Fabrica todos los DAOs necesarios, para la operación de la base de datos
 *
 * @author migueldiaz
 */
public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();
    private UserDAO userDAO;
    private InventoryItemDAOImpl inventoryDAO;

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public UserDAO getUserDAO() {
        if (this.userDAO == null) {
            this.userDAO = new UserDAO();
        }
        return this.userDAO;
    }
    
    public InventoryItemDAOImpl getInventoryDAO(){
        if(this.inventoryDAO==null){
            this.inventoryDAO=new InventoryItemDAOImpl();
        }
        return this.inventoryDAO;
    }
}
