/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
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

    //tạo ngày cách ngày hiện tại số ngày int
    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }

    // hàm kiểm tra xem có phải ngày tháng k
    public static boolean isValidDate(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            df.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // hàm kiểm tra định dạng alpha
    public static boolean isAlphabetic(String input) {
        return !input.isEmpty() && input.matches("[\\p{L} ]+");
    }

    //hàm kiểm tra năm
    public static boolean isMoreThan16YearsAgo(LocalDate date) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(date, now);
        return period.getYears() > 16;
    }

    public static boolean isMoreThan5DaysFromNow(LocalDate date) {
        LocalDate now = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(now, date);
        return daysBetween >= 5;
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
    //kiểm tra chuỗi có phải 1 số hay không

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
