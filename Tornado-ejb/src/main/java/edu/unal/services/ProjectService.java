/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.services;

import edu.unal.dao.implementation.ProjectDAO;
import edu.unal.dto.ProjectDTO;
import edu.unal.factory.DAOFactory;
import edu.unal.model.Project;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Johan
 */
public class ProjectService {
    ProjectDAO projectDAO;
    
    public ProjectService(){
        DAOFactory factory=DAOFactory.getInstance();
        this.projectDAO=factory.getProjectDAO();
    }
    
     public void save(ProjectDTO dto){
        projectDAO.save(dto.dtoToModel());
    }
    
    public void delete(ProjectDTO dto){
        projectDAO.delete(dto.dtoToModel());
    }
    
    public List<ProjectDTO> findAll(){
        List<Project> list=projectDAO.findAll();
        List<ProjectDTO> dtoList=new ArrayList<>();
        
        for(Project item:list){
            ProjectDTO aux=new ProjectDTO();
            dtoList.add(aux.modelToDTO(item));
        }
        return dtoList;
    }
    
    
    public void deleteAll(){
        projectDAO.deleteAll();
    }
    
    public void update(ProjectDTO oldItem, ProjectDTO newItem){
        projectDAO.update(oldItem.dtoToModel(), newItem.dtoToModel());
    }
    
    public ProjectDTO findOne(ProjectDTO dto){
        ProjectDTO aux=new ProjectDTO();
        Project model= projectDAO.findOne(dto.dtoToModel());
        return aux.modelToDTO(model);
    }
}
