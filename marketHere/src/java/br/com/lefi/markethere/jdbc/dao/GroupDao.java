/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;

import br.com.lefi.markethere.jdbc.dao.javaBean.GroupBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.GroupHasUserBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserBean;
import br.com.lefi.markethere.utils.Email;
import br.com.lefi.markethere.utils.EmailFormatInvalidException;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author assert
 */
public class GroupDao extends AbastractDao{
    private String sqlInsert = "insert into markethere_sch1.Grupo"+
                            "(data_criacao, nome, quant_pessoas) values(?,?,?);";
    
    private String sqlGetAllGroups = "select grupo.* from markethere_sch1.grupo;";
    
    private String sqlGetAllUsers = "select usuario.* from markethere_sch1.grupo_tem_usuario inner join markethere_sch1.grupo on grupo_tem_usuario.fk_id_grupo = grupo.id and grupo.id = ?\n" +
                            "inner join markethere_sch1.usuario on grupo_tem_usuario.fk_id_usuario = usuario.id;";
    
    private String sqlGetQuantUsers = "select count(grupo_tem_usuario.fk_id_usuario) as quant_users from markethere_sch1.grupo_tem_usuario where grupo_tem_usuario.fk_id_grupo = ?;";
    
    private String sqlGetGroupByName = "select grupo.* from markethere_sch1.grupo where grupo.nome like ?;";
    
    private String sqlGetGroupById = "select grupo.* from markethere_sch1.grupo where grupo.id = ?;";
    
    private GroupHasUserDao groupUserRelantionship = new GroupHasUserDao();
    
    public GroupDao(){
        super();
    }
    
    /**
     * 
     * @param group 
     */
    public void add(GroupBean group){
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(sqlInsert);
            super.sqlCompiler.setDate(1, new Date(group.getCreationDate().getTimeInMillis()));
            super.sqlCompiler.setString(2, group.getName());
            super.sqlCompiler.setInt(3, group.getQuantPessoas());
            super.sqlCompiler.execute();
            super.sqlCompiler.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error in insert group in database");
        }
    }
    
    /**
     * 
     * @return 
     */
    public List <GroupBean> getAllGroups(){
        List <GroupBean> tempArrayGroup = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetAllGroups);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while (resultQuery.next()) {                
                GroupBean tempGroupItem = new GroupBean();
                tempGroupItem.setName(resultQuery.getString("nome"));
                tempGroupItem.setId(resultQuery.getInt("id"));
                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.setTime(resultQuery.getDate("data_criacao"));
                tempGroupItem.setCreationDate(tempCalendar);
                tempGroupItem.setQuantPessoas(0);
                tempGroupItem.setQuantPessoas(this.getQuantUsers(tempGroupItem.getId()));
                tempArrayGroup.add(tempGroupItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
        }
        return tempArrayGroup;
    }
    
    /**
     * 
     * @param idGroup
     * @return 
     */
    public int getQuantUsers(int idGroup){
        int quantUsers = 0;
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetQuantUsers);
            super.sqlCompiler.setInt(1, idGroup);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                quantUsers = resultQuery.getInt("quant_users");
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query quantUsers");
        }
        return quantUsers;
    }
    public List <GroupBean> getGroupByName(String nameGroup){
        List <GroupBean> tempArrayGroup = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetGroupByName);
            super.sqlCompiler.setString(1, "%" + nameGroup + "%");
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while (resultQuery.next()) {                
                GroupBean tempGroupItem = new GroupBean();
                tempGroupItem.setName(resultQuery.getString("nome"));
                tempGroupItem.setId(resultQuery.getInt("id"));
                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.setTime(resultQuery.getDate("data_criacao"));
                tempGroupItem.setCreationDate(tempCalendar);
                tempGroupItem.setQuantPessoas(0);
                tempGroupItem.setQuantPessoas(this.getQuantUsers(tempGroupItem.getId()));
                tempArrayGroup.add(tempGroupItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
        }
        return tempArrayGroup;
    }
    
    /**
     * 
     * @param idGroup
     * @return 
     */
    public List<GroupBean> getGroupById(int idGroup){
        List <GroupBean> tempArrayGroup = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetGroupById);
            super.sqlCompiler.setInt(1, idGroup);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while (resultQuery.next()) {                
                GroupBean tempGroupItem = new GroupBean();
                tempGroupItem.setName(resultQuery.getString("nome"));
                tempGroupItem.setId(resultQuery.getInt("id"));
                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.setTime(resultQuery.getDate("data_criacao"));
                tempGroupItem.setCreationDate(tempCalendar);
                tempGroupItem.setQuantPessoas(0);
                tempGroupItem.setQuantPessoas(this.getQuantUsers(tempGroupItem.getId()));
                tempArrayGroup.add(tempGroupItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
        }
        return tempArrayGroup;
    }
    
    public List <UserBean> getUsersInGroup(int idGroup){
        List <UserBean> tempArrayUsers = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetAllUsers);
            super.sqlCompiler.setInt(1, idGroup);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while (resultQuery.next()) {
                UserBean tempUserItem = new UserBean();
                tempUserItem.setId(resultQuery.getInt("id"));
                tempUserItem.setFirstName(resultQuery.getString("first_name"));
                tempUserItem.setLastName(resultQuery.getString("last_name"));
                try {
                    tempUserItem.setEmail(new Email(resultQuery.getString("email")));
                } catch (EmailFormatInvalidException e) {
                    throw new RuntimeException(e);
                }
                Calendar dataBirth = Calendar.getInstance();
                dataBirth.setTime(resultQuery.getDate("data_nascimento"));
                tempUserItem.setDateBirth(dataBirth);
                tempUserItem.setBairro(resultQuery.getString("bairro"));
                tempUserItem.setCep(resultQuery.getInt("cep"));
                Calendar dataEntry = Calendar.getInstance();
                dataEntry.setTime(resultQuery.getDate("data_ingresso"));
                tempUserItem.setDateEntry(dataEntry);
                tempUserItem.setNum(resultQuery.getInt("num"));
                tempArrayUsers.add(tempUserItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
        }
        return tempArrayUsers;
    }
    
    public void addUsersInGroup (List <UserBean> usersListAdd, GroupBean groupReference){
        GroupHasUserBean tempBeanObject = new GroupHasUserBean(groupReference, usersListAdd);
        
        this.groupUserRelantionship.add(tempBeanObject);
    }
}
