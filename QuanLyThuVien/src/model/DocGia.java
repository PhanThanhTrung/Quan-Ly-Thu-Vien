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
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Truong Tran
 */
public class DocGia {

    private static String maDocGia;
    private static String hoDocGia;
    private static String tenLotDocGia;
    private static String tenDocGia;
    private static Boolean gioiTinh; //bằng 0 thì đọc giả là nữ, bằng 1 thì đọc giả là nam
    private static Date ngaySinh;
    private static String soNha;
    private static String duong;
    private static String quan;
    private static String soDienThoai;
    private static Date ngayDangKi;
    private static Date ngayHetHanDK;
    public static ArrayList<Integer> ds = new ArrayList<>();
    private static DocGia docGia = new DocGia();
    private static DocGia diaChi = new DocGia();
    private int stt;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public static String getMaDocGia() {
        return maDocGia;
    }

    public static String getHoDocGia() {
        return hoDocGia;
    }

    public static String getTenLotDocGia() {
        return tenLotDocGia;
    }

    public static String getTenDocGia() {
        return tenDocGia;
    }

    public static Boolean getGioiTinh() {
        return gioiTinh;
    }

    public static Date getNgaySinh() {
        return ngaySinh;
    }

    public static String getSoNha() {
        return soNha;
    }

    public static String getDuong() {
        return duong;
    }

    public static String getQuan() {
        return quan;
    }

    public static String getSoDienThoai() {
        return soDienThoai;
    }

    public static Date getNgayDangKi() {
        return ngayDangKi;
    }

    public static Date getNgayHetHanDK() {
        return ngayHetHanDK;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public void setHoDocGia(String hoDocGia) {
        this.hoDocGia = hoDocGia;
    }

    public void setTenLotDocGia(String tenLotDocGia) {
        this.tenLotDocGia = tenLotDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public void setNgayHetHanDK(Date ngayHetHanDK) {
        this.ngayHetHanDK = ngayHetHanDK;
    }

    public DocGia() {
    }

    public DocGia(String maDocGia, String hoDocGia, String tenLotDocGia, String tenDocGia, Boolean gioiTinh, Date ngaySinh, String soNha, String duong, String quan, String soDienThoai, Date ngayDangKi, Date ngayHetHanDK) {
        this.maDocGia = maDocGia;
        this.hoDocGia = hoDocGia;
        this.tenLotDocGia = tenLotDocGia;
        this.tenDocGia = tenDocGia;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soNha = soNha;
        this.duong = duong;
        this.quan = quan;
        this.soDienThoai = soDienThoai;
        this.ngayDangKi = ngayDangKi;
        this.ngayHetHanDK = ngayHetHanDK;
    }

    public static void layMaDocGia() {

        Connection con = Connections.getConnection();
        try {
            String sql = "select MaDocGia from DOCGIA;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Integer b = Integer.parseInt(rs.getString(1).substring(3));
                ds.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean kiemMaDocGia_FormDocGia(int id) {
        for (int i = 0; i < ds.size(); i++) {
            if (id == ds.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static int maDocGiaTuTang() {
        layMaDocGia();
        int id = 1;
        while (kiemMaDocGia_FormDocGia(id)) {
                id++;
            }
        return id;
    }

    public static void tachTenDocGia(JTextField txtTenDocGia) {
        int a, b;
        String hoTen = txtTenDocGia.getText();
        a = hoTen.trim().indexOf(" ");
        b = hoTen.trim().lastIndexOf(" ");
        docGia.setHoDocGia(hoTen.trim().substring(0, a));
        docGia.setTenDocGia(hoTen.substring(b).trim());
        docGia.setTenLotDocGia(hoTen.trim().substring(a, b - a).trim());
    }

    public static void tachDiaChi(JTextField txtDiaChi) {
        String sonha = "";
        String duong = "";
        String quan = "";
        String diachi = "";
        int c, d;
        diachi = txtDiaChi.getText();
        c = diachi.indexOf(",");//vi tri  dau tien_dau phay
        d = diachi.lastIndexOf(",");//vi tri cuoi_dau phay
        diaChi.setSoNha(diachi.trim().substring(0, c));
        diaChi.setQuan(diachi.trim().substring(d + 1).trim());
        diaChi.setDuong(diachi.substring(c + 1, d - (c + 1)).trim());
    }

    public static boolean kiemTraGioiTinh(JRadioButton btnNam, JRadioButton btnNu, ButtonGroup btnGioiTinh) {
        btnGioiTinh.add(btnNu);
        btnGioiTinh.add(btnNam);
        if (btnNam.isSelected()) {

            return true;
        } else {

            return false;
        }
    }

    public static void Them(JTextField tenDocGia, JRadioButton btnNam, JRadioButton btnNu, ButtonGroup btnGioiTinh,
            JXDatePicker ngaySinh, JTextField diaChi, JTextField soDienThoai, JXDatePicker ngayDangKi, JXDatePicker ngayHetHanDK) {
        String sql = "INSERT INTO DOCGIA (STT,MaDocGia,HoDocGia,TenLotDocGia,TenDocGia,GioiTinh,NgaySinh,"
                + "SoNha,Duong,Quan,SoDienThoai,NgayDangKi,NgayHetHanDK) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
        tachTenDocGia(tenDocGia);
        tachDiaChi(diaChi);
        boolean a = kiemTraGioiTinh(btnNam, btnNu, btnGioiTinh);
        java.sql.Date b = new java.sql.Date(ngaySinh.getDate().getTime());
        java.sql.Date c = new java.sql.Date(ngayDangKi.getDate().getTime());
        java.sql.Date d = new java.sql.Date(ngayHetHanDK.getDate().getTime());
        String sdt = soDienThoai.getText();

        try {
            Connection con = Connections.getConnection();
            PreparedStatement prs = con.prepareStatement(sql);
            prs.setInt(1, maDocGiaTuTang());
            prs.setString(2, "MDG" + maDocGiaTuTang());
            prs.setString(3, getHoDocGia());
            prs.setString(4, getTenLotDocGia());
            prs.setString(5, getTenDocGia());
            prs.setBoolean(6, a);
            prs.setDate(7, (java.sql.Date) b);
            prs.setString(8, DocGia.diaChi.getSoNha());
            prs.setString(9, DocGia.diaChi.getDuong());
            prs.setString(10, DocGia.diaChi.getQuan());
            prs.setString(11, sdt);
            prs.setDate(12, (java.sql.Date) c);
            prs.setDate(13, (java.sql.Date) d);
            prs.executeUpdate();
            System.out.println("INSERT INTO DOCGIA (STT,MaDocGia,HoDocGia,TenLotDocGia,TenDocGia,GioiTinh,NgaySinh,"
                    + "SoNha,Duong,Quan,SoDienThoai,NgayDangKi,NgayHetHanDK) "
                    + "VALUES(" + maDocGiaTuTang()+"   "
                    + "MDG" + maDocGiaTuTang()+"    "
                    + getHoDocGia()+"    "
                    + getTenLotDocGia()+"   "
                    + getTenDocGia()+"    "
                    + a+"    "
                    + b+"    "
                    + DocGia.diaChi.getSoNha()+"    "
                    + DocGia.diaChi.getDuong()+"    "
                    + DocGia.diaChi.getQuan()+"    "
                    + sdt+"    "
                    + c+"    "
                    + d+");");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
