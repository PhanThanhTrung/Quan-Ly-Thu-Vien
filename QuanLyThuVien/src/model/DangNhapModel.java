/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Connections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Truong Tran
 */
public class DangNhapModel {
    
    public static boolean DangNhap(String username, String password)
    {
        Connection con = Connections.getConnection();
        try {
            String sql ="SELECT * FROM DANGNHAP WHERE username=? AND upass=?;";
            PreparedStatement prs = con.prepareStatement(sql);
            prs.setString(1,username);
            prs.setString(2,password);
            ResultSet rs = prs.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
