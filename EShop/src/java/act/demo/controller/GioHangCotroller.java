/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

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
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Toan
 */
@Controller
public class GioHangCotroller {

    ManagerDMSP dMMSP = new ManagerDMSP();
    ManagerProduct mp = new ManagerProduct();
    chiTietManager ct = new chiTietManager();
    ManagerCustomer mc = new ManagerCustomer();
    LienHeManager lhmn = new LienHeManager();

    @RequestMapping("/gioHang")
    public String gioHang(@ModelAttribute("p") Product p, Model model, @ModelAttribute("c") Customer c) throws SQLException {
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();
        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        return "GioHang";
    }

    @RequestMapping("/TruGioHang")
    public String deleteCart(@ModelAttribute(value = "p") Product p, @ModelAttribute(value = "c") Customer c, HttpSession session, @RequestParam("id") int masp, Model model) throws JsonProcessingException, SQLException {
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();
        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);

        List<GioHang> lgh = (List<GioHang>) session.getAttribute("cart");
        for (GioHang gh : lgh) {
            if (gh.getMaSP() == masp) {
                int soluong = gh.getSoLuong();
                if (soluong > 1) {
                    soluong = soluong - 1;
                }
                gh.setSoLuong(soluong);
            }
        }
        int money = 0;
        for (GioHang gh : lgh) {
            money = money + (mp.Cartmoney(gh.getMaSP()) * gh.getSoLuong());
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String oldPrice = currencyVN.format(money);
        session.setAttribute("money", oldPrice);
        session.setAttribute("cart", lgh);

        return "GioHang";
    }

    @RequestMapping("/CongGioHang")
    public String CongGioHang(@ModelAttribute(value = "p") Product p, @ModelAttribute(value = "c") Customer c, HttpSession session, @RequestParam("id") int masp, Model model) throws JsonProcessingException, SQLException {
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();
        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);

        List<GioHang> lgh = (List<GioHang>) session.getAttribute("cart");
        for (GioHang gh : lgh) {
            if (gh.getMaSP() == masp) {
                int soluong = gh.getSoLuong();
                if (soluong < gh.getMaxSoLuong()) {
                    soluong = soluong + 1;
                }
                gh.setSoLuong(soluong);
            }
        }

        int money = 0;
        for (GioHang gh : lgh) {
            money = money + (mp.Cartmoney(gh.getMaSP()) * gh.getSoLuong());
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String oldPrice = currencyVN.format(money);
        session.setAttribute("money", oldPrice);

        session.setAttribute("cart", lgh);

        return "GioHang";
    }
}
