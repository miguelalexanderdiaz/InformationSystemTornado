/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.factory;

import edu.unal.services.InventoryItemService;

/**
 *
 * @author migueldiaz
 */
public class ServiceFactory {
    
    private static final ServiceFactory INSTANCE=new ServiceFactory();
    private InventoryItemService inventoryService;
    
    
    public static ServiceFactory getInstance(){
        return INSTANCE;
    }
    
    public InventoryItemService getInventoryItemService(){
        if(this.inventoryService==null){
            this.inventoryService=new InventoryItemService();
        }
        return this.inventoryService;
    }
        
}
