/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;

import java.sql.SQLException;
import br.com.lefi.markethere.jdbc.dao.javaBean.MarketHasProductBean;
import java.sql.Date;

/**
 *
 * @author assert
 */
public class MarketHasProductDao extends AbastractDao{
    private String sqlInsert = "insert into markethere_sch1.market_has_product\n" +
            "(fk_id_market, fk_id_product, price_product, update_date)\n" +
            "values (?,?,?,?);";
    
    public MarketHasProductDao(){
        super();
    }
    
    public void add(MarketHasProductBean marketHasProduct){
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(sqlInsert);
            super.sqlCompiler.setInt(1, marketHasProduct.getFkIdMarket());
            super.sqlCompiler.setInt(2, marketHasProduct.getFkIdProduct());
            super.sqlCompiler.setDouble(3, (double) marketHasProduct.getPriceProduct());
            super.sqlCompiler.setDate(4, new Date(marketHasProduct.getUpdateDate().getTimeInMillis()));
            super.sqlCompiler.execute();
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in insert MarketHasProduct relation on database");
        }
    }
}
