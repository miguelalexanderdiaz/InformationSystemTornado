/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.user.ui;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author migueldiaz
 */
@ManagedBean
@RequestScoped
public class Car implements Serializable{
        private String model;
        private int year;
        private String manufacturer;
        private String color;
        
        public Car(){}
        
        public Car(String model,int year,String manufacturer,String color){
            this.model=model;
            this.year=year;
            this.manufacturer=manufacturer;
            this.color=color;
        
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
        
        
    
    }
