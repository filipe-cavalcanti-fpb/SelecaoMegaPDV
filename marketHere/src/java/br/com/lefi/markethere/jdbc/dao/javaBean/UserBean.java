/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

import br.com.lefi.markethere.utils.Email;
import br.com.lefi.markethere.utils.Password;
import java.util.Calendar;

/**
 *
 * @author assert
 */
public class UserBean extends AbstractBeanObject{
    private int id;
    private String firstName;
    private String lastName;
    private Email email;
    private Password password;
    private long salt;
    private Calendar dateBirth;
    private Calendar dateEntry;
    private int cep;
    private String street;
    private int num;
    private String bairro;
    
    public UserBean(int id, String firstName, String lastName, Email email, Password password, Calendar dateBirth, Calendar dateEntry, int cep, String street, int num, String bairro) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateBirth = dateBirth;
        this.dateEntry = dateEntry;
        this.cep = cep;
        this.street = street;
        this.num = num;
        this.bairro = bairro;
    }
    
    public UserBean(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
        this.salt = password.getSalt();
    }

    public Calendar getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Calendar dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Calendar getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Calendar dateEntry) {
        this.dateEntry = dateEntry;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "UserBean{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" 
                + password + ", salt=" + salt + ", dateBirth=" + dateBirth + ", dateEntry=" + dateEntry + ", cep=" + cep + ", street=" + street + ", num=" + num + ", bairro=" + bairro + '}';
    }
    
}
