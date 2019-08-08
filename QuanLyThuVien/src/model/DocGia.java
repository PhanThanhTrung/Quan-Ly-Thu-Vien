/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Connections;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JTextField;

/**
 *
 * @author Truong Tran
 */
public class DocGia {

    private String maDocGia;
    private String hoDocGia;
    private String tenLotDocGia;
    private String tenDocGia;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String soNha;
    private String duong;
    private String quan;
    private String soDienThoai;
    private Date ngayDK;
    private Date ngayHetHanDK;
    public static ArrayList<Integer> ds = new ArrayList<>();

    public static void LayMaDocGia() {

        Connection con = Connections.getConnection();
        try {
            String sql = "select MaDocGia from DOCGIA;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Integer b;
                b = Integer.parseInt(rs.getString(1).substring(3));
                ds.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean KiemMaDocGia_FormDocGia(int id) {
        for (int i = 0; i < ds.size(); i++) {
            if (id == ds.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static String MaDocGiaTuTang() {
          LayMaDocGia();
        boolean b = true;
        int id = 1;
        while (b) {
            if (KiemMaDocGia_FormDocGia(id)) {
                b = true;
                id++;
            } else {
                break;
            }
        }
        return "MDG" + id;

    }
public static void TachTenDocGia(JTextField txtTenDocGia) {
        String ho = "";
        String ten = "";
        String tenLot = "";
        String hoTen = "";
        int a, b;
        hoTen = txtTenDocGia.getText();
        a = hoTen.trim().indexOf(" ");
        b = hoTen.trim().lastIndexOf(" ");
        ho = hoTen.trim().substring(0, a);
        ten = hoTen.substring(b).trim();
        tenLot = hoTen.trim().substring(a, b - a).trim();
    }
   
    

    public static void Them(String MaDocGia, String HoDocGia, String TenLotDocGia, String TenDocGia,boolean GioiTinh,Date NgaySinh,String SoNha,String Duong,
            String Quan,String SoDienThoai,Date NgayDangKi,Date NgayHethanDK) {
        String sql = "INSERT INTO DOCGIA (MaDocGia,HoDocGia,TenLotDocGia,TenDocGia,GioiTinh,NgaySinh,"
                + "SoNha,Duong,Quan,SoDienThoai,NgayDangKi,NgayHetHanDK) "
                + "VALUES( ?,?,?,?,?,?,?,?,?,?,?,?);";
        try{
        Connection con = Connections.getConnection();
        PreparedStatement prs = con.prepareStatement(sql);
        prs.setString(1, MaDocGiaTuTang());
        
        
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        

    }


}
