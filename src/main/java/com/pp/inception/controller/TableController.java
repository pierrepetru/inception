package com.pp.inception.controller;

import com.pp.inception.service.connection.ConnectionService;
import com.pp.inception.service.connection.ConnectionSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdinulescu on 3/3/2016.
 */

@Controller
public class TableController {

    @Autowired(required=true)
    private ConnectionService hibernateConnectionService ;//connectionSqlService;
/*
    String database = "protein_tracker" ;
    String url = "jdbc:mysql://localhost:3306/"+database;
    String username = "root";
    String password = "root2";*/

//See all tables on the database
    @RequestMapping( value ="tables", method = RequestMethod.GET)
    @ResponseBody
    public List<String> findTables() throws SQLException, ClassNotFoundException {//throws ClassNotFoundException, SQLException {


        return hibernateConnectionService.getAllTables() ;

         //   return connectionSqlService.getAllTables();

    }





        /*
    List<String> response =new ArrayList<>();

        System.out.println("Connecting database...");
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            System.out.println("Database connected!");
            DatabaseMetaData metaData = connection.getMetaData() ;

            ResultSet rs1 = metaData.getTables(null, null, null,new String[] {"TABLE"});
            while (rs1.next()) {

                    String tableName = rs1.getString("TABLE_NAME");
                response.add(rs1.getString("TABLE_SCHEM") );
                    response.add(rs1.getString("TABLE_NAME") );
                    System.out.println(tableName);
            }
            rs1.close();

            connection.close();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }


        return response ; */ //"tabJsPage" ;


/*
    @RequestMapping( value ="table/{name}", method = RequestMethod.GET)
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

                System.out.println(
                       " " + res.getString("TABLE_SCHEM")
                                + ", "+res.getString("TABLE_NAME")
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

*/
}
