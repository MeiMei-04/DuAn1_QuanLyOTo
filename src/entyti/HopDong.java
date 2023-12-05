/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

import java.util.Date;

/**
 *
 * @author hieud
 */
public class HopDong {
    private String mahopdong;
    private String maxe;
    private int userid;
    private Date ngaythue;
    private Date ngayhethan;
    private Date ngaytraxe;
    private int songayquahan;
    private String mavoucher;
    private int thanhtien;
    private int thoihanhopdong;
    private String diadiemnhanxe;
    private int tinhtranghopdong;

    public HopDong() {
    }

    public HopDong(String mahopdong, String maxe, int userid, Date ngaythue, Date ngayhethan, Date ngaytraxe, int songayquahan, String mavoucher, int thanhtien, int thoihanhopdong, String diadiemnhanxe, int tinhtranghopdong) {
        this.mahopdong = mahopdong;
        this.maxe = maxe;
        this.userid = userid;
        this.ngaythue = ngaythue;
        this.ngayhethan = ngayhethan;
        this.ngaytraxe = ngaytraxe;
        this.songayquahan = songayquahan;
        this.mavoucher = mavoucher;
        this.thanhtien = thanhtien;
        this.thoihanhopdong = thoihanhopdong;
        this.diadiemnhanxe = diadiemnhanxe;
        this.tinhtranghopdong = tinhtranghopdong;
    }

    public String getMahopdong() {
        return mahopdong;
    }

    public void setMahopdong(String mahopdong) {
        this.mahopdong = mahopdong;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(Date ngaythue) {
        this.ngaythue = ngaythue;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(Date ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public Date getNgaytraxe() {
        return ngaytraxe;
    }

    public void setNgaytraxe(Date ngaytraxe) {
        this.ngaytraxe = ngaytraxe;
    }

    public int getSongayquahan() {
        return songayquahan;
    }

    public void setSongayquahan(int songayquahan) {
        this.songayquahan = songayquahan;
    }

    public String getMavoucher() {
        return mavoucher;
    }

    public void setMavoucher(String mavoucher) {
        this.mavoucher = mavoucher;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getThoihanhopdong() {
        return thoihanhopdong;
    }

    public void setThoihanhopdong(int thoihanhopdong) {
        this.thoihanhopdong = thoihanhopdong;
    }

    public String getDiadiemnhanxe() {
        return diadiemnhanxe;
    }

    public void setDiadiemnhanxe(String diadiemnhanxe) {
        this.diadiemnhanxe = diadiemnhanxe;
    }

    public int getTinhtranghopdong() {
        return tinhtranghopdong;
    }

    public void setTinhtranghopdong(int tinhtranghopdong) {
        this.tinhtranghopdong = tinhtranghopdong;
    }

    
}
