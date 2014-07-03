/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.dto;

import edu.unal.model.InventoryItem;
import edu.unal.model.Project;
import edu.unal.model.User;
import java.util.ArrayList;

/**
 *
 * @author Johan
 */
public class ProjectDTO {

    private String code;
    private ArrayList<InventoryItem> items;
    private ArrayList<User> users;
    private String fecha;
    private String descripcion;
    private int cantidadNecesaria[];
    private int horasDeTrabajo[];

    public ProjectDTO(String nombre, ArrayList<InventoryItem> items, ArrayList<User> users, String fecha, String descripcion, int cantidadNecesaria[], int horasDeTrabajo[]) {
        this.code = nombre;
        this.items = items;
        this.users = users;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cantidadNecesaria = cantidadNecesaria;
        this.horasDeTrabajo = horasDeTrabajo;
    }

    public ProjectDTO() {
    }

    public Project dtoToModel() {
        Project model = new Project(this.getCode(),
                this.getItems(),
                this.getUsers(),
                this.getFecha(), this.getDescripcion(),this.getCantidadNecesaria(), this.getHorasDeTrabajo());
        return model;
    }

    public ProjectDTO modelToDTO(Project model) {
        this.code = model.getCode();
        this.items = model.getItems();
        this.users = model.getUsers();
        this.fecha = model.getFecha();
        this.cantidadNecesaria = model.getCantidadNecesaria();
        this.horasDeTrabajo = model.getHorasDeTrabajo();
        return this;
    }

    public int[] getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    public void setHorasDeTrabajo(int[] horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
    }
    
    public int[] getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(int[] cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String nombre) {
        this.code = nombre;
    }

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" Project code: ").append(this.code);
        str.append(" date: ").append(this.fecha);
        return str.toString();
    }

}
