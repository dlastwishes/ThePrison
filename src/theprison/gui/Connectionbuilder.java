/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theprison.gui;

import java.sql.*;

/**
 *
 * @author int105
 */
public class Connectionbuilder {
    public static int count=0;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        final String host = "jdbc:derby://localhost:1527/theprison";
        final String uName = "prison";
        final String uPass = " ";
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        System.out.println("Driver loaded");

        Connection con = DriverManager.getConnection(host, uName, uPass);
        System.out.println("Connection created");
        count++;
        System.out.println(count);
        return con;
    }

}
