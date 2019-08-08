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
    private String tenCuonSach;
    private String maDauSach;
    private String loaiSach;
    private String tacGia;

    public String getTenCuonSach() {
        return tenCuonSach;
    }

    public String getMaDauSach() {
        return maDauSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTenCuonSach(String tenCuonSach) {
        this.tenCuonSach = tenCuonSach;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public DanhMucSach() {
    }
    
    
    // Ten cuon Sach,Ma dau sach, loai sach, tac gia
    public static ArrayList<DanhMucSach> getDanhSach()
    {
        ArrayList<DanhMucSach> arr = new ArrayList<>();
        Connection con= Connections.getConnection();
        try{
            String sql="select CUONSACH.TenCuonSach, CUONSACH.MaDauSach, THELOAI.TenLoaiSach, TACGIA.TenTacGia from CUONSACH"
                    + " inner join DAUSACH on CUONSACH.MaDauSach = DAUSACH.MaDauSach inner join TUASACH on DAUSACH.MaTuaSach = TUASACH.MaTuaSach"
                    + " inner join TACGIA on TACGIA.MaTacGia = TUASACH.MaTacGia "
                    + "inner join THELOAI on TUASACH.MaTheLoai = THELOAI.MaTheLoai;";
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet res = stm.executeQuery();
            while(res.next())
            {
                DanhMucSach tmp= new DanhMucSach();
                tmp.setTenCuonSach(res.getString(1));
                tmp.setMaDauSach(res.getString(2));
                tmp.setLoaiSach(res.getString(3));
                tmp.setTacGia(res.getString(4));
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
