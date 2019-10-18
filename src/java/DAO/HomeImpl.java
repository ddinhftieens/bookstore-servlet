/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ConnectionJDBC.getConnection;
import Model.Product;
import java.sql.Connection;
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
public class HomeImpl extends ConnectionJDBC implements ICommon<Product>{

    @Override
    public List<Product> getAll() {
        Connection conn = getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where status = 'New'");
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
    public void add(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getByID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAllbyID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
