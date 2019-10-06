/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import act.demo.dto.LienHe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toan
 */
public class LienHeManager {

    private Connection conn;

    public LienHeManager() {
        Connector db = new Connector();
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LienHe show() throws SQLException {
        String sql = "select * from LienHe";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        LienHe lh = new LienHe();
        while (rs.next()) {
            lh.setName(rs.getString("name"));
            lh.setAddress(rs.getString("address"));
            lh.setEmail(rs.getString("email"));
            lh.setPhone(rs.getString("phone"));
            lh.setThem(rs.getString("them"));
        }
        return lh;
    }

    public void update(LienHe lh) throws SQLException {
         String sql = "UPDATE LienHe SET name=?,email=?,address=?,phone=?,them=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, lh.getName());
        ps.setString(2, lh.getEmail());
        ps.setString(3, lh.getAddress());
          ps.setString(4, lh.getPhone());
            ps.setString(5, lh.getThem());
         ps.executeUpdate();
    }
}
