package com.pp.inception.controller;

import com.pp.inception.model.sql.Column;
import com.pp.inception.service.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.Optional;


/**
 * Created by pdinulescu on 3/3/2016.
 */

@Controller
public class TableController {

    @Autowired()
    private ConnectionService hibernateConnectionService;



    @RequestMapping( value = "tables/{name}/{fieldName}",method = RequestMethod.GET )
    @ResponseBody
    public List findDataColumnTable(@PathVariable String name, @PathVariable String fieldName) {

        return hibernateConnectionService.getDataColumnTable(name, fieldName, 0, 100);

    }

    @RequestMapping( value = "tables/{name}/{fieldName}",params = { "page", "pageCount" },method = RequestMethod.GET )
    @ResponseBody
    public List findDataColumnTable(
            @RequestParam(value = "page", required = false ) Optional<Integer> page, @RequestParam( value ="pageCount", required = false ) Optional<Integer> size, @PathVariable String name, @PathVariable String fieldName){

        int pageDef = 0 ;
        int sizeDef = 100 ;

        if( page.isPresent() ){
            pageDef = page.get();
        }
        if( size.isPresent() ){
            sizeDef = size.get();
        }

        return hibernateConnectionService.getDataColumnTable(name, fieldName, pageDef, sizeDef);

    }


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
        dt.setPassword("config");
        dt.setType("sql");
        dt.setUrl("hjjhhh");
        session.persist(dt);
        t.commit();
        session.close();
        System.out.println("save succesfull");
*/
    }

}
