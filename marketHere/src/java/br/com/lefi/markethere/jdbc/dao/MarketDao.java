/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;

import br.com.lefi.markethere.jdbc.dao.javaBean.MarketBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class MarketDao extends AbastractDao{
    private String sqlInsert = "insert into markethere_sch1.Market"+
                                "(name, status, rua, bairro) values(?,?,?,?);";
    
    private String slqGetAllMarkets = "select * from markethere_sch1.Market;";
    
    private String sqlGetProductsMarket = "select product.name, product.bar_code, product.fk_id_category, market_has_product.price_product from markethere_sch1.market_has_product as market_has_product \n" +
                                "inner join markethere_sch1.market as market on market_has_product.fk_id_market = market.id and market.id = ?\n" +
                                "inner join markethere_sch1.product as product on market_has_product.fk_id_product = product.bar_code;";
    
    private String slqGetMarketByName = "select * from markethere_sch1.market as market where upper(market.name) like upper(?);";
    
    private String sqlCompairProdct = "select product.name as product_name, product.bar_code, market_has_product.price_product, market.name as market_name, market.id, market.status, market.rua, market.bairro \n" +
                                "from markethere_sch1.market_has_product as market_has_product inner join markethere_sch1.product as product \n" +
                                "on market_has_product.fk_id_product = product.bar_code and product.bar_code = ?\n" +
                                "inner join markethere_sch1.market as market on market_has_product.fk_id_market = market.id;";
    
    private String sqlCompairProductAndGetSmallPrice = "select product.name as product_name, product.bar_code, market_has_product.price_product, market.name as market_name, market.id, market.status, market.rua, market.bairro \n" +
                                "from markethere_sch1.market_has_product as market_has_product inner join markethere_sch1.product as product \n" +
                                "on market_has_product.fk_id_product = product.bar_code\n" +
                                "inner join markethere_sch1.market as market on market_has_product.fk_id_market = market.id \n" +
                                "and market_has_product.price_product = (select min(market_has_product.price_product) \n" +
                                                                        "from markethere_sch1.market_has_product inner join markethere_sch1.product \n" +
                                                                        "on market_has_product.fk_id_product = product.bar_code and product.bar_code = ?);";
    
    private String sqlGetPriceSharedList = "select sum(market_has_product.price_product), market.* from markethere_sch1.market_has_product inner join markethere_sch1.product \n" +
                                "on market_has_product.fk_id_product = product.bar_code inner join markethere_sch1.shared_list_has_product \n" +
                                "on market_has_product.fk_id_product = shared_list_has_product.fk_id_product and shared_list_has_product.fk_id_shared_list = ?\n" +
                                "inner join markethere_sch1.market on market_has_product.fk_id_market = market.id\n" +
                                "group by markethere_sch1.market.id;";
    
    private String sqlGetSmallPriceSharedList = "select sum(market_has_product.price_product) as price_list, market.* from markethere_sch1.market_has_product inner join markethere_sch1.product\n" +
                                "on market_has_product.fk_id_product = product.bar_code inner join markethere_sch1.shared_list_has_product \n" +
                                "on market_has_product.fk_id_product = shared_list_has_product.fk_id_product and shared_list_has_product.fk_id_shared_list = ?\n" +
                                "inner join markethere_sch1.market on market_has_product.fk_id_market = market.id\n" +
                                "group by markethere_sch1.market.id order by price_list limit 1;";
    
    public MarketDao(){
        super();
    }
    /**
     * O método add adiciona a instancia de um mercado na base de dados
     * @param market instancia do mercado a ser salva na base
     */
    public void add(MarketBean market){
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(sqlInsert);
            super.sqlCompiler.setString(1, market.getNome());
            super.sqlCompiler.setInt(2, market.getStatus());
            super.sqlCompiler.setString(3, market.getRua());
            super.sqlCompiler.setString(4, market.getBairro());
            super.sqlCompiler.execute();
            super.sqlCompiler.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error in insert market in database");
        }
    }
    
    /**
     * O método getAllMarkets retorna todos os mercados da base não retornando 
     * os produtos que estes vendem
     * @return retorna um JSON com todos os mercados sem os seus produtos
     */
    public List <MarketBean> getAllMarkets(){
        List <MarketBean> tempArrayMarket = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.slqGetAllMarkets);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                MarketBean tempMarketItem = new MarketBean();
                tempMarketItem.setNome(resultQuery.getString("name"));
                tempMarketItem.setBairro(resultQuery.getString("bairro"));
                tempMarketItem.setId(resultQuery.getInt("id"));
                tempMarketItem.setRua(resultQuery.getString("rua"));
                tempMarketItem.setStatus(resultQuery.getInt("status"));
                tempArrayMarket.add(tempMarketItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query all markets");
        }
        return tempArrayMarket;
    }
    
    /**
     * O método getProductsMarket retorna os produtos que são vendidos por um 
     * mercado passado como paramêtro
     * @param idMarket id do mercado a ser procurado
     * @return retorna um JSON com os produtos e os preços de cada produto que
     * o mercado passado como paramêtro oferece
     */
    public List<ProductBean> getProductsMarket(int idMarket){
        List <ProductBean> tempArrayProducts = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetProductsMarket);
            super.sqlCompiler.setInt(1, idMarket);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                ProductBean tempProductItem = new ProductBean();
                tempProductItem.setBarCode(resultQuery.getInt("bar_code"));
                tempProductItem.setName(resultQuery.getString("name"));
                tempProductItem.setPrice((float)resultQuery.getDouble("price_product"));
                tempProductItem.setFkIdCategory(resultQuery.getInt("fk_id_category"));
                tempArrayProducts.add(tempProductItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query products markets");
        }
        return tempArrayProducts;
    }
    
    /**
     * o método getMarketByName retorna os mercados que possuem o nome dado como
     * paramêtro
     * @param nameMarket nome do mercado a ser procurado
     * @return retorna um JSON com a lista dos mercados que possuem o nome dado 
     * como paramêtro
     */
    public List <MarketBean> getMarketByName(String nameMarket){
        List <MarketBean> tempArrayMarkets = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.slqGetMarketByName);
            super.sqlCompiler.setString(1, "%" + nameMarket + "%");
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                MarketBean tempMarketItem = new MarketBean();
                tempMarketItem.setNome(resultQuery.getString("name"));
                tempMarketItem.setBairro(resultQuery.getString("bairro"));
                tempMarketItem.setId(resultQuery.getInt("id"));
                tempMarketItem.setRua(resultQuery.getString("rua"));
                tempMarketItem.setStatus(resultQuery.getInt("status"));
                tempArrayMarkets.add(tempMarketItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in qury market by name");
        }
        return tempArrayMarkets;
    }
    
    /**
     * O método compairProducts compara os preços de um produto dado como paramêtro
     * e retorna o preço do produto em todos os mercados que o possuem
     * @param productReference instancia do produto a ser procurado
     * @return retorna um JSON com os mercados e preço do produto no respectivo 
     * mercado
     */
    public List <MarketBean> compairProducts(int idProduct){
        List <MarketBean> tempArrayMarkets = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlCompairProdct);
            super.sqlCompiler.setInt(1, idProduct);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                MarketBean tempMarketItem = new MarketBean();
                tempMarketItem.setId(resultQuery.getInt("id"));
                tempMarketItem.setNome(resultQuery.getString("market_name"));
                tempMarketItem.setBairro((resultQuery.getString("bairro")));
                tempMarketItem.setRua(resultQuery.getString("rua"));
                tempMarketItem.setStatus(resultQuery.getInt("status"));
                ProductBean tempProductItem = new ProductBean();
                tempProductItem.setBarCode(resultQuery.getInt("bar_code"));
                tempProductItem.setName(resultQuery.getString("product_name"));
                tempProductItem.setPrice((float)resultQuery.getDouble("price_product"));
                tempMarketItem.addProduct(tempProductItem);
                tempArrayMarkets.add(tempMarketItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in compair products");
        }
        return tempArrayMarkets;
    }
    
    /**
     * 
     * @param idProduct
     * @return 
     */
    public List <MarketBean> compairAndGetSmallPrice(int idProduct){
        List <MarketBean> tempArrayMarkets = new ArrayList<>();
        try {
            super.sqlCompiler = abstractConnection.prepareStatement(this.sqlCompairProductAndGetSmallPrice);
            super.sqlCompiler.setInt(1, idProduct);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                MarketBean tempMarketItem = new MarketBean();
                tempMarketItem.setBairro(resultQuery.getString("bairro"));
                tempMarketItem.setId(resultQuery.getInt("id"));
                tempMarketItem.setNome(resultQuery.getString("market_name"));
                tempMarketItem.setRua(resultQuery.getString("rua"));
                ProductBean tempProduct = new ProductBean();
                tempProduct.setBarCode(resultQuery.getInt("bar_code"));
                tempProduct.setName(resultQuery.getString("product_name"));
                tempProduct.setPrice((float)resultQuery.getDouble("price_product"));
                tempMarketItem.addProduct(tempProduct);
                tempArrayMarkets.add(tempMarketItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in compair products");
        }
        return tempArrayMarkets;
    }
    
    /**
     * 
     * @param idSharedList
     * @return 
     */
    public List <MarketBean> getPriceSharedList(int idSharedList){
        List <MarketBean> tempArrayMarkets = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetPriceSharedList);
            super.sqlCompiler.setInt(1, idSharedList);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                MarketBean tempMarketItem = new MarketBean();
                tempMarketItem.setId(resultQuery.getInt("id"));
                tempMarketItem.setNome(resultQuery.getString("name"));
                tempMarketItem.setBairro(resultQuery.getString("bairro"));
                tempMarketItem.setRua(resultQuery.getString("rua"));
                tempMarketItem.setStatus(resultQuery.getInt("status"));
                tempMarketItem.setPriceSharedListReference((float)resultQuery.getDouble("sum"));
                tempArrayMarkets.add(tempMarketItem);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in get price of list index "+ idSharedList);
        }
        return tempArrayMarkets;
    }
    
    /**
     * 
     * @param idSharedList
     * @return 
     */
    public List <MarketBean> getSmallPriceSharedList(int idSharedList){
        List <MarketBean> tempArrayMarkets = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetSmallPriceSharedList);
            super.sqlCompiler.setInt(1, idSharedList);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                MarketBean tempMarketItem = new MarketBean();
                tempMarketItem.setId(resultQuery.getInt("id"));
                tempMarketItem.setNome(resultQuery.getString("name"));
                tempMarketItem.setRua(resultQuery.getString("rua"));
                tempMarketItem.setBairro(resultQuery.getString("bairro"));
                tempMarketItem.setPriceSharedListReference((float)resultQuery.getDouble("price_list"));
                tempMarketItem.setStatus(resultQuery.getInt("status"));
                tempArrayMarkets.add(tempMarketItem);
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nEror in query small price of shared list");
        }
        return tempArrayMarkets;
    }
}
