/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author hieud
 */
public class support_function {

    public static void ham_setbackground(JLabel lable) {
        lable.setSize(1280,720);
        ImageIcon icon = new ImageIcon("src/IMAGE/IMAGE/BACKGROUND ALL.jpg");
        lable.setIcon(icon);
    }

    public static void kiemtratep(String filePath) {
        Path path = Paths.get(filePath);

        if (Files.exists(path)) {
            System.out.println("Tệp tồn tại.");
        } else {
            System.out.println("Tệp không tồn tại.");
        }
    }
    
}
