/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.tests;
import br.com.lefi.markethere.jdbc.dao.SharedListDao;
import br.com.lefi.markethere.jdbc.dao.UserDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.SharedListBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserBean;
import java.util.Calendar;

/**
 *
 * @author assert
 */
public class SharedListDaoTest {
    public static void main(String[] args) {
        //SharedListBean sharedListTest = new SharedListBean("lista da farra", "farra's list", Calendar.getInstance(), 1, 2);
        SharedListDao tempSharedList = new SharedListDao();
        System.err.println(new UserDao().getUserById(3).get(0));
        //tempSharedList.addUser(tempSharedList.getSharedListById(1).get(0), );
    }
}
