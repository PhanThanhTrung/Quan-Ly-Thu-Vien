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
public class DauSach {
    private String maDauSach;
    private String maTuaSach;
    private String ngonNgu;
    private String maNXB;

    public String getMaDauSach() {
        return maDauSach;
    }

    public String getMaTuaSach() {
        return maTuaSach;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
    }

    public void setMaTuaSach(String maTuaSach) {
        this.maTuaSach = maTuaSach;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public DauSach() {
    }

    public DauSach(String maDauSach, String maTuaSach, String ngonNgu, String maNXB) {
        this.maDauSach = maDauSach;
        this.maTuaSach = maTuaSach;
        this.ngonNgu = ngonNgu;
        this.maNXB = maNXB;
    }
    
    
    
}
