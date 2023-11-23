/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import entyti.TaiKhoan;
/**
 *
 * @author hieud
 */
public class AuthHelper {
//khai báo user =>Duy trì user đăng nhập vào hệ thống
    public static TaiKhoan user = null;

    //Xóa user khi người dùng đăng xuất
    public static void logoff() {
        AuthHelper.user = null;
    }

    //Kiểm tra đăng nhập hay chưa?
    public static boolean authenticated() {
        return AuthHelper.user != null;//user khác null =>Đã đăng nhập
    }

    //Kiểm tra vai trò trưởng phòng hay nhân viên 
    public static boolean isManager() {
        return AuthHelper.authenticated() && user.isVaitro();
    }
}
