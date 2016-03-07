package com.pp.inception.controller;

import com.pp.inception.model.sql.Column;
import com.pp.inception.model.sql.Table;
import com.pp.inception.service.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdinulescu on 3/4/2016.
 */

@Controller
public class ViewController {

    @Autowired
    private ConnectionService hibernateConnectionService;


    @RequestMapping( value ="views", method = RequestMethod.GET)
    @ResponseBody
    public List<String> findViews() throws ClassNotFoundException {

        return  hibernateConnectionService.getAllViews()   ;
    }



    @RequestMapping( value ="views/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Column> showStructureViews(@PathVariable String name) throws ClassNotFoundException {

        return hibernateConnectionService.getStructureViews(name) ;

    }


}
