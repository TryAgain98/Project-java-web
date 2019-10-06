/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.Customer;
import act.demo.dto.DanhMucSP;
import act.demo.dto.LienHe;
import act.demo.dto.Product;
import act.demo.model.LienHeManager;
import act.demo.model.ManagerCustomer;
import act.demo.model.ManagerDMSP;
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
public class chiTietController {

    ManagerDMSP dMMSP = new ManagerDMSP();
    ManagerProduct mp = new ManagerProduct();
    chiTietManager ct = new chiTietManager();
    ManagerCustomer mc = new ManagerCustomer();
    LienHeManager lhmn = new LienHeManager();

    @RequestMapping("/SearchCTRam")
    public String SearchCTRam(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String ram) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietRam(madm, ram);
        model.addAttribute("lsp", lsp);

        return "index2";
    }
    
    @RequestMapping("/SearchCTRom")
    public String SearchCTRom(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String ram) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietRom(madm, ram);
        model.addAttribute("lsp", lsp);

        return "index2";
    }
    
     @RequestMapping("/SearchCTCPU")
    public String SearchCTCPU(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String cpu) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietCPU(madm, cpu);
        model.addAttribute("lsp", lsp);

        return "index2";
    }
      @RequestMapping("/SearchCTHDH")
    public String SearchCTHDH(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String hdh) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietHDH(madm, hdh);
        model.addAttribute("lsp", lsp);

        return "index2";
    }

      @RequestMapping("/SearchCTMH")
    public String SearchCTMH(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String mh) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietMH(madm, mh);
        model.addAttribute("lsp", lsp);

        return "index2";
    }
      @RequestMapping("/SearchCTSim")
    public String SearchCTSim(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String sim) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietSim(madm, sim);
        model.addAttribute("lsp", lsp);

        return "index2";
    }

     @RequestMapping("/SearchCTCameraT")
    public String SearchCTCameraT(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String CameraT) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietCameraT(madm, CameraT);
        model.addAttribute("lsp", lsp);

        return "index2";
    }

      @RequestMapping("/SearchCTCameraS")
    public String SearchCTCameraS(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String CameraS) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietCameraS(madm, CameraS);
        model.addAttribute("lsp", lsp);

        return "index2";
    }

     @RequestMapping("/SearchCTCDH")
    public String SearchCTCDH(Model model,@ModelAttribute("p") Product p,@ModelAttribute(value = "c") Customer c, @RequestParam("madm") int madm, @RequestParam("id") String cdh1) throws SQLException {
        model.addAttribute("maDM", madm);//
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
        model.addAttribute("lh", lh);/// bat buoc can lấy : footer,list danh mục,list chi tiết,ma danh mục

        List<Product> lsp = mp.searchChiTietCDH(madm, cdh1);
        model.addAttribute("lsp", lsp);

        return "index2";
    }
}
