/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao.implementation;

import edu.unal.configuration.SpringMongoConfig;
import edu.unal.dao.interfaces.UserDAOInterface;
import edu.unal.model.User;
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
 * @author migueldiaz
 */
public class UserDAOImpl implements UserDAOInterface{
    
    static final Logger log= Logger.getLogger("UserDB_log");
    
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOp = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    public void save(User user) {
        mongoOp.save(user);
        log.log(Level.INFO, "user saved // \t{0}", user.toString());
    }

    @Override
    public void delete(User user) {
        mongoOp.remove(user);
        log.log(Level.INFO, "user deleted // \t{0}", user.toString());
    }

    @Override
    public User findById(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        log.info("user found // \t"+user.toString());
        User foundUser= mongoOp.findOne(query, User.class);
        return foundUser;
    } 
    
    @Override
    public User findByName(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(user.getUserName()));
        log.log(Level.INFO, "user found // \t{0}", user.toString());
        User foundUser= mongoOp.findOne(query, User.class);
        return foundUser;
    }

    @Override
    public List<User> findAll() {
        List<User> users=mongoOp.findAll(User.class);
        return users;
    }

    @Override
    public void deleteAll() {
        List<User> toDelete = mongoOp.findAll(User.class);
        for (User user : toDelete) {
            this.delete(user);
        }
    }
    
    
    
  
}
