/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao;

import edu.unal.dao.implementation.UserDAOImplementation;
import edu.unal.factory.DAOFactory;
import edu.unal.model.User;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author migueldiaz
 */
public class UserDAOTest {
     ArrayList<User> usersList = new ArrayList<>();
    UserDAOImplementation userDAO;
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DAOFactory factory=DAOFactory.getInstance();//se obtiene la fabrica de daos
        this.userDAO=factory.getUserDAO();//inicializa el dao para usuarios
        
        User user = new User("miguel diaz", "contraseña0");
        usersList.add(user);
        user = new User("johan rodrigez", "contraseña1");
        usersList.add(user);
        user = new User("luis sierra", "contraseña2");
        usersList.add(user);
        user = new User("gustavo prieto", "contraseña3");
        usersList.add(user);
        
            
        
    }
    
    @After
    public void tearDown() {
    }


     @Test
    public void testSave() {
        Boolean flag=true;
        for (User u : usersList) {
            userDAO.save(u);
            if(u.getId()==null)
                flag=false;
        }
        assertTrue(flag);
    }
}
