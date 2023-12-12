/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author Hieu
 */
public class PhuPhi {
    private String maphuphi;
    private String tenphuphi;
    private int giatri;
    private boolean trangthai;

    public PhuPhi() {
    }

    public String getMaphuphi() {
        return maphuphi;
    }

    public void setMaphuphi(String maphuphi) {
        this.maphuphi = maphuphi;
    }

    public String getTenphuphi() {
        return tenphuphi;
    }

    public void setTenphuphi(String tenphuphi) {
        this.tenphuphi = tenphuphi;
    }

    public int getGiatri() {
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

    public PhuPhi(String maphuphi, String tenphuphi, int giatri, boolean trangthai) {
        this.maphuphi = maphuphi;
        this.tenphuphi = tenphuphi;
        this.giatri = giatri;
        this.trangthai = trangthai;
    }
    
}
