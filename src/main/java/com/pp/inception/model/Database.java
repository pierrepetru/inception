package com.pp.inception.model;

import com.pp.inception.model.sql.Table;
import org.hibernate.annotations.Columns;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pdinulescu on 3/4/2016.
 */
/*
@Entity
@javax.persistence.Table(name = "DATABASE")
*/

public class Database {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id ;

    @Column(name = "type")
    private String type ;

    @Column(name = "name")
    private String name ;

    public String getDialect() {
        return dialect;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private String host ;

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getShow_sql() {
        return show_sql;
    }

    public void setShow_sql(String show_sql) {
        this.show_sql = show_sql;
    }

    public String getFormat_sql() {
        return format_sql;
    }

    public void setFormat_sql(String format_sql) {
        this.format_sql = format_sql;
    }

    private String dialect ;
    private String show_sql ;
    private String format_sql ;


    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private String port ;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    private String driver ;

    @Column(name = "url")
    private String url ;

    @Column(name = "username")
    private String username ;

    @Column(name = "password")
    private String password ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
