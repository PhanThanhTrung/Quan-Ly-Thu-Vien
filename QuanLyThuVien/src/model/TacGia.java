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
public class TacGia {
    private String maTacGia;
    private String tenTacGia;

    public String getMaTacGia() {
        return maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public TacGia() {
    }

    public TacGia(String maTacGia, String tenTacGia) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
    }
    
    
}
