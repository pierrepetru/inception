package com.pp.inception.service.connection;

import com.pp.inception.model.sql.Column;
import com.pp.inception.model.sql.Table;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by pdinulescu on 3/4/2016.
 */
public interface ConnectionService {



    String connecte() ;

    List<String> getAllTables() throws SQLException, ClassNotFoundException;
    List<Column> getStructureTable(String name) ;
    List getDataColumnTable(String name,String fieldName, int page, int size);

    List<String> getAllViews() ;
    List<Column> getStructureViews(String name) ;
    List getDataColumnView(String name,String fieldName, int page, int size);


}

