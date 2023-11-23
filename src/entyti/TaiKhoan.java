/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entyti;

/**
 *
 * @author hieud
 */
public class TaiKhoan {
    private int userid;
    private String taikhoan;
    private String matkhau;
    private String email;
    private boolean vaitro;
    private boolean trangthai;

    public TaiKhoan() {
    }

    public TaiKhoan(int userid, String taikhoan, String matkhau, String email, boolean vaitro, boolean trangthai) {
        this.userid = userid;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.email = email;
        this.vaitro = vaitro;
        this.trangthai = trangthai;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVaitro() {
        return vaitro;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    
    
}
