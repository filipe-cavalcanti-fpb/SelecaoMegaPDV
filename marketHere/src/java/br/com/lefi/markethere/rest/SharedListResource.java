/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.rest;

import br.com.lefi.markethere.jdbc.dao.SharedListDao;
import br.com.lefi.markethere.jdbc.dao.UserDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.SharedListBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserBean;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author assert
 */
@Path("/sharedlist/")
public class SharedListResource {
    private Gson compilerJson = new Gson();
    private SharedListDao sharedListSource = new SharedListDao();
    
    /**
     * 
     * @param userId
     * @return 
     */
    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMySharedList(@PathParam("userId") int userId){
        List <SharedListBean> tempSharedList = this.sharedListSource.getSharedListByUser(userId);
        for (SharedListBean sharedListItem: tempSharedList){
            sharedListItem.setProductList(this.sharedListSource.getProductsList(sharedListItem.getId()));
        }
        return this.compilerJson.toJson(tempSharedList);
    }
    
    /**
     * 
     * @return 
     */
    @POST
    @Path("/add/user/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addSharedList(InputStream in, @PathParam("userId") int userId)throws IOException{
        List <SharedListBean> tempSharedList = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginArray();
        while (reader.hasNext()) {
            SharedListBean sharedListItem = this.compilerJson.fromJson(reader, SharedListBean.class);
            tempSharedList.add(sharedListItem);
        }
        reader.endArray();
        for (SharedListBean sharedListItem: tempSharedList){
            this.sharedListSource.add(sharedListItem);
        }
        reader.close();
        return this.compilerJson.toJson(this.sharedListSource.getSharedListByUser(userId));
    }
    
    /**
     * 
     * @param idList
     * @param in
     * @return 
     * @throws IOException
     */
    @POST
    @Path("add/productList/{idList}/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String setListProductInSharedList(@PathParam("idList") int idList, InputStream in) throws  IOException{
        List <ProductBean> tempProductList = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginArray();
        while (reader.hasNext()) {
            ProductBean productBeanItem = this.compilerJson.fromJson(reader, ProductBean.class);
            tempProductList.add(productBeanItem);
        }
        reader.endArray();
        for (ProductBean productBeanItem: tempProductList){
            try {
                this.sharedListSource.addProductInList(productBeanItem, this.sharedListSource.getSharedListById(idList).get(0));
            } catch (IndexOutOfBoundsException ie) {
                throw new RuntimeException(ie + "\n shared_list with the index " +  idList + " not exits");
            }
        }
        reader.close();
        return this.compilerJson.toJson(this.sharedListSource.getSharedListById(idList));
    }
    
    /**
     * 
     * @param in
     * @return
     * @throws IOException 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addSharedList(InputStream in) throws IOException{
        List <SharedListBean> tempArraySharedList = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginArray();
        while(reader.hasNext()){
            SharedListBean tempSharedListItem = this.compilerJson.fromJson(reader, SharedListBean.class);
            tempArraySharedList.add(tempSharedListItem);
        }
        reader.endArray();
        for (SharedListBean sharedListItem: tempArraySharedList){
            this.sharedListSource.add(sharedListItem);
        }
        return this.compilerJson.toJson(tempArraySharedList);
    }

    /**
     * 
     * @param idSharedList
     * @return 
     */
    @PUT
    @Path("add/productList/{idSharedList}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List <ProductBean> getProductsOfTheSharedList(@PathParam("idSharedList") int idSharedList, InputStream in)throws IOException{
        List <ProductBean> tempArrayProduct = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(in,"UTF-8"));
        SharedListBean sharedListReference = this.sharedListSource.getSharedListById(idSharedList).get(0);
        reader.beginArray();
        while(reader.hasNext()){
            ProductBean tempProductItem = this.compilerJson.fromJson(reader, ProductBean.class);
            this.sharedListSource.addProductInList(tempProductItem, sharedListReference);
            tempArrayProduct.add(tempProductItem);
        }
        reader.endArray();
        return tempArrayProduct;
    }
    
    /**
     * 
     * @param idSharedList
     * @return 
     */
    @GET
    @Path("{idSharedList}/users/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUser(@PathParam("idSharedList") int idSharedList){
        return this.compilerJson.toJson(this.sharedListSource.getAllUsers(idSharedList));
    }
    
    /**
     * 
     * @param idSharedList
     * @param idUser
     * @return 
     */
    @PUT
    @Path("{idSharedList}/share/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUserInSharedList(@PathParam("idSharedList") int idSharedList, @PathParam("idUser") int idUser){
        try {
            UserBean tempUser = new UserDao().getUserById(idUser).get(0);
            SharedListBean tempSharedList = new SharedListDao().getSharedListById(idSharedList).get(0);
            this.sharedListSource.addUser(tempSharedList, tempUser);
        } catch (IndexOutOfBoundsException ie) {
            throw new RuntimeException(ie);
        }
       return  this.compilerJson.toJson(this.sharedListSource.getSharedListById(idSharedList));
    }
}
