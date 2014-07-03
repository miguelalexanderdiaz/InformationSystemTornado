/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.dao.implementation;

import edu.unal.configuration.SpringMongoConfig;
import edu.unal.dao.interfaces.ProjectDAOInterface;
import edu.unal.model.InventoryItem;
import edu.unal.model.Project;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author Johan
 */
public class ProjectDAO implements ProjectDAOInterface {

    static final Logger log = Logger.getLogger("InventoryItemDB_log");

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOp = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    public void save(Project project) {
        mongoOp.save(project);
        log.log(Level.INFO, "Project saved // \t{0}", project.getCode());
    }

    @Override
    public void delete(Project project) {
        mongoOp.remove( findOne(project));
        log.log(Level.INFO, "project deleted // \t{0}", project.getCode());
    }

    @Override
    public void update(Project oldProject, Project newProject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> findAll() {
        List<Project> inventory =mongoOp.findAll(Project.class);
        return inventory;
    }

    @Override
    public void deleteAll() {
        List<Project> toDelete = mongoOp.findAll(Project.class);
        for(Project item: toDelete){
            this.delete(item);
        }
    }

    @Override
    public Project findOne(Project project) {
        Query q =new Query();
        q.addCriteria(Criteria.where("code").is(project.getCode()));
        return mongoOp.findOne(q, Project.class);
    }

}
