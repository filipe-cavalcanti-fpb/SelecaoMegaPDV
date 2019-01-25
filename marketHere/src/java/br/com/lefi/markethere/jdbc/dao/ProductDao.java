/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class ProductDao extends AbastractDao{
    
    private String sqlInsertProduct = "insert into markethere_sch1.Product"+
                "(bar_code, name, fk_id_category) values(?,?,?);";
    
    private String sqlGetProductByCategory = "select product.name, product.bar_code\n" +
                "from markethere_sch1.product as product\n" +
                "INNER JOIN markethere_sch1.category on product.fk_id_category = category.id and category.id = ?;";
    
    private String sqlGetProductByName = "select product.name, product.bar_code\n" +
                "from markethere_sch1.product as product\n" +
                "where upper(product.name) like upper(?);";
    
    private String sqlGetProductByBarCode = "select product.name, product.fk_id_category\n" +
                "from markethere_sch1.product as product\n" +
                "where product.bar_code = ?;";
    
    private String sqlGetAllProducts = "select * from markethere_sch1.product;";
            
    public ProductDao(){
        super();
    }
    
    /**
     * 
     * @param product 
     */
    public void add(ProductBean product){
        try {
        super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlInsertProduct);
        super.sqlCompiler.setInt(1, product.getBarCode());
        super.sqlCompiler.setString(2, product.getName());
        super.sqlCompiler.setInt(3, product.getFkIdCategory());
        super.sqlCompiler.execute();
        super.sqlCompiler.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    
    /**
     * 
     * @param fkIdCategory
     * @return 
     */
    public List<ProductBean> getProductByCategory(int fkIdCategory){
        List<ProductBean> resultQueryList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetProductByCategory);
            super.sqlCompiler.setInt(1, fkIdCategory);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                ProductBean tempProduct = new ProductBean();
                tempProduct.setName(resultQuery.getString("name"));
                tempProduct.setBarCode(resultQuery.getInt("bar_code"));
                tempProduct.setFkIdCategory(fkIdCategory);
                resultQueryList.add(tempProduct);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "Error in query product by category");
        }
        finally{
            try {
                super.sqlCompiler.close();
            } catch (SQLException sqlE) {
            }
        }
        return resultQueryList;
    }
    
    /**
     * 
     * @param nameProduct
     * @return 
     */
    public List<ProductBean> getProductByName(String nameProduct){
        List<ProductBean> resultQueryList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetProductByName);
            super.sqlCompiler.setString(1, "%" + nameProduct + "%");
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                ProductBean tempProduct = new ProductBean();
                tempProduct.setName(resultQuery.getString("name"));
                tempProduct.setBarCode(resultQuery.getInt("bar_code"));
                resultQueryList.add(tempProduct);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "Error in query product by name");
        }
        finally{
            try {
                super.sqlCompiler.close();
            } catch (SQLException sqlE) {
            }
        }
        return resultQueryList;
    }
    
    /**
     * 
     * @param barCode
     * @return 
     */
    public List<ProductBean> getProductByBarCode(int barCode){
        List<ProductBean> resultQueryList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetProductByBarCode);
            super.sqlCompiler.setInt(1, barCode);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                ProductBean tempProduct = new ProductBean();
                tempProduct.setName(resultQuery.getString("name"));
                tempProduct.setBarCode(barCode);
                tempProduct.setFkIdCategory(resultQuery.getInt("fk_id_category"));
                resultQueryList.add(tempProduct);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in get product by barcode");
        }
        return resultQueryList;
    }
    
    /**
     * 
     * @return 
     */
    public List<ProductBean> getAllProducts(){
        List<ProductBean> resultQueryList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetAllProducts);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                ProductBean tempProduct = new ProductBean();
                tempProduct.setName(resultQuery.getString("name"));
                tempProduct.setBarCode(resultQuery.getInt("bar_code"));
                tempProduct.setFkIdCategory(resultQuery.getInt("fk_id_category"));
                resultQueryList.add(tempProduct);
            }
            super.sqlCompiler.close();
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "error in query all products");
        }
        return resultQueryList;
    }
}
