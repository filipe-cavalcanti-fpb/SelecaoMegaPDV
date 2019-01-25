/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc;
import java.sql.*;
import org.postgresql.Driver;

/**
 *
 * @author assert
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/marketHereDataBase", "postgres", "root123");
        } catch (SQLException sqlE) {
            throw new RuntimeException("Error in driver jdbc for Postgres");
        }
    }
}
