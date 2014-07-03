/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author migueldiaz
 */
@Document
public class InventoryItem {
    @Id
    private String id;
    private String code;
    private String description;
    private String measure;
    private int quantity;
 
    /*
    //saldo
    private Integer balance_units;
    private Double balance_cost;
    //Entradas mes
    private Integer income_units;
    private Double income_cost;
    //Salidas mes
    private Integer outcome_units;
    private Double outchome_cost;
     */
    
    
    
    public InventoryItem(String code, String description, String measure, int quantity){
        this.code=code;
        this.description=description;
        this.measure=measure;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
        
    public String getId() {
        return id;
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
    public String toString(){
        StringBuilder str= new StringBuilder();
        str.append("id: ").append(this.id);
        str.append(" code ").append(this.code);
        str.append(" description ").append(this.description);
        str.append(" measure ").append(this.measure);
        str.append(" quantity ").append(this.quantity);
        return str.toString();
    }
    
    
    
    
    
}
