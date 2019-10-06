/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import act.demo.dto.DanhMucSP;
import act.demo.dto.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Toan
 */
public class ManagerProduct {

    private Connection conn;

    public ManagerProduct() {
        try {
            Connector db = new Connector();
            conn = db.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Product> showProduct() throws SQLException {
        String sql = "select * from product";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Product> l = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;
    }
    public List<Product> showProduct(int limit,int offset) throws SQLException {
        String sql = "select * from product LIMIT ?, ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, offset);
        pstmt.setInt(2, limit);
        ResultSet rs = pstmt.executeQuery();
        List<Product> l = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;
    }

    public List<Product> showProductCT(int masp) throws SQLException {
        String sql = "select * from product where masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Product> l = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));
            p.setThuongHieu(rs.getString("Thuonghieu"));
            p.setGhiChu(rs.getString("ghichu"));
            p.setSoLuong(rs.getInt("soluong"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;
    }

    public List<Product> search(String name) throws SQLException {
        String sql = "select p.name as name, masp ,OldPrice, newprice ,thuonghieu, image, trangthai from product as p join danhmucsp as dm on dm.madm=p.madm where p.name like '%" + name + "%' or dm.name like '%" + name + "%' or thuonghieu like '%" + name + "%'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Product> l = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            System.out.println("lol");
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;
    }

    public List<Product> searchDM(int madm) throws SQLException {
        String sql = "select * from product where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Product> l = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietRam(int madm, String ram) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where ram='" + ram + "' and madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where ram='" + ram + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));

            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietRom(int madm, String rom) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where rom='" + rom + "' and madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }
            l.add(p);
        }
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where rom='" + rom + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));
            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietCPU(int madm, String cpu) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where cpu='" + cpu + "' and madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }
            l.add(p);
        }
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where cpu='" + cpu + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));
            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietHDH(int madm, String hdh) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where hdh='" + hdh + "' and madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }
            l.add(p);
        }
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where hdh='" + hdh + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));
            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietMH(int madm, String mh) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where mh='" + mh + "' and madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }
            l.add(p);
        }
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where mh='" + mh + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));
            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietCDH(int madm, String cdh) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where cdh='" + cdh + "' and madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }
            l.add(p);
        }

        return l;

    }

    public List<Product> searchChiTietSim(int madm, String sim) throws SQLException {
        List<Product> l = new ArrayList<>();

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where sim='" + sim + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));
            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietCameraT(int madm, String CameraT) throws SQLException {
        List<Product> l = new ArrayList<>();

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where camerat='" + CameraT + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));
            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public List<Product> searchChiTietCameraS(int madm, String CameraS) throws SQLException {
        List<Product> l = new ArrayList<>();

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where cameraS='" + CameraS + "' and madm=" + madm;
        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
        ResultSet rs1 = pstmt1.executeQuery();
        while (rs1.next()) {
            Product p = new Product();
            p.setMaSP(rs1.getInt("masp"));
            p.setName(rs1.getString("name"));
            double giamgia = (double) rs1.getInt("NewPrice") / (double) rs1.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;
            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs1.getString("image"));
            p.setTrangThai(rs1.getString("trangthai"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs1.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs1.getInt("NewPrice"));
            if (rs1.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }

            l.add(p);
        }
        return l;

    }

    public Product ProductCart(int masp) throws SQLException {
        String sql = "select * from product where masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            double giamgia = (double) rs.getInt("NewPrice") / (double) rs.getInt("OldPrice");
            int gg1 = (int) ((double) (Math.round(giamgia * 100)) / 100 * 100);
            int gg = 100 - gg1;

            if (gg <= 0) {
                p.setGiamGia(100);
            } else {
                p.setGiamGia(gg);
            }
            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));
            p.setThuongHieu(rs.getString("Thuonghieu"));

            p.setSoLuong(rs.getInt("soluong"));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(rs.getInt("OldPrice"));
            String newPrice = currencyVN.format(rs.getInt("NewPrice"));
            if (rs.getInt("NewPrice") <= 0) {
                p.setNewPrice(oldPrice);
            } else {
                p.setOldPrice(oldPrice);
                p.setNewPrice(newPrice);
            }
            return p;

        }
        return null;
    }

    public int Cartmoney(int masp) throws SQLException {
        String sql = "select * from product where masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            if (rs.getInt("newprice") == 0) {
                System.out.println(rs.getInt("oldprice"));
                return rs.getInt("oldprice");

            } else {
                return rs.getInt("newprice");
            }

        }

        return 0;
    }
    
    public int searchSoLuong(int masp) throws SQLException{
        String sql="select * from product where masp="+masp;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            return rs.getInt("soluong");
        }
        return 0;
    }
    
    public void DeleteSoLuong(int masp,int soluongGioHang) throws SQLException{
        int soluong=searchSoLuong(masp)-soluongGioHang;
        String sql="UPDATE product SET soluong="+soluong+" WHERE masp="+masp;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }

}
