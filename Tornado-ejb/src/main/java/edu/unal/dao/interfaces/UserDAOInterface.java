/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao.interfaces;

import edu.unal.model.User;
import java.util.List;
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
    
    public void delete(User user);
    
    public User findById(User user);
    
    public User findByName(User user);
    
    public User findOne(User user);
    
    public List<User> findAll();
    
    public void deleteAll();
    
    public void update(User oldUser, User newUser);
}
