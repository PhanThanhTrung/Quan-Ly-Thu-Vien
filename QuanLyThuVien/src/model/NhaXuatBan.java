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
public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;

    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public NhaXuatBan() {
    }

    public NhaXuatBan(String maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
    }
    
    
}
