/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.controller;

import act.demo.dto.Product;
import act.demo.model.ManagerProduct;
import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Toan
 */
@RestController
public class ApiController {
      ManagerProduct mp = new ManagerProduct();
    @RequestMapping("/product")
    public List<Product> getListproduct(@RequestParam("page") Integer page) throws SQLException{
        int limit=4;
        int offset=0;
        if(page != null){
            offset=(page-1) * limit;
        }
        
        return mp.showProduct(limit, offset);
    }
}
