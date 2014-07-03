/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.designer.controller;

import edu.unal.dto.InventoryItemDTO;

/**
 *
 * @author Johan
 */
public class InventoryCant {

    private int cantidadNecesaria;
    private String code;
    private String description;
    private String measure;
    private int quantity;

    public InventoryCant(int cantidadNecesaria, String code, String description, String measure, int quantity) {
        this.cantidadNecesaria = cantidadNecesaria;
        this.code = code;
        this.description = description;
        this.measure = measure;
        this.quantity = quantity;
    }

    public int getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(int cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
