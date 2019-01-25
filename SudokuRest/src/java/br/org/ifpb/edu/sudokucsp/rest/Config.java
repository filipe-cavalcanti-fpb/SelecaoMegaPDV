/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.rest;

import br.org.ifpb.edu.sudokucsp.CSP.facade.SudokuFacade;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author assert
 */
@Path("/config/")
public class Config {
    SudokuFacade facadeReference = SudokuFacade.getInstance();
    
    @GET
    @Path("{restart}")
    @Produces(MediaType.APPLICATION_JSON)
    public String restart(@PathParam("restart")boolean restart){
        if(restart){
            this.facadeReference.restart();
        }
        return this.facadeReference.getMatrix();
    }
}
