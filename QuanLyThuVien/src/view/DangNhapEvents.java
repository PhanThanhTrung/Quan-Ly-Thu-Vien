/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Truong Tran
 */
public class DangNhapEvents {    
    
    public void buttonDangNhap(JTextField txttaikhoan, JPasswordField txtmatkhau)
    {
        String username = txttaikhoan.getText();
        String password= String.valueOf(txtmatkhau.getPassword());
        boolean con = DangNhapCtr.DangNhap(username, password);
        if(username.equalsIgnoreCase("")||password.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null,"Trường tài khoản, mật khẩu không được để trống","Lỗi",1);
        }else
        
        if(con)
        {
            JOptionPane.showMessageDialog(null,"Đăng nhập thành công!");
            
        }else
        {
            JOptionPane.showMessageDialog(null,"Tài khoản hoặc mật khẩu không chính xác.");
        }
       
    }
    
    
    public void buttonThoat()
    {
          int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình không?",
                "Thoát", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
