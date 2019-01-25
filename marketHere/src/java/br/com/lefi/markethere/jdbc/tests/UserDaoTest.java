/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.tests;
import br.com.lefi.markethere.jdbc.dao.UserDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserBean;
import br.com.lefi.markethere.utils.Email;
import br.com.lefi.markethere.utils.EmailFormatInvalidException;
import br.com.lefi.markethere.utils.Password;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author assert
 */
public class UserDaoTest {
    public static void main(String[] args) throws EmailFormatInvalidException, NoSuchAlgorithmException, SQLException {
        UserBean user1 = new UserBean(0, "filipe", "cazuza", new Email("filipe@acadesdfmico"), new Password("filipe"), Calendar.getInstance(), Calendar.getInstance(), 1234, "rua 1", 0, "bairro 1");
        for(UserBean userItem: new UserDao().getUserByFirstName("fili")){
            System.err.println(userItem);
        }
    }
    
}
