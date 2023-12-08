/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.text.DecimalFormat;

/**
 *
 * @author HieuCute
 */
public class MoneyFormatter {
    public static String formatMoney(int giathue) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###");
        return decimalFormat.format(giathue) + " VNĐ";
    }
}
