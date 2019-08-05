/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phan Thanh Trung
 */
public class TheLoai {
    private String maTheLoai;
    private String tenLoaiSach;

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public String getTenLoaiSach() {
        return tenLoaiSach;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public void setTenLoaiSach(String tenLoaiSach) {
        this.tenLoaiSach = tenLoaiSach;
    }

    public TheLoai() {
    }

    public TheLoai(String maTheLoai, String tenLoaiSach) {
        this.maTheLoai = maTheLoai;
        this.tenLoaiSach = tenLoaiSach;
    }
    
    
}
