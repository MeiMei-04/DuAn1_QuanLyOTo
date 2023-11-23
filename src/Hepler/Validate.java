/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import DAO.TaiKhoanDAO;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import entyti.TaiKhoan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author HieuCute
 */
public class Validate extends javax.swing.JFrame {
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
