/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.tests;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import br.com.lefi.markethere.jdbc.dao.ProductDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class ProductDaoTest {
    public static void main(String[] args) {
        ProductBean testProd = new ProductBean(1235458, "leite cond", 2);
        ProductDao product = new ProductDao();
        for(ProductBean itemProduct:product.getProductByBarCode(111111)){
            System.out.println(itemProduct);
        }
    }
}
