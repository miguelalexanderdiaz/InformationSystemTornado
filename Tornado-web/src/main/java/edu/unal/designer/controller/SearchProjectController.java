/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.designer.controller;

import edu.unal.dto.InventoryItemDTO;
import edu.unal.dto.ProjectDTO;
import edu.unal.dto.UserDTO;
import edu.unal.model.InventoryItem;
import edu.unal.model.User;
import edu.unal.services.ProjectService;
import edu.unal.sessionhandler.SessionHandler;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Johan
 */
@ManagedBean
@ViewScoped
public class SearchProjectController {

    //Codigo para buscar el proyecto
    private String code;
    private ProjectDTO project;
    private final ProjectService projectService;
    private ArrayList<UserDTO> userList=new ArrayList<>();
    private ArrayList<UserDTO> selectedUserList=new ArrayList<>();
    private ArrayList<InventoryItemDTO> inventoryList=new ArrayList<>();
    private ArrayList<InventoryItemDTO> selectedInventoryList=new ArrayList<>();
    private UserDTO selectedUser;
    private InventoryItemDTO selectedItem;

    /**
     * Creates a new instance of SearchProjectController
     */
    public SearchProjectController() {
        this.projectService = SessionHandler.serviceFactory.getProjectService();
    }

    public void search() {
        ProjectDTO toSearch = new ProjectDTO(code, null, null, null, null);
        try {
             project = projectService.findOne(toSearch);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("El proyecto con codigo " + code + " no existe.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
       
            for (User user : project.getUsers()) {
                System.out.println("WA" + user.getUserName());
                System.out.println("WA2" + user.getRol());
                System.out.println("WA3" + user.getSalary());
                UserDTO userDTO = new UserDTO();
                userList.add(userDTO.modeltToDTO(user));
            }
            for (InventoryItem inv : project.getItems()) {
                InventoryItemDTO inventoryItemDTO = new InventoryItemDTO();
                inventoryList.add(inventoryItemDTO.modelToDTO(inv));
            }
        
    }

    //----------Cambios en usuarios
    public void deleteSelectedUsers() {
        for (UserDTO dto : selectedUserList) {
            for (UserDTO userDTO : userList) {
                if(dto.getUserName().equals(userDTO.getUserName())){
                                userList.remove(userDTO);
                            }
            }
            userList.remove(dto);
        }
    }

    //----------Cambios en items-------------------------------------------
    public void deleteSelectedItems() {
        for (InventoryItemDTO dto : selectedInventoryList) {
            for (InventoryItemDTO invdto : inventoryList) {
                if(dto.getCode().equals(invdto.getCode())){
                    inventoryList.remove(invdto);
                }
            }
        }
    }
    
    public void guardarCambios(){
        ArrayList<User> usersFinal=new ArrayList<>();
        ArrayList<InventoryItem> invFinal= new ArrayList<>();
        
        for (UserDTO user : userList) {
                usersFinal.add(user.dtoToModel());
            }
            for (InventoryItemDTO inv : inventoryList) {
                invFinal.add(inv.dtoToModel());
        }
        
        ProjectDTO newPro = new ProjectDTO(code,invFinal,usersFinal,project.getFecha(),project.getDescripcion());
    
       projectService.update(project, newPro);
    }
    
   
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public ArrayList<UserDTO> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserDTO> userList) {
        this.userList = userList;
    }

    public ArrayList<UserDTO> getSelectedUserList() {
        return selectedUserList;
    }

    public void setSelectedUserList(ArrayList<UserDTO> selectedUserList) {
        this.selectedUserList = selectedUserList;
    }

    public ArrayList<InventoryItemDTO> getSelectedInventoryList() {
        return selectedInventoryList;
    }

    public void setSelectedInventoryList(ArrayList<InventoryItemDTO> selectedInventoryList) {
        this.selectedInventoryList = selectedInventoryList;
    }

    public UserDTO getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDTO selectedUser) {
        this.selectedUser = selectedUser;
    }

    public InventoryItemDTO getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(InventoryItemDTO selectedItem) {
        this.selectedItem = selectedItem;
    }

    public ArrayList<InventoryItemDTO> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<InventoryItemDTO> inventoryList) {
        this.inventoryList = inventoryList;
    }

}
