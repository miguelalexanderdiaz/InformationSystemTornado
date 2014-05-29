/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.inventory.ui;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.services.InventoryItemService;
import edu.unal.sessionhandler.SessionHandler;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@RequestScoped
public class InventoryBean {
    
    private List<InventoryItemDTO> inventoryList;
    private final InventoryItemService inventoryService;
    private InventoryItemDTO selectedItem;
    

    /**
     * Creates a new instance of InventoryBean
     */
    public InventoryBean() {
        this.inventoryService=SessionHandler.serviceFactory.getInventoryItemService();
        loadInventory();
    }
    
    public void loadInventory(){
        this.inventoryList=inventoryService.findAll();
    }

    public List<InventoryItemDTO> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<InventoryItemDTO> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public InventoryItemDTO getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(InventoryItemDTO selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    public void onEdit (RowEditEvent event){
        FacesMessage msg =new FacesMessage("Item Editado", ((InventoryItemDTO) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
    
    public void onCancel(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Edición cancelada", ((InventoryItemDTO) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
    
    
}
