/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

import java.util.Date;

/**
 *
 * @author Hieu
 */
public class SuaChuaBaoDuong {
    private String maxe;
    private String noidung;
    private Date langannhat;
    private Date ngaysuachua;

    public SuaChuaBaoDuong(String maxe, String noidung, Date langannhat, Date ngaysuachua) {
        this.maxe = maxe;
        this.noidung = noidung;
        this.langannhat = langannhat;
        this.ngaysuachua = ngaysuachua;
    }

    public SuaChuaBaoDuong() {
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

    public Date getLangannhat() {
        return langannhat;
    }

    public void setLangannhat(Date langannhat) {
        this.langannhat = langannhat;
    }

    public Date getNgaysuachua() {
        return ngaysuachua;
    }

    public void setNgaysuachua(Date ngaysuachua) {
        this.ngaysuachua = ngaysuachua;
    }
    
    
}
