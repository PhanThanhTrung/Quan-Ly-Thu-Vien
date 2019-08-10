/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.DocGia;

import org.jdesktop.swingx.JXDatePicker;
import view.FormTrangChu;

/**
 *
 * @author Truong Tran
 */
public class DocGiaController {

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

    //Hàm này lấy thông tin từ view trả về cho model xử lý tên độc giả
    public static void tachTenDocGia(DocGia dg, JTextField txtTenDocGia) {
        String hoTen = txtTenDocGia.getText();
        dg.tach_TenDocGia(dg, hoTen);
    }

    //Hàm này lấy thông tin từ view trả về cho model xử lý địa chỉ
    public static void tachDiaChi(DocGia dg, JTextField txtDiaChi) {
        String diaChi = txtDiaChi.getText();
        dg.tach_DiaChi(dg, diaChi);
    }

    //Hàm này lấy thông tin từ view trả về cho model xử lý giới tính độc giả
    public static boolean kiemTra_GioiTinh(JRadioButton btnNam, JRadioButton btnNu, ButtonGroup btnGioiTinh) {
        btnGioiTinh.add(btnNu);
        btnGioiTinh.add(btnNam);
        if (btnNam.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    //Hàm này lấy thông tin từ view trả về cho model xử lý thêm độc giả
    public static void btnThem_DocGia(JTextField tenDocGia, JRadioButton btnNam, JRadioButton btnNu, ButtonGroup btnGioiTinh,
            JXDatePicker ngaySinh, JTextField diaChi, JTextField soDienThoai, JXDatePicker ngayDangKi, JXDatePicker ngayHetHanDK) {
        DocGia themDG = new DocGia();
        try {
            DocGiaController.tachTenDocGia(themDG, tenDocGia);
            DocGiaController.tachDiaChi(themDG, diaChi);
            themDG.setGioiTinh(kiemTra_GioiTinh(btnNam, btnNu, btnGioiTinh));
            themDG.setNgaySinh(new java.sql.Date(ngaySinh.getDate().getTime()));
            themDG.setNgayDangKi(new java.sql.Date(ngayDangKi.getDate().getTime()));
            themDG.setNgayHetHanDK(new java.sql.Date(ngayHetHanDK.getDate().getTime()));
            themDG.setSoDienThoai(soDienThoai.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập đầy đủ thông tin.");
        }
        if (themDG.them_DocGia(themDG.getHoDocGia(), themDG.getTenLotDocGia(), themDG.getTenDocGia(),
                themDG.getGioiTinh(), themDG.getNgaySinh(), themDG.getSoNha(), themDG.getDuong(), themDG.getQuan(),
                themDG.getSoDienThoai(), themDG.getNgayDangKi(), themDG.getNgayHetHanDK())) {
            JOptionPane.showMessageDialog(null, "Thêm độc giả thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại.");
        }
    }

    public static void btnXoa_DG(JTextField txtMaDG) {

        DocGia xoaDocGia = new DocGia();
        xoaDocGia.setMaDocGia(txtMaDG.getText());
        if (xoaDocGia.xoa_DocGia(xoaDocGia.getMaDocGia())) {
            JOptionPane.showMessageDialog(null, "Xóa thông tin độc giả thành công.");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thông tin thất bại.");
        }
    }

    public static void btnSua_DG(JTextField txtMaDG, JTextField tenDocGia, JRadioButton btnNam, JRadioButton btnNu, ButtonGroup btnGioiTinh,
            JXDatePicker ngaySinh, JTextField diaChi, JTextField soDienThoai, JXDatePicker ngayDangKi, JXDatePicker ngayHetHanDK) {
        DocGia suaDG = new DocGia();
        try {
            suaDG.setMaDocGia(txtMaDG.getText());
            DocGiaController.tachTenDocGia(suaDG, tenDocGia);
            DocGiaController.tachDiaChi(suaDG, diaChi);
            suaDG.setGioiTinh(kiemTra_GioiTinh(btnNam, btnNu, btnGioiTinh));
            suaDG.setNgaySinh(new java.sql.Date(ngaySinh.getDate().getTime()));
            suaDG.setNgayDangKi(new java.sql.Date(ngayDangKi.getDate().getTime()));
            suaDG.setNgayHetHanDK(new java.sql.Date(ngayHetHanDK.getDate().getTime()));
            suaDG.setSoDienThoai(soDienThoai.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Yêu cầu nhập đầy đủ thông tin.");
            e.printStackTrace();
        }
        if (suaDG.sua_DocGia(suaDG.getMaDocGia(), suaDG.getHoDocGia(), suaDG.getTenLotDocGia(), suaDG.getTenDocGia(),
                suaDG.getGioiTinh(), suaDG.getNgaySinh(), suaDG.getSoNha(), suaDG.getDuong(), suaDG.getQuan(),
                suaDG.getSoDienThoai(), suaDG.getNgayDangKi(), suaDG.getNgayHetHanDK())) {
            JOptionPane.showMessageDialog(null, "Sửa thông tin độc giả thành công.");
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thông tin thất bại.");
        }
    }

    public static void hienThiDS_DG(JTable jTable) {
        ArrayList<DocGia> dsDG = DocGia.layDS_DocGia();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[9];
        int index = 1;
        for (DocGia u : dsDG) {
            row[0] = index;
            row[1] = u.getMaDocGia();
            row[2] = u.getHoTenDocGia();
            row[3] = u.getNgaySinh();
            row[4] = u.getGioiTinhStr();
            row[5] = u.getDiaChiStr();
            row[6] = u.getNgayDangKi();
            row[7] = u.getNgayHetHanDK();
            row[8] = u.getSoDienThoai();
            model.addRow(row);
            index++;
        }
    }
    
    public static void hienThiDS_TKMaDG(JTable jTable, JTextField maDocGia)
    {
        ArrayList<DocGia> dsDG = DocGia.timKiem_DocGia_TheoMa(maDocGia.getText());
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[9];
        int index = 1;
        for (DocGia u : dsDG) {
            row[0] = index;
            row[1] = u.getMaDocGia();
            row[2] = u.getHoTenDocGia();
            row[3] = u.getNgaySinh();
            row[4] = u.getGioiTinhStr();
            row[5] = u.getDiaChiStr();
            row[6] = u.getNgayDangKi();
            row[7] = u.getNgayHetHanDK();
            row[8] = u.getSoDienThoai();
            model.addRow(row);
            index++;
        }
    }
    
    
        
}
