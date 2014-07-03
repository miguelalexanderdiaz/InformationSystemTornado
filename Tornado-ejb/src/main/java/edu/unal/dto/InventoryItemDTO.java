/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.dto;

import edu.unal.model.InventoryItem;

/**
 *
 * @author migueldiaz
 */
public class InventoryItemDTO {

    private String code;
    private String description;
    private String measure;
    private int quantity;

    public InventoryItemDTO(String code, String description, String measure, int quantity) {
        this.code = code;
        this.description = description;
        this.measure = measure;
        this.quantity = quantity;
    }

    public InventoryItemDTO() {
    }

    public InventoryItem dtoToModel() {
        InventoryItem model = new InventoryItem(
                this.getCode(),
                this.getDescription(),
                this.getMeasure(), this.getQuantity());
        return model;
    }

    public InventoryItemDTO modelToDTO(InventoryItem model) {
        this.code = model.getCode();
        this.description = model.getDescription();
        this.measure = model.getMeasure();
        this.quantity = model.getQuantity();
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("code: ").append(this.code);
        str.append(" description: ").append(this.description);
        str.append(" measure: ").append(this.measure);
        str.append(" quantity: ").append(this.quantity);
        return str.toString();
    }

}
