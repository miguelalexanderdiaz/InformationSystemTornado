/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao.interfaces;

import edu.unal.model.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author migueldiaz
 */
@Repository
public interface UserDAOInterface  {
    /*
    *@param user El usuario a almacenar
    */
    public void save(User user);
    
}
