/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blt;

import java.util.Date;

/**
 *
 * @author Phan Thanh Trung
 */
public class Muon {
    private String maMuon;
    private String maDocGia;
    private String maCuonSach;
    private int    soLuong;
    private Date   ngayMuon;
    private Date   ngayHenTra;
    private Date   ngayTra;
    private String ghiChu;

    public String getMaMuon() {
        return maMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getMaCuonSach() {
        return maCuonSach;
    }

    public int getSoLuong() {
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

    public void setSoLuong(int soLuong) {
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

    public Muon(String maMuon, String maDocGia, String maCuonSach, int soLuong, Date ngayMuon, Date ngayHenTra, Date ngayTra, String ghiChu) {
        this.maMuon = maMuon;
        this.maDocGia = maDocGia;
        this.maCuonSach = maCuonSach;
        this.soLuong = soLuong;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
    }
    
    
}
