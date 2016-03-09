package com.pp.inception.repository;

import com.pp.inception.model.Database;
import com.pp.inception.model.sql.Column;
import com.pp.inception.model.sql.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by pdinulescu on 3/8/2016.
 */
@Component
public class HibernateDataBaseConnection implements DataBaseConnection {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistryBuilder builder;

    //  private static Database myDatabase ;

    static {

        /*    System.out.println("*********************************************Database object ***************************************************************************");

            Database db = new Database();
            db.setType("hibernate");
            db.setDriver("com.mysql.jdbc.Driver");
            db.setUrl("jdbc:mysql://localhost:3306/inception_db");
            db.setName("test");
            db.setUsername("root");
            db.setPassword("root2");

            db.setPort("3306");
            // db.setPort("27017");
            db.setDialect("org.hibernate.dialect.MySQLDialect");
            db.setShow_sql("hibernate.show_sql");
            db.setFormat_sql("hibernate.format_sql");

            db.setHost("localhost");
*/


        //  System.out.println(myDatabase.getUsername() );

        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/protein_tracker");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root2");

        Configuration cfg = new Configuration().setProperties(prop);
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true");

        builder = new StandardServiceRegistryBuilder().
                applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    @Override
    public Object getConnection() {
        return this.getSessionFactory();
    }

}

