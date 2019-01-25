/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

import java.util.Calendar;

/**
 *
 * @author assert
 */
public class MarketHasProductBean extends AbstractBeanObject{
    private int fkIdProduct;
    private int fkIdMarket;
    private double priceProduct;
    private Calendar updateDate;

    public MarketHasProductBean(int fkIdProduct, int fkIdMarket, double priceProduct, Calendar updateDate) {
        this.fkIdProduct = fkIdProduct;
        this.fkIdMarket = fkIdMarket;
        this.priceProduct = priceProduct;
        this.updateDate = updateDate;
    }
    public MarketHasProductBean(){
        
    }

    public int getFkIdProduct() {
        return fkIdProduct;
    }

    public void setFkIdProduct(int fkIdProduct) {
        this.fkIdProduct = fkIdProduct;
    }

    public int getFkIdMarket() {
        return fkIdMarket;
    }

    public void setFkIdMarket(int fkIdMarket) {
        this.fkIdMarket = fkIdMarket;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Calendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }
}
