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
public class DanhMucSach {
    // Ten cuon Sach,Tua sach, loai sach, tac gia, nha xuat bản
    private String tenCuonSach;
    private String tuaSach;
    private String loaiSach;
    private String tacGia;
    private String nhaXuatBan;

    public String getTenCuonSach() {
        return tenCuonSach;
    }

    public void setTenCuonSach(String tenCuonSach) {
        this.tenCuonSach = tenCuonSach;
    }

    public String getTuaSach() {
        return tuaSach;
    }

    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }
    
    public DanhMucSach() {
    }
    
    
    // Ten cuon Sach,Tua sach, loai sach, tac gia, nha xuat bản
    public static ArrayList<DanhMucSach> getDanhSach()
    {
        ArrayList<DanhMucSach> arr = new ArrayList<>();
        Connection con= Connections.getConnection();
        try{
            String sql="select CUONSACH.TenCuonSach, CUONSACH.TuaSach, THELOAI.TenLoaiSach, TACGIA.TenTacGia, NHAXUATBAN.TenNXB"
                    + " from CUONSACH inner join THELOAI on CUONSACH.MaTheLoai = THELOAI.MaTheLoai"
                    + " inner join TACGIA on CUONSACH.MaTacGia = TACGIA.MaTacGia"
                    + " inner join NHAXUATBAN on CUONSACH.MaNXB = NHAXUATBAN.MaNXB;";
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet res = stm.executeQuery();
            while(res.next())
            {
                DanhMucSach tmp= new DanhMucSach();
                tmp.setTenCuonSach(res.getString(1));
                tmp.setTuaSach(res.getString(2));
                tmp.setLoaiSach(res.getString(3));
                tmp.setTacGia(res.getString(4));
                tmp.setNhaXuatBan(res.getString(5));
                arr.add(tmp);
            }
        }   
        catch(Exception e)
        {
            System.out.println(e);
            e.fillInStackTrace();
        }
        return arr;
    }
    
}
