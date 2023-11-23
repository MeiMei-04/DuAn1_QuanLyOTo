/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author truon
 */
public class Voucher {
    private String mavoucher;
    private String noidung;
    private int giatri;
    private boolean trangthai;

    public Voucher() {
    }

    public Voucher(String mavoucher, String noidung, int giatri, boolean trangthai) {
        this.mavoucher = mavoucher;
        this.noidung = noidung;
        this.giatri = giatri;
        this.trangthai = trangthai;
    }

    public String getMavoucher() {
        return mavoucher;
    }

    public void setMavoucher(String mavoucher) {
        this.mavoucher = mavoucher;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public float getGiatri() {
        return giatri;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

   
}
