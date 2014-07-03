/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.service;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.dto.ProjectDTO;
import edu.unal.dto.UserDTO;
import edu.unal.factory.ServiceFactory;
import edu.unal.model.InventoryItem;
import edu.unal.model.Rol;
import edu.unal.model.User;
import edu.unal.services.InventoryItemService;
import edu.unal.services.ProjectService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class ProjectServiceTest {

    ArrayList<InventoryItem> inventoryList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    ProjectService projectService;

    public ProjectServiceTest() {
    }

    @Before
    public void setUp() {
        ServiceFactory factory = ServiceFactory.getInstance();
        this.projectService = factory.getProjectService();

        projectService.deleteAll();
        for (int i = 0; i < 4; i++) {
            InventoryItem dto;
            User userDTO;
            userDTO = new User("nuser" + i, "nuser" + i, Rol.DISENADOR, i + 200);
            dto = new InventoryItem(String.valueOf(i), "una descripcion" + i, "alguna medida" + i, i);
            inventoryList.add(dto);
            userList.add(userDTO);
        }

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeClass
    public static void setUpClass() {        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date d1 = c.getTime();

        ProjectDTO test = new ProjectDTO("AK47", inventoryList, userList,d1.toString(), "dificil");
        projectService.save(test);
    }
    
    @Test
    public void testDelete() {
        boolean flag=true;
        ProjectDTO test = new ProjectDTO("AK47", null, null,null, "dificil");
        projectService.save(test);
        projectService.delete(test);
        if(!projectService.findAll().isEmpty()){
            flag=false;
        }
        assertTrue(flag);
    }
}
