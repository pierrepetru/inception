package com.pp.inception.model;

import com.pp.inception.model.sql.Table;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pdinulescu on 3/4/2016.
 */
@Entity
@javax.persistence.Table(name = "DATABASE")

public class Database {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id ;

    @Column(name = "type")
    private String type ;

    @Column(name = "name")
    private String name ;

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
