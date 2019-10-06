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

    public List<String> listRam(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT ram from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("ram"));
        }

        String sql = "SELECT DISTINCT ram from chitietmt as mt join product as p on p.masp=mt.masp where madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            lram.add(rs1.getString("ram"));
        }

        return lram;

    }

    public List<String> listRom(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT rom from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("rom"));
        }

        String sql = "SELECT DISTINCT rom from chitietmt as mt join product as p on p.masp=mt.masp where madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            lram.add(rs1.getString("rom"));
        }

        return lram;

    }

    public List<String> listCPU(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT cpu from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("cpu"));
        }

        String sql = "SELECT DISTINCT cpu from chitietmt as mt join product as p on p.masp=mt.masp where madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            lram.add(rs1.getString("cpu"));
        }

        return lram;

    }

    public List<String> listHDH(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT hdh from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("hdh"));
        }

        String sql = "SELECT DISTINCT hdh from chitietmt as mt join product as p on p.masp=mt.masp where madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            lram.add(rs1.getString("hdh"));
        }

        return lram;

    }

    public List<String> listManHinh(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT mh from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("mh"));
        }

        String sql = "SELECT DISTINCT mh from chitietmt as mt join product as p on p.masp=mt.masp where madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            lram.add(rs1.getString("mh"));
        }

        return lram;

    }

    public List<String> listSim(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT sim from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("sim"));
        }

        return lram;

    }

    public List<String> listcameraT(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT cameraT from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("cameraT"));
        }

        return lram;

    }

    public List<String> listcameraS(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql1 = "SELECT DISTINCT cameraS from chitietdt as dt join product as p on p.masp=dt.masp where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            lram.add(rs.getString("cameraS"));
        }

        return lram;

    }

    public List<String> listCDH(int madm) throws SQLException {//ram
        List<String> lram = new ArrayList<>();

        String sql = "SELECT DISTINCT CDH from chitietmt as mt join product as p on p.masp=mt.masp where madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            lram.add(rs1.getString("CDH"));
        }

        return lram;

    }

    public String showRamSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT ram from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("ram");
        }

        String sql = "SELECT DISTINCT ram from chitietmt as mt join product as p on p.masp=mt.masp where p.masp=" + masp;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            return rs1.getString("ram");
        }

        return null;

    }

    public String showRomSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT rom from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("rom");
        }

        String sql = "SELECT DISTINCT rom from chitietmt as mt join product as p on p.masp=mt.masp where p.masp=" + masp;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            return rs1.getString("rom");
        }

        return null;

    }

    public String showCPUSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT cpu from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("cpu");
        }

        String sql = "SELECT DISTINCT cpu from chitietmt as mt join product as p on p.masp=mt.masp where p.masp=" + masp;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            return rs1.getString("cpu");
        }

        return null;

    }

    public String showHDHSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT hdh from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("hdh");
        }

        String sql = "SELECT DISTINCT hdh from chitietmt as mt join product as p on p.masp=mt.masp where p.masp=" + masp;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            return rs1.getString("hdh");
        }

        return null;

    }

    public String showManHinhSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT mh from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("mh");
        }

        String sql = "SELECT DISTINCT mh from chitietmt as mt join product as p on p.masp=mt.masp where p.masp=" + masp;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            return rs1.getString("mh");
        }

        return null;

    }

    public String showSimSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT sim from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("sim");
        }

        return null;

    }

    public String showcameraTSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT cameraT from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("cameraT");
        }

        return null;

    }

    public String showcameraSSP(int masp) throws SQLException {//ram

        String sql1 = "SELECT DISTINCT cameraS from chitietdt as dt join product as p on p.masp=dt.masp where p.masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            return rs.getString("cameraS");
        }

        return null;

    }

    public String showCDHSP(int masp) throws SQLException {//ram

        String sql = "SELECT DISTINCT CDH from chitietmt as mt join product as p on p.masp=mt.masp where p.masp=" + masp;
        PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            return rs1.getString("CDH");
        }

        return null;

    }

}
