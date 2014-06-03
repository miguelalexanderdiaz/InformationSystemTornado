/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.service;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.factory.ServiceFactory;
import edu.unal.services.InventoryItemService;
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
public class InventoryItemServiceTest {
    
    ArrayList<InventoryItemDTO> inventoryList = new ArrayList<>();
    InventoryItemService inventoryService;
    
    public InventoryItemServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ServiceFactory factory = ServiceFactory.getInstance();
        this.inventoryService = factory.getInventoryItemService();
        
        inventoryService.deleteAll();
        for (int i = 0; i < 20; i++) {
            InventoryItemDTO dto;            
            dto = new InventoryItemDTO(String.valueOf(i), "una descripcion" + i, "alguna medida" + i);
            inventoryList.add(dto);
        }
        
    }
    
    @After
    public void tearDown() {  
    }
    
    @Test
    public void testSave() {
        try {
            for (InventoryItemDTO dto : inventoryList) {
                inventoryService.save(dto);
            }
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }
    
    @Test
    public void testUpdate() {
        InventoryItemDTO oldItem=inventoryList.get(0);
        inventoryService.save(oldItem);
        InventoryItemDTO newItem=new InventoryItemDTO("A1115", "modificación del dto", "medida dto modificado");
        inventoryService.update(oldItem, newItem);
        testSave();
        InventoryItemDTO aux=inventoryService.findOne(newItem);
        assertNotNull(aux);
        
    }
    
}
