/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.LienHe;
import act.demo.model.LienHeManager;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Toan
 */
@Controller
public class LienHeController {
    LienHeManager lhmn=new LienHeManager();
    @RequestMapping("/LienHe")
    public String LienHe(Model model) throws SQLException{
        LienHe lh=lhmn.show();
        model.addAttribute("lh", lh);
        return "LienHe";
    }
    
    @RequestMapping("/saveLienHe")
    public String saveLienHe(Model model,@ModelAttribute("lh") LienHe lh) throws SQLException{
        lhmn.update(lh);
        
        
        lh=lhmn.show();
        model.addAttribute("lh", lh);
        return "LienHe";
    }
    
}
