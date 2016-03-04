package com.pp.inception.controller;

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



    String database = "protein_tracker" ;
    String url = "jdbc:mysql://localhost:3306/"+database;
    String username = "root";
    String password = "root2";


    @RequestMapping( value ="views", method = RequestMethod.GET)
    @ResponseBody
    public List<String> findTables() throws ClassNotFoundException {
        List<String> response =new ArrayList<>();

        System.out.println("Connecting database...");
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            System.out.println("Database connected!");
            DatabaseMetaData metaData = connection.getMetaData() ;

            ResultSet rs1 = metaData.getTables(null, null, null,new String[] {"VIEW"});
            while (rs1.next()) {
                System.out.println(rs1.getString("TABLE_NAME"));
                response.add(rs1.getString("TABLE_NAME") );
            }

            rs1.close();
            connection.close();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }


        return response ;
    }



    @RequestMapping( value ="views/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<String> showStructureTable(@PathVariable String name) throws ClassNotFoundException {
        List<String> response =new ArrayList<>();
        System.out.println("name of table :" + name);
        System.out.println("Connecting database...");
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            DatabaseMetaData metaData = connection.getMetaData() ;

            ResultSet res = metaData.getColumns(null, null,name ,null);
            while (res.next()) {
                System.out.println("entrer" );
                System.out.println(
//                        " " + res.getString("TABLE_SCHEM") + ", "+
                                 res.getString("TABLE_NAME")
                                + ", "+res.getString("COLUMN_NAME")
                                + ", "+res.getString("TYPE_NAME")
                                + ", "+res.getInt("COLUMN_SIZE")
                                + ", "+res.getInt("NULLABLE"));

                response.add(res.getString("TABLE_NAME")
                        + ", "+res.getString("COLUMN_NAME")
                        + ", "+res.getString("TYPE_NAME")
                        + ", "+res.getInt("COLUMN_SIZE")
                        + ", "+res.getInt("NULLABLE"));
            }
            res.close();

            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        return response ;
    }


}
