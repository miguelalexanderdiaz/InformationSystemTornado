/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.factory;

import edu.unal.dao.implementation.UserDAOImpl;

/**
 * Fabrica todos los DAOs necesarios, para la operación de la base de datos
 *
 * @author migueldiaz
 */
public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();
    private UserDAOImpl userDAO;

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public UserDAOImpl getUserDAO() {
        if (this.userDAO == null) {
            this.userDAO = new UserDAOImpl();
        }
        return this.userDAO;
    }
}
