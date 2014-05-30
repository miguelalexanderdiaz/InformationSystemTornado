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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

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
        mongoOp.remove( findOne(inventoryItem));
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

    @Override
    public void update(InventoryItem oldItem, InventoryItem newItem) {
        Query q =new Query();
        q.addCriteria(Criteria.where("code").
                is(oldItem.getCode()).and("description").
                is(oldItem.getDescription()).and("measure").
                is(oldItem.getMeasure()));
        Update up=new Update();
        up.set("code", newItem.getCode());
        up.set("description", newItem.getDescription());
        up.set("measure", newItem.getMeasure());
        
        mongoOp.findAndModify(q, up, InventoryItem.class);
        Object aux [] = {oldItem.toString(),newItem.toString()};
        log.log(Level.INFO, "actualizado de: {0} a {1}: ", aux);
        
        
    }

    @Override
    public InventoryItem findOne(InventoryItem inventoryItem) {
        Query q =new Query();
        q.addCriteria(Criteria.where("code").
                is(inventoryItem.getCode()).and("description").
                is(inventoryItem.getDescription()).and("measure").
                is(inventoryItem.getMeasure()));
        return mongoOp.findOne(q, InventoryItem.class);
    }
    
    
    
}
