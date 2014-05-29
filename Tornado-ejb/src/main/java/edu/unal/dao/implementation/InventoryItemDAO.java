/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao.implementation;

import edu.unal.configuration.SpringMongoConfig;
import edu.unal.dao.interfaces.InventoryItemDAOInterface;
import edu.unal.model.InventoryItem;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 *
 * @author migueldiaz
 */
public class InventoryItemDAO implements InventoryItemDAOInterface{
    
    static final Logger log=Logger.getLogger("InventoryItemDB_log");
    
    ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOp = (MongoOperations) ctx.getBean("mongoTemplate");
    
    @Override
    public void save(InventoryItem inventoryItem) {
        mongoOp.save(inventoryItem);
        log.log(Level.INFO, "inventory item saved // \t{0}", inventoryItem.toString());
    }

    @Override
    public void delete(InventoryItem inventoryItem) {
        mongoOp.remove(inventoryItem);
        log.log(Level.INFO, "inventory item deleted // \t{0}", inventoryItem.toString());
    }

    @Override
    public List<InventoryItem> findAll() {
        List<InventoryItem> inventory =mongoOp.findAll(InventoryItem.class);
        return inventory;
    }
    
    @Override
    public void deleteAll(){
        List<InventoryItem> toDelete = mongoOp.findAll(InventoryItem.class);
        for(InventoryItem item: toDelete){
            this.delete(item);
        }
    }
    
}
