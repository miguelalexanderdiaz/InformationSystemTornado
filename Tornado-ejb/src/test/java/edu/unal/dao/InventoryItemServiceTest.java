/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.factory.ServiceFactory;
import edu.unal.model.InventoryItem;
import edu.unal.services.InventoryItemService;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author migueldiaz
 */
public class InventoryItemServiceTest {
    ArrayList<InventoryItem> inventoryList =new ArrayList<>();
    InventoryItemService inventoryService;
    
    public InventoryItemServiceTest(){
    }
    
    @BeforeClass
    public static void setUpClass(){
    }
    
    @AfterClass
    public static void tearDownClass(){
    }
    
    @Before
    public void setUp(){
        ServiceFactory factory=ServiceFactory.getInstance();
        this.inventoryService=factory.getInventoryItemService();
    }
    
    @After
    public void tearDown(){
    }
    
    @Test
    public void testSave()
    {
        InventoryItemDTO dto=new InventoryItemDTO("12343","una descripcion", "alguna medida");
        inventoryService.save(dto);
    
    }
    
}
