/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.utils.tests;

import br.com.lefi.markethere.utils.Email;
import br.com.lefi.markethere.utils.Password;
import br.com.lefi.markethere.utils.EmailFormatInvalidException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author assert
 */
public class EmailTest {

    Email testEmail;

    public EmailTest() {
        try {
            this.testEmail = new Email("teste@gmail.com");
        } catch (EmailFormatInvalidException ex) {
            System.err.println("unhum!!!");
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Password pass = new Password("felipe");
        System.out.println(pass);
        System.out.println(pass.isEquals("felipe"));
    }

}
