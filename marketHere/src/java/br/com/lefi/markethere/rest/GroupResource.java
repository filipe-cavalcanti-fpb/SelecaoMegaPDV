/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.rest;

import br.com.lefi.markethere.jdbc.dao.GroupDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.GroupBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.GroupHasUserBean;
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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author assert
 */
@Path("/group/")
public class GroupResource {
    private Gson jsonCompiler = new Gson();
    private GroupDao groupSource = new GroupDao();
    
    /**
     * 
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllGroup(){
        List <GroupBean> tempArrayGroup = this.groupSource.getAllGroups();
        for (GroupBean groupItem: tempArrayGroup){
            groupItem.setUsersInGroup(this.groupSource.getUsersInGroup(groupItem.getId()));
        }
        return this.jsonCompiler.toJson(tempArrayGroup);
    }
    
    /**
     * 
     * @param idGroup
     * @return 
     */
    @GET
    @Path("{idGroup}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById(@PathParam("idGroup") int idGroup){
        return this.jsonCompiler.toJson(this.groupSource.getGroupById(idGroup));
    }
    
    /**
     * 
     * @param idGroup
     * @return 
     */
    @GET
    @Path("{idGroup}/users/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsersInGroup(@PathParam("idGroup") int idGroup){
        return this.jsonCompiler.toJson(this.groupSource.getUsersInGroup(idGroup));
    }
    
    /**
     * 
     * @param nameGroup
     * @return 
     */
    @GET
    @Path("name/{nameGroup}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGroupByName(@PathParam("nameGroup") String nameGroup){
        return this.jsonCompiler.toJson(this.groupSource.getGroupByName(nameGroup));
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
    public String addGroup(InputStream in) throws IOException{
        List <GroupBean> tempArrayGroup = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginArray();
        while(reader.hasNext()){
            GroupBean tempGroupItem = this.jsonCompiler.fromJson(reader, GroupBean.class);
            tempArrayGroup.add(tempGroupItem);
        }
        reader.endArray();
        for (GroupBean groupItem: tempArrayGroup){
            this.groupSource.add(groupItem);
        }
        return this.jsonCompiler.toJson(tempArrayGroup);
    }
    
    /**
     * 
     * @param idGroup
     * @param in
     * @return
     * @throws IOException 
     */
    @POST
    @Path("/{idGroup}/addUser/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUserInGroup(@PathParam("idGroup") int idGroup, InputStream in) throws IOException{
        List <UserBean> tempArrayUser = new ArrayList<>();
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginArray();
        while(reader.hasNext()){
            UserBean tempGroupItem = this.jsonCompiler.fromJson(reader, UserBean.class);
            tempArrayUser.add(tempGroupItem);
        }
        reader.endArray();
        GroupHasUserBean groupReference = new GroupHasUserBean(this.groupSource.getGroupById(idGroup).get(0), tempArrayUser);
        
        return this.jsonCompiler.toJson(tempArrayUser);
    }
}
