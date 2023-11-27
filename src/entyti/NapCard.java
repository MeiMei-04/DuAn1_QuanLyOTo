/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author Hieu
 */
public class NapCard {
    private int ID;
    private String manap;
    private String noidung;
    private int giatri;
    private boolean trangthai;

    public NapCard() {
    }

    public NapCard(int ID, String manap, String noidung, int giatri, boolean trangthai) {
        this.ID = ID;
        this.manap = manap;
        this.noidung = noidung;
        this.giatri = giatri;
        this.trangthai = trangthai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getManap() {
        return manap;
    }

    public void setManap(String manap) {
        this.manap = manap;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
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
    
  
    
}
