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
 * @author Phan Thanh Trung
 */
public class TheLoai {
    private String maTheLoai;
    private String tenLoaiSach;

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public String getTenLoaiSach() {
        return tenLoaiSach;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public void setTenLoaiSach(String tenLoaiSach) {
        this.tenLoaiSach = tenLoaiSach;
    }

    public TheLoai() {
    }

    public TheLoai(String maTheLoai, String tenLoaiSach) {
        this.maTheLoai = maTheLoai;
        this.tenLoaiSach = tenLoaiSach;
    }

    @Override
    public String toString() {
        return "TheLoai{" + "maTheLoai=" + maTheLoai + ", tenLoaiSach=" + tenLoaiSach + '}';
    }
    
    public static String checkTenTheLoai(String tenTheLoai){
        // trả về true nếu như tên thể loại không có trong bảng THELOAI  ngược lại trả về false
        Connection con = Connections.getConnection();
        try{
            String query="select MaTheLoai from THELOAI where THELOAI.TenLoaiSach = ?;";
            PreparedStatement stm= con.prepareStatement(query);
            stm.setString(1, tenTheLoai);
            ResultSet res= stm.executeQuery();
            if(res.wasNull())
            {
                return null;
            }
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
    
    public static String newMaTheLoai()
    {
        int maxIndex=-1;
        Connection con = Connections.getConnection();
        try{
            String query="select MaTheLoai from THELOAI;";
            PreparedStatement stm= con.prepareStatement(query);
            ResultSet res= stm.executeQuery();
            while(res.next())
            {
                maxIndex=Math.max(maxIndex,Integer.parseInt(res.getString(1).substring(3)));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "MTL"+(maxIndex+1);
    }
    
    public static int newSTT()
    {
        int maxSTT=-1;
        Connection con = Connections.getConnection();
        try{
            String query="select STT from THELOAI;";
            PreparedStatement stm= con.prepareStatement(query);
            ResultSet res= stm.executeQuery();
            while(res.next())
            {
                maxSTT=Math.max(maxSTT,res.getInt(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return maxSTT+1;
    }
    public static boolean themTheLoai(TheLoai newTL)
    {
        Connection con = Connections.getConnection();
        try{
            String query="insert into THELOAI (STT,MaTheLoai,TenLoaiSach) values(?,?,?);";
            PreparedStatement stm= con.prepareStatement(query);
            stm.setInt(1, TheLoai.newSTT());
            stm.setString(2, newTL.getMaTheLoai());
            stm.setString(3, newTL.getTenLoaiSach());
            stm.execute();
            return true; //them thanh cong
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false; // them that bai
    }
}
