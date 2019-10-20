/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ConnectionJDBC.getConnection;
import Model.User;
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
public class UserIO extends ConnectionJDBC implements ICommon<User> {

    @Override
    public void add(User t) {
        Connection conn = getConnection();
        String sql = "insert into userIO(userName,passWord,firstName,lastName,address,phone,email,role,saltEncoder)values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prestm;
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getUser());
            prestm.setString(2, t.getPass());
            prestm.setString(3, t.getFristName());
            prestm.setString(4, t.getLastName());
            prestm.setString(5, t.getAddress());
            prestm.setString(6, t.getPhone());
            prestm.setString(7, t.getEmail());
            prestm.setString(8, t.getRole());
            prestm.setString(9, t.getSaltEncoder());
            prestm.executeUpdate();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getByID(int ID) {
        User user = new User();
        Connection conn = getConnection();
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from userIO where ID = " + ID);
            while (resultSet.next()) {
                user.setID(resultSet.getInt(1));
                user.setUser(resultSet.getString(2));
                user.setPass(resultSet.getString(3));
                user.setFristName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setAddress(resultSet.getString(6));
                user.setPhone(resultSet.getString(7));
                user.setEmail(resultSet.getString(8));
                user.setRole(resultSet.getString(9));
                user.setSaltEncoder(resultSet.getString(10));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @Override
    public User getByName(String name) {
        User user = new User();
        Connection conn = getConnection();
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from userIO where userName = '" + name + "'");
            while (resultSet.next()) {
                user.setID(resultSet.getInt(1));
                user.setUser(resultSet.getString(2));
                user.setPass(resultSet.getString(3));
                user.setFristName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setAddress(resultSet.getString(6));
                user.setPhone(resultSet.getString(7));
                user.setEmail(resultSet.getString(8));
                user.setRole(resultSet.getString(9));
                user.setSaltEncoder(resultSet.getString(10));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> listUser = new ArrayList();
        Connection conn = getConnection();
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from userIO");
            while (resultSet.next()) {
                User user = new User();
                user.setID(resultSet.getInt(1));
                user.setUser(resultSet.getString(2));
                user.setPass(resultSet.getString(3));
                user.setFristName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setAddress(resultSet.getString(6));
                user.setPhone(resultSet.getString(7));
                user.setEmail(resultSet.getString(8));
                user.setRole(resultSet.getString(9));
                user.setSaltEncoder(resultSet.getString(10));
                listUser.add(user);
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }

    @Override
    public List<User> getAllbyID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean checkUser(String userName,String phone,String email) {
        Connection conn = getConnection();
        PreparedStatement prestm;
        boolean status = true;
        try {
            prestm = conn.prepareStatement("select * from userIO where userName = ? or phone = ? or email = ?");
            prestm.setString(1, userName);
            prestm.setString(2, phone);
            prestm.setString(3, email);
            ResultSet rs = prestm.executeQuery();
            status = rs.next();
            rs.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
    public static boolean checkUpdate(String user,String phone,String email){
        Connection conn = getConnection();
        PreparedStatement prestm;
        boolean status = true;
        try {
            prestm = conn.prepareStatement("select * from userIO where phone = ? or email = ? except select * from userIO where userName = ?");
            prestm.setString(1, phone);
            prestm.setString(2, email);
            prestm.setString(3, user);
            ResultSet rs = prestm.executeQuery();
            status = rs.next();
            rs.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
    public static boolean findUser(String user){
        Connection conn = getConnection();
        PreparedStatement prestm;
        boolean status = true;
        try {
            prestm = conn.prepareStatement("select * from userIO where userName = ?");
            prestm.setString(1, user);
            ResultSet rs = prestm.executeQuery();
            status = rs.next();
            rs.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
    public static void update(String user,String phone,String email,String address){
        Connection conn = getConnection();
        PreparedStatement prestm;
        try {
            prestm = conn.prepareStatement("update userIO set phone = ?,address= ?,email= ? where userName = ?");
            prestm.setString(1, phone);
            prestm.setString(2, address);
            prestm.setString(3, email);
            prestm.setString(4, user);
            prestm.execute();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void updateRole(int ID,String role){
        Connection conn = getConnection();
        PreparedStatement prestm;
        try {
            prestm = conn.prepareStatement("update userIO set role = ? where ID = ?");
            prestm.setString(1, role);
            prestm.setInt(2, ID);
            prestm.execute();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void updatePass(String user,String pass){
        Connection conn = getConnection();
        PreparedStatement prestm;
        try {
            prestm = conn.prepareStatement("update userIO set passWord = ? where userName = ?");
            prestm.setString(1, pass);
            prestm.setString(2, user);
            prestm.execute();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
