package com.pp.inception.service.connection;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.pp.inception.model.sql.Column;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by pdinulescu on 3/8/2016.
 */
@Service("mongodbConnectionService")
public class MongodbConnectionService implements ConnectionService {

    public static final String DB_NAME = "test";
    public static final String PERSON_COLLECTION = "restaurants";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    @Override
    public String connecte(){
        String result = "";
        System.out.println("----------------------------------------");
        Mongo mongo = null;
        try {
            mongo = new Mongo(MONGO_HOST, MONGO_PORT);
          //  MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
           // mongoOps.findOne() ;

           // MongoDatabase db = mongo.getDatabase("test");
        System.out.println("********************Connection Mongo***********************");
            DB db = mongo.getDB("test");
            Set<String> collections = db.getCollectionNames();

            for (String collectionName : collections) {
                System.out.println(collectionName);
                result +=" " + collectionName ;
            }
            DBCollection coll = db.getCollection("restaurants");
         //   DBObject doc = coll.findOne();

            DBObject myDoc = coll.findOne();
            result += " " + myDoc.toString() ;
            System.out.println(myDoc);


            mongo.close();

    } catch (MongoException e) {
        e.printStackTrace();
    }
        return result ;

    }

    @Override
    public List<String> getAllTables() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Column> getStructureTable(String name) {
        return null;
    }

    @Override
    public List getDataColumnTable(String name, String fieldName, int page, int size) {
        return null;
    }

    @Override
    public List<String> getAllViews() {
        return null;
    }

    @Override
    public List<Column> getStructureViews(String name) {
        return null;
    }

    @Override
    public List getDataColumnView(String name, String fieldName, int page, int size) {
        return null;
    }


}
