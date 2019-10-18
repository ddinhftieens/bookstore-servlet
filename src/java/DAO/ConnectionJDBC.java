/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class ConnectionJDBC {
    static Connection connection = null;
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-7946KH9:1433;databaseName=LTWeb","sa","Tjeens");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
