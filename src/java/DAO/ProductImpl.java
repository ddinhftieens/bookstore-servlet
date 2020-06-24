/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Product;
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
public class ProductImpl extends ConnectionJDBC implements ICommon<Product>{
    private CatalogImpl catalogImpl = new CatalogImpl();
    @Override
    public void add(Product t) {
        Connection conn = getConnection();
        try {
            String sql = "insert into product(nameBook,author,IDcode,datecreated,description,dateofissue,NXB,numberpage,quantity,price,sale,IDcatalog,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getNameBook());
            prestm.setString(2,t.getAuthor());
            prestm.setString(3, t.getIDcode());
            prestm.setString(4, t.getDatecreated());
            prestm.setString(5, t.getDescription());
            prestm.setString(6, t.getDateofissue());
            prestm.setString(7, t.getNXB());
            prestm.setInt(8, t.getNumberpage());
            prestm.setInt(9, t.getQuantity());
            prestm.setDouble(10, t.getPrice());
            prestm.setDouble(11, t.getSale());
            prestm.setInt(12, t.getIDcatalog());
            prestm.setString(13, t.getStatus());
            prestm.executeUpdate();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void edit(Product t) {
        Connection conn = getConnection();
        try {
            String sql = "update product set nameBook = ?,author = ?,datecreated = ?,description = ?,dateofissue = ?,NXB = ?,numberpage = ?,quantity = ?,price = ?,sale = ?, status = ? where ID = ?";
            PreparedStatement prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getNameBook());
            prestm.setString(2, t.getAuthor());
            prestm.setString(3, t.getDatecreated());
            prestm.setString(6, t.getNXB());
            prestm.setString(4, t.getDescription());
            prestm.setString(5, t.getDateofissue());
            prestm.setInt(7, t.getNumberpage());
            prestm.setInt(8, t.getQuantity());
            prestm.setDouble(9, t.getPrice());
            prestm.setDouble(10, t.getSale());
            prestm.setString(11, t.getStatus());
            prestm.setInt(12, t.getID());
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
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where ID = ?");
            preparedStatement.setInt(1,ID);
            preparedStatement.execute();
            conn.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Product getByID(int ID) {
        Connection conn = getConnection();
        Product pro = new Product();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where ID = " + ID);
            while (resultSet.next()){
                pro.setID(resultSet.getInt(1));
                pro.setNameBook(resultSet.getString(2));
                pro.setAuthor(resultSet.getString(3));
                pro.setIDcode(resultSet.getString(4));
                pro.setDatecreated(resultSet.getString(5));
                pro.setDescription(resultSet.getString(6));
                pro.setDateofissue(resultSet.getString(7));
                pro.setNXB(resultSet.getString(8));
                pro.setNumberpage(resultSet.getInt(9));
                pro.setQuantity(resultSet.getInt(10));
                pro.setPrice(resultSet.getFloat(11));
                pro.setSale(resultSet.getFloat(12));
                pro.setIDcatalog(resultSet.getInt(13));
                pro.setStatus(resultSet.getString(14));
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
        return pro;
    }

    @Override
    public Product getByName(String name) {
        Product pro = new Product();
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where nameBook = '" + name+"'");
            while (resultSet.next()){
                pro.setID(resultSet.getInt(1));
                pro.setNameBook(resultSet.getString(2));
                pro.setAuthor(resultSet.getString(3));
                pro.setIDcode(resultSet.getString(4));
                pro.setDatecreated(resultSet.getString(5));
                pro.setDescription(resultSet.getString(6));
                pro.setDateofissue(resultSet.getString(7));
                pro.setNXB(resultSet.getString(8));
                pro.setNumberpage(resultSet.getInt(9));
                pro.setQuantity(resultSet.getInt(10));
                pro.setPrice(resultSet.getFloat(11));
                pro.setSale(resultSet.getFloat(12));
                pro.setIDcatalog(resultSet.getInt(13));
                pro.setStatus(resultSet.getString(14));
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
        return pro;
    }

    @Override
    public List<Product> getAll() {
        Connection conn = getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product");
            while (resultSet.next()){
                Product pro = new Product();
                pro.setID(resultSet.getInt(1));
                pro.setNameBook(resultSet.getString(2));
                pro.setAuthor(resultSet.getString(3));
                pro.setIDcode(resultSet.getString(4));
                pro.setDatecreated(resultSet.getString(5));
                pro.setDescription(resultSet.getString(6));
                pro.setDateofissue(resultSet.getString(7));
                pro.setNXB(resultSet.getString(8));
                pro.setNumberpage(resultSet.getInt(9));
                pro.setQuantity(resultSet.getInt(10));
                
                pro.setPrice(resultSet.getFloat(11));
                pro.setSale(resultSet.getFloat(12));
                pro.setIDcatalog(resultSet.getInt(13));
                pro.setStatus(resultSet.getString(14));
                productList.add(pro);
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
        return productList;
    }

    @Override
    public List<Product> getAllbyID(int ID) {
        Connection conn = getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where IDcatalog = "+ID);
            while (resultSet.next()){
                Product pro = new Product();
                pro.setID(resultSet.getInt(1));
                pro.setNameBook(resultSet.getString(2));
                pro.setAuthor(resultSet.getString(3));
                pro.setIDcode(resultSet.getString(4));
                pro.setDatecreated(resultSet.getString(5));
                pro.setDescription(resultSet.getString(6));
                pro.setDateofissue(resultSet.getString(7));
                pro.setNXB(resultSet.getString(8));
                pro.setNumberpage(resultSet.getInt(9));
                pro.setQuantity(resultSet.getInt(10));
                pro.setPrice(resultSet.getFloat(11));
                pro.setSale(resultSet.getFloat(12));
                pro.setIDcatalog(resultSet.getInt(13));
                pro.setStatus(resultSet.getString(14));
                productList.add(pro);
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
        return productList;
    }
    public List<Product> getAllbyName(String name) {
        Connection conn = getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where nameBook LIKE '%" + name+"%'");
            while (resultSet.next()){
                Product pro = new Product();
                pro.setID(resultSet.getInt(1));
                pro.setNameBook(resultSet.getString(2));
                pro.setAuthor(resultSet.getString(3));
                pro.setIDcode(resultSet.getString(4));
                pro.setDatecreated(resultSet.getString(5));
                pro.setDescription(resultSet.getString(6));
                pro.setDateofissue(resultSet.getString(7));
                pro.setNXB(resultSet.getString(8));
                pro.setNumberpage(resultSet.getInt(9));
                pro.setQuantity(resultSet.getInt(10));
                pro.setPrice(resultSet.getFloat(11));
                pro.setSale(resultSet.getFloat(12));
                pro.setIDcatalog(resultSet.getInt(13));
                pro.setStatus(resultSet.getString(14));
                productList.add(pro);
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
        return productList;
    }
    public void updateQuantity(int IDproduct,int pay){
        int quantity = getByID(IDproduct).getQuantity() - pay;
        Connection conn = getConnection();
        try {
            PreparedStatement prestm = conn.prepareStatement("update product set quantity = ? where ID = ?");
            prestm.setInt(1, quantity);
            prestm.setInt(2, IDproduct);
            prestm.execute();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
