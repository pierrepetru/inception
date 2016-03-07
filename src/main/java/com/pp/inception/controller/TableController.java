package com.pp.inception.controller;

import com.pp.inception.config.HibernateConfiguration;
import com.pp.inception.model.Database;
import com.pp.inception.model.sql.Column;
import com.pp.inception.service.connection.ConnectionService;
import com.pp.inception.service.connection.ConnectionSqlService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by pdinulescu on 3/3/2016.
 */

@Controller
public class TableController {

    @Autowired()
    private ConnectionService hibernateConnectionService;


    @RequestMapping(value = "tables", method = RequestMethod.GET)
    @ResponseBody
    public List<String> findTables() throws SQLException, ClassNotFoundException {//throws ClassNotFoundException, SQLException {

        return hibernateConnectionService.getAllTables();

    }


    @RequestMapping(value = "tables/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Column> showStructureTable(@PathVariable String name) throws ClassNotFoundException {
        System.out.println("name of table :" + name);
        return hibernateConnectionService.getStructureTable(name);
    }



    @RequestMapping(value = "createOne", method = RequestMethod.GET)
    public void createOne()  {
/*
    Session session = transactionManager.getSessionFactory().openSession() ;
        Transaction t = session.beginTransaction();
        Database dt = new Database();
        dt.setUsername("pierre");
        dt.setName("databasepersonnel");
        dt.setPassword("toto");
        dt.setType("sql");
        dt.setUrl("hjjhhh");
        session.persist(dt);
        t.commit();
        session.close();
        System.out.println("save succesfull");
*/
    }

}
