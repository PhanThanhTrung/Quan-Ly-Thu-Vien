/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Truong Tran
 */
public class Connections {
    private static String url="jdbc:sqlserver://localhost:1433;databaseName=ThuVienBaoNgoc;";
    private static String user="Truong1";
    private static String pass="1234";
    
    public static Connection getConnection()
    {
        Connection con =null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Connect successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    
    
         
    
    
}
