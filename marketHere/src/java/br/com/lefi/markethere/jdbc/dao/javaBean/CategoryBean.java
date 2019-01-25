/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

/**
 *
 * @author assert
 */
public class CategoryBean extends AbstractBeanObject{
    private String name;
    
    public CategoryBean(String name){
        this.name = name;
    }
    public CategoryBean(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
