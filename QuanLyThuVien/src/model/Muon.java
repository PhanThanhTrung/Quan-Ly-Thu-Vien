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
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Phan Thanh Trung
 */
public class Muon {
    private String maMuon;
    private String maDocGia;
    private String maCuonSach;
    private int    soLuong;
    private Date   ngayMuon;
    private Date   ngayHenTra;
    private Date   ngayTra;
    private String ghiChu;
    public String getMaMuon() {
        return maMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getMaCuonSach() {
        return maCuonSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public Date getNgayHenTra() {
        return ngayHenTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaMuon(String maMuon) {
        this.maMuon = maMuon;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public void setMaCuonSach(String maCuonSach) {
        this.maCuonSach = maCuonSach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setNgayHenTra(Date ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Muon() {
    }

    public Muon(String maMuon, String maDocGia, String maCuonSach, int soLuong, Date ngayMuon, Date ngayHenTra, Date ngayTra, String ghiChu) {
        this.maMuon = maMuon;
        this.maDocGia = maDocGia;
        this.maCuonSach = maCuonSach;
        this.soLuong = soLuong;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
    }
    // your code goes here
    
    
    public static int layMaMuon()
    {
        Connection con = Connections.getConnection();
        int ans=-1;
        try{
            String query="select MaMuon from MUON;";
            PreparedStatement stm= con.prepareStatement(query);
            ResultSet res = stm.executeQuery();
            while(res.next()){
                String str=res.getString(1).substring(1);
                int value = Integer.parseInt(str);
                ans=Math.max(value,ans);
            }
        }
        catch(SQLException e)
        {
            e.fillInStackTrace();
        }
        return ans;
    }
    
    public static Boolean checkMaMuon(String maMuon){
        Connection con= Connections.getConnection();
        try{
            String query = "select MaMuon from MUON;";
            PreparedStatement stm= con.prepareStatement(query);
            ResultSet res= stm.executeQuery();
            while(res.next())
            {
                if(maMuon == res.getString(1))
                {
                    return false;
                }
            }
            return true;
        }
        catch(Exception e)
        {
            e.fillInStackTrace();
        }
        return null;
    }
    public static String maMuonTuTang(){
        String ans="";
        int lastBorrowID=layMaMuon();
        
        return "M"+Integer.toString(lastBorrowID);
    }
    
    public static String[] danhSachTenSach()
    {
        String[] danhSachTen= new String[100000];
        int index=0;
       try{
            Connection con = Connections.getConnection();
            String query= "select TenCuonSach from CUONSACH;";
            PreparedStatement stm= con.prepareStatement(query);
        
            ResultSet res= stm.executeQuery();
            while(res.next())
            {
                danhSachTen[index]=res.getString(1);
                index+=1;
            }
       }
       catch(Exception e)
       {
           e.fillInStackTrace();
       }
       if(index==0)
       {
           return null;
       }
       return danhSachTen;
    }
    
    
    
    public static Boolean themBangMuon(String maMuon,String maDocGia,String tenCuonSach, int soLuong, Date ngayMuon, Date ngayHienTai,Date ngayTra,String ghiChu) {
        // [MaMuon],[MaDocGia],[MaCuonSach],[SoLuong],[NgayMuon],[NgayHenTra],[NgayTra],[GhiChu]
        String maCuonSach=CuonSach.timMaSach(tenCuonSach);
        if(maCuonSach!=null)
        {   
            Connection con = Connections.getConnection();
            try{
                String query="insert into MUON (MaMuon,MaDocGia,MaCuonSach,SoLuong,NgayMuon,NgayHenTra,NgayTra,Ghichu) value(?,?,?,?,?,?,?,?);";
                PreparedStatement stm= con.prepareStatement(query);
                stm.setString(1,maMuon);
                stm.setString(2,maDocGia);
                stm.setString(3,maCuonSach);
                stm.setInt(4,soLuong);
                stm.setDate(5, (java.sql.Date) ngayMuon);
                stm.setDate(6, (java.sql.Date) ngayHienTai);
                stm.setDate(7, (java.sql.Date) ngayTra);
                stm.setString(8,ghiChu);
                stm.execute();
                return true;
            }
            catch(Exception e)
            {
                e.fillInStackTrace();
            }
        }
        return false;
    }
}
