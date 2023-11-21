/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.util.regex.Pattern;

/**
 *
 * @author hieud
 */
public class alphaHelper {
    // hàm kiểm tra chuỗi có phải kiểu alpha ko và ko chứa cách
    public static boolean isAlphaNumeric(String str) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
        return pattern.matcher(str).matches();
    }
}
