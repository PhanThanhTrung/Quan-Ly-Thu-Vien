/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import javax.swing.*;
import model.*;
import org.jdesktop.swingx.JXDatePicker;
import view.*;
/**
 *
 * @author Phan Thanh Trung
 */
public class TrangChuController {
    //ghi chu, sl, ngay muon, ngay hen tra, ngay tra,combobox
    public Boolean themMoiMuon(JTextField txtMaMuon,JTextField txtMaDocGia,JTextField txtGhiChu,JTextField txtSoLuong, JXDatePicker dteNgayMuon,JXDatePicker dteNgayHenTra, JXDatePicker dteNgayTra,JComboBox<String> comboTenSach)            
    {
        String maMuon     = txtMaMuon.getText();
        String maDocGia   = txtMaDocGia.getText();
        String tenSach    = (String) comboTenSach.getSelectedItem();
        String ghiChu     = txtGhiChu.getText();
        int    soLuong    = Integer.parseInt(txtSoLuong.getText());
        Date ngayMuon     = dteNgayMuon.getDate();
        Date ngayHenTra   = dteNgayHenTra.getDate();
        Date ngayTra      = dteNgayTra.getDate();
        
        if(model.Muon.checkMaMuon(maMuon)==true)
        {
            Boolean done=model.Muon.themBangMuon(maMuon, maDocGia, tenSach, soLuong, ngayMuon, ngayHenTra, ngayTra, ghiChu);
            if(done==true)
            {
                return true;
            }
                
        }
        return false;
    }
}
