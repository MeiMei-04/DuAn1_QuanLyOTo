/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.ChiTietTaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class ChiTietTaiKhoanDAO {

    String INSERT_CHITIETAIKHOAN = "INSERT INTO ChiTietTaiKhoan ("
            + "userid,"
            + "hoten,"
            + "anhdaidien,"
            + "cccd,"
            + "banglaixe,"
            + "sdt,"
            + "ngaysinh,"
            + "gioitinh,"
            + "diachi,"
            + "yeucauxacthuc) "
            + "values(?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_CHITIETAIKHOAN_THONGTIN = "UPDATE ChiTietTaiKhoan SET "
            + "hoten=?,"
            + "anhdaidien=?, "
            + "cccd = ?,"
            + "banglaixe = ?,"
            + "sdt=?,"
            + "ngaysinh=?,"
            + "gioitinh=?,"
            + "diachi=? "
            + "WHERE userid =?";
    String UPDATE_CHITIETAIKHOAN_SODU = "UPDATE ChiTietTaiKhoan SET sodu = ? WHERE userid =?";
    String DELETE_CHITIETTAIKHOAN_WHERE_USERID = "DELETE FROM ChiTietTaiKhoan WHERE userid =?";
    String SELECT_ALL = "SELECT * FROM ChiTietTaiKhoan";
    String SELECT_BY_ID_USERID = "select * from ChiTietTaiKhoan where userid =?";
    String SELECT_BY_ID_YEUCAUXACTHUC = "select * from ChiTietTaiKhoan"
            + " INNER JOIN TaiKhoan "
            + "ON ChiTietTaiKhoan.UserID = TaiKhoan.UserID "
            + "where yeucauxacthuc = ? and Trangthai = 0";

    //thêm
    public void insert(ChiTietTaiKhoan entity) {
        JDBCHelper.executeUpdate(INSERT_CHITIETAIKHOAN,
                entity.getUserid(),
                entity.getHoten(),
                entity.getAnhdaidien(),
                entity.getCccd(), 
                entity.getBanglaixe(), 
                entity.getSdt(),
                entity.getNgaysinh(), 
                entity.isGioitinh(), 
                entity.getDiachi(), 
                entity.isYeucauxacthuc()
        );
    }
    //sửa
    public void update(ChiTietTaiKhoan entity) {
        JDBCHelper.executeUpdate(UPDATE_CHITIETAIKHOAN_THONGTIN, 
                entity.getHoten(), 
                entity.getAnhdaidien(), 
                entity.getCccd(), 
                entity.getBanglaixe(), 
                entity.getSdt(), 
                entity.getNgaysinh(), 
                entity.isGioitinh(), 
                entity.getDiachi(), 
                entity.getUserid()
        );
    }
    //xóa
    public void delete(String userid) {
        JDBCHelper.executeUpdate(DELETE_CHITIETTAIKHOAN_WHERE_USERID, userid);
    }
    //trả về danh sách tất cả các bản ghi
    public List<ChiTietTaiKhoan> selectAll() {
        return selectBySQL(SELECT_ALL);
    }
    //trả về 1 đối tượng ChiTietTaiKhoan khi userid =
    public ChiTietTaiKhoan selectByID_DOITUONG(String userid) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<ChiTietTaiKhoan> list = selectBySQL(SELECT_BY_ID_USERID, userid);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    public List<ChiTietTaiKhoan> selectByID_DANHSACH(String yeucauxacthuc) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<ChiTietTaiKhoan> list = selectBySQL(SELECT_BY_ID_YEUCAUXACTHUC, yeucauxacthuc);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    protected List<ChiTietTaiKhoan> selectBySQL(String sql, Object... args) {
        List<ChiTietTaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                ChiTietTaiKhoan cttk = new ChiTietTaiKhoan();
                cttk.setUserid(rs.getInt("userid"));
                cttk.setHoten(rs.getString("hoten"));
                cttk.setAnhdaidien(rs.getString("anhdaidien"));
                cttk.setCccd(rs.getString("cccd"));
                cttk.setBanglaixe(rs.getString("banglaixe"));
                cttk.setSdt(rs.getString("sdt"));
                cttk.setNgaysinh(rs.getDate("ngaysinh"));
                cttk.setGioitinh(rs.getBoolean("gioitinh"));
                cttk.setDiachi(rs.getString("diachi"));
                cttk.setSodu(rs.getInt("sodu"));
                cttk.setYeucauxacthuc(rs.getBoolean("yeucauxacthuc"));
                list.add(cttk);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    public void update_sodu(ChiTietTaiKhoan entity) {
        JDBCHelper.executeUpdate(UPDATE_CHITIETAIKHOAN_SODU,
                entity.getSodu(),
                entity.getUserid()
        );
    }
}
