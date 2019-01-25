/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.rest;

import br.com.lefi.markethere.jdbc.dao.MarketDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.MarketBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.ProductBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.SharedListBean;
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
@Path("/market/")
public class MarketResource {
    private MarketDao marketSource = new MarketDao();
    private Gson jsonCompiler = new Gson();
    
    /**
     * O método getAllMarkets retorna toddos os mercados da base
     * @return todos os mercados da base
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMarkets(){
        return this.jsonCompiler.toJson(this.marketSource.getAllMarkets());
    }
    
    /**
     * O método setMarket recebe Stream proviniente do JSON e converte para
     * uma Instancia de MarketBean, então adiciona na base
     * @param in Stream JSON que representa os mercados
     * @return a instância do mercado salvo na base
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String setMarket(InputStream in){
        throw new RuntimeException();
    }
    
    /**
     * O método getProductsMarket retorna os produtos com os preços que um dado 
     * supermercado disponibiliza na base 
     * @param idMarket id do mercado 
     * @return retorna um JSON com todos os produtos e seus respctivos preços
     */
    @GET
    @Path("/{idMarket}/products/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductsMarket(@PathParam("idMarket") int idMarket){
        return this.jsonCompiler.toJson(this.marketSource.getProductsMarket(idMarket));
    }
    
    /**
     * O método getMarketByName retorna um JSON com o mercado que foi buscado pelo
     * nome
     * @param nameMarket nome do mercado a ser procurado
     * @return retorna qualquer mercado que possua a sequência de caracteres
     * dada pelo paramêtro nameMarket
     */
    @GET
    @Path("/name/{nameMarket}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMarketByName(@PathParam("nameMarket") String nameMarket){
        return this.jsonCompiler.toJson(this.marketSource.getMarketByName(nameMarket));
    }
    
    /**
     * O método addProductsMarket adiciona uma lista de produtos e associa-os ao
     * mercado passado como paramêtro
     * @param idMarket id do mercado
     * @param in Stream JSON que representa a lista de produtos
     * @return retorna uma instancia do mercado com a lista de seus produtos 
     * agora atualizada
     */
    @POST
    @Path("/{idMarket}/products/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addProductsMarket(@PathParam("idMarket") int idMarket, InputStream in){
        return "";
    }
    
    /**
     * O método compairProduct compara um produto passado como paramêtro e retorna
     * uma lista de todos os mercados e o preço do produto em cada um desses 
     * mercados
     * @param idProduct id do produto a ser comparado
     * @return retorna um JSON com os mercados e seus respectivos preços
     */
    @GET
    @Path("/compair/{idProduct}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String compairProduct(@PathParam("idProduct") int idProduct){
        return this.jsonCompiler.toJson(this.marketSource.compairProducts(idProduct));
    }
    
    /**
     * O método compairProductsAndGetSmallPrice compara um produto passado como
     * paramêtro e retorna o mercado (mais de um pode ser retornado havendo 
     * dois ou mais mercados com o mesmo valor) onde o dado produto é mais barato
     * @param idProduct id do produto a ser comparado
     * @return retorna um JSON com o mercado(s) onde o preço é mais baixo
     */
    @GET
    @Path("/compair/{idProduct}/small/")
    @Produces(MediaType.APPLICATION_JSON)
    public String compairProductsAndGetSmallPrice(@PathParam("idProduct") int idProduct){
        return this.jsonCompiler.toJson(this.marketSource.compairAndGetSmallPrice(idProduct));
    }
    
    /**
     * O método compairSharedList retorna a lista do mercados junto com o preço
     * da lista de compras em cada um desses mercados
     * @param idSharedList id da lista a ser comparada
     * @return retorna um JSON com os mercados e o preço da lista de compras em 
     * cada um desses
     */
    @GET
    @Path("/sharedList/{idSharedList}/")
    @Produces(MediaType.APPLICATION_JSON)
    public String compairSharedList(@PathParam("idSharedList") int idSharedList){
        return this.jsonCompiler.toJson(this.marketSource.getPriceSharedList(idSharedList));
    }
    
    /**
     * O método compairSharedListAndGetSmallPrice compara os preços da lista de 
     * compras e retorna o mercado onde a lista é mais barata
     * @param idSharedList id da lista de compra a ser comparada
     * @return retorna um JSON com o mercado onde a lista é mais barata
     */
    @GET
    @Path("/sharedList/{idSharedList}/small/")
    @Produces(MediaType.APPLICATION_JSON)
    public String compairSharedListAndGetSmallPrice(@PathParam("idSharedList") int idSharedList){
        return this.jsonCompiler.toJson(this.marketSource.getSmallPriceSharedList(idSharedList));
    }
}
