/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;

import br.com.lefi.markethere.jdbc.dao.javaBean.CategoryBean;
import java.sql.SQLException;

/**
 *
 * @author assert
 */
public class CategoryDao extends AbastractDao{
    private String sqlInsert = "insert into markethere_sch1.Category(nome)values(?);";
    
    public CategoryDao(){
        super();
    }
    public void add(CategoryBean category){
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(sqlInsert);
            super.sqlCompiler.setString(1, category.getName());
            super.sqlCompiler.execute();
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException("Error in insert category to database");
        }
    }
}
