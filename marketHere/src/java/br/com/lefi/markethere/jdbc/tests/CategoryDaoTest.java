/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.tests;

import br.com.lefi.markethere.jdbc.dao.CategoryDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.CategoryBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.AbstractBeanObject;
/**
 *
 * @author assert
 */
public class CategoryDaoTest {
    public static void main(String[] args) {
        CategoryBean categoryTest = new CategoryBean("verduras");
        new CategoryDao().add(categoryTest);
    }
}
