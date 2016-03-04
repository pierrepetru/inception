package com.pp.inception.service.connection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by pdinulescu on 3/4/2016.
 */

@Service("hibernateConnectionService")
public class hibernateConnectionService implements ConnectionService {

    @PersistenceContext
    private EntityManager em;

    private static SessionFactory sessionFactory;
    private static  StandardServiceRegistryBuilder builder ;

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
    public Connection connecte() {//throws SQLException, ClassNotFoundException {
        return null;
    }

    public List<String> getAllTables() throws SQLException {
        List<String> allTables = new ArrayList<>() ;
        System.out.println("*********************************************");
        System.out.println("-------------------------------------");
        Session session = sessionFactory.openSession() ;

    /*    Query query2 = session.createQuery("SELECT * FROM USERS ");
        String idpersonne = query2.list().get(0).toString() ;
        System.out.println( idpersonne);
        allTables.add(idpersonne) ;
*/
        org.hibernate.engine.spi.SessionImplementor sessionImp =
                (org.hibernate.engine.spi.SessionImplementor) em.getDelegate();
        DatabaseMetaData metadata = sessionImp.connection().getMetaData();
//do whatever you need with the metadata object...
        System.out.println(metadata.getDatabaseProductName());


        return allTables;
    }
}
