/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import act.demo.dto.DonHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toan
 */
public class ManagerDonHang {

    private Connection conn;

    public ManagerDonHang() {
        Connector db = new Connector();
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<DonHang> showDonHangChuaGiao() throws SQLException {
        String sql = "select  hd.makh as makh,name,phone,address,email,count(c.name) as soluong,sum(price) as price,giaohang from customer as c join donhang as hd on hd.makh=c.makh where giaohang='Chưa Giao' GROUP BY hd.makh";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<DonHang> l = new ArrayList<>();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        while (rs.next()) {
            DonHang dh = new DonHang();
            dh.setMaKH(rs.getInt("makh"));
            dh.setName(rs.getString("name"));
            dh.setPhone(rs.getString("phone"));
            dh.setAddress(rs.getString("address"));
            dh.setEmail(rs.getString("email"));
            dh.setSoluong(rs.getInt("soluong"));
            dh.setGiaoHang(rs.getString("giaohang"));

            String price = currencyVN.format(rs.getInt("price"));
            dh.setPrice(price);

            l.add(dh);
        }
        return l;

    }
    public List<DonHang> showDonHangDaGiao() throws SQLException {
        String sql = "select  hd.makh as makh,name,phone,address,email,count(c.name) as soluong,sum(price) as price,giaohang from customer as c join donhang as hd on hd.makh=c.makh where giaohang='Đã Giao' GROUP BY hd.makh";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<DonHang> l = new ArrayList<>();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        while (rs.next()) {
            DonHang dh = new DonHang();
            dh.setMaKH(rs.getInt("makh"));
            dh.setName(rs.getString("name"));
            dh.setPhone(rs.getString("phone"));
            dh.setAddress(rs.getString("address"));
            dh.setEmail(rs.getString("email"));
            dh.setSoluong(rs.getInt("soluong"));
            dh.setGiaoHang(rs.getString("giaohang"));

            String price = currencyVN.format(rs.getInt("price"));
            dh.setPrice(price);

            l.add(dh);
        }
        return l;

    }
    
    public List<DonHang> showDonHangMaKH(int makh) throws SQLException {
        String sql = "select  hd.makh as makh,name,phone,address,email,count(c.name) as soluong,sum(price) as price,giaohang from customer as c join donhang as hd on hd.makh=c.makh where c.makh="+makh+" GROUP BY hd.makh";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<DonHang> l = new ArrayList<>();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        while (rs.next()) {
            DonHang dh = new DonHang();
            dh.setMaKH(rs.getInt("makh"));
            dh.setName(rs.getString("name"));
            dh.setPhone(rs.getString("phone"));
            dh.setAddress(rs.getString("address"));
            dh.setEmail(rs.getString("email"));
            dh.setSoluong(rs.getInt("soluong"));
            dh.setGiaoHang(rs.getString("giaohang"));

            String price = currencyVN.format(rs.getInt("price"));
            dh.setPrice(price);

            l.add(dh);
        }
        return l;

    }
    
    public void deleteDonHang(int maKH) throws SQLException{
        String sql="delete from donhang where makh="+maKH;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        
    }
    
     public void deleteDonHangMaSP(int masp) throws SQLException{
        String sql="delete from donhang where masp="+masp;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        
    }
     
     public void updateDonHang(int makh,String giaoHang) throws SQLException{
         String sql="UPDATE donhang SET giaohang=? where makh="+makh;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, giaoHang);
        ps.executeUpdate();
        
     }

}
