/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import act.demo.dto.ChiTietDT;
import act.demo.dto.ChiTietMT;

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
public class chiTietManager {

    private Connection conn;

    public chiTietManager() {
        Connector db = new Connector();
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(chiTietManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(chiTietManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String check(int masp) throws SQLException {
        String sql = "select * from chiTietDT where masp =" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            return "dt";
        }
        return "mt";

    }

    public ChiTietMT showChiTietMT(int masp) throws SQLException {
        String sql = "select * from chitietmt where masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        ChiTietMT chiTietMT = new ChiTietMT();
        while (rs.next()) {
            chiTietMT.setRam(rs.getString("ram"));
            chiTietMT.setRom(rs.getString("rom"));
            chiTietMT.setCpu(rs.getString("cpu"));
            chiTietMT.setHeDH(rs.getString("hdh"));
            chiTietMT.setManHinh(rs.getString("mh"));
            chiTietMT.setCardDH(rs.getString("cdh"));
            chiTietMT.setMaSP(rs.getInt("masp"));
            chiTietMT.setMaCT(rs.getInt("mact"));

        }
        return chiTietMT;
    }

    public ChiTietDT showChiTietDT(int masp) throws SQLException {
        String sql = "select * from chitietdt where masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        ChiTietDT chiTietDT = new ChiTietDT();
        while (rs.next()) {
            chiTietDT.setRam(rs.getString("ram"));
            chiTietDT.setRom(rs.getString("rom"));
            chiTietDT.setCpu(rs.getString("cpu"));
            chiTietDT.setHeDH(rs.getString("hdh"));
            chiTietDT.setManHinh(rs.getString("mh"));

            chiTietDT.setMaSP(rs.getInt("masp"));
            chiTietDT.setMaCT(rs.getInt("mact"));
            chiTietDT.setCameraS(rs.getString("cameraS"));
            chiTietDT.setCameraT(rs.getString("cameraT"));
            chiTietDT.setSim(rs.getString("sim"));

        }
        return chiTietDT;
    }

    public void addChiTietMT(String ram, String rom, String cpu, String hdh, String mh, String cdh) throws SQLException {
        ManagerProduct mp = new ManagerProduct();
        int masp = mp.layMaSP();
        String sql = "insert into chitietmt(ram,rom,cpu,hdh,mh,cdh,masp) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, ram);
        pstmt.setString(2, rom);
        pstmt.setString(3, cpu);
        pstmt.setString(4, hdh);
        pstmt.setString(5, mh);
        pstmt.setString(6, cdh);
        pstmt.setInt(7, masp);
        pstmt.executeUpdate();

    }

    public void addChiTietDT(String ram, String rom, String cpu, String hdh, String mh, String cameraT, String cameraS, String sim) throws SQLException {
        ManagerProduct mp = new ManagerProduct();
        int masp = mp.layMaSP();
        System.out.println("Ma san pham " + masp);
        String sql = "insert into chitietdt(ram,rom,cpu,hdh,mh,sim,cameraT,cameraS,masp) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, ram);
        pstmt.setString(2, rom);
        pstmt.setString(3, cpu);
        pstmt.setString(4, hdh);
        pstmt.setString(5, mh);
        pstmt.setString(6, sim);
        pstmt.setString(7, cameraT);
        pstmt.setString(8, cameraS);
        pstmt.setInt(9, masp);
        pstmt.executeUpdate();

    }

    public void updateMayTinh(String ram, String rom, String cpu, String hdh, String mh, String cdh, int masp) throws SQLException {

        String slect = "select * from chitietmt where masp = " + masp;
        PreparedStatement pstmt = conn.prepareStatement(slect);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String sql = "UPDATE chitietmt SET ram=?,rom=?,cpu=?,hdh=?,mh=?,cdh=? where masp= " + masp;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ram);
            ps.setString(2, rom);
            ps.setString(3, cpu);
            ps.setString(4, hdh);
            ps.setString(5, mh);
            ps.setString(6, cdh);
            ps.executeUpdate();

        } else {
            String sql = "insert into chitietmt(ram,rom,cpu,hdh,mh,cdh,masp) values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1, ram);
            pstmt1.setString(2, rom);
            pstmt1.setString(3, cpu);
            pstmt1.setString(4, hdh);
            pstmt1.setString(5, mh);
            pstmt1.setString(6, cdh);
            pstmt1.setInt(7, masp);
            pstmt1.executeUpdate();
        }

    }

    public void updateChiTietDT(String ram, String rom, String cpu, String hdh, String mh, String cameraT, String cameraS, String sim, int masp) throws SQLException {
        String sql = "UPDATE chitietdt SET ram=?,rom=?,cpu=?,hdh=?,mh=?,camerat=?,cameras=?,sim=? where masp= " + masp;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ram);
        ps.setString(2, rom);
        ps.setString(3, cpu);
        ps.setString(4, hdh);
        ps.setString(5, mh);
        ps.setString(6, cameraT);
        ps.setString(7, cameraS);
        ps.setString(8, sim);

        ps.executeUpdate();

    }

    public void deleteChiTiet(int masp) throws SQLException {

        String check = check(masp);
        if (check.equals("mt")) {
            String sql = "DELETE FROM chitietmt WHERE  masp=" + masp;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } else if (check.equals("dt")) {
            String sql = "DELETE FROM chitietdt WHERE  masp=" + masp;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        }

    }

}
