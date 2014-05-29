/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.service;

import edu.unal.dto.UserDTO;
import edu.unal.helper.HashSHA256;
import edu.unal.model.Rol;
import edu.unal.model.User;
import edu.unal.services.UserService;
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
 * @author Johan
 */
public class UserServiceTest {

    ArrayList<User> usersList = new ArrayList<>();
    UserService userService = new UserService();


    public UserServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        User user = new User("miguel diaz", "contraseña0", Rol.ADMINISTRADOR);
        usersList.add(user);
        user = new User("johan rodrigez", "contraseña1", Rol.DISENADOR);
        usersList.add(user);
        user = new User("luis sierra", "contraseña2", Rol.ADMINISTRADOR);
        usersList.add(user);
        user = new User("gustavo prieto", "contraseña3", Rol.DISENADOR);
        usersList.add(user);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        Boolean flag = true;

        for (User u : usersList) {
            UserDTO user = new UserDTO(u.getUserName(), HashSHA256.getHash(u.getPassword()) , u.getRol());
            userService.save(user);
            if (!userService.findByName(user).getUserName().equals(user.getUserName())) {
                flag = false;
            }
        }
        userService.deleteAll();
        assertTrue(flag);
    }

    @Test
    public void testDeleteAll() {
        Boolean flag = true;
        for (User u : usersList) {
            UserDTO user = new UserDTO(u.getUserName(), u.getPassword(), u.getRol());
            userService.save(user);
        }
        userService.deleteAll();
        List<UserDTO> testList = userService.findAll();
        if (!testList.isEmpty()) {
            flag = false;
        }
        assertTrue(flag);
    }

    @Test
    public void testFindByName() {
        Boolean flag = true;
        for (User u : usersList) {
            UserDTO user = new UserDTO(u.getUserName(), u.getPassword(), u.getRol());
            userService.save(user);
            if (!userService.findByName(user).getUserName().equals(user.getUserName())) {
                flag = false;
            }
        }
        userService.deleteAll();
        assertTrue(flag);
    }

    @Test
    public void testDelete() {
        UserDTO test;
        Boolean flag = true;
        
        for (User u : usersList) {
            UserDTO user = new UserDTO(u.getUserName(), u.getPassword(), u.getRol());
            userService.save(user);
        }
        System.out.println("LISTA DE PRUEBA=================================================");
        List <UserDTO> users = userService.findAll();
        for (UserDTO userDTO : users) {
            System.out.println("Usuario: "+ userDTO.toString());
        }
        System.out.println("================================================================");
        for (User u : usersList) {
            UserDTO user = new UserDTO(u.getUserName(), u.getPassword(), u.getRol());            
            userService.delete(user);
        }
        if(!userService.findAll().isEmpty()){
            flag=false;
        }
        System.out.println("LISTA DE PRUEBA vacia=================================================");
        List <UserDTO> users2 = userService.findAll();
        for (UserDTO userDTO : users2) {
            System.out.println("Usuario: "+ userDTO.toString());
        }
        System.out.println("================================================================");
        assertTrue(flag);
    }

}
