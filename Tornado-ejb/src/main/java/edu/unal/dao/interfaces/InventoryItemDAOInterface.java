/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao.interfaces;

import edu.unal.model.InventoryItem;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author migueldiaz
 */
@Repository
public interface InventoryItemDAOInterface {
    
    public void save(InventoryItem inventoryItem);
    
    public void delete(InventoryItem inventoryItem);
    
    public List<InventoryItem> findAll();
    
    public void deleteAll();
    
}
