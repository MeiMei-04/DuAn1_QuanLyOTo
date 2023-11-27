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
public class ChiTietTaiKhoan {
    private int id_detail;
    private int userid;
    private String hoten;
    private String anhdaidien;
    private String cccd;
    private String banglaixe;
    private String sdt;
    private Date ngaysinh;
    private int sodu;
    private boolean gioitinh;
    private String diachi;
    private boolean yeucauxacthuc;

    public ChiTietTaiKhoan() {
    }

    public ChiTietTaiKhoan(int id_detail, int userid, String hoten, String anhdaidien, String cccd, String banglaixe, String sdt, Date ngaysinh, int sodu, boolean gioitinh, String diachi, boolean yeucauxacthuc) {
        this.id_detail = id_detail;
        this.userid = userid;
        this.hoten = hoten;
        this.anhdaidien = anhdaidien;
        this.cccd = cccd;
        this.banglaixe = banglaixe;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.sodu = sodu;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.yeucauxacthuc = yeucauxacthuc;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getBanglaixe() {
        return banglaixe;
    }

    public void setBanglaixe(String banglaixe) {
        this.banglaixe = banglaixe;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getSodu() {
        return sodu;
    }

    public void setSodu(int sodu) {
        this.sodu = sodu;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isYeucauxacthuc() {
        return yeucauxacthuc;
    }

    public void setYeucauxacthuc(boolean yeucauxacthuc) {
        this.yeucauxacthuc = yeucauxacthuc;
    }

    
}
