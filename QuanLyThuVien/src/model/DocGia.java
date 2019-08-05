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
public class DocGia {
    private String  maDocGia;
    private String  hoDocGia;
    private String  tenLotDocGia;
    private String  tenDocGia;
    private Boolean gioiTinh; //bằng 0 thì đọc giả là nữ, bằng 1 thì đọc giả là nam
    private Date    ngaySinh;
    private String  soNha;
    private String  duong;
    private String  quan;
    private String  soDienThoai;
    private Date    ngayDangKi;
    private Date    ngayHetHanDK;

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
    
    
}
