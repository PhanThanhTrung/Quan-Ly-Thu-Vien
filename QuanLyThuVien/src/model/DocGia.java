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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Truong Tran
 */
public class DocGia {

    private String maDocGia;
    private String hoDocGia;
    private String tenLotDocGia;
    private String tenDocGia;
    private Boolean gioiTinh; //bằng 0 thì đọc giả là nữ, bằng 1 thì đọc giả là nam
    private Date ngaySinh;
    private String soNha;
    private String duong;
    private String quan;
    private String soDienThoai;
    private Date ngayDangKi;
    private Date ngayHetHanDK;
    public static ArrayList<Integer> ds = new ArrayList<>();
    private int stt;
    private String hoTenDocGia;
    private String gioiTinhStr;
    private String diaChiStr;


    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getHoDocGia() {
        return hoDocGia;
    }

    public String getTenLotDocGia() {
        return tenLotDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getSoNha() {
        return soNha;
    }

    public String getDuong() {
        return duong;
    }

    public String getQuan() {
        return quan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public Date getNgayHetHanDK() {
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

    public String getHoTenDocGia() {
        return hoTenDocGia;
    }

    public String getGioiTinhStr() {
        return gioiTinhStr;
    }

    public void setHoTenDocGia(String hoTenDocGia) {
        this.hoTenDocGia = hoTenDocGia;
    }

    public void setGioiTinhStr(String gioiTinhStr) {
        this.gioiTinhStr = gioiTinhStr;
    }

    public String getDiaChiStr() {
        return diaChiStr;
    }

    public void setDiaChiStr(String diaChiStr) {
        this.diaChiStr = diaChiStr;
    }

   
    
    

    public DocGia(String maDocGia, String hoTenDocGia, String gioiTinhStr, Date ngaySinh, String diaChiDocGia, String soDienThoai, Date ngayDangKi, Date ngayHetHanDK) {
        this.maDocGia = maDocGia;
        this.hoTenDocGia = hoTenDocGia;
        this.gioiTinhStr = gioiTinhStr;
        this.diaChiStr = diaChiDocGia;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.ngayDangKi = ngayDangKi;
        this.ngayHetHanDK = ngayHetHanDK;
    }

    //Hàm này lấy mã độc giả add vào danh sách 
    public static void lay_MaDocGia() {
        Connection con = Connections.getConnection();
        String sql = "SELECT MaDocGia from DOCGIA;";
        try {

            PreparedStatement prs = con.prepareStatement(sql);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                Integer b = Integer.parseInt(rs.getString(1).substring(3));
                ds.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hàn này kiểm tra xem mã độc giả có bị trùng trong danh sách hay không?
    public static boolean kiemTra_MaDocGia(int id) {
        for (int i = 0; i < ds.size(); i++) {
            if (id == ds.get(i)) {
                return true;
            }
        }
        return false;
    }

    //Hàm này lấy ra mã độc giả bị khuyết.
    public static int maDocGia_TuTang() {
        lay_MaDocGia();
        int id = 1;
        while (kiemTra_MaDocGia(id)) {
            id++;
        }
        return id;
    }

    //Hàm này tách tên độc giả
    public void tach_TenDocGia(DocGia dg, String hoTen) {
        int a, b;
        a = hoTen.trim().indexOf(" ");
        b = hoTen.trim().lastIndexOf(" ");
        dg.setHoDocGia(hoTen.trim().substring(0, a));
        dg.setTenDocGia(hoTen.substring(b).trim());
        dg.setTenLotDocGia(hoTen.trim().substring(a, b).trim());
    }

    //Hàm này tách địa chỉ độc giả
    public void tach_DiaChi(DocGia dg, String diaChi) {
        int c, d;
        c = diaChi.indexOf(",");//vi tri  dau tien_dau phay
        d = diaChi.lastIndexOf(",");//vi tri cuoi_dau phay
        dg.setSoNha(diaChi.trim().substring(0, c));
        dg.setQuan(diaChi.trim().substring(d + 1).trim());
        dg.setDuong(diaChi.trim().substring(c + 1, d).trim());
    }

    //Hàm này thêm 1 độc giả vào database.
    public boolean them_DocGia(String hoDocGia, String tenLotDocGia, String tenDocGia, boolean GioiTinh,
            Date ngaySinh, String soNha, String duong, String quan, String soDienThoai, Date ngayDangKi, Date ngayHetHanDK) {
        Connection con = Connections.getConnection();
        String sql = "INSERT INTO DOCGIA (STT,MaDocGia,HoDocGia,TenLotDocGia,TenDocGia,GioiTinh,NgaySinh,"
                + "SoNha,Duong,Quan,SoDienThoai,NgayDangKi,NgayHetHanDK) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement prs = con.prepareStatement(sql);
            prs.setInt(1, maDocGia_TuTang());
            prs.setString(2, "MDG" + maDocGia_TuTang());
            prs.setString(3, hoDocGia);
            prs.setString(4, tenLotDocGia);
            prs.setString(5, tenDocGia);
            prs.setBoolean(6, GioiTinh);
            prs.setDate(7, (java.sql.Date) ngaySinh);
            prs.setString(8, soNha);
            prs.setString(9, duong);
            prs.setString(10, quan);
            prs.setString(11, soDienThoai);
            prs.setDate(12, (java.sql.Date) ngayDangKi);
            prs.setDate(13, (java.sql.Date) ngayHetHanDK);
            prs.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //Hàm này kiểm tra có tồn tại độc giả hay không? trả về true nếu có
    public static boolean kiemTra_MaDocGia(String maDocGia) {
        Connection con = Connections.getConnection();
        String sql = "SELECT MaDocGia FROM DOCGIA WHERE MaDocGia=?;";
        try {
            PreparedStatement prs = con.prepareStatement(sql);
            prs.setString(1, maDocGia);
            ResultSet rs = prs.executeQuery();
            String a = null;
            if (rs.next()) {
                a = rs.getString(1);
            }
            if (a.equalsIgnoreCase(maDocGia)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Hàm này kiểm tra có tồn tại độc giả đang mượn sách của thư viện trả về true nếu có
    public static boolean kiemTra_Xoa_BangMuon(String maDocGia) {
        Connection con = Connections.getConnection();
        String sql = "SELECT MaDocGia FROM MUON WHERE MaDocGia=?;";
        try {
            PreparedStatement prs = con.prepareStatement(sql);
            prs.setString(1, maDocGia);
            ResultSet rs = prs.executeQuery();
            String a = null;
            if (rs.next()) {
                a = rs.getString(1);
            }
            if (a.equalsIgnoreCase(maDocGia)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Hàm này xóa thông tin của 1 độc giả
    public boolean xoa_DocGia(String maDocGia) {
        //Kiểm tra xem độc giả này có còn mượn sách thư viện hay không nếu có thì không cho xóa.
        if (kiemTra_Xoa_BangMuon(maDocGia)) {
            JOptionPane.showMessageDialog(null, "Độc giả này đang mượn sách không thể xóa.");
            //Kiểm tra xem độc giả này có tồn tại hay không nếu không thì không cần phải xóa.
        } else if (kiemTra_MaDocGia(maDocGia) == false) {
            JOptionPane.showMessageDialog(null, "Độc giả này không tồn tại.");
        } else {
            try {
                //Cần phải có xác nhận khi xóa 1 độc giả
                //JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa độc giả này không?"); 
                String sql = "DELETE FROM DocGia WHERE MaDocGia=?;";
                Connection con = Connections.getConnection();
                PreparedStatement prs = con.prepareStatement(sql);
                prs.setString(1, maDocGia);
                prs.executeUpdate();
                con.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean sua_DocGia(String maDocGia, String hoDocGia, String tenLotDocGia, String tenDocGia, boolean GioiTinh,
            Date ngaySinh, String soNha, String duong, String quan, String soDienThoai, Date ngayDangKi, Date ngayHetHanDK) {
        Connection con = Connections.getConnection();
        String sql = "UPDATE DOCGIA SET HoDocGia=?, TenLotDocGia=?, TenDocGia=?, GioiTinh=?,"
                + "NgaySinh=?, SoNha=?, Duong=?, Quan=?, SoDienThoai=?, NgayDangKi=?, NgayHetHanDK=? WHERE MaDocGia=?;";
        try {
            if (kiemTra_MaDocGia(maDocGia)) {
                PreparedStatement prs = con.prepareStatement(sql);
                prs.setString(1, hoDocGia);
                prs.setString(2, tenLotDocGia);
                prs.setString(3, tenDocGia);
                prs.setBoolean(4, GioiTinh);
                prs.setDate(5, (java.sql.Date) ngaySinh);
                prs.setString(6, soNha);
                prs.setString(7, duong);
                prs.setString(8, quan);
                prs.setString(9, soDienThoai);
                prs.setDate(10, (java.sql.Date) ngayDangKi);
                prs.setDate(11, (java.sql.Date) ngayHetHanDK);
                prs.setString(12, maDocGia);
                System.out.println(maDocGia);
                prs.executeUpdate();
                con.close();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Mã độc giả này không tồn tại.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<DocGia> layDS_DocGia() {
        ArrayList<DocGia> dsDG = new ArrayList<>();
        Connection con = Connections.getConnection();
        String sql = "SELECT * from DOCGIA;";
        try {
            PreparedStatement prs = con.prepareStatement(sql);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                DocGia a = new DocGia();
                a.setHoTenDocGia(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
                a.setDiaChiStr(rs.getString(8) + ", " + rs.getString(9) + ", " + rs.getString(10));
                if (rs.getInt(6) == 1) {
                    a.setGioiTinhStr("Nam");
                } else {
                    a.setGioiTinhStr("Nữ");
                }
                dsDG.add(new DocGia(rs.getString(2), a.getHoTenDocGia(), a.getGioiTinhStr(), rs.getDate(7), a.getDiaChiStr(), rs.getString(11), rs.getDate(12), rs.getDate(13)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDG;

    }

}
