/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.dao;
import java.sql.*;
import br.com.lefi.markethere.jdbc.ConnectionFactory;
        

/**
 *
 * @author assert
 */
public abstract class AbastractDao {
    
    protected Connection abstractConnection;
    protected PreparedStatement sqlCompiler;
    
    public AbastractDao(){
        this.abstractConnection = new ConnectionFactory().getConnection();
    }
}
