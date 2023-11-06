/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author hieud
 */
public class Xe {
    private String maxe;
    private String tenxe;
    private int soghe;
    private boolean trangthaixethue;
    private double giathue;
    private String anhxe;
    private boolean loaixe;
    private String ghichu;

    public Xe() {
    }

    public Xe(String maxe, String tenxe, int soghe, boolean trangthaixethue, double giathue, String anhxe, boolean loaixe, String ghichu) {
        this.maxe = maxe;
        this.tenxe = tenxe;
        this.soghe = soghe;
        this.trangthaixethue = trangthaixethue;
        this.giathue = giathue;
        this.anhxe = anhxe;
        this.loaixe = loaixe;
        this.ghichu = ghichu;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public int getSoghe() {
        return soghe;
    }

    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }

    public boolean isTrangthaixethue() {
        return trangthaixethue;
    }

    public void setTrangthaixethue(boolean trangthaixethue) {
        this.trangthaixethue = trangthaixethue;
    }

    public double getGiathue() {
        return giathue;
    }

    public void setGiathue(double giathue) {
        this.giathue = giathue;
    }

    public String getAnhxe() {
        return anhxe;
    }

    public void setAnhxe(String anhxe) {
        this.anhxe = anhxe;
    }

    public boolean isLoaixe() {
        return loaixe;
    }

    public void setLoaixe(boolean loaixe) {
        this.loaixe = loaixe;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
}
