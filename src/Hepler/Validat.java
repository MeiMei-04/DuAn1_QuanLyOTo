/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import DAO.TaiKhoanDAO;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import entyti.TaiKhoan;
import java.util.List;

/**
 *
 * @author HieuCute
 */
public class Validat extends javax.swing.JFrame {

    public boolean dangKyTaiKhoan(JTextField taikhoan, JPasswordField pass, JPasswordField passcomfirm,JTextField email,JTextField maxacnhan) {
        TaiKhoanDAO tkd = new TaiKhoanDAO();
        String string = taikhoan.getText();
        String stringpass = String.valueOf(pass.getPassword());
        try {
            List<TaiKhoan> list = tkd.selectAll();
            for (TaiKhoan tk : list) {
                if (string.equalsIgnoreCase(tk.getTaikhoan())) {
                    DialogHelper.alert(this, "Tài Khoản Đã Tồn Tại");
                    return false;
                }
            }
        } catch (Exception e) {
        }
        if(taikhoan.getText()==null){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            taikhoan.requestFocus();
            return false;
        }if(pass.getPassword()==null){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            pass.requestFocus();
            return false;
        }if(passcomfirm.getPassword()==null){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            passcomfirm.requestFocus();
            return false;
        }if(email.getText()==null){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            email.requestFocus();
            return false;
        }
        if(maxacnhan.getText()==null){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            maxacnhan.requestFocus();
            return false;
        }

        return true;
    }
}
