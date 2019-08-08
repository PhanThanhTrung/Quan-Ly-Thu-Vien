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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Phan Thanh Trung
 */
public class Muon {
    private String maMuon;
    private String maDocGia;
    private String maCuonSach;
    private float    soLuong;
    private Date   ngayMuon;
    private Date   ngayHenTra;
    private Date   ngayTra;
    private String ghiChu;
    
    // được thêm vào: Trung
    private String tenCuonSach;
    public String getTenCuonSach() {
        return tenCuonSach;
    }

    public void setTenCuonSach(String TenCuonSach) {
        this.tenCuonSach = TenCuonSach;
    }
    
    public String getMaMuon() {
        return maMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getMaCuonSach() {
        return maCuonSach;
    }

    public float getSoLuong() {
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

    public void setSoLuong(float soLuong) {
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

    public Muon(String maMuon, String maDocGia, String maCuonSach, float soLuong, Date ngayMuon, Date ngayHenTra, Date ngayTra, String ghiChu) {
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
        
        return "M"+Integer.toString(lastBorrowID+1);
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
    
    
    
    public static Boolean themBangMuon(String maMuon,String maDocGia,String tenCuonSach, float soLuong, Date ngayMuon, Date ngayHenTra,Date ngayTra,String ghiChu) {
        // [MaMuon],[MaDocGia],[MaCuonSach],[SoLuong],[NgayMuon],[NgayHenTra],[NgayTra],[GhiChu]
        String maCuonSach=CuonSach.timMaSach(tenCuonSach);
        if(maCuonSach!=null)
        {   
            Connection con = Connections.getConnection();
            try{
                
                String query="insert into MUON (MaMuon,MaDocGia,MaCuonSach,SoLuong,NgayMuon,NgayHenTra,NgayTra,Ghichu) values(?,?,?,?,?,?,?,?);";
                PreparedStatement stm= con.prepareStatement(query);
                
                stm.setString(1,maMuon);
                
                stm.setString(2,maDocGia);
                stm.setString(3,maCuonSach);
                stm.setFloat(4,soLuong);
                java.sql.Timestamp ngayMuonStamp = new java.sql.Timestamp(ngayMuon.getTime());
                stm.setTimestamp(5, ngayMuonStamp);
                java.sql.Timestamp ngayHenTraStamp = new java.sql.Timestamp(ngayHenTra.getTime());
                stm.setTimestamp(6, ngayHenTraStamp);
                java.sql.Timestamp ngayTraStamp = new java.sql.Timestamp(ngayTra.getTime());
                stm.setTimestamp(7, ngayTraStamp);
                stm.setString(8,ghiChu);
                stm.execute();
                
                return true;
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
                e.fillInStackTrace();
            }
        }
        return false;
    }
    
    public static ArrayList<Muon> selectInfor()
    {
        ArrayList<Muon> arr= new ArrayList<>(100);
        int indexRow=0, indexColumn=0;
        String sql="select MUON.MaMuon,MUON.MaDocGia,CUONSACH.TenCuonSach,MUON.SoLuong,MUON.NgayMuon,MUON.NgayHenTra,MUON.NgayTra,MUON.GhiChu from MUON "
                + "inner join CUONSACH on MUON.MaCuonSach = CUONSACH.MaCuonSach;";
        try{
            Connection con= Connections.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            //
            ResultSet res= stm.executeQuery();
            
            while(res.next())
            {
                
                Muon temp = new Muon();
                temp.setMaMuon(res.getString(1));
                temp.setMaDocGia(res.getString(2));
                temp.setTenCuonSach(res.getString(3));
                temp.setSoLuong(Float.parseFloat(res.getString(4)));
                temp.setNgayMuon(res.getDate(5));
                temp.setNgayHenTra(res.getDate(6));
                temp.setNgayTra(res.getDate(7));
                temp.setGhiChu(res.getString(8));
                arr.add(temp);
            }
        }
        catch(Exception e)
        {
            
            System.out.println(e.toString());
            e.fillInStackTrace();
        }
        
        return arr;
    }
    
    public static Boolean xoaMuon(String maMuon, String maDocGia, String tenCuonSach, float soLuong, Date ngayMuon, Date ngayHenTra, Date ngayTra, String ghiChu ) {
        Boolean ans=false;
        if(Muon.checkMaMuon(maMuon)==false)
            return false;
        Connection con = Connections.getConnection();
        try{
            String maCuonSach=CuonSach.timMaSach(tenCuonSach);
            String sql= "delete from MUON where MUON.MaMuon=? and MUON.MaDocGia=? and MUON.MaCuonSach=? and MUON.SoLuong=? and MUON.NgayMuon=? and MUON.NgayHenTra=? and MUON.NgayTra=? and MUON.GhiChu=?;";
            PreparedStatement stm= con.prepareStatement(sql);
            stm.setString(1, maMuon);
            stm.setString(2, maDocGia);
            stm.setString(3, maCuonSach);
            stm.setFloat(4,  soLuong);
            java.sql.Timestamp ngayMuonStamp = new java.sql.Timestamp(ngayMuon.getTime());
            stm.setTimestamp(5, ngayMuonStamp);
            java.sql.Timestamp ngayHenTraStamp = new java.sql.Timestamp(ngayHenTra.getTime());
            stm.setTimestamp(6, ngayHenTraStamp);
            java.sql.Timestamp ngayTraStamp = new java.sql.Timestamp(ngayTra.getTime());
            stm.setTimestamp(7, ngayTraStamp);
            stm.setString(8, ghiChu);
            stm.execute();
            ans=true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.fillInStackTrace();
        }
        return ans;
    }
}
