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
    private String ghichu;
    private Date ngaythue;
    private Date ngaytra;
    private String madichvu;
    private int thanhtien;
    private boolean trangthaihopdong;

    public HopDong() {
    }

    public HopDong(String mahopdong, String maxe, int userid, String ghichu, Date ngaythue, Date ngaytra, String madichvu, int thanhtien, boolean trangthaihopdong) {
        this.mahopdong = mahopdong;
        this.maxe = maxe;
        this.userid = userid;
        this.ghichu = ghichu;
        this.ngaythue = ngaythue;
        this.ngaytra = ngaytra;
        this.madichvu = madichvu;
        this.thanhtien = thanhtien;
        this.trangthaihopdong = trangthaihopdong;
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

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Date getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(Date ngaythue) {
        this.ngaythue = ngaythue;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(String madichvu) {
        this.madichvu = madichvu;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public boolean isTrangthaihopdong() {
        return trangthaihopdong;
    }

    public void setTrangthaihopdong(boolean trangthaihopdong) {
        this.trangthaihopdong = trangthaihopdong;
    }
    
    
    
}
