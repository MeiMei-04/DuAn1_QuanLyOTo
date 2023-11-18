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
public class DanhGia {
    private int id;
    private String maxe;
    private String hoten;
    private String anhdaidien;
    private String noidung;
    private Date ngaydanhgia;
    private int sosaodanhgia;

    public DanhGia() {
    }

    public DanhGia(int id, String maxe, String hoten, String anhdaidien, String noidung, Date ngaydanhgia, int sosaodanhgia) {
        this.id = id;
        this.maxe = maxe;
        this.hoten = hoten;
        this.anhdaidien = anhdaidien;
        this.noidung = noidung;
        this.ngaydanhgia = ngaydanhgia;
        this.sosaodanhgia = sosaodanhgia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
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

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Date getNgaydanhgia() {
        return ngaydanhgia;
    }

    public void setNgaydanhgia(Date ngaydanhgia) {
        this.ngaydanhgia = ngaydanhgia;
    }

    public int getSosaodanhgia() {
        return sosaodanhgia;
    }

    public void setSosaodanhgia(int sosaodanhgia) {
        this.sosaodanhgia = sosaodanhgia;
    }

    
}
