/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.lefi.markethere.jdbc.dao.UserDao;
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
import javax.ws.rs.POST;

/**
 *
 * @author assert
 */

@Path("/user/")
public class UserResource {
    private Gson jsonCompiler = new Gson();
    private UserDao userSource = new UserDao();
    
    /**
     * O método getAllUsers retorna todos os usuario da base
     * @return retorna um JSON com todos os usuarios salvos no banco
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsers(){
        return this.jsonCompiler.toJson(this.userSource.getAllUsers());
    }
    
    /**
     * O método getUserById retorna a instancia de um usuario cujo o ID é passado
     * como paramêtro
     * @param id ID do usuario a ser pesquisado
     * @return retorna um JSON com a representação do usuario, caso não encontrado
     * retorna uma lista vazia
     */
    @GET
    @Path("/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById(@PathParam("id") int id){
        return this.jsonCompiler.toJson(this.userSource.getUserById(id));
    }
    
    @GET
    @Path("name/{nameUser}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserByFirstName(@PathParam("nameUser") String nameUser){
        return this.jsonCompiler.toJson(this.userSource.getUserByFirstName(nameUser));
    }
    
    
    /**
     * O método createUser recebe um Stream representando as instancias dos usuarios
     * a serem salvos na base
     * @param in Stream JSON dos usuarios a serem criados
     * @return retorna um JSON com os usuarios criados
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(InputStream in)throws IOException{
        List <UserBean> tempArrayUser = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginArray();
        while(reader.hasNext()){
            UserBean tempUserItem = this.jsonCompiler.fromJson(reader, UserBean.class);
            System.err.println(tempUserItem);
            tempArrayUser.add(tempUserItem);
        }
        reader.endArray();
        for (UserBean tempUserItem: tempArrayUser){
            this.userSource.add(tempUserItem);
        }
        return this.jsonCompiler.toJson(tempArrayUser);
    }
}
