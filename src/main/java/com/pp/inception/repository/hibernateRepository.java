package com.pp.inception.repository;

import com.pp.inception.model.Database;
import com.pp.inception.model.sql.Column;
import com.pp.inception.model.sql.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdinulescu on 3/9/2016.
 */

public class HibernateRepository implements FunctionRepository  {

    @Autowired
    private  HibernateDataBaseConnection database ;

    public  List<String> getDataColumnView(String name, String fieldName, int page, int size) {

        Session session = database.getSessionFactory().openSession();

        String sql = "Select " + fieldName + " from " + name + " LIMIT " + size + " OFFSET " + size * page;

        List result = new ArrayList<>();
        result = session.createSQLQuery(sql).list();

        session.close();
        return result ;

    }

    @Override
    public List getDataColumnTable(String name, String fieldName, int page, int size) {

        Session session = database.getSessionFactory().openSession();

        String sql = "Select " + fieldName + " from " + name + " LIMIT " + size + " OFFSET " + size * page;
        List result = new ArrayList<>();
        result = session.createSQLQuery(sql).list();

        session.close();
        return result;
    }



    public List<String> getAllTables() throws SQLException, ClassNotFoundException {
        List<String> allTables = new ArrayList<>();
        System.out.println("********************OPENNING SESSION *************************");
        Session session = database.getSessionFactory().openSession();

        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //connection, finally!
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet rs1 = metaData.getTables(null, null, null, new String[]{"TABLE"});

                System.out.println(metaData.getTables(null, null, null, new String[]{"TABLE"}).toString());
                while (rs1.next()) {

                    String tableName = rs1.getString("TABLE_NAME");
                    //    allTables.add(rs1.getString("TABLE_SCHEM") );
                    allTables.add(rs1.getString("TABLE_NAME"));
                    System.out.println(tableName);
                }
                rs1.close();
            }
        });
        session.close();

        return allTables;
    }

    public List<Column> getStructureTable(String name) {

        List<Column> informationTable = new ArrayList<Column>();

        Session session = database.getSessionFactory().openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //connection, finally!
                DatabaseMetaData metaData = connection.getMetaData();

                ResultSet rs1 = metaData.getColumns(null, null, name, null);

                while (rs1.next()) {
                    Column colonne = new Column();

                    colonne.setName(rs1.getString("COLUMN_NAME"));
                    colonne.setNullable(rs1.getInt("NULLABLE"));
                    colonne.setType(rs1.getString("TYPE_NAME"));

                    informationTable.add(colonne);
                }
                rs1.close();
            }
        });
        session.close();
        return informationTable;

    }

    @Override
    public List<String> getAllViews() {
        List<String> allViews = new ArrayList<>();
        System.out.println("********************OPENNING SESSION *************************");
        Session session = database.getSessionFactory().openSession();

        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //connection, finally!
                DatabaseMetaData metaData = connection.getMetaData();


                ResultSet rs1 = metaData.getTables(null, null, null, new String[]{"VIEW"});
                while (rs1.next()) {

                    allViews.add(rs1.getString("TABLE_NAME"));
                }
                rs1.close();
            }
        });
        session.close();

        return allViews;
    }

    @Override
    public List<Column> getStructureViews(String name) {
        List informationViews = new ArrayList<Table>();

        System.out.println("********************OPENNING SESSION *************************");
        Session session = database.getSessionFactory().openSession();

        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //connection, finally!
                DatabaseMetaData metaData = connection.getMetaData();

                ResultSet res = metaData.getColumns(null, null, name, null);

                while (res.next()) {
                    Column colonne = new Column();

                    colonne.setName(res.getString("COLUMN_NAME"));
                    colonne.setNullable(res.getInt("NULLABLE"));
                    colonne.setType(res.getString("TYPE_NAME"));


                    informationViews.add(colonne);
                }
                res.close();
            }
        });
        session.close();

        return informationViews;
    }

}
