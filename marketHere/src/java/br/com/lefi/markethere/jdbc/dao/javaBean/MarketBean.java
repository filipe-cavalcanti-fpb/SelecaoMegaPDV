/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao.javaBean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class MarketBean extends AbstractBeanObject{
    private int id;
    private String nome;
    private int status;
    private String rua;
    private String bairro;
    private List <ProductBean> productsMarkets;
    private float priceSharedListReference;

    public MarketBean(String nome, int status, String rua, String bairro) {
        this.nome = nome;
        this.status = status;
        this.rua = rua;
        this.bairro = bairro;
        this.productsMarkets = new ArrayList<>();
    }
    
    public MarketBean(){
        this.productsMarkets = new ArrayList<>();
    }

    public float getPriceSharedListReference() {
        return priceSharedListReference;
    }

    public void setPriceSharedListReference(float priceSharedListReference) {
        this.priceSharedListReference = priceSharedListReference;
    }

    public List<ProductBean> getProductsMarkets() {
        return productsMarkets;
    }

    public void setProductsMarkets(List<ProductBean> productsMarkets) {
        this.productsMarkets = productsMarkets;
    }
    
    public void addProduct(ProductBean ProductItem){
        this.productsMarkets.add(ProductItem);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "MarketBean{" + "id=" + id + ", nome=" + nome + ", status=" + status + ", rua=" + rua + ", bairro=" + bairro + '}';
    }
}