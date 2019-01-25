/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.rest;

import br.com.lefi.markethere.jdbc.dao.ProductDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author assert
 */
@Path("/product/")
public class ProductResource {
    private ProductDao productSource = new ProductDao();
    private Gson compilerJson = new Gson();
    
    /**
     * 
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProducts(){
        return this.compilerJson.toJson(this.productSource.getAllProducts());
    }
    
    /**
     * 
     * @param idCategory
     * @return 
     */
    @GET
    @Path("/category/{idCategory}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductByCategory(@PathParam("idCategory") int idCategory){
        return this.compilerJson.toJson(this.productSource.getProductByCategory(idCategory));
    }
    
    /**
     * 
     * @param nameProduct
     * @return 
     */
    @GET
    @Path("/name/{nameProduct}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductByName(@PathParam("nameProduct") String nameProduct){
        return this.compilerJson.toJson(this.productSource.getProductByName(nameProduct));
    }
    
    /**
     * 
     * @param barCode
     * @return 
     */
    @GET
    @Path("barcode/{barCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductByBarCode(@PathParam("barCode") int barCode){
        return this.compilerJson.toJson(this.productSource.getProductByBarCode(barCode));
    }
    
}
