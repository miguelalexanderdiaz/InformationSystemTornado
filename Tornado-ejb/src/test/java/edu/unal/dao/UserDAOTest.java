/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.dao;

import edu.unal.dao.implementation.UserDAO;
import edu.unal.factory.DAOFactory;
import edu.unal.helper.HashSHA256;
import edu.unal.model.Rol;
import edu.unal.model.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author migueldiaz
 */
public class UserDAOTest {

    ArrayList<User> usersList = new ArrayList<>();
    UserDAO userDAO;

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
        DAOFactory factory = DAOFactory.getInstance();//se obtiene la fabrica de daos
        this.userDAO = factory.getUserDAO();//inicializa el dao para usuarios

        User user = new User("miguel diaz", HashSHA256.getHash("contraseña0"),Rol.ADMINISTRADOR, 30000);
        usersList.add(user);
        user = new User("johan rodrigez", HashSHA256.getHash("contraseña1"),Rol.DISENADOR, 30000);
        usersList.add(user);
        user = new User("luis sierra", HashSHA256.getHash("contraseña2"),Rol.ADMINISTRADOR, 30000);
        usersList.add(user);
        user = new User("gustavo prieto", HashSHA256.getHash("contraseña3"),Rol.DISENADOR, 30000);
        usersList.add(user);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        Boolean flag = true;
        for (User u : usersList) {
            userDAO.save(u);
            if (u.getId() == null) {
                flag = false;
            }
        }
        userDAO.deleteAll();
        assertTrue(flag);
    }

    @Test
    public void testDeleteAll() {
        Boolean flag = true;
        userDAO.deleteAll();
        List<User> testList = userDAO.findAll();
        if (!testList.isEmpty()) {
            flag = false;
        }
        assertTrue(flag);
    }

    @Test
    public void testFindById() {
        String id;
        Boolean flag = true;
        for (User u : usersList) {
            userDAO.save(u);
        }

        for (User u : usersList) {
            id = userDAO.findById(u).getId();
            if (!u.getId().equals(id)) {
                flag = false;
            }
        }
        userDAO.deleteAll();
        assertTrue(flag);
    }

    @Test
    public void testDelete() {
        User test;
        Boolean flag = true;
        for (User u : usersList) {
            userDAO.save(u);
        }

        for (User u : usersList) {
            userDAO.delete(u);
            test = userDAO.findById(u);
            if (test != null) {
                flag = false;
            }
        }
        userDAO.deleteAll();
        assertTrue(flag);
    }

    @Test
    public void testFindByName() {
        String name;
        Boolean flag = true;
        for (User u : usersList) {
            userDAO.save(u);
        }

        for (User u : usersList) {
            name = userDAO.findByName(u).getUserName();
            if (!u.getUserName().equals(name)) {
                flag = false;
            }
        }
        userDAO.deleteAll();
        assertTrue(flag);
    }

    @Test
    public void testFindAll() {
        String id;
        Boolean flag = true;
        for (User u : usersList) {
            userDAO.save(u);
        }

        List<User> testList = userDAO.findAll();
        for (User u : usersList) {
            id = userDAO.findById(u).getId();
            if (!u.getId().equals(id)) {
                flag = false;
            }
        }
        userDAO.deleteAll();
        assertTrue(flag);
    }

}
