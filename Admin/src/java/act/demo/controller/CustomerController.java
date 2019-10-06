/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.Customer;
import act.demo.dto.Product;
import act.demo.model.ManagerCustomer;
import act.demo.model.ManagerDMSP;
import act.demo.model.ManagerProduct;
import act.demo.model.chiTietManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Toan
 */
@Controller
public class CustomerController {
     ManagerDMSP dMMSP = new ManagerDMSP();//danhmuc
    ManagerProduct mp = new ManagerProduct();//san pham
    chiTietManager ct = new chiTietManager();//chi tiet san pham
    ManagerCustomer mc = new ManagerCustomer();//khach hang

    @RequestMapping("/KhachHang")
    public String showProduct(Model model) throws SQLException {
        List<Customer> l=new ArrayList<>();
        l=mc.showCustomer();
        model.addAttribute("l", l);

        return "KhachHang";
    }

}
