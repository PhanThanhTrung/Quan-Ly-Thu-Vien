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
public class CuonSach {
    private String  maCuonSach;
    private String  tenCuonSach;
    private String  maDauSach;
    private Boolean tinhTrang;

    public String getMaCuonSach() {
        return maCuonSach;
    }

    public String getTenCuonSach() {
        return tenCuonSach;
    }

    public String getMaDauSach() {
        return maDauSach;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setMaCuonSach(String maCuonSach) {
        this.maCuonSach = maCuonSach;
    }

    public void setTenCuonSach(String tenCuonSach) {
        this.tenCuonSach = tenCuonSach;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public CuonSach() {
    }

    public CuonSach(String maCuonSach, String tenCuonSach, String maDauSach, Boolean tinhTrang) {
        this.maCuonSach = maCuonSach;
        this.tenCuonSach = tenCuonSach;
        this.maDauSach = maDauSach;
        this.tinhTrang = tinhTrang;
    }
    
    
}
