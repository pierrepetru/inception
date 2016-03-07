package com.pp.inception.service.connection;


import com.pp.inception.model.Database;
import com.pp.inception.model.sql.Column;
import com.pp.inception.model.sql.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.*;
import java.util.*;

/**
 * Created by pdinulescu on 3/4/2016.
 */

@Service("hibernateConnectionService")
public class hibernateConnectionService implements ConnectionService {

    private static SessionFactory sessionFactory;
    private static  StandardServiceRegistryBuilder builder ;
    private Database myDatabase ;

    static  {
        Properties prop =  new Properties() ;

        prop.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/protein_tracker" ) ;
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver") ;
        prop.setProperty("hibernate.connection.username" ,"root");
        prop.setProperty("hibernate.connection.password" ,"root2");

        Configuration cfg = new Configuration().setProperties(prop) ;
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.show_sql","true")
                .setProperty("hibernate.format_sql","true");

        builder = new StandardServiceRegistryBuilder().
        applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }


    @Override
    public Connection connecte() {
        return null;
    }

    public List<String> getAllTables() throws SQLException, ClassNotFoundException {
        List<String> allTables = new ArrayList<>() ;
        System.out.println("********************OPENNING SESSION *************************");
        Session session = sessionFactory.openSession() ;

        session.doWork(new Work() {
           @Override
            public void execute(Connection connection) throws SQLException {
                //connection, finally!
                DatabaseMetaData metaData = connection.getMetaData() ;
                ResultSet rs1 = metaData.getTables(null, null, null,new String[] {"TABLE"});

               System.out.println(metaData.getTables(null, null, null,new String[] {"TABLE"}).toString());
                while (rs1.next()) {

                    String tableName = rs1.getString("TABLE_NAME");
                //    allTables.add(rs1.getString("TABLE_SCHEM") );
                    allTables.add(rs1.getString("TABLE_NAME") );
                    System.out.println(tableName);
                }
                rs1.close();
            }
        });
        session.close() ;

        return allTables;
    }

    public List<Column> getStructureTable(String name) {

        List<Column> informationTable = new ArrayList<Column>();

        Session session = sessionFactory.openSession() ;
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //connection, finally!
                DatabaseMetaData metaData = connection.getMetaData() ;

                ResultSet rs1 =  metaData.getColumns(null, null,name ,null);

                while (rs1.next()) {
                    Column colonne = new Column();

                    colonne.setName(rs1.getString("COLUMN_NAME"));
                    colonne.setNullable(rs1.getInt("NULLABLE"));
                    colonne.setType(rs1.getString("TYPE_NAME"));

                    informationTable.add(colonne) ;
                }
                rs1.close();
            }
        });
        session.close() ;
        return informationTable ;

    }

    @Override
    public List<String> getAllViews() {
        List<String> allViews= new ArrayList<>() ;
        System.out.println("********************OPENNING SESSION *************************");
        Session session = sessionFactory.openSession() ;

        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //connection, finally!
                DatabaseMetaData metaData = connection.getMetaData() ;


                ResultSet rs1 = metaData.getTables(null, null, null,new String[] {"VIEW"});
                while (rs1.next()) {

                    allViews.add(rs1.getString("TABLE_NAME") );
                }
                rs1.close();
            }
        });
        session.close() ;

        return allViews;
    }

    @Override
    public List<Column> getStructureViews(String name) {
        List informationViews = new ArrayList<Table>();

        System.out.println("********************OPENNING SESSION *************************");
        Session session = sessionFactory.openSession();

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

        return informationViews ;
    }


}
