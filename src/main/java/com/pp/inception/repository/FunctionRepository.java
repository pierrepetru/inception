package com.pp.inception.repository;

import com.pp.inception.model.sql.Column;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pdinulescu on 3/9/2016.
 */
public interface FunctionRepository {

    List<String> getAllTables() throws SQLException, ClassNotFoundException;
    List<Column> getStructureTable(String name) ;
    List getDataColumnTable(String name,String fieldName, int page, int size);

    List<String> getAllViews() ;
    List<Column> getStructureViews(String name) ;
    List getDataColumnView(String name,String fieldName, int page, int size);

}
