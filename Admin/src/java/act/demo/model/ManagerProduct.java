/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import act.demo.dto.DanhMucSP;
import act.demo.dto.Product;
import act.demo.dto.SanPhamDonHang;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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

            p.setThuongHieu(rs.getString("thuonghieu"));
            p.setSoLuong(rs.getInt("soluong"));
            p.setGhiChu(rs.getString("ghichu"));
            p.setTrangThai(rs.getString("trangThai"));

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

    public List<Product> showProductUpdate(int masp) throws SQLException {//update product tiền mặc định
        String sql = "select * from product where masp=" + masp;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Product> l = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setMaSP(rs.getInt("masp"));
            p.setName(rs.getString("name"));

            p.setImage(rs.getString("image"));
            p.setTrangThai(rs.getString("trangthai"));
            p.setThuongHieu(rs.getString("Thuonghieu"));
            p.setGhiChu(rs.getString("ghichu"));
            p.setSoLuong(rs.getInt("soluong"));
            p.setMaDM(rs.getInt("madm"));
            p.setNewPrice(rs.getString("newprice"));
            p.setOldPrice(rs.getString("oldprice"));
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

    public List<Product> searchChiTietRam(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where maram=" + id + " and madm=" + madm;
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

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where maram=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietRom(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where marom=" + id + " and madm=" + madm;
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
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where marom=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietCPU(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where macpu=" + id + " and madm=" + madm;
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
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where macpu=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietHDH(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where mahdh=" + id + " and madm=" + madm;
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
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where mahdh=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietMH(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where mamh=" + id + " and madm=" + madm;
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
        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where mamh=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietCDH(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();
        String sql = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietmt as ct on ct.masp=p.masp) where macdh=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietSim(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where masim=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietCameraT(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where macamerat=" + id + " and madm=" + madm;
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

    public List<Product> searchChiTietCameraS(int madm, int id) throws SQLException {
        List<Product> l = new ArrayList<>();

        String sql1 = "select p.name as name, p.masp  as masp,OldPrice, newprice ,thuonghieu, image, trangthai from (product as p join chitietdt as ct on ct.masp=p.masp) where macameraS=" + id + " and madm=" + madm;
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

    public void updateProduct(Product p) throws SQLException {
        String sql = "UPDATE product SET name=?,Oldprice=?,newprice=?,thuonghieu=?,soluong=?,image=?,ghichu=?,trangthai=?,madm=? WHERE masp=" + p.getMaSP();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, p.getName());
        pstmt.setInt(2, Integer.parseInt(p.getOldPrice()));
        pstmt.setInt(3, Integer.parseInt(p.getNewPrice()));
        pstmt.setString(4, p.getThuongHieu());
        pstmt.setInt(5, p.getSoLuong());
        pstmt.setString(6, p.getImage());
        pstmt.setString(7, p.getGhiChu());
        pstmt.setString(8, p.getTrangThai());
        pstmt.setInt(9, p.getMaDM());
        pstmt.executeUpdate();
    }

    public void addProduct(Product p) throws SQLException {
        String sql = "insert into product(name,OldPrice,NewPrice,thuongHieu,soluong,image,ghichu,trangthai,maDM) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, p.getName());
        pstmt.setInt(2, Integer.parseInt(p.getOldPrice()));
        pstmt.setInt(3, Integer.parseInt(p.getNewPrice()));
        pstmt.setString(4, p.getThuongHieu());
        pstmt.setInt(5, p.getSoLuong());
        pstmt.setString(6, p.getImage());
        pstmt.setString(7, p.getGhiChu());
        pstmt.setString(8, p.getTrangThai());
        pstmt.setInt(9, p.getMaDM());
        pstmt.executeUpdate();

    }

    public int layMaSP() throws SQLException {
        String sql = "SELECT MAX(masp) as masp FROM product";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int masp = 0;
        while (rs.next()) {
            masp = rs.getInt("masp");

        }
        return masp;
    }

    public void deleteProduct(int masp) throws SQLException {
        String sql = "delete from product where masp=" + masp;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void deleteProductDanhMuc(int madm) throws SQLException {
        String sql = "delete from product where madm=" + madm;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }

    public List<Integer> showProductDM(int madm) throws SQLException {
        String sql = "select * from product where madm=" + madm;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Integer> l = new ArrayList<>();
        while (rs.next()) {
            l.add(rs.getInt("masp"));
        }
        return l;

    }

    public List<SanPhamDonHang> showSanPhamDonHang(int makh) throws SQLException {
        String sql = "select name,oldprice,newprice,thuonghieu,dh.soluong as soluong,dh.price as price,image from product as p join donhang as dh on dh.masp=p.masp where makh=" + makh;
        PreparedStatement ps = conn.prepareStatement(sql);
        List<SanPhamDonHang> l = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        while (rs.next()) {
            SanPhamDonHang sp = new SanPhamDonHang();
            sp.setName(rs.getString("name"));
            String oldprice = currencyVN.format(rs.getInt("oldprice"));
            String newprice = currencyVN.format(rs.getInt("newprice"));
            sp.setNewPrice(newprice);
            sp.setOldPrice(oldprice);
            sp.setThuongHieu(rs.getString("thuonghieu"));
            sp.setSoluongDH(rs.getInt("soluong"));
             String price = currencyVN.format(rs.getInt("price"));
             sp.setPriceDH(price);
             sp.setImage(rs.getString("image"));
             l.add(sp);
        }
        return l;

    }
}
