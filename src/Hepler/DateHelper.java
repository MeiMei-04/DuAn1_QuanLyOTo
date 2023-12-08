/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import entyti.HopDong;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    // kiểm tra định dạng ngày
    public static boolean isValidDate(String input, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        try {
            sdf.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    // kiểm tra xem ngày nhập có hơn ngày hiện tại không
    public static boolean isFutureDate(String input, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        try {
            Date inputDate = sdf.parse(input);
            
            // Lấy ngày hiện tại
            Date currentDate = new Date();
            
            // So sánh ngày nhập liệu với ngày hiện tại, bao gồm trường hợp bằng nhau
            return !inputDate.before(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }
    // Phương thức hỗ trợ để tính số ngày thuê còn lại
    public static int calculateRemainingDays(List<HopDong> contracts, Date rentalStart, Date rentalEnd,int songaythue){
        int remainingDays = songaythue;

        for (HopDong hd : contracts) {
            if (rentalStart.after(hd.getNgaythue()) && rentalStart.before(hd.getNgayhethan())) {
                // Ngày thuê nằm trong một hợp đồng hiện tại
                remainingDays -= calculateDaysBetween(rentalStart, hd.getNgayhethan());
            } else if (rentalEnd.after(hd.getNgaythue()) && rentalEnd.before(hd.getNgayhethan())) {
                // Ngày trả nằm trong một hợp đồng hiện tại
                remainingDays -= calculateDaysBetween(hd.getNgaythue(), rentalEnd);
            }
        }

        return remainingDays;
    }

// Phương thức hỗ trợ để tính số ngày giữa hai ngày
    private static int calculateDaysBetween(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
