/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.services;

import edu.unal.dao.implementation.InventoryItemDAO;
import edu.unal.dto.InventoryItemDTO;
import edu.unal.factory.DAOFactory;
import edu.unal.model.InventoryItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author migueldiaz
 */
@Service
public class InventoryItemService {
    InventoryItemDAO inventoryDAO;
    
    public InventoryItemService(){
        DAOFactory factory=DAOFactory.getInstance();
        this.inventoryDAO=factory.getInventoryDAO();
    }
    
    public void save(InventoryItemDTO dto){
        inventoryDAO.save(dto.dtoToModel());
    }
    
    public void delete(InventoryItemDTO dto){
        inventoryDAO.delete(dto.dtoToModel());
    }
    
    public List<InventoryItemDTO> findAll(){
        List<InventoryItem> list=inventoryDAO.findAll();
        List<InventoryItemDTO> dtoList=new ArrayList<>();
        
        for(InventoryItem item:list){
            InventoryItemDTO aux=new InventoryItemDTO();
            dtoList.add(aux.modelToDTO(item));
        }
        return dtoList;
    }
    
    
    public void deleteAll(){
        inventoryDAO.deleteAll();
    }
    
    public void update(InventoryItemDTO oldItem, InventoryItemDTO newItem){
        inventoryDAO.update(oldItem.dtoToModel(), newItem.dtoToModel());
    }
    
    public InventoryItemDTO findOne(InventoryItemDTO dto){
        InventoryItemDTO aux=new InventoryItemDTO();
        InventoryItem model= inventoryDAO.findOne(dto.dtoToModel());
        return aux.modelToDTO(model);
    }
    
}
