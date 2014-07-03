/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao.interfaces;

import edu.unal.model.Project;
import java.util.List;

/**
 *
 * @author Johan
 */
public interface ProjectDAOInterface {
    
    public void save(Project project);
    
    public void delete(Project project);
    
    public void update(Project oldProject,Project newProject);
    
    public List<Project> findAll();
    
    public void deleteAll();
    
    public Project findOne(Project project);
    
    
}
