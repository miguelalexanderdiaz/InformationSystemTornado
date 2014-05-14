/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.dao.implementation;

import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import edu.unal.configuration.SpringMongoConfig;
import edu.unal.dao.interfaces.UserDAOInterface;
import edu.unal.model.User;

/**
 *
 * @author migueldiaz
 */
public class UserDAOImpl implements UserDAOInterface{
    
    static final Logger log= Logger.getLogger("UserDB_log");
    
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOp = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    @SuppressWarnings("LoggerStringConcat")
    public void save(User user) {
        mongoOp.save(user);
        log.info("user saved // \t"+user.toString());
    }
    
    
    
}
