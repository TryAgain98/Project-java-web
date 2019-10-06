/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.Customer;
import act.demo.dto.DanhMucSP;

import act.demo.dto.Product;

import act.demo.model.ManagerCustomer;

import act.demo.model.ManagerDMSP;
import act.demo.model.ManagerDonHang;
import act.demo.model.ManagerProduct;
import act.demo.model.chiTietManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Toan
 */
@Controller
public class DanhMucController {

    ManagerDMSP dMMSP = new ManagerDMSP();//danhmuc
    ManagerProduct mp = new ManagerProduct();//san pham
    chiTietManager ct = new chiTietManager();//chi tiet san pham
    ManagerCustomer mc = new ManagerCustomer();//khach hang
     ManagerDonHang mdh=new ManagerDonHang();
    @RequestMapping("/")
    public String home(Model model) {

        return "index";
    }

    @RequestMapping("showDanhMuc")
    public String showDanhMuc(Model model) {

        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        try {
            l = dMMSP.showDM();
            System.out.println("lol");
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("l", l);
        return "showDanhMuc";
    }

    @RequestMapping("deleteDanhMuc")
    public String deleteDanhMuc(Model model, @RequestParam("id") int madm) throws SQLException {
         List<Integer> lmasp=new ArrayList<>();
         lmasp=mp.showProductDM(madm);
         for(int masp :lmasp){
             mdh.deleteDonHangMaSP(masp);
             ct.deleteChiTiet(masp);
         }
         
         
        mp.deleteProductDanhMuc(madm);
        dMMSP.deleteDM(madm);
        
        
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
      
            l = dMMSP.showDM();
            
        
        model.addAttribute("l", l);
        return "showDanhMuc";
    }

    @RequestMapping("updateDanhMuc")
    public String updateDanhMuc(Model model, @RequestParam("id") int madm) {

        try {
            DanhMucSP dm = dMMSP.showDM(madm);
            model.addAttribute("dm", dm);

        } catch (SQLException ex) {
            Logger.getLogger(DanhMucController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "updateDanhMuc";
    }

    @RequestMapping("/saveUpdateDanhMuc")
    public String saveUpdateDanhMuc(Model model, @ModelAttribute DanhMucSP dm) {

        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        try {

            dMMSP.updateDM(dm);

            l = dMMSP.showDM();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("l", l);
        model.addAttribute("informDanhMuc", "Lưu Thành Công");

        return "showDanhMuc";
    }

    @RequestMapping("/searchDanhMuc")
    public String searchDanhMuc(Model model, @RequestParam("name") String name) {

        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        try {

            l = dMMSP.searchDM(name);
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("l", l);

        return "showDanhMuc";
    }

    @RequestMapping("/addDanhMuc")
    public String updateDanhMuc(Model model) {

        DanhMucSP dm = new DanhMucSP();
        model.addAttribute("dm", dm);

        return "AddDanhMuc";
    }

    @RequestMapping("/saveAddDanhMuc")
    public String saveAddDanhMuc(Model model, @ModelAttribute DanhMucSP dm) {

        try {
            dMMSP.insertDM(dm);
            List<DanhMucSP> l = new ArrayList<DanhMucSP>();
            l = dMMSP.showDM();
            model.addAttribute("l", l);
            model.addAttribute("informDanhMuc", "Thêm Thành Công");
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "showDanhMuc";
    }

}
