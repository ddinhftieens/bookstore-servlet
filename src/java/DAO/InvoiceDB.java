/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.ConnectionJDBC.getConnection;
import Model.Invoice;
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
public class InvoiceDB extends ConnectionJDBC implements ICommon<Invoice> {

    @Override
    public void add(Invoice t) {
        Connection conn = getConnection();
        String sql = "insert into invoice(name,address,phone,email,note,datecreated,timerevice,pay,IDproduct,quantity,price,totalPrice,status,idcustomer)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prestm;
        try {
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getName());
            prestm.setString(2, t.getAddress());
            prestm.setString(3, t.getPhone());
            prestm.setString(4, t.getEmail());
            prestm.setString(5, t.getNote());
            prestm.setString(6, t.getDateCreated());
            prestm.setString(7, t.getTimerevice());
            prestm.setString(8, t.getPayment());
            prestm.setString(9, t.getIDproduct());
            prestm.setString(10, t.getQuantity());
            prestm.setString(11, t.getPrice());
            prestm.setString(12, t.getTotalPrice());
            prestm.setString(13, t.getStatus());
            prestm.setInt(14, t.getIdcustomer());
            prestm.execute();
            prestm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Invoice getByID(int ID) {
        Connection conn = getConnection();
        Invoice iv = new Invoice();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from invoice where id = " + ID);
            while(rs.next()){ 
                iv.setId(rs.getInt(1));
                iv.setName(rs.getString(2));
                iv.setAddress(rs.getString(3));
                iv.setPhone(rs.getString(4));
                iv.setEmail(rs.getString(5));
                iv.setNote(rs.getString(6));
                iv.setDateCreated(rs.getString(7));
                iv.setTimerevice(rs.getString(8));
                iv.setPayment(rs.getString(9));
                iv.setIDproduct(rs.getString(10));
                iv.setQuantity(rs.getString(11));
                iv.setPrice(rs.getString(12));
                iv.setTotalPrice(rs.getString(13));
                iv.setStatus(rs.getString(14));
                iv.setIdcustomer(rs.getInt(15));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iv;
    }

    @Override
    public Invoice getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Invoice> getAll() {
        List<Invoice> listInvoice = new ArrayList();
        Connection conn = getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from invoice");
            while(rs.next()){
                Invoice iv = new Invoice();
                iv.setId(rs.getInt(1));
                iv.setName(rs.getString(2));
                iv.setAddress(rs.getString(3));
                iv.setPhone(rs.getString(4));
                iv.setEmail(rs.getString(5));
                iv.setNote(rs.getString(6));
                iv.setDateCreated(rs.getString(7));
                iv.setTimerevice(rs.getString(8));
                iv.setPayment(rs.getString(9));
                iv.setIDproduct(rs.getString(10));
                iv.setQuantity(rs.getString(11));
                iv.setPrice(rs.getString(12));
                iv.setTotalPrice(rs.getString(13));
                iv.setStatus(rs.getString(14));
                iv.setIdcustomer(rs.getInt(15));
                listInvoice.add(iv);
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listInvoice;
    }

    @Override
    public List<Invoice> getAllbyID(int ID) {
        List<Invoice> listInvoice = new ArrayList();
        Connection conn = getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from invoice where idcustomer = " + ID);
            while(rs.next()){
                Invoice iv = new Invoice();
                iv.setId(rs.getInt(1));
                iv.setName(rs.getString(2));
                iv.setAddress(rs.getString(3));
                iv.setPhone(rs.getString(4));
                iv.setEmail(rs.getString(5));
                iv.setNote(rs.getString(6));
                iv.setDateCreated(rs.getString(7));
                iv.setTimerevice(rs.getString(8));
                iv.setPayment(rs.getString(9));
                iv.setIDproduct(rs.getString(10));
                iv.setQuantity(rs.getString(11));
                iv.setPrice(rs.getString(12));
                iv.setTotalPrice(rs.getString(13));
                iv.setStatus(rs.getString(14));
                iv.setIdcustomer(rs.getInt(15));
                listInvoice.add(iv);
            }
            conn.close();
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listInvoice;
    }
    public void updateStatus(int ID,String status){
        Connection conn = getConnection();
        PreparedStatement prestm;
        try {
            prestm = conn.prepareStatement("update invoice set status = ? where id = ?");
            prestm.setString(1, status);
            prestm.setInt(2, ID);
            prestm.execute();
            prestm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
