/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import net.ifok.image.image4j.codec.ico.ICOEncoder;

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
        JFileChooser f = new JFileChooser("/src");
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
    public static boolean checkfile(String patha) {
        Path path = Paths.get(patha);

        // Kiểm tra xem tệp có tồn tại hay không
        if (Files.exists(path)) {
            System.out.println("Tệp tồn tại.");
            return true;
        } else {
            System.out.println("Tệp không tồn tại.");
            return false;
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
    public static void convertImgTo280x180(String readurl,String patch,String writeurl) {
        try {
            // Đọc hình ảnh
            BufferedImage image = ImageIO.read(new File(readurl+ patch));

            // Thay đổi kích thước hình ảnh thành 24x35
            Image tempImage = image.getScaledInstance(280, 180, Image.SCALE_SMOOTH);
            BufferedImage resizedImage = new BufferedImage(280, 180, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resizedImage.createGraphics();
            
            g.drawImage(tempImage, 0, 0, null);
            g.dispose();
            File dir = new File(writeurl);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //kiểm tra xem tệp tồn tại chưa, rồi thì không thêm nưa
            if(checkfile(writeurl+patch)){
                return;
           }else{
                ImageIO.write(resizedImage, "png", new File(writeurl+ patch));
            }
            // Ghi hình ảnh đã thay đổi kích thước vào tệp gốc
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void convertImgTo110x164(String readurl,String patch,String writeurl) {
        try {
            // Đọc hình ảnh
            BufferedImage image = ImageIO.read(new File(readurl+ patch));

            // Thay đổi kích thước hình ảnh thành 24x35
            Image tempImage = image.getScaledInstance(110, 164, Image.SCALE_SMOOTH);
            BufferedImage resizedImage = new BufferedImage(110, 164, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resizedImage.createGraphics();
            
            g.drawImage(tempImage, 0, 0, null);
            g.dispose();
            File dir = new File(writeurl);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //kiểm tra xem tệp tồn tại chưa, rồi thì không thêm nưa
            if(checkfile(writeurl+patch)){
                return;
           }else{
                ImageIO.write(resizedImage, "png", new File(writeurl+ patch));
            }
            // Ghi hình ảnh đã thay đổi kích thước vào tệp gốc
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteImg(String writeurl,String patch){
        File file = new File(writeurl+patch);

        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }
    public static void main(String[] args) {
    }
}
