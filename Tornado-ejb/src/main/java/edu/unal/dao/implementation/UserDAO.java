/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.dao.implementation;

import com.mongodb.BasicDBObject;
import edu.unal.configuration.SpringMongoConfig;
import edu.unal.dao.interfaces.UserDAOInterface;
import edu.unal.model.InventoryItem;
import edu.unal.model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;

/**
 *
 * @author migueldiaz
 */
public class UserDAO implements UserDAOInterface {

    static final Logger log = Logger.getLogger("UserDB_log");

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOp = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    @SuppressWarnings("LoggerStringConcat")
    public void save(User user) {
        mongoOp.save(user);
        log.info("user saved // \t" + user.toString());
    }

    @Override
    public void delete(User user) {
        mongoOp.remove(findOne(user));
        log.info("user deleted // \t" + user.toString());
    }

    @Override
    public User findById(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        User foundUser = mongoOp.findOne(query, User.class);
        log.info("user found // \t" + user.toString());
        return foundUser;
    }

    @Override
    public User findByName(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(user.getUserName()));

        User foundUser = mongoOp.findOne(query, User.class);
        log.info("user found // \t" + foundUser.toString());
        return foundUser;
    }

    @Override
    public List<User> findAll() {
        List<User> users = mongoOp.findAll(User.class);
        return users;
    }

    @Override
    public void deleteAll() {
        List<User> toDelete = mongoOp.findAll(User.class);
        for (User user : toDelete) {
            this.delete(user);
        }
    }

    @Override
    public User findOne(User user) {
        Query q =new Query();
        q.addCriteria(Criteria.where("userName").
                is(user.getUserName()).and("password").
                is(user.getPassword()).and("rol").
                is(user.getRol()));
        return mongoOp.findOne(q, User.class);
    }

    @Override
    public void update(User oldUser, User newUser) {
        Query q=new Query();
        q.addCriteria(Criteria.where("userName").is(oldUser.getUserName()).
                and("password").is(oldUser.getPassword()).and("rol").is(oldUser.getRol()));
        Update up=new Update();
        up.set("userName", newUser.getUserName());
        up.set("password", newUser.getPassword());
        up.set("rol", newUser.getRol());
        up.set("salary", newUser.getSalary());
        
        mongoOp.findAndModify(q, up, User.class);
        Object aux[] = {oldUser.toString(),newUser.toString()};
        log.log(Level.INFO, "actualizado de: {0} a {1} ", aux);
    }
    
    

}
