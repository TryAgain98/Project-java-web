/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import act.demo.dto.DanhMucSP;

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
public class ManagerDMSP {

    private Connection conn;

    public ManagerDMSP() {
        Connector c = new Connector();
        try {
            conn = c.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerDMSP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDMSP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<DanhMucSP> showDM() throws SQLException {
        String sql = "select * from danhmucsp";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<DanhMucSP> l = new ArrayList<>();
        while (rs.next()) {
            DanhMucSP dm = new DanhMucSP();
            dm.setMaDM(rs.getInt("madm"));
            dm.setName(rs.getString("name"));
            l.add(dm);
        }
        return l;
    }

}
