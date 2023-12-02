/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 *
 * @author hieud
 */
public class DateHelper {

    static SimpleDateFormat formater = new SimpleDateFormat();

    //chuyển chuỗi sang kiểu date
    public static Date toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);//
            return formater.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // chuyển kiểu date sang chuỗi
    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);

    }

    // cộng ngày vào 1 ngày cụ thể
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    // lấy ngày hiện tại
    public static Date now() {
        return new Date();
    }

    public static String nowdate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    //tạo ngày cách ngày hiện tại số ngày int
    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }

    //convert to localdate
    public static LocalDate toLocalDate(String date, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e);
        }
    }

}
