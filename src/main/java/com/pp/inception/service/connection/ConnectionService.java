package com.pp.inception.service.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pdinulescu on 3/4/2016.
 */
public interface ConnectionService {



    Connection connecte() ; //throws SQLException,ClassNotFoundException;


    List<String> getAllTables() throws SQLException;//throws SQLException, ClassNotFoundException;
}
