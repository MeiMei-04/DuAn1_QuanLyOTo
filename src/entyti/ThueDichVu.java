/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author truon
 */
public class ThueDichVu {
    private int userid;
    private String maxe;
    private String dichvu;

    public ThueDichVu() {
    }

    public ThueDichVu(int userid, String maxe, String dichvu) {
        this.userid = userid;
        this.maxe = maxe;
        this.dichvu = dichvu;
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

    public String getDichvu() {
        return dichvu;
    }

    public void setDichvu(String dichvu) {
        this.dichvu = dichvu;
    }
    
}
