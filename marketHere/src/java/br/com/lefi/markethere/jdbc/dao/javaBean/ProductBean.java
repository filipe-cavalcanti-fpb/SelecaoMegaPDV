/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

import com.google.gson.Gson;

/**
 *
 * @author assert
 */
public class ProductBean extends AbstractBeanObject{
    private int barCode;
    private String name;
    private int fkIdCategory;
    private float price;

    public ProductBean(int barCode, String name, int fkIdCategory) {
        this.barCode = barCode;
        this.name = name;
        this.fkIdCategory = fkIdCategory;
    }
    public ProductBean(){
        
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFkIdCategory() {
        return fkIdCategory;
    }

    public void setFkIdCategory(int fkIdCategory) {
        this.fkIdCategory = fkIdCategory;
    }

    @Override
    public String toString() {
        return "ProductBean{" + "barCode=" + barCode + ", name=" + name + ", fkIdCategory=" + fkIdCategory + '}';
    }
    
    public String getJson(){
        Gson compilerJson = new Gson();
        return compilerJson.toJson(this);
    }
}