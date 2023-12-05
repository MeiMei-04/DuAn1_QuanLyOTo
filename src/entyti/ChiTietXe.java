/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author hieud
 */
public class ChiTietXe {
    private String maxe;
    private String tenxe;
    private int soghe;
    private int giathue;
    private String anhxe;
    private int mahangxe;
    private String trangthaixe;

    public ChiTietXe() {
    }

    public ChiTietXe(String maxe, String tenxe, int soghe, int giathue, String anhxe, int mahangxe, String trangthaixe) {
        this.maxe = maxe;
        this.tenxe = tenxe;
        this.soghe = soghe;
        this.giathue = giathue;
        this.anhxe = anhxe;
        this.mahangxe = mahangxe;
        this.trangthaixe = trangthaixe;
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

    public int getGiathue() {
        return giathue;
    }

    public void setGiathue(int giathue) {
        this.giathue = giathue;
    }

    public String getAnhxe() {
        return anhxe;
    }

    public void setAnhxe(String anhxe) {
        this.anhxe = anhxe;
    }

    public int getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(int mahangxe) {
        this.mahangxe = mahangxe;
    }

    public String getTrangthaixe() {
        return trangthaixe;
    }

    public void setTrangthaixe(String trangthaixe) {
        this.trangthaixe = trangthaixe;
    }
    public String tenhangxe(int mahangxe){
        if(mahangxe == 1){
            return "KIA";
        }else if(mahangxe == 2 ){
            return "Vinfast";
        }else if(mahangxe == 3 ){
            return "Mercedes";
        }else if(mahangxe == 4 ){
            return "Toyota";
        }else if(mahangxe == 5 ){
            return "Audi";
        }else if(mahangxe == 6 ){
            return "Lexus";
        }else if(mahangxe == 7 ){
            return "BMW";
        }else if(mahangxe == 8 ){
            return "Honda";
        }else if(mahangxe == 9 ){
            return "Mazda";
        }else if(mahangxe == 10 ){
            return "Ford";
        }else if(mahangxe == 11 ){
            return "Hyundai";
        }else if(mahangxe == 12 ){
            return "Samco";
        }
        
        return null;
    }

    
}
