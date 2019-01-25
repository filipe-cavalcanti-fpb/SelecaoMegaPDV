/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.SharedListBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.SharedListHasProductBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserHasSharedListBean;
import br.com.lefi.markethere.utils.Email;
import br.com.lefi.markethere.utils.EmailFormatInvalidException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author assert
 */
public class SharedListDao extends AbastractDao{
    private String sqlInsert = "insert into markethere_sch1.Shared_list"+
                                "(descricao, nome, data_criacao, fk_id_grupo)"+
                                "values(?,?,?,?);";
    
    private String sqlGetSharedListByUser = "select * from markethere_sch1.shared_list\n" +
                                "where fk_id_usuario = ?;";
    
    private String slqGetProductsOfTheList = "select product.bar_code, product.name, product.fk_id_category \n" +
                                "from markethere_sch1.shared_list_has_product as shared_list_has_product inner join \n" +
                                "markethere_sch1.shared_list as shared_list on shared_list_has_product.fk_id_shared_list = shared_list.id and shared_list.id = ?\n" +
                                "inner join markethere_sch1.product as product on shared_list_has_product.fk_id_product = product.bar_code;";
    
    private String slqGetSharedListByName = "SELECT * FROM markethere_sch1.shared_list AS shared_list WHERE upper(shared_list.nome) like upper(?);";
    
    private String sqlGetSharedListById = "select * from markethere_sch1.shared_list as shared_list where shared_list.id = ?;";
    
    private String sqlGetAllUsers = "select usuario.* from markethere_sch1.user_has_shared_list inner join markethere_sch1.usuario on user_has_shared_list.fk_id_user = usuario.id\n" +
                                "inner join markethere_sch1.shared_list  on user_has_shared_list.fk_id_shared_list = shared_list.id and shared_list.id = ?;";
        
    private SharedListHasProductDao sharedListProductRelationship = new SharedListHasProductDao();
    private UserHasSharedListDao sharedListUserRelationship = new UserHasSharedListDao();
    
    public SharedListDao(){
        super();        
    }
    
