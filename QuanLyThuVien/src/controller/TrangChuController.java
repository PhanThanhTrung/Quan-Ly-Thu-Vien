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
            index+=1;
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

    /*
        tab Danh Mục Sách
        Trung
        */
    //hiển thị data gribview
    public static void danhMucSach(JTable danhMucSach) {
        DefaultTableModel tble = (DefaultTableModel) danhMucSach.getModel();
        tble.setNumRows(0);
        // stt, Ten cuon Sach,Ma dau sach, loai sach, tac gia
        int index = 1;
        ArrayList<model.DanhMucSach> str = DanhMucSach.getDanhSach();

        for (model.DanhMucSach ele : str) {
            tble.addRow(new Object[]{index, ele.getTenCuonSach(), ele.getTuaSach(), ele.getLoaiSach(), ele.getTacGia(), ele.getNhaXuatBan()});
            index+=1;
        }
        danhMucSach.setModel(tble);
    }
    // hiển thị combobox
    public static void hienthiComboBox(JComboBox jcb){
        jcb.removeAllItems();
        for(String ele: model.NhaXuatBan.getDanhSachNXB())
        {
            jcb.addItem(ele);
        }
        
    }
    //hiển thị mã Cuốn sách hợp lệ
    public static String maCSHopLe()
    {
        return model.CuonSach.maCuonSachTuTang();
    }
    
    /*public static boolean checkMuon(JRadioButton btnDaMuonDSM, JRadioButton btnChuaMuonDSM, ButtonGroup checkMuonDSM)
    {
        checkMuonDSM.add(btnDaMuonDSM);
        checkMuonDSM.add(btnChuaMuonDSM);
        return btnDaMuonDSM.isSelected();
    }
    */
    // button thêm mới
    
    
    public void themMoiDMS(JTextField maCuonSach, JTextField tenCuonSach, JComboBox tenNhaXuatBan, JTextField tuaCuonSach,JTextField tenTacGia, JTextField tenLoaiSach,JRadioButton btnDaMuonDSM)
    {
        String maSach= maCuonSach.getText().toString().trim();
        String tenSach= tenCuonSach.getText().toString().trim();
        String tenNXB=tenNhaXuatBan.getSelectedItem().toString().trim();
        String tuaSach=tuaCuonSach.getText().toString().trim();
        String tacGia= tenTacGia.getText().toString().trim();
        String loaiSach= tenLoaiSach.getText().toString().trim();
        boolean daMuon=btnDaMuonDSM.isSelected();
        model.CuonSach newCS= new CuonSach();
        if(model.CuonSach.checkMaSach(maSach))
        {
            newCS.setMaCuonSach(maSach);   
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Mã Sách Không Hợp Lệ");
        }
        newCS.setTenCuonSach(tenSach);
        newCS.setTinhTrang(daMuon);
        newCS.setTuaSach(tuaSach);
        if(TheLoai.checkTenTheLoai(loaiSach)==null)
        {
            newCS.setMaTheLoai(TheLoai.newMaTheLoai());
            TheLoai newTG= new TheLoai();
            newTG.setMaTheLoai(TheLoai.newMaTheLoai());
            newTG.setTenLoaiSach(loaiSach);
            model.TheLoai.themTheLoai(newTG);
        }
        else
        {
            newCS.setMaTheLoai(TheLoai.checkTenTheLoai(loaiSach));
        }
        if(TacGia.checkTenTacGia(tacGia)==null)
        {
            newCS.setMaTacGia(TacGia.newMaTacGia());
            TacGia newTG= new TacGia();
            newTG.setMaTacGia(TacGia.newMaTacGia());
            newTG.setTenTacGia(tacGia);
            model.TacGia.themTacGia(newTG);
        }
        else
        {
            newCS.setMaTacGia(TacGia.checkTenTacGia(tacGia));
        }
        if(NhaXuatBan.layMaNXB(tenNXB.toString())!=null)
            newCS.setMaNXB(NhaXuatBan.layMaNXB(tenNXB));
        else
            JOptionPane.showMessageDialog(null, "lỗi, không thể thêm");
        boolean genza=CuonSach.themCuonSach(newCS.getMaCuonSach(),newCS.getTenCuonSach(), newCS.getTinhTrang(), newCS.getMaTacGia(),newCS.getMaNXB(),newCS.getTuaSach(),newCS.getMaTheLoai());
        if(genza==true)
            JOptionPane.showMessageDialog(null, "Thêm Mới Thành Công");
        else
            JOptionPane.showMessageDialog(null, "Thêm Mới Không Thành Công");
    }
    
    public void xoaCuonSachDMS(JTextField maCuonSach)
    {
        String maSach=maCuonSach.getText().toString().trim();
        boolean done= CuonSach.xoaCuonSach(maSach);
        if(done)
        {
            JOptionPane.showMessageDialog(null, "Xóa thành công, vui lòng cập nhật để xem kết quả");
        }
        else
            JOptionPane.showMessageDialog(null, "Xóa không thành công");
       
    }
}
