/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import act.demo.dto.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toan
 */
public class ManagerCustomer {

    private Connection conn;

    public ManagerCustomer() {
        Connector db = new Connector();
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addCustomer(Customer c) throws SQLException {
        String sql = "insert into customer(name,gender,phone,email,password) values(?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c.getName());
        pstmt.setString(2, c.getGender());
        pstmt.setString(3, c.getPhone());
        pstmt.setString(4, c.getEmail());
        pstmt.setString(5, c.getPassword());
    

        pstmt.executeUpdate();
    }
    
    public Customer Login(String email, String pass) throws SQLException{
        String sql="select * from customer where email = '" + email + "' and password = '"+pass+"'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Customer c=new Customer();
        while(rs.next()){
            c.setMaKH(rs.getInt("makh"));
            c.setName(rs.getString("name"));
        }
        return c;
    }
    
     public List<Customer> showCustomer() throws SQLException {
        String sql = "select * from customer ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
       List<Customer> l=new ArrayList<>();
        
        while (rs.next()) {
              Customer c = new Customer();
            c.setMaKH(rs.getInt("makh"));
            c.setName(rs.getString("name"));
            c.setGender(rs.getString("gender"));
            c.setPhone(rs.getString("phone"));
            c.setEmail(rs.getString("email"));
            c.setPassword(rs.getString("password"));
            c.setAddress(rs.getString("address"));

            l.add(c);
        }
        return l;
    }

}
