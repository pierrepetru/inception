package com.pp.inception.model.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdinulescu on 3/4/2016.
 */
public class Table {


   private String name ;
   private List<Column> parametre = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getParametre() {
        return parametre;
    }

    public void setParametre(List<Column> parametre) {
        this.parametre = parametre;
    }

    public void addColumn(Column col){

        parametre.add(col) ;
    }

}
