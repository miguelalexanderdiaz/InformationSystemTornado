/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.service;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.factory.ServiceFactory;
import edu.unal.model.InventoryItem;
import edu.unal.services.InventoryItemService;
import java.util.ArrayList;
import java.util.Random;
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
        Random ran = new Random();
        for (int i = 0; i < 20; i++) {
            InventoryItemDTO dto; 
            dto= new InventoryItemDTO(String.valueOf(ran.nextInt()), "una descripcion" + i, "alguna medida"+i);
            inventoryList.add(dto);
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        for (InventoryItemDTO dto : inventoryList) {
            inventoryService.save(dto);
        }

    }

}
