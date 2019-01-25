/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserBean;
import br.com.lefi.markethere.utils.Email;
import br.com.lefi.markethere.utils.EmailFormatInvalidException;
import br.com.lefi.markethere.utils.Password;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.RuntimeException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author assert
 */
public class UserDao extends AbastractDao{
    
    private String sqlInsertUser = "insert into markethere_sch1.Usuario"+
                         "(first_name, last_name, email, senha, data_nascimento, data_ingresso, cep, rua, num, bairro, salt)" + 
                         "values(?,?,?,?,?,?,?,?,?,?,?);";
    
    private String sqlGetUserById = "select usuario.* from markethere_sch1.usuario where usuario.id = ?;";
    
    private String sqlGetAllUsers = "select usuario.* from markethere_sch1.usuario;";
    
    private String sqlGetUserByFirstName = "select usuario.* from markethere_sch1.usuario where upper(usuario.first_name) like upper(?)";
    
    private PreparedStatement sqlCompiler;
    
    public UserDao(){
        super();
    }
    
    /**
     * 
     * @param user 
     */
    public void add(UserBean user){
        try {
            this.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlInsertUser);
            this.sqlCompiler.setString(1, user.getFirstName());
            this.sqlCompiler.setString(2, user.getLastName());
            this.sqlCompiler.setString(3, user.getEmail().toString());
            this.sqlCompiler.setString(4, user.getPassword().toString());
            this.sqlCompiler.setDate(5, new Date(user.getDateBirth().getTimeInMillis()));
            this.sqlCompiler.setDate(6, new Date(user.getDateEntry().getTimeInMillis()));
            this.sqlCompiler.setInt(7, user.getCep());
            this.sqlCompiler.setString(8, user.getStreet());
            this.sqlCompiler.setInt(9, user.getNum());
            this.sqlCompiler.setString(10, user.getBairro());
            this.sqlCompiler.setInt(11, user.getPassword().getSalt());
            this.sqlCompiler.execute();
            this.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException();
        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public List <UserBean> getUserById(int id){
        List <UserBean> tempArrayUsers = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetUserById);
            super.sqlCompiler.setInt(1, id);
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
    
    /**
     * 
     * @return 
     */
    public List<UserBean> getAllUsers(){
        List <UserBean> tempArrayUsers = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetAllUsers);
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
                try {
                    tempUserItem.setPassword(new Password(resultQuery.getString("senha")));
                } catch (NoSuchAlgorithmException | SQLException e) {
                }
                tempArrayUsers.add(tempUserItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
        }
        return tempArrayUsers;
    }
    
    /**
     * 
     * @param nameUser
     * @return 
     */
    public List <UserBean> getUserByFirstName(String nameUser){
        List <UserBean> tempArrayUsers = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetUserByFirstName);
            super.sqlCompiler.setString(1,"%" + nameUser + "%");
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
            throw new RuntimeException(sqlE);
        }
        return tempArrayUsers;
    }
}
