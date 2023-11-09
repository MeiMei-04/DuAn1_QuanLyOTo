/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author HieuCute
 */
public class set_iconlbl {
    public static void setIconlabel(JLabel label, String path){
        ImageIcon icon = new ImageIcon(path);
        // Tạo một nhãn mới và đặt biểu tượng cho nó
        label.setIcon(icon);
    }
    public static void checkfile(String patha){
        Path path = Paths.get(patha);

        // Kiểm tra xem tệp có tồn tại hay không
        if (Files.exists(path)) {
            System.out.println("Tệp tồn tại.");
        } else {
            System.out.println("Tệp không tồn tại.");
        }
    }
}
