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
import edu.unal.model.Rol;
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
    private ProjectDTO project = new ProjectDTO();
    private final ProjectService projectService;
    private ArrayList<UserDTO> userList = new ArrayList<>();
    private ArrayList<UserConHoras> usersC = new ArrayList<>();
    private ArrayList<UserConHoras> selectUC = new ArrayList<>();
    private ArrayList<UserDTO> selectedUserList = new ArrayList<>();
    private ArrayList<InventoryItemDTO> inventoryList = new ArrayList<>();
    private ArrayList<InventoryCant> inventoryListConCantidad = new ArrayList<>();
    private ArrayList<InventoryCant> selectedInvConCant = new ArrayList<>();
    private UserDTO selectedUser;
    private InventoryItemDTO selectedItem;
    private int precio;

    /**
     * Creates a new instance of SearchProjectController
     */
    public SearchProjectController() {
        this.projectService = SessionHandler.serviceFactory.getProjectService();
    }

    public void search() {
        ProjectDTO toSearch = new ProjectDTO(code, null, null, null, null, null, null);
        userList = new ArrayList<>();
        inventoryList = new ArrayList<>();
        inventoryListConCantidad = new ArrayList<>();
        usersC = new ArrayList<>();

        project = projectService.findOne(toSearch);
        int i = 0;
        for (User user : project.getUsers()) {
            UserDTO userDTO = new UserDTO(user.getUserName(), user.getPassword(), user.getRol(), user.getSalary());
            UserConHoras usC = new UserConHoras(user.getUserName(), user.getPassword(), user.getSalary(), user.getRol(), project.getHorasDeTrabajo()[i]);
            userList.add(userDTO.modeltToDTO(user));
            usersC.add(usC);
            i++;
        }
        int j = 0;
        for (InventoryItem inv : project.getItems()) {
            InventoryItemDTO dto = new InventoryItemDTO(inv.getCode(), inv.getDescription(), inv.getMeasure(), inv.getQuantity());
            InventoryCant toTable = new InventoryCant(project.getCantidadNecesaria()[j], dto.getCode(), dto.getDescription(), dto.getMeasure(), dto.getQuantity());
            inventoryListConCantidad.add(toTable);
            inventoryList.add(dto);
            j++;
        }
        int total = 0;
        for (UserConHoras user : usersC) {
            total = total + user.getSalary() * user.getHoras();
        }
        for (InventoryCant inv : inventoryListConCantidad) {
            total = total + inv.getCantidadNecesaria() * Integer.parseInt(inv.getMeasure());
        }
        this.precio = total;
    }

    //----------Cambios en usuarios
    public void deleteSelectedUsers() {
        for (UserConHoras dto : selectUC) {
            for (UserDTO userDTO : userList) {
                if (dto.getUserName().equals(userDTO.getUserName())) {
                    usersC.remove(dto);
                    userList.remove(userDTO);
                }
            }
        }
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //----------Cambios en items-------------------------------------------
    public void deleteSelectedItems() {
        for (InventoryCant dto : selectedInvConCant) {
            for (InventoryItemDTO invdto : inventoryList) {
                if (dto.getCode().equals(invdto.getCode())) {
                    inventoryList.remove(invdto);
                    inventoryListConCantidad.remove(dto);
                }
            }
        }
    }

    public ArrayList<UserConHoras> getUsersC() {
        return usersC;
    }

    public void setUsersC(ArrayList<UserConHoras> usersC) {
        this.usersC = usersC;
    }

    public ArrayList<UserConHoras> getSelectUC() {
        return selectUC;
    }

    public void setSelectUC(ArrayList<UserConHoras> selectUC) {
        this.selectUC = selectUC;
    }

    public void guardarCambios() {
        ArrayList<User> usersFinal = new ArrayList<>();
        ArrayList<InventoryItem> invFinal = new ArrayList<>();

        for (UserDTO user : userList) {
            usersFinal.add(user.dtoToModel());
        }
        for (InventoryItemDTO inv : inventoryList) {
            invFinal.add(inv.dtoToModel());
        }

        ProjectDTO newPro = new ProjectDTO(code, invFinal, usersFinal, project.getFecha(), project.getDescripcion(), project.getCantidadNecesaria(), project.getHorasDeTrabajo());

        projectService.update(project, newPro);
    }

    public ArrayList<InventoryCant> getInventoryListConCantidad() {
        return inventoryListConCantidad;
    }

    public void setInventoryListConCantidad(ArrayList<InventoryCant> inventoryListConCantidad) {
        this.inventoryListConCantidad = inventoryListConCantidad;
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

    public ArrayList<InventoryCant> getSelectedInvConCant() {
        return selectedInvConCant;
    }

    public void setSelectedInvConCant(ArrayList<InventoryCant> selectedInvConCant) {
        this.selectedInvConCant = selectedInvConCant;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

}
