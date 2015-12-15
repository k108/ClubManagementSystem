/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClubManager.services;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hp
 */
public class ConnectDB {

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///cluborganiser", "root", "");
        } catch (Exception ex) {
            System.out.println("In Creating Connection():" + ex);
        }
        return conn;

    }

}
