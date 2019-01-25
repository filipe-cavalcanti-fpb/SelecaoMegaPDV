/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author assert
 */
public class SharedListBean extends AbstractBeanObject{
    private int id;
    private String description;
    private String name;
    private Calendar creationDate;
    private int fkIdGroup;
    private List <UserBean> userList;
    private List <ProductBean> ProductList;

    public SharedListBean(String description, String name, Calendar creationDate, int fkIdGroup) {
        this.description = description;
        this.name = name;
        this.creationDate = creationDate;
        this.fkIdGroup = fkIdGroup;
        this.ProductList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public List<ProductBean> getProductList() {
        return ProductList;
    }

    public void setProductList(List<ProductBean> ProductList) {
        this.ProductList = ProductList;
    }
    
    public SharedListBean(){
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public int getFkIdGroup() {
        return fkIdGroup;
    }

    public void setFkIdGroup(int fkIdGroup) {
        this.fkIdGroup = fkIdGroup;
    }

    public List<UserBean> getUserList() {
        return userList;
    }

    public void setUserList(List<UserBean> usersReference) {
        this.userList = usersReference;
    }

    @Override
    public String toString() {
        return "SharedListBean{" + "id=" + id + ", description=" + description + ", name=" + name + ", creationDate=" + creationDate + ", fkIdGroup=" + fkIdGroup + ", fkIdUser=" + userList + '}';
    }
    
    
}
