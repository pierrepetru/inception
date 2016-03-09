package com.pp.inception.controller;

import com.pp.inception.model.sql.Column;
import com.pp.inception.model.sql.Table;
import com.pp.inception.service.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by pdinulescu on 3/4/2016.
 */

@Controller
public class ViewController {

    @Autowired
    private ConnectionService hibernateConnectionService;


    @RequestMapping( value = "views/{name}/{fieldName}",method = RequestMethod.GET )
    @ResponseBody
    public List findDataColumnTable(@PathVariable String name, @PathVariable String fieldName) {

        return hibernateConnectionService.getDataColumnTable(name, fieldName, 0, 100);

    }

    @RequestMapping( value = "views/{name}/{fieldName}",params = { "page", "pageCount" },method = RequestMethod.GET )
    @ResponseBody
    public List findDataColumnViews(
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
