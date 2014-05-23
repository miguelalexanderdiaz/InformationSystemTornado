/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.services;

import edu.unal.dao.implementation.UserDAOImpl;
import edu.unal.dto.UserDTO;
import edu.unal.factory.DAOFactory;
import edu.unal.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author migueldiaz
 */
@Service
public class UserService {
    UserDAOImpl userDAO;

    public UserService() {
        DAOFactory factory=DAOFactory.getInstance();
        this.userDAO=factory.getUserDAO();
    }
    
    public void save(UserDTO dto){
        userDAO.save(dto.dtoToModel());
    }
    
    public void delete(UserDTO dto){
        userDAO.delete(dto.dtoToModel());
    }
    
    public void findByName(UserDTO dto){
        userDAO.findByName(dto.dtoToModel());
    }
    
    public void findById(UserDTO dto){
        userDAO.findById(dto.dtoToModel());
    }
    
    public void deleteAll(){
        userDAO.deleteAll();
    }
}
