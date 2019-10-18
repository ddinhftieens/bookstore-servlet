/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Catalog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class CatalogImpl extends ConnectionJDBC implements ICommon<Catalog>{

    @Override
    public void add(Catalog t) {
        Connection conn = getConnection();
        try {
            String sql = "insert into catalog(Catalog,DateCreated)values(?,?)";
            PreparedStatement prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getNameCatalog());
            prestm.setString(2, t.getDatecreated());
            prestm.executeUpdate();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Catalog t) {
        Connection conn = getConnection();
        try {
            String sql = "update catalog set Catalog = ?,Datecreated = ? where ID = ?";
            PreparedStatement prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getNameCatalog());
            prestm.setString(2, t.getDatecreated());
            prestm.setInt(3, t.getID());
            prestm.execute();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int ID) {
        Connection conn = getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("delete from catalog where ID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
            conn.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Catalog getByID(int ID) {
        Connection conn = getConnection();
        Catalog catalog = new Catalog();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from catalog where ID = " + ID);
            while (resultSet.next()){
                catalog.setID(resultSet.getInt(1));
                catalog.setNameCatalog(resultSet.getString(2));
                catalog.setDatecreated(resultSet.getString(3));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catalog;
    }

    @Override
    public Catalog getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Catalog> getAll() {
        Connection conn = getConnection();
        List<Catalog> catalogList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from catalog");
            while (resultSet.next()){
                Catalog cata = new Catalog();
                cata.setID(resultSet.getInt(1));
                cata.setNameCatalog(resultSet.getString(2));
                cata.setDatecreated(resultSet.getString(3));
                catalogList.add(cata);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catalogList;
    }

    @Override
    public List<Catalog> getAllbyID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
