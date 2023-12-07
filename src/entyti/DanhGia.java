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
    private int userid;
    private String maxe;
    private String noidung;
    private Date ngaydanhgia;
    private int sosaodanhgia;

    public DanhGia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
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

    public DanhGia(int id, int userid, String maxe, String noidung, Date ngaydanhgia, int sosaodanhgia) {
        this.id = id;
        this.userid = userid;
        this.maxe = maxe;
        this.noidung = noidung;
        this.ngaydanhgia = ngaydanhgia;
        this.sosaodanhgia = sosaodanhgia;
    }

    
}
