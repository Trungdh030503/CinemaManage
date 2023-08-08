/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author int.thong.nk
 */
public class DBcontext {

    protected Connection connection;

    public DBcontext() {
        try {
            String user = "root";
            String pass = "1234567";
            String url = "jdbc:mysql://localhost:3306/cinema_test";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DBcontext db = new DBcontext();
        System.out.println(db.connection);
    }
}
