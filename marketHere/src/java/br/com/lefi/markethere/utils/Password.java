/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author assert
 */
public class Password {
    private String password;
    private int salt;
    private static MessageDigest encrypter;
    
    /**
     * 
     * @param password
     * @throws NoSuchAlgorithmException 
     */
    public Password(String password) throws NoSuchAlgorithmException{
        this.salt = new Random().nextInt();
        password += this.salt;
        Password.encrypter = MessageDigest.getInstance("SHA-512");
        byte hashByte[] = Password.encrypter.digest(password.getBytes(StandardCharsets.UTF_8));
        this.password = new String(hashByte);
        Password.encrypter.reset();
    }
    /**
     * 
     * @param password
     * @return 
     */
    public boolean isEquals(String password){
        password += this.salt;
        byte attempHash[] = Password.encrypter.digest(password.getBytes(StandardCharsets.UTF_8));
        Password.encrypter.reset();
        if(this.password.equals(new String(attempHash))){
            return true;
        }
        return false;
    }
    public int getSalt(){
        return this.salt;
    }
    /**
     * 
     * @return 
     */
    public String toString(){
        return this.password;
    }
}