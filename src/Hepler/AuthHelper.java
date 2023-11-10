/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import entyti.TaiKhoan;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
