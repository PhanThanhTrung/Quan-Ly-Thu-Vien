/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blt;

/**
 *
 * @author Phan Thanh Trung
 */
public class TuaSach {
    private String maTuaSach;
    private String tenTuaSach;
    private String maTacGia;
    private String maTheLoai;
    private String NDTomTat;

    public String getMaTuaSach() {
        return maTuaSach;
    }

    public String getTenTuaSach() {
        return tenTuaSach;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public String getNDTomTat() {
        return NDTomTat;
    }

    public void setMaTuaSach(String maTuaSach) {
        this.maTuaSach = maTuaSach;
    }

    public void setTenTuaSach(String tenTuaSach) {
        this.tenTuaSach = tenTuaSach;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public void setNDTomTat(String NDTomTat) {
        this.NDTomTat = NDTomTat;
    }

    public TuaSach() {
    }

    public TuaSach(String maTuaSach, String tenTuaSach, String maTacGia, String maTheLoai, String NDTomTat) {
        this.maTuaSach = maTuaSach;
        this.tenTuaSach = tenTuaSach;
        this.maTacGia = maTacGia;
        this.maTheLoai = maTheLoai;
        this.NDTomTat = NDTomTat;
    }
    
    
    // your code goes here
    
    
}
