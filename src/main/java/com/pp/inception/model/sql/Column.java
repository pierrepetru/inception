package com.pp.inception.model.sql;

/**
 * Created by pdinulescu on 3/7/2016.
 */
public class Column {

    String name ;
    String type ;
    int nullable ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNullable() {
        return nullable;
    }

    public void setNullable(int nullable) {
        this.nullable = nullable;
    }




}
