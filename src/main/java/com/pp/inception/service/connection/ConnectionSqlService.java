package com.pp.inception.service.connection;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdinulescu on 3/4/2016.
 */

@Service("connectionSqlService")
public class ConnectionSqlService {//implements ConnectionService {


    String database = "protein_tracker" ;
    String url = "jdbc:mysql://localhost:3306/"+database;
    String username = "root";
    String password = "root2";



public Connection connecte() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");

    return DriverManager.getConnection(url, username, password);
}


public List<String> getAllTables()  throws SQLException, ClassNotFoundException {

    List<String> listInfo = new ArrayList<>();

    Connection connection = connecte();
    DatabaseMetaData metaData = connection.getMetaData();

    ResultSet rs1 = metaData.getTables(null, null, null, new String[]{"TABLE"});
        while (rs1.next()) {

            listInfo.add(rs1.getString("TABLE_SCHEM"));
            listInfo.add(rs1.getString("TABLE_NAME"));

        }
        rs1.close();


    connection.close();
      return listInfo;
}

}
