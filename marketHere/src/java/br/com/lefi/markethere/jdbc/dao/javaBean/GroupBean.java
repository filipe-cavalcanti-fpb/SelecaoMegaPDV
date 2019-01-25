/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author assert
 */
public class GroupBean extends AbstractBeanObject{
    private int id;
    private Calendar creationDate;
    private String name;
    private int quantPessoas;
    private List <UserBean> usersInGroup;

    public GroupBean(Calendar creationDate, String name, int quantPessoas) {
        this.creationDate = creationDate;
        this.name = name;
        this.quantPessoas = quantPessoas;
    }
    public GroupBean(){
        
    }

    public List<UserBean> getUsersInGroup() {
        return usersInGroup;
    }

    public void setUsersInGroup(List<UserBean> usersInGroup) {
        this.usersInGroup = usersInGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantPessoas() {
        return quantPessoas;
    }

    public void setQuantPessoas(int quantPessoas) {
        this.quantPessoas = quantPessoas;
    }

    @Override
    public String toString() {
        return "GroupBean{" + "id=" + id + ", creationDate=" + creationDate + ", name=" + name + ", quantPessoas=" + quantPessoas + '}';
    }
    
}