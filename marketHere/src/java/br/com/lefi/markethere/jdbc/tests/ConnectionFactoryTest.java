/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lefi.markethere.jdbc.tests;
import java.sql.*;
import br.com.lefi.markethere.jdbc.ConnectionFactory;

/**
 *
 * @author assert
 */
public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Connection connction = new ConnectionFactory().getConnection();
        String sql = "insert into markethere_sch1.Category(nome)" +
                    "values(?)";
        try {
            PreparedStatement stmt = connction.prepareStatement(sql);
            stmt.setString(1, "testCategory");
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("error");
        }
    }
    
}
