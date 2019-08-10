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
import java.util.ArrayList;

/**
 *
 * @author Phan Thanh Trung
 */
public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;

    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public NhaXuatBan() {
    }

    public NhaXuatBan(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
    }
    
    public static ArrayList<String> getDanhSachNXB()
    {
        ArrayList<String> arr= new ArrayList<>();
        Connection con= Connections.getConnection();
        try{
            String sql="select NHAXUATBAN.TenNXB from NHAXUATBAN;";
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet res= stm.executeQuery();
            while(res.next())
            {
                arr.add(res.getString(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arr;
    }
    public static String layMaNXB(String tenNXB){
        Connection con= Connections.getConnection();
        try{
            String sql="select NHAXUATBAN.MaNXB from NHAXUATBAN where NHAXUATBAN.TenNXB=?;";
            PreparedStatement stm= con.prepareStatement(sql);
            stm.setString(1,tenNXB);
            ResultSet res= stm.executeQuery();
            while(res.next())
            {
                return res.getString(1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
