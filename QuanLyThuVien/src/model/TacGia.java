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
public class TacGia {
    private String maTacGia;
    private String tenTacGia;

    public String getMaTacGia() {
        return maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public TacGia() {
    }

    public TacGia(String maTacGia, String tenTacGia) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
    }
    
    public static String checkTenTacGia(String tenTacGia){
        // trả về true nếu như tên tác giả không có trong bảng TACGIA  ngược lại trả về false
        Connection con = Connections.getConnection();
        try{
            String query="select MaTacGia from TACGIA where TACGIA.TenTacGia= ?;";
            PreparedStatement stm= con.prepareStatement(query);
            stm.setString(1, tenTacGia);
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
    
    public static String newMaTacGia()
    {
        int maxIndex=-1;
        Connection con = Connections.getConnection();
        try{
            String query="select MaTacGia from TACGIA;";
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
        return "MTG"+(maxIndex+1);
    }
    
    public static int newSTT()
    {
        int maxSTT=-1;
        Connection con = Connections.getConnection();
        try{
            String query="select STT from TACGIA;";
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
    public static boolean themTacGia(TacGia newTG)
    {
        Connection con = Connections.getConnection();
        try{
            String query="insert into TACGIA (STT,MaTacGia,TenTacGia) values(?,?,?);";
            PreparedStatement stm= con.prepareStatement(query);
            stm.setInt(1, TacGia.newSTT());
            stm.setString(2, newTG.getMaTacGia());
            stm.setString(3, newTG.getTenTacGia());
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
