/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Toan
 */
public class Connector {
     public Connection getConnection() throws ClassNotFoundException, SQLException{
       
        Class.forName("com.mysql.jdbc.Driver");
        String connStr="jdbc:mysql://localhost:3306/webbh?characterEncoding=UTF-8";
        Connection conn = DriverManager.getConnection(connStr,"root","Toan0167");
        
        return conn;
    }
}
