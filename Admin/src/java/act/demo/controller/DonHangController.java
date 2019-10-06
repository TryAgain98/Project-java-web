/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.Customer;
import act.demo.dto.DonHang;
import act.demo.dto.SanPhamDonHang;
import act.demo.model.ManagerCustomer;
import act.demo.model.ManagerDMSP;
import act.demo.model.ManagerDonHang;
import act.demo.model.ManagerProduct;
import act.demo.model.chiTietManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Toan
 */
@Controller
public class DonHangController {
      ManagerDMSP dMMSP = new ManagerDMSP();//danhmuc
    ManagerProduct mp = new ManagerProduct();//san pham
    chiTietManager ct = new chiTietManager();//chi tiet san pham
    ManagerCustomer mc = new ManagerCustomer();//khach hang
    ManagerDonHang mdh=new ManagerDonHang();

    @RequestMapping("/DHChuaGiao")
    public String showProduct(Model model) throws SQLException {
        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangChuaGiao();
        model.addAttribute("l", l);

        return "DHChuaGiao";
    }
    
    @RequestMapping("/deleteDonHang")
    public String deleteDonHang(Model model,@RequestParam("id") int makh) throws SQLException {
        mdh.deleteDonHang(makh);
        
        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangChuaGiao();
        model.addAttribute("l", l);

        return "DHChuaGiao";
    }
    
    @RequestMapping("/deleteDonHangDaGiao")
    public String deleteDonHangDaGiao(Model model,@RequestParam("id") int makh) throws SQLException {
        mdh.deleteDonHang(makh);
        
        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangDaGiao();
        model.addAttribute("l", l);

        return "DHDaGiao";
    }
    
    @RequestMapping("/updateDonHang")
    public String updateDonHang(Model model,@RequestParam("id") int makh) throws SQLException {
        
        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangMaKH(makh);
        model.addAttribute("l", l);
        
         List<SanPhamDonHang> lsp = new ArrayList<>();
         lsp=mp.showSanPhamDonHang(makh);
         model.addAttribute("lsp", lsp);
        return "UpdateDonHang";
    }
     @RequestMapping("/saveUpdateDonHang")
    public String saveUpdateDonHang(Model model,@RequestParam("giaoHang") String giaoHang,@RequestParam("makh") int makh) throws SQLException {
        
        mdh.updateDonHang(makh, giaoHang);

        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangChuaGiao();
        
        model.addAttribute("l", l);
        
        
        return "DHChuaGiao";
       
    }
    
     @RequestMapping("/DHDaGiao")
    public String DHDaGiao(Model model) throws SQLException {
        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangDaGiao();
        model.addAttribute("l", l);

        return "DHDaGiao";
    }
    @RequestMapping("/updateDonHangDaGiao")
    public String updateDonHangDaGiao(Model model,@RequestParam("id") int makh) throws SQLException {
        
        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangMaKH(makh);
        model.addAttribute("l", l);
        
         List<SanPhamDonHang> lsp = new ArrayList<>();
         lsp=mp.showSanPhamDonHang(makh);
         model.addAttribute("lsp", lsp);
        return "updateDonHangDaGiao";
    }
     @RequestMapping("/saveUpdateDonHangDaGiao")
    public String saveUpdateDonHangDaGiao(Model model,@RequestParam("giaoHang") String giaoHang,@RequestParam("makh") int makh) throws SQLException {
        
        mdh.updateDonHang(makh, giaoHang);

        List<DonHang> l=new ArrayList<>();
        l=mdh.showDonHangDaGiao();
        
        model.addAttribute("l", l);
        
        
        return "DHDaGiao";
       
    }
    
}
