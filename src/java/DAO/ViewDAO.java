/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class ViewDAO extends ConnectionJDBC {

    public static void addView(int IDproduct) {
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into viewDB(idproduct) values(?)");
            ps.setInt(1, IDproduct);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(int ID) {
        Connection conn = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from viewDB where idproduct = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
            conn.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static int readView(int IDproduct) {
        int k = 0;
        Connection conn = getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select count(*) from viewDB where idproduct = " + IDproduct);
            while(rs.next()){
                k = rs.getInt(1);
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
}
