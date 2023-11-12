/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author hieud
 */
public class ImagesHelper {

    //lưu file
    public static void saveLogo(File src) {
        File dst = new File("logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    //đọc file
    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    //chọn file
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

    //đặt icon cho nhãn
    public static void setIconlabel(JLabel label, String path) {
        ImageIcon icon = new ImageIcon(path);
        // Tạo một nhãn mới và đặt biểu tượng cho nó
        label.setIcon(icon);
    }

    //kiểm tra file
    public static void checkfile(String patha) {
        Path path = Paths.get(patha);

        // Kiểm tra xem tệp có tồn tại hay không
        if (Files.exists(path)) {
            System.out.println("Tệp tồn tại.");
        } else {
            System.out.println("Tệp không tồn tại.");
        }
    }

    //đặt icon cho nút
    public static void setIconButton(JButton button, String path) {
        ImageIcon icon = new ImageIcon(path);
        // Tạo một nhãn mới và đặt biểu tượng cho nó
        button.setIcon(icon);
    }
    public static Image getAppIcon() {
        ImageIcon imgIcon = new ImageIcon("src/IMAGE/logo.png");
        Image img = imgIcon.getImage();
        return img;
    }
    public static void main(String[] args) {
        
    }
}
