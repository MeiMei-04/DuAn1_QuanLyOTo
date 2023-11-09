/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author hieud
 */
public class pickimg {

    public static String chonAnh() {
        JFileChooser f = new JFileChooser();
        f.setDialogTitle("Chọn ảnh");
        f.showOpenDialog(null);
        File file = f.getSelectedFile();
        if (file != null) {
            String urlanh = file.getAbsolutePath();
            System.out.println("Chọn ảnh thành công");
            return file.getName();
        } else {
            System.out.println("lỗi chọn ảnh");
            return null;
        }
    }

}