    /**
     * 
     * @param sharedList 
     */
    public void add(SharedListBean sharedList){
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(sqlInsert);
            super.sqlCompiler.setString(1, sharedList.getDescription());
            super.sqlCompiler.setString(2, sharedList.getName());
            super.sqlCompiler.setDate(3, new Date(sharedList.getCreationDate().getTimeInMillis()));
            super.sqlCompiler.setInt(4, sharedList.getFkIdGroup());
            super.sqlCompiler.execute();
            super.sqlCompiler.close();
        } catch (SQLException SqlE) {
            throw new RuntimeException();
        }
    }
    
    public List<SharedListBean> getSharedListById(int id){
        List <SharedListBean> tempArraySharedBeanList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetSharedListById);
            super.sqlCompiler.setInt(1, id);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                SharedListBean tempSharedList = new SharedListBean();
                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.setTime(resultQuery.getDate("data_criacao"));
                tempSharedList.setCreationDate(tempCalendar);
                tempSharedList.setDescription(resultQuery.getString("descricao"));
                tempSharedList.setUserList(this.getAllUsers(id));
                tempSharedList.setName(resultQuery.getString("nome"));
                tempSharedList.setFkIdGroup(resultQuery.getInt("fk_id_grupo"));
                tempSharedList.setId(id);
                tempArraySharedBeanList.add(tempSharedList);
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query shared_list by id");
        }
        return tempArraySharedBeanList;
    }
    
    /**
     * 
     * @param fkIdUser
     * @return 
     */
    public List<SharedListBean> getSharedListByUser(int fkIdUser){
        List <SharedListBean> resultQueryList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetSharedListByUser);
            super.sqlCompiler.setInt(1, fkIdUser);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                SharedListBean tempSharedList = new SharedListBean();
                tempSharedList.setId(resultQuery.getInt("id"));
                tempSharedList.setName(resultQuery.getString("nome"));
                tempSharedList.setDescription(resultQuery.getString("descricao"));
                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.setTime(resultQuery.getDate("data_criacao"));
                tempSharedList.setCreationDate(tempCalendar);
                tempSharedList.setUserList(this.getAllUsers(resultQuery.getInt("id")));
                tempSharedList.setFkIdGroup(resultQuery.getInt("fk_id_grupo"));
                resultQueryList.add(tempSharedList);
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query all shared list by user");
        }
        return resultQueryList;
    }
    
    /**
     * 
     * @param fkIdSharedList
     * @return 
     */
    public List <ProductBean> getProductsList(int fkIdSharedList){
        List <ProductBean> resultQueryList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.slqGetProductsOfTheList);
            super.sqlCompiler.setInt(1, fkIdSharedList);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while(resultQuery.next()){
                ProductBean tempProduct = new ProductBean();
                tempProduct.setBarCode(resultQuery.getInt("bar_code"));
                tempProduct.setName(resultQuery.getString("name"));
                tempProduct.setFkIdCategory(resultQuery.getInt("fk_id_category"));
                resultQueryList.add(tempProduct);
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query products list");
        }
        return resultQueryList;
    }
    
    /**
     * 
     * @param sharedListName
     * @return 
     */
    public List <SharedListBean> getSharedListByName(String sharedListName){
        List <SharedListBean> resultQueryList = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.slqGetSharedListByName);
            super.sqlCompiler.setString(1, "%"+sharedListName+"%");
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while (resultQuery.next()){
                SharedListBean tempSharedList = new SharedListBean();
                tempSharedList.setDescription(resultQuery.getString("descricao"));
                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.setTime(resultQuery.getDate("data_criacao"));
                tempSharedList.setCreationDate(tempCalendar);
                tempSharedList.setUserList(this.getAllUsers(resultQuery.getInt("id")));
                tempSharedList.setId(resultQuery.getInt("id"));
                tempSharedList.setName(resultQuery.getString("nome"));
                tempSharedList.setProductList(this.getProductsList(tempSharedList.getId()));
                resultQueryList.add(tempSharedList);
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query shared_list by name");
        }
        return resultQueryList;
    }
    
    /**
     * 
     * @param productList
     * @param sharedListReference 
     */
    public void setProductList(List <ProductBean> productList, SharedListBean sharedListReference){
        for (ProductBean productBeanItem: productList){
            SharedListHasProductBean tempSharedListHasProductBean = new SharedListHasProductBean();
            tempSharedListHasProductBean.setFkIdProduct(productBeanItem.getBarCode());
            tempSharedListHasProductBean.setFkIdSharedList(sharedListReference.getId());
            this.sharedListProductRelationship.add(tempSharedListHasProductBean);
        }
    }
    
    /**
     * 
     * @param productReference
     * @param sharedListReference 
     */
    public void addProductInList(ProductBean productReference, SharedListBean sharedListReference){
        SharedListHasProductBean tempSharedListHasProductBean = new SharedListHasProductBean();
        tempSharedListHasProductBean.setFkIdProduct(productReference.getBarCode());
        tempSharedListHasProductBean.setFkIdSharedList(sharedListReference.getId());
        this.sharedListProductRelationship.add(tempSharedListHasProductBean);
    }
    
    /**
     * 
     * @param idSharedList
     * @return 
     */
    public List <UserBean> getAllUsers(int idSharedList) {
        List <UserBean> tempArrayUsers = new ArrayList<>();
        try {
            super.sqlCompiler = super.abstractConnection.prepareStatement(this.sqlGetAllUsers);
            super.sqlCompiler.setInt(1, idSharedList);
            ResultSet resultQuery = super.sqlCompiler.executeQuery();
            while (resultQuery.next()){
                UserBean tempUserItem = new UserBean();
                tempUserItem.setId(resultQuery.getInt("id"));
                tempUserItem.setFirstName(resultQuery.getString("first_name"));
                tempUserItem.setLastName(resultQuery.getString("last_name"));
                try {
                    tempUserItem.setEmail(new Email(resultQuery.getString("email")));
                } catch (EmailFormatInvalidException emailE) {
                    throw new RuntimeException(emailE);
                }
                tempArrayUsers.add(tempUserItem);
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE + "\nError in query all users in shared_list index " + idSharedList);
        }
        return tempArrayUsers;
    }
    
    public void addUser(SharedListBean sharedListReference, UserBean userReference){
        this.sharedListUserRelationship.add(new UserHasSharedListBean(userReference, sharedListReference));
    }
}
