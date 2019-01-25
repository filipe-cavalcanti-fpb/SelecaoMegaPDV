/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.tests;

import br.com.lefi.markethere.jdbc.dao.javaBean.MarketBean;
import br.com.lefi.markethere.jdbc.dao.MarketDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
/**
 *
 * @author assert
 */
public class MarketDaoTest {
    public static void main(String[] args) {
        MarketBean marketTest = new MarketBean("LeFi Market", 5, "rua 2", "dim 2");
        for(MarketBean marketItem: new MarketDao().getSmallPriceSharedList(1)){
            System.err.println(marketItem);
        }
    }
}
