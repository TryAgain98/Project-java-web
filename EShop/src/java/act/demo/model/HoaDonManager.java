/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.model;

import act.demo.DB.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toan
 */
public class HoaDonManager {

    private Connection conn;

    public HoaDonManager() {
        Connector db = new Connector();
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addHoaDon(int masp, int makh, int soluong, int price) throws SQLException {
        String sql = "insert into donhang(makh,masp,soluong,price) values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, makh);
        ps.setInt(2, masp);
        ps.setInt(3, soluong);
        ps.setInt(4, price);
        ps.executeUpdate();
    }

}
