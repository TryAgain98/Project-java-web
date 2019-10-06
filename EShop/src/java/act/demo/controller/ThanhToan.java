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
import act.demo.model.HoaDonManager;
import act.demo.model.LienHeManager;
import act.demo.model.ManagerCustomer;
import act.demo.model.ManagerDMSP;
import act.demo.model.ManagerProduct;
import act.demo.model.chiTietManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Toan
 */
@Controller
public class ThanhToan {

    ManagerDMSP dMMSP = new ManagerDMSP();
    ManagerProduct mp = new ManagerProduct();
    chiTietManager ct = new chiTietManager();
    ManagerCustomer mc = new ManagerCustomer();
    LienHeManager lhmn = new LienHeManager();

    @RequestMapping("/ThanhToan")

    public String gioHang(@ModelAttribute("p") Product p, Model model, HttpSession session, @ModelAttribute("c") Customer c) throws SQLException {
        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        List<Product> lsp = new ArrayList<>();
        lsp = mp.showProduct();
        l = dMMSP.showDM();
        model.addAttribute("l", l);
        model.addAttribute("lsp", lsp);
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);
        int makh = (int) session.getAttribute("makh");
        c = mc.search(makh);
        model.addAttribute("c", c);

        return "ThanhToan";

    }

    @RequestMapping("/saveThanhToan")
    public String saveThanhToan(@ModelAttribute("p") Product p, Model model, HttpSession session, @ModelAttribute("c") Customer c) throws SQLException {
        mc.updateAcountThanhToan(c);
        HoaDonManager mh = new HoaDonManager();
        if (session.getAttribute("cart") != null) {
            List<GioHang> lgh = (List<GioHang>) session.getAttribute("cart");
            int makh = (int) session.getAttribute("makh");
            for (GioHang gh : lgh) {
                int price;
                price = (mp.Cartmoney(gh.getMaSP()) * gh.getSoLuong());
                int soluong = gh.getSoLuong();
                int masp = gh.getMaSP();
                mp.DeleteSoLuong(masp, soluong);
                mh.addHoaDon(masp, makh, soluong, price);
            }
            session.removeAttribute("cart");
            session.removeAttribute("soluong");
            session.removeAttribute("money");
        }
        LienHe lh = lhmn.show();
        model.addAttribute("lh", lh);

        List<Product> lsp = new ArrayList<>();

        lsp = mp.showProduct();
        model.addAttribute("lsp", lsp);

        List<DanhMucSP> l = new ArrayList<DanhMucSP>();
        l = dMMSP.showDM();

        model.addAttribute("l", l);

        model.addAttribute("inform", "Thanh Toán Thành Công");
        return "index";
    }

}
