/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.una.inventory.controller;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.services.InventoryItemService;
import edu.unal.sessionhandler.SessionHandler;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@ViewScoped
public class InventoryBeanController {

    private List<InventoryItemDTO> inventoryList;
    private List<InventoryItemDTO> selectedItemsList;
    private final InventoryItemService inventoryService;
    private InventoryItemDTO selectedItem;

    private String code;
    private String description;
    private String measure;
    private int quantity;

    public InventoryBeanController() {
        this.inventoryService = SessionHandler.serviceFactory.getInventoryItemService();
        loadInventory();
    }

    public void loadInventory() {
        this.inventoryList = inventoryService.findAll();
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

    public void onEditInit(RowEditEvent event) {
        InventoryItemDTO aux = (InventoryItemDTO) event.getObject();
        this.selectedItem = new InventoryItemDTO();
        this.selectedItem.setCode(aux.getCode());
        this.selectedItem.setDescription(aux.getDescription());
        this.selectedItem.setMeasure(aux.getMeasure());

    }

    public void onEdit(RowEditEvent event) {
        InventoryItemDTO aux = (InventoryItemDTO) event.getObject();
        if (aux.getQuantity() < 0) {
            FacesMessage msg = new FacesMessage("La cantidad no puede ser negativa");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            loadInventory();
        } else {
            FacesMessage msg = new FacesMessage("Item Editado", ((InventoryItemDTO) event.getObject()).toString());
            inventoryService.update(getSelectedItem(), aux);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición cancelada", ((InventoryItemDTO) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteSelectedItems() {
        for (InventoryItemDTO dto : selectedItemsList) {
            inventoryService.delete(dto);
        }
        loadInventory();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void saveItem() {
        if (quantity < 0) {
            FacesMessage msg = new FacesMessage("La cantidad no puede ser negativa");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            InventoryItemDTO dto = new InventoryItemDTO(code, description, measure, quantity);
            inventoryService.save(dto);
            loadInventory();
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<InventoryItemDTO> getSelectedItemsList() {
        return selectedItemsList;
    }

    public void setSelectedItemsList(List<InventoryItemDTO> selectedItemsList) {
        this.selectedItemsList = selectedItemsList;
    }

}
