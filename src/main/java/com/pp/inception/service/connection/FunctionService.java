package com.pp.inception.service.connection;

import com.pp.inception.model.Database;
import com.pp.inception.model.sql.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pdinulescu on 3/9/2016.
 */
@Service("function")
public class FunctionService implements ConnectionService {

    @Autowired
    private Database myData ;


    @Override
    public String connecte() {
        return null;
    }

    @Override
    public List<String> getAllTables() throws SQLException, ClassNotFoundException {
        System.out.println("***********************************************************mydata **********************");
        System.out.println(myData.getUsername()) ;
        return null;
    }

    @Override
    public List<Column> getStructureTable(String name) {
        return null;
    }

    @Override
    public List getDataColumnTable(String name, String fieldName, int page, int size) {
        return null;
    }

    @Override
    public List<String> getAllViews() {
        return null;
    }

    @Override
    public List<Column> getStructureViews(String name) {
        return null;
    }

    @Override
    public List getDataColumnView(String name, String fieldName, int page, int size) {
        return null;
    }
}
