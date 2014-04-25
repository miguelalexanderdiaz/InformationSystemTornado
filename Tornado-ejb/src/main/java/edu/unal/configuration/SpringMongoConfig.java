/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unal.configuration;


 
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
 

/**
 *
 * @author migueldiaz
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {
    private final String DB_IP="127.0.0.1";
    private final String DB_NAME="tornadoDB";
    

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(DB_IP);
    }
    
}
