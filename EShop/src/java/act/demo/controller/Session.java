/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.Customer;
import act.demo.dto.DanhMucSP;
import act.demo.dto.GioHang;
import act.demo.dto.Product;
import act.demo.model.ManagerCustomer;
import act.demo.model.ManagerDMSP;
import act.demo.model.ManagerProduct;
import act.demo.model.chiTietManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Toan
 */
@RestController
public class Session {

    ManagerDMSP dMMSP = new ManagerDMSP();
    ManagerProduct mp = new ManagerProduct();
    chiTietManager ct = new chiTietManager();
    ManagerCustomer mc = new ManagerCustomer();

    @RequestMapping("/addCard")
    public String addCard(HttpSession session, @RequestParam("id") int masp, Model model, @RequestParam("quantity") int quantity) throws SQLException {

        System.out.println("đã vào session");
        int soluong = 0;//tổng sản phẩm giỏ hàng
        if (session.getAttribute("cart") == null) {
            List<GioHang> l = new ArrayList<GioHang>();
            GioHang gh = new GioHang();
            Product p = new Product();
            p = mp.ProductCart(masp);
            gh.setMaSP(p.getMaSP());
            gh.setName(p.getName());
            gh.setNewPrice(p.getNewPrice());
            gh.setOldPrice(p.getOldPrice());
            gh.setGiamGia(p.getGiamGia());

            gh.setSoLuong(quantity);
            gh.setMaxSoLuong(p.getSoLuong());
            gh.setImage(p.getImage());
            l.add(gh);
            session.setAttribute("cart", l);
            soluong = 1;
            session.setAttribute("soluong", soluong);

            int money;
            System.out.println("ma sp" + gh.getMaSP());
            System.out.println("soluong " + gh.getSoLuong());
            System.out.println("gia " + mp.Cartmoney(gh.getMaSP()));

            money = (mp.Cartmoney(gh.getMaSP()) * gh.getSoLuong());

            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(money);

            session.setAttribute("money", oldPrice);

        } else {
            List<GioHang> l = new ArrayList<GioHang>();
            l = (List<GioHang>) session.getAttribute("cart");
            int check = 0;

            for (GioHang gh : l) {
                if (gh.getMaSP() == masp) {
                    gh.setSoLuong(gh.getSoLuong() + quantity);
                    check = 1;
                }
                soluong++;

            }
            session.setAttribute("soluong", soluong);
            if (check == 0) {
                GioHang gh = new GioHang();
                Product p = new Product();
                p = mp.ProductCart(masp);
                gh.setMaSP(p.getMaSP());
                gh.setName(p.getName());
                gh.setNewPrice(p.getNewPrice());
                gh.setOldPrice(p.getOldPrice());
                gh.setGiamGia(p.getGiamGia());
                gh.setMaxSoLuong(p.getSoLuong());
                gh.setSoLuong(quantity);
                gh.setImage(p.getImage());
                l.add(gh);
                soluong += 1;
                session.setAttribute("soluong", soluong);
            }

            int money = 0;
            for (GioHang gh : l) {
                money = money + (mp.Cartmoney(gh.getMaSP()) * gh.getSoLuong());
            }
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(money);
            session.setAttribute("money", oldPrice);

            session.setAttribute("cart", l);

        }

        return "index";
    }

//    @RequestMapping("/deleteCart")
//    public String deleteCart(HttpSession session, @RequestParam("id") int masp, Model model) {
//        System.out.println("ma sp : " + masp);
//        if(session.getAttribute("cart") != null){
//        List<GioHang> l = new ArrayList<GioHang>();
//        l = (List<GioHang>) session.getAttribute("cart");
//
//        int soluong = 0;
//        for (GioHang gh : l) {
//            if (gh.getMaSP() == masp) {
//                System.out.println("ok");
//                
//            }
//            soluong++;
//        }
//        System.out.println("soluong : "+soluong);
//        session.setAttribute("cart", l);
//
//        session.setAttribute("soluong", soluong - 1);}
//        return null;
//    }
    @RequestMapping("/list")
    public String list(HttpSession session, Model model, @RequestParam("masp") int masp) throws SQLException {

        int soluong = 0;
        List<GioHang> l = new ArrayList<GioHang>();
        l = (List<GioHang>) session.getAttribute("cart");
        int check = 0;

        for (GioHang gh : l) {

            soluong++;

        }

        GioHang gh = new GioHang();
        Product p = new Product();
        p = mp.ProductCart(masp);
        gh.setMaSP(p.getMaSP());
        gh.setName(p.getName());
        gh.setNewPrice(p.getNewPrice());
        gh.setOldPrice(p.getOldPrice());
        gh.setGiamGia(p.getGiamGia());
        gh.setMaxSoLuong(p.getSoLuong());
        //gh.setSoLuong(quantity);
        gh.setImage(p.getImage());
        l.add(gh);
        soluong += 1;
        session.setAttribute("soluong", soluong);

        session.setAttribute("cart", l);

        return "index";
    }

}
