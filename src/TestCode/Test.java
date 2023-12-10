/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestCode;

import DAO.HopDongDAO;
import card.cardThueXe;
import entyti.HopDong;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hieu
 */
public class Test {
    HopDongDAO hdd = new HopDongDAO();
    String S_ngaythue  = "12/12/2023";
    int songaythue = 12;
    Date ngayThue = Hepler.DateHelper.toDate(S_ngaythue, "dd/MM/yyyy");
    String maxe = "xe01";
    public int tinhSoNgayThue(int songaythue) {
        List<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int max = -1;
        for (int i = 1; i <= songaythue; i++) {
            if (kiemtraxe(i)) {
                list.add(i);
            }
        }
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public boolean kiemtraxe(int ngaythue) {
        Date ngayTra = null;
        Date ngaythue_fake = null;
        ngaythue_fake = (Date) ngayThue.clone();
        ngayTra = Hepler.DateHelper.addDays(ngaythue_fake, ngaythue);
        try {
            HopDong hd = hdd.selectByID_MAXE_NULL(this.maxe, ngayTra);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
}
