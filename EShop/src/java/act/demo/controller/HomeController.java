/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.ChiTietDT;
import act.demo.dto.ChiTietMT;
import act.demo.dto.Customer;
import act.demo.dto.DanhMucSP;
import act.demo.dto.GioHang;

import act.demo.dto.LienHe;
import act.demo.dto.Product;

import act.demo.model.LienHeManager;
import act.demo.model.ManagerCustomer;

import act.demo.model.ManagerDMSP;
import act.demo.model.ManagerProduct;
import act.demo.model.chiTietManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
@Controller
public class HomeController {

    ManagerDMSP dMMSP = new ManagerDMSP();
    ManagerProduct mp = new ManagerProduct();
    chiTietManager ct = new chiTietManager();
    ManagerCustomer mc = new ManagerCustomer();
    LienHeManager lhmn = new LienHeManager();

    @RequestMapping("/")
    public String home(Model model) {
        try {

            LienHe lh = lhmn.show();
            model.addAttribute("lh", lh);

            List<Product> lsp = new ArrayList<>();

            lsp = mp.showProduct(8, 0);
            model.addAttribute("lsp", lsp);

            List<DanhMucSP> l = new ArrayList<DanhMucSP>();
            l = dMMSP.showDM();

            model.addAttribute("l", l);
            Customer c = new Customer();
            Product p = new Product();
            model.addAttribute("c", c);
            model.addAttribute("p", p);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    @RequestMapping("/SearchDM")
    public String SearchDM(Model model, @ModelAttribute("p") Product p, @ModelAttribute(value = "c") Customer c, @RequestParam("id") int madm) throws SQLException {
        List<Product> lsp = mp.searchDM(madm);//list product theo ma dm
        model.addAttribute("lsp", lsp);
        System.out.println("madm" + madm);

        model.addAttribute("maDM", madm);
        List<String> lram = ct.listRam(madm);//list cac chi tiet
        List<String> lrom = ct.listRom(madm);
        List<String> lcpu = ct.listCPU(madm);
        List<String> lhdh = ct.listHDH(madm);
        List<String> lmh = ct.listManHinh(madm);
        List<String> cdh = ct.listCDH(madm);
        List<String> lsim = ct.listSim(madm);
        List<String> lcameraT = ct.listcameraT(madm);
        List<String> lcameraS = ct.listcameraS(madm);
        model.addAttribute("lram", lram);
        model.addAttribute("lrom", lrom);
        model.addAttribute("lcpu", lcpu);
        model.addAttribute("lhdh", lhdh);
        model.addAttribute("lmh", lmh);
        model.addAttribute("cdh", cdh);
        model.addAttribute("lsim", lsim);
        model.addAttribute("lcameraT", lcameraT);
        model.addAttribute("lcameraS", lcameraS);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        LienHe lh = lhmn.show();//footer
        model.addAttribute("lh", lh);

        return "index2";
    }

    @RequestMapping("/sanpham")
    public String sanpham() {

        return "index";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("p") Product p, @ModelAttribute(value = "c") Customer c, Model model) {
        try {
            List<DanhMucSP> l = new ArrayList<DanhMucSP>();
            List<Product> lsp = new ArrayList<>();
            lsp = mp.search(p.getName());
            LienHe lh = lhmn.show();
            model.addAttribute("lh", lh);
            l = dMMSP.showDM();
            model.addAttribute("l", l);
            model.addAttribute("lsp", lsp);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute(value = "p") Product p, @ModelAttribute(value = "c") Customer c, HttpSession session, Model model) throws SQLException {
        Customer c1;
        c1 = mc.Login(c.getEmail(), c.getPassword());

        session.setAttribute("name", c1.getName());
        session.setAttribute("makh", c1.getMaKH());
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);
        return "index";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute(value = "p") Product p, @ModelAttribute(value = "c") Customer c, Model model, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("sexx") String gender) throws SQLException {

        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();

        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        c.setName(name);
        c.setEmail(email);
        c.setGender(gender);
        c.setPhone(phone);
        c.setPassword(password);
        model.addAttribute("check", "Đăng Ký Thành Công");
        try {
            mc.addCustomer(c);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    @RequestMapping("/DangXuat")
    public String dangxuat(@ModelAttribute(value = "p") Product p, @ModelAttribute(value = "c") Customer c, HttpSession session, Model model) throws SQLException {
        session.removeAttribute("name");
        session.removeAttribute("makh");
        session.removeAttribute("cart");
        session.removeAttribute("soluong");
        session.removeAttribute("money");

        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();
        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        return "index";
    }

    @RequestMapping("/deleteCart")
    public String deleteCart(@ModelAttribute(value = "p") Product p, @ModelAttribute(value = "c") Customer c, HttpSession session, @RequestParam("id") int masp, Model model) throws JsonProcessingException, SQLException {
        System.out.println("ma sp : " + masp);
        if (session.getAttribute("cart") != null) {
            List<GioHang> l = new ArrayList<GioHang>();
            System.out.println("1");
            l = (List<GioHang>) session.getAttribute("cart");
            System.out.println("2");
            int soluong = (int) session.getAttribute("soluong");
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getMaSP() == masp) {
                    l.remove(i);
                }

            }
            int money = 0;
            for (GioHang gh : l) {
                money = money + (mp.Cartmoney(gh.getMaSP()) * gh.getSoLuong());
            }
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String oldPrice = currencyVN.format(money);
            session.setAttribute("money", oldPrice);
            LienHe lh = lhmn.show();
            model.addAttribute("lh", lh);
            System.out.println("soluong : " + soluong);
            session.setAttribute("cart", l);
            model.addAttribute("masp", masp);
            session.setAttribute("soluong", soluong - 1);
        }
        return "index";
    }

    @RequestMapping("/myAcount")
    public String myAcount(@ModelAttribute(value = "p") Product p, Model model, @ModelAttribute(value = "c") Customer c, @RequestParam("id") int makh) throws SQLException {
        try {
            c = new Customer();
            Customer c1 = new Customer();
            c1 = mc.search(makh);
            model.addAttribute("c1", c1);
            model.addAttribute("c", c);
            List<DanhMucSP> l = new ArrayList<DanhMucSP>();
            List<Product> lsp = new ArrayList<>();

            lsp = mp.showProduct();
            l = dMMSP.showDM();
            model.addAttribute("l", l);
            model.addAttribute("lsp", lsp);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        return "MyAcount";
    }

    @RequestMapping("/updateAcount")
    public String updateAcount(@ModelAttribute(value = "p") Product p, HttpSession session, Model model, @ModelAttribute(value = "c") Customer c, @RequestParam("sexx") String gender) throws SQLException {
        c.setGender(gender);
        System.out.println("gender" + gender);
        System.out.println("" + c);
        mc.updateAcount(c);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);
        session.setAttribute("name", c.getName());
        model.addAttribute("check", "cập nhật thành công");

        return "index";
    }

    @RequestMapping("/ChiTietProduct")
    public String ChiTietProduct(@ModelAttribute(value = "p") Product p, Model model, @ModelAttribute(value = "c") Customer c, @RequestParam("id") int masp) throws SQLException {
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();//list danh muc
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        LienHe lh = lhmn.show();//footer
        model.addAttribute("lh", lh);

        List<Product> lsp = new ArrayList<>();

        lsp = mp.showProductCT(masp);
        model.addAttribute("lsp", lsp);
        model.addAttribute("maSP", masp);

        String ram = ct.showRamSP(masp);//list cac chi tiet
        String rom = ct.showRomSP(masp);
        System.out.println("rom" + rom);
        String cpu = ct.showCPUSP(masp);
        String hdh = ct.showHDHSP(masp);
        String mh = ct.showManHinhSP(masp);
        String cdh = ct.showCDHSP(masp);
        String sim = ct.showSimSP(masp);
        String cameraT = ct.showcameraTSP(masp);
        String cameraS = ct.showcameraSSP(masp);
        model.addAttribute("ram", ram);
        model.addAttribute("rom", rom);
        model.addAttribute("cpu", cpu);
        model.addAttribute("hdh", hdh);
        model.addAttribute("mh", mh);
        model.addAttribute("cdh", cdh);
        model.addAttribute("sim", sim);
        model.addAttribute("cameraT", cameraT);
        model.addAttribute("cameraS", cameraS);

        return "ChiTietProduct";
    }

}
