/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author hieud
 */
public class DichVu {
    private String madichvu;
    private String tendichvu;
    private String ghichu;
    private int dongia;
    private boolean trangthai;

    public DichVu() {
    }

    public DichVu(String madichvu, String tendichvu, String ghichu, int dongia, boolean trangthai) {
        this.madichvu = madichvu;
        this.tendichvu = tendichvu;
        this.ghichu = ghichu;
        this.dongia = dongia;
        this.trangthai = trangthai;
    }

    public String getMadichvu() {
        return madichvu;
    }

    public void setMadichvu(String madichvu) {
        this.madichvu = madichvu;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

}
