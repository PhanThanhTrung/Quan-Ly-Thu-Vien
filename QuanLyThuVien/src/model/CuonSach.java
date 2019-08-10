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
public class CuonSach {
    private String  maCuonSach;
    private String  tenCuonSach;
    private String  TuaSach;
    private Boolean tinhTrang;
    private String  maTheLoai;
    private String  maTacGia;
    private String  maNXB;

    public String getTuaSach() {
        return TuaSach;
    }

    public void setTuaSach(String TuaSach) {
        this.TuaSach = TuaSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }
    
    
    
    public String getMaCuonSach() {
        return maCuonSach;
    }

    public String getTenCuonSach() {
        return tenCuonSach;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setMaCuonSach(String maCuonSach) {
        this.maCuonSach = maCuonSach;
    }

    public void setTenCuonSach(String tenCuonSach) {
        this.tenCuonSach = tenCuonSach;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public CuonSach() {
    }

    @Override
    public String toString() {
        return "CuonSach{" + "maCuonSach=" + maCuonSach + ", tenCuonSach=" + tenCuonSach + ", TuaSach=" + TuaSach + ", tinhTrang=" + tinhTrang + ", maTheLoai=" + maTheLoai + ", maTacGia=" + maTacGia + ", maNXB=" + maNXB + '}';
    }
       
    public static String timMaSach(String tenCuonSach)
    {
        String ans=null;
        Connection con= Connections.getConnection();
        try{
            String query= "select MaCuonSach from CUONSACH where CUONSACH.TenCuonSach =?;";
            PreparedStatement stm= con.prepareStatement(query);
            stm.setString(1, tenCuonSach);
            ResultSet res =stm.executeQuery();
            while(res.next())
            {
                ans = res.getString(1);
            }
        } 
        catch(Exception e)
        {
            e.fillInStackTrace();
        }
        return ans;
    }
    
    public static boolean checkMaSach(String maSach)
    {
        Connection con= Connections.getConnection();
        try{
            String query= "select MaCuonSach from CUONSACH;";
            PreparedStatement stm= con.prepareStatement(query);
            ResultSet res =stm.executeQuery();
            while(res.next())
            {
                if(maSach==res.getString(1))
                    return false;
            }
        } 
        catch(Exception e)
        {
            e.fillInStackTrace();
        }
        return true;
    }
    public static String maCuonSachTuTang()
    {
        int maxIndex=-1;
        Connection con= Connections.getConnection();
        try{
            String query= "select MaCuonSach from CUONSACH;";
            PreparedStatement stm= con.prepareStatement(query);
            ResultSet res =stm.executeQuery();
            while(res.next())
            {
                maxIndex=Math.max(maxIndex, Integer.parseInt(res.getString(1).substring(3)));
            }
        } 
        catch(Exception e)
        {
            e.fillInStackTrace();
        }
        return "MCS"+(maxIndex+1);
    }
    
    
    public static boolean themCuonSach(String maSach, String tenSach, boolean tinhTrang, String maTG,String maNXB, String tuaSach, String maTheLoai){
       Connection con = Connections.getConnection();
        try{
            String query="insert into CUONSACH (MaCuonSach,TenCuonSach,TinhTrang,MaTacGia,MaNXB,TuaSach,MaTheLoai)"
                    + " values(?,?,?,?,?,?,?);";
            PreparedStatement stm= con.prepareStatement(query);
            stm.setString(1,maSach);
            stm.setString(2,tenSach);
            stm.setBoolean(3,tinhTrang);
            stm.setString(4,maTG);
            stm.setString(5,maNXB);
            stm.setString(6,tuaSach);
            stm.setString(7,maTheLoai);
            stm.executeUpdate();
            return true; //them thanh cong
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false; // them that bai 
    }        
    public static boolean xoaCuonSach(String maSach)
    {
        Connection con = Connections.getConnection();
        try{
            String sql="delete CUONSACH where CUONSACH.MaCuonSach=?;";
            PreparedStatement stm= con.prepareStatement(sql);
            stm.setString(1,maSach);
            stm.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
