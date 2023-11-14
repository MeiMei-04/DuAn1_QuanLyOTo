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
    private double dongia;

    public DichVu() {
    }

    public DichVu(String madichvu, String tendichvu, String ghichu, double dongia) {
        this.madichvu = madichvu;
        this.tendichvu = tendichvu;
        this.ghichu = ghichu;
        this.dongia = dongia;
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

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

 
    
}
