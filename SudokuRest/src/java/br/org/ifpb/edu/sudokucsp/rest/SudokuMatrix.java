/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.rest;

import br.org.ifpb.edu.sudokucsp.CSP.CSPSingleton;
import br.org.ifpb.edu.sudokucsp.CSP.facade.SudokuFacade;
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
@Path("/matrix/")
public class SudokuMatrix {
    private SudokuFacade facadeReference = SudokuFacade.getInstance();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        this.facadeReference = SudokuFacade.getInstance();
        return this.facadeReference.getMatrix();
    }
    
    @GET
    @Path("{node}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public String play(@PathParam("node")int node, @PathParam("value")int value){
        this.facadeReference.play(node, value);
        return "{\"status\":200}";
    }
}
