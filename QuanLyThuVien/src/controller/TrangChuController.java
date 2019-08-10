/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Phan Thanh Trung
 */
public class TrangChuController {

    //ghi chu, sl, ngay muon, ngay hen tra, ngay tra,combobox
    public Boolean themMoiMuon(JTextField txtMaMuon, JTextField txtMaDocGia, JTextField txtGhiChu, JTextField txtSoLuong, JXDatePicker dteNgayMuon, JXDatePicker dteNgayHenTra, JXDatePicker dteNgayTra, JComboBox<String> comboTenSach) {
        String maMuon = txtMaMuon.getText();
        String maDocGia = txtMaDocGia.getText();
        String tenSach = (String) comboTenSach.getSelectedItem();
        String ghiChu = txtGhiChu.getText();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        Date ngayMuon = dteNgayMuon.getDate();
        Date ngayHenTra = dteNgayHenTra.getDate();
        Date ngayTra = dteNgayTra.getDate();

        if (model.Muon.checkMaMuon(maMuon) == true) {
            Boolean done = model.Muon.themBangMuon(maMuon, maDocGia, tenSach, soLuong, ngayMuon, ngayHenTra, ngayTra, ghiChu);
            if (done == true) {
                return true;
            }

        }
        return false;
    }

    public void dataGribViewForMuon(JTable tblDanhSach) {
        DefaultTableModel tble = (DefaultTableModel) tblDanhSach.getModel();
        tble.setNumRows(0);
        ArrayList<Muon> Str = model.Muon.selectInfor();
        int index = 1;
        for (Muon ele : Str) {
         
            String ngayHenTra = "";
            if (ele.getNgayHenTra() != null) {
                ngayHenTra = ele.getNgayHenTra().toString();
            }
            String ngayMuon = "";
            if (ele.getNgayMuon() != null) {
                ngayMuon = ele.getNgayMuon().toString();
            }
            String ngayTra = "";
            if (ele.getNgayTra() != null) {
                ngayTra = ele.getNgayTra().toString();
            }
            tble.addRow(new Object[]{index, ele.getMaMuon(), ele.getMaDocGia(), ele.getTenCuonSach(), ele.getSoLuong(), ngayMuon, ngayHenTra, ngayTra, ele.getGhiChu()});
        }
        tblDanhSach.setModel(tble);
    }

    public Boolean xoaMuon(JTextField txtMaMuon, JTextField txtMaDocGia, JTextField txtGhiChu, JTextField txtSoLuong, JXDatePicker dteNgayMuon, JXDatePicker dteNgayHenTra, JXDatePicker dteNgayTra, JComboBox<String> comboTenSach) {
        String maMuon = txtMaMuon.getText();
        String maDocGia = txtMaDocGia.getText();
        String tenSach = (String) comboTenSach.getSelectedItem();
        String ghiChu = txtGhiChu.getText();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        Date ngayMuon = dteNgayMuon.getDate();
        Date ngayHenTra = dteNgayHenTra.getDate();
        Date ngayTra = dteNgayTra.getDate();

        Boolean done = model.Muon.xoaMuon(maMuon, maDocGia, tenSach, soLuong, ngayMuon, ngayHenTra, ngayTra, ghiChu);
        if (done == false) {
            System.out.println("khong the xoa, xem lai thong tin");
        } else {
            System.out.println("xoa thanh cong");
        }
        return done;
    }

    //tab Danh Mục Sách
    public static void danhMucSach(JTable danhMucSach) {
        DefaultTableModel tble = (DefaultTableModel) danhMucSach.getModel();
        tble.setNumRows(0);
        // stt, Ten cuon Sach,Ma dau sach, loai sach, tac gia
        int index = 1;
        ArrayList<model.DanhMucSach> str = DanhMucSach.getDanhSach();

        for (model.DanhMucSach ele : str) {
            tble.addRow(new Object[]{index, ele.getTenCuonSach(), ele.getMaDauSach(), ele.getLoaiSach(), ele.getTacGia()});
        }
        danhMucSach.setModel(tble);
    }

  
}
