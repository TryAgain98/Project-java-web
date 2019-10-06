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
    
     public DanhMucSP showDM(int madm) throws SQLException {
        String sql = "select * from danhmucsp where madm="+madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        DanhMucSP dm=new DanhMucSP();
        while (rs.next()) {
         
            dm.setMaDM(rs.getInt("madm"));
            dm.setName(rs.getString("name"));
         
            
        }
        return dm;
    }
     
      public DanhMucSP showDMmaSP(int masp) throws SQLException {
        String sql = "select dm.madm as madm ,dm.name as name  from danhmucsp as dm join product as p on p.madm=dm.madm where masp="+masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        DanhMucSP dm=new DanhMucSP();
        while (rs.next()) {
         
            dm.setMaDM(rs.getInt("madm"));
            dm.setName(rs.getString("name"));
         
            
        }
        return dm;
    }
     public List<DanhMucSP> searchDM(String name) throws SQLException {
        String sql = "select * from danhmucsp where name like '%" + name + "%'";
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
     

//    public List<DanhMucSP> deleteDM(int madm) throws SQLException {
//        String sql = "select * from danhmucsp";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//        List<DanhMucSP> l = new ArrayList<>();
//        while (rs.next()) {
//            DanhMucSP dm = new DanhMucSP();
//            dm.setMaDM(rs.getInt("madm"));
//            dm.setName(rs.getString("name"));
//            l.add(dm);
//            
//        }
//        return l;
//    }
//   
    
    public void updateDM(DanhMucSP dm1) throws SQLException {
        String sql = "UPDATE danhmucsp SET name=? WHERE madm=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dm1.getName());
        pstmt.setInt(2, dm1.getMaDM());
        pstmt.executeUpdate();
        
    }
    public void insertDM(DanhMucSP dm1) throws SQLException {
        String sql = "insert into danhmucsp(name) values(?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dm1.getName());
        pstmt.executeUpdate();
        
    }
    
    public void deleteDM(int madm) throws SQLException{
        String sql="delete from danhmucsp where madm = "+madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }
   
    
}
