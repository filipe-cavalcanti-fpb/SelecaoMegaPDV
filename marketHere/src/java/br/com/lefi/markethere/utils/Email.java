/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author assert
 */
public class Email {
    private String email;
    
    public Email(String email) throws EmailFormatInvalidException{
        if(this.validator(email)){
            this.email = email;
        }
        else{
            throw new EmailFormatInvalidException();
        }
        
    }
    private boolean validator(String email){
        final String PATTERN = "^(.*)@(.*)$";
        Pattern reg = Pattern.compile(PATTERN);
        Matcher match = reg.matcher(email);
        if(match.find()){
            return true;
        }
        return false;
    }
    public String toString(){
        return this.email;
    }
}
