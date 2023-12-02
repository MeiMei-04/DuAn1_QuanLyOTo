/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author HieuCute
 */
public class openweb {
    public static void openWebPage(String filePath) {
        try {
            // Kiểm tra xem máy tính có hỗ trợ Desktop không
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Kiểm tra xem URI có thể được tạo từ đường dẫn không
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Chuyển đổi đường dẫn tệp thành URI
                    URI uri = new File(filePath).toURI();

                    // Mở trang web trong trình duyệt mặc định
                    desktop.browse(uri);
                }
            } else {
                System.out.println("Không hỗ trợ Desktop trên máy tính này.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
