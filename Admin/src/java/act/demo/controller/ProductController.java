/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.ChiTietDT;
import act.demo.dto.ChiTietMT;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Toan
 */
@Controller
public class ProductController {

    ManagerDMSP dMMSP = new ManagerDMSP();//danhmuc
    ManagerProduct mp = new ManagerProduct();//san pham
    chiTietManager ct = new chiTietManager();//chi tiet san pham
    ManagerCustomer mc = new ManagerCustomer();//khach hang

    @RequestMapping("/showProduct")
    public String showProduct(Model model) throws SQLException {
        List<Product> lp = mp.showProduct();
        model.addAttribute("lp", lp);

        return "showProduct";
    }
    
     @RequestMapping("/searchProduct")
    public String searchProduct(Model model,@RequestParam("name") String name) throws SQLException {
        List<Product> lp = mp.search(name);
        model.addAttribute("lp", lp);

        return "showProduct";
    }
    
    

    @RequestMapping("/updateProduct")
    public String updateProduct(Model model, @RequestParam("id") int masp) throws SQLException {
        List<Product> lsp = mp.showProductUpdate(masp);
        model.addAttribute("lsp", lsp);
        String check = ct.check(masp);
        ChiTietMT ctmt1 = new ChiTietMT();
        model.addAttribute("ctmt", ctmt1);
        Product p = new Product();
        model.addAttribute("p", p);

        DanhMucSP dmsp = new DanhMucSP();
        dmsp = dMMSP.showDMmaSP(masp);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("dmsp", dmsp);

        if (check.equals("dt")) {

            ChiTietDT chiTietDT = ct.showChiTietDT(masp);
            model.addAttribute("ctmt", chiTietDT);

            return "updateDienThoai";
        } else if (check.equals("mt")) {
            ChiTietMT ctmt = ct.showChiTietMT(masp);
            model.addAttribute("ctmt", ctmt);

            return "updateMayTinh";
        }

        return "updateProduct";
    }

    @RequestMapping("/addDienThoai")
    public String addDienThoai(Model model) throws SQLException {
        Product p = new Product();
        model.addAttribute("p", p);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);

        return "addDienThoai";
    }

    @RequestMapping("/addMayTinh")
    public String addMayTinh(Model model) throws SQLException {
        Product p = new Product();
        model.addAttribute("p", p);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);

        return "addMayTinh";
    }

    @RequestMapping("/saveAddDienThoai")
    public String saveAddDienThoai(Model model, @ModelAttribute("p") Product p, @RequestParam("madm") int madm, @RequestParam("ram") String ram,
            @RequestParam("rom") String rom, @RequestParam("cpu") String cpu, @RequestParam("heDH") String hdh,
            @RequestParam("manHinh") String mh, @RequestParam("sim") String sim, @RequestParam("cameraT") String cameraT,
            @RequestParam("cameraS") String cameraS) throws SQLException {
        p.setMaDM(madm);
        System.out.println(p);

        mp.addProduct(p);
        System.out.println(ram + rom + cpu + hdh + mh + cameraT + cameraS + sim);
        ct.addChiTietDT(ram, rom, cpu, hdh, mh, cameraT, cameraS, sim);
        Product p1=new Product();
        model.addAttribute("p", p1);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        return "addDienThoai";
    }

    @RequestMapping("/saveAddMayTinh")
    public String saveAddMayTinh(Model model, @ModelAttribute("p") Product p, @RequestParam("madm") int madm, @RequestParam("ram") String ram,
            @RequestParam("rom") String rom, @RequestParam("cpu") String cpu, @RequestParam("heDH") String hdh,
            @RequestParam("manHinh") String mh, @RequestParam("cdh") String cdh) throws SQLException {
        p.setMaDM(madm);
        System.out.println(p);

        mp.addProduct(p);

        ct.addChiTietMT(ram, rom, cpu, hdh, mh, cdh);

        Product p1=new Product();
        model.addAttribute("p", p1);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        return "addMayTinh";
    }

    @RequestMapping("/saveUpdateMayTinh")
    public String saveUpdateMayTinh(
            Model model, @ModelAttribute("p") Product p, @RequestParam("madm") int madm, @RequestParam("ram") String ram,
            @RequestParam("rom") String rom, @RequestParam("cpu") String cpu, @RequestParam("heDH") String hdh,
            @RequestParam("manHinh") String mh, @RequestParam("cardDH") String cdh, @RequestParam("img") String img) throws SQLException {
        p.setMaDM(madm);

        if (p.getImage().equals("")) {

            p.setImage(img);
        }

        mp.updateProduct(p);

        ct.updateMayTinh(ram, rom, cpu, hdh, mh, cdh, p.getMaSP());

        List<Product> lsp = mp.showProductUpdate(p.getMaSP());
        model.addAttribute("lsp", lsp);
        String check = ct.check(p.getMaSP());
        ChiTietMT ctmt1 = new ChiTietMT();
        model.addAttribute("ctmt", ctmt1);
        model.addAttribute("p", p);

        DanhMucSP dmsp = new DanhMucSP();
        dmsp = dMMSP.showDMmaSP(p.getMaSP());
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("dmsp", dmsp);

        ChiTietMT ctmt = ct.showChiTietMT(p.getMaSP());
        model.addAttribute("ctmt", ctmt);

        return "updateMayTinh";

    }

    @RequestMapping("/saveUpdateDienThoai")
    public String saveUpdateDienThoai(
            Model model, @ModelAttribute("p") Product p, @RequestParam("madm") int madm, @RequestParam("ram") String ram,
            @RequestParam("rom") String rom, @RequestParam("cpu") String cpu, @RequestParam("heDH") String hdh,
            @RequestParam("manHinh") String mh, @RequestParam("cameraT") String cameraT, @RequestParam("img") String img,
            @RequestParam("cameraS") String cameraS, @RequestParam("sim") String sim
    ) throws SQLException {
        p.setMaDM(madm);

        if (p.getImage().equals("")) {

            p.setImage(img);
        }

        mp.updateProduct(p);
        ct.updateChiTietDT(ram, rom, cpu, hdh, mh, cameraT, cameraS, sim, p.getMaSP());
        
        

        List<Product> lsp = mp.showProductUpdate(p.getMaSP());
        model.addAttribute("lsp", lsp);
        String check = ct.check(p.getMaSP());
        ChiTietMT ctmt1 = new ChiTietMT();
        model.addAttribute("ctmt", ctmt1);
   
        model.addAttribute("p", p);

        DanhMucSP dmsp = new DanhMucSP();
        dmsp = dMMSP.showDMmaSP(p.getMaSP());
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("dmsp", dmsp);

        ChiTietDT chiTietDT = ct.showChiTietDT(p.getMaSP());
        model.addAttribute("ctmt", chiTietDT);

        return "updateDienThoai";

    }

    
     @RequestMapping("/deleteProduct")
    public String deleteProduct(Model model,@RequestParam("id") int masp) throws SQLException {
          ManagerDonHang mdh=new ManagerDonHang();
          mdh.deleteDonHangMaSP(masp);
        ct.deleteChiTiet(masp);
        mp.deleteProduct(masp);
        

        List<Product> lp = mp.showProduct();
        model.addAttribute("lp", lp);

        return "showProduct";
    }
    
}
