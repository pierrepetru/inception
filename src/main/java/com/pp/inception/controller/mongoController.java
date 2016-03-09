package com.pp.inception.controller;

import com.pp.inception.service.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by pdinulescu on 3/8/2016.
 */

@Controller
public class MongoController {


    @Autowired
    private ConnectionService mongodbConnectionService;



    @RequestMapping(value = "mongoConnecte", method = RequestMethod.GET)
    @ResponseBody
    public String seeMongo(){
        System.out.println("***************************************");
        String result = mongodbConnectionService.connecte() ;

        return result ;
    }



}
