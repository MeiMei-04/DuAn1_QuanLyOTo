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
    private boolean trangthai;

    public Voucher(String mavoucher, String noidung, boolean trangthai) {
        this.mavoucher = mavoucher;
        this.noidung = noidung;
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

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Voucher() {
    }
}
