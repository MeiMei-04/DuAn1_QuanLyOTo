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
public class ChiTietTaiKhoanDAO extends QuanLyOToDAO<ChiTietTaiKhoan, String> {

    String INSERT_SQL = "INSERT INTO ChiTietTaiKhoan (userid,hoten,Email,anhdaidien,cccd,banglaixe,sdt,ngaysinh,gioitinh,diachi,sodu) values(?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ChiTietTaiKhoan SET hoten=?,email = ?,anhdaidien=?, cccd = ?,banglaixe = ?,sdt=?,ngaysinh=?,gioitinh=?,diachi=?, sodu=? WHERE userid =?";
    String DELETE_SQL = "DELETE FROM ChiTietTaiKhoan WHERE userid =?";
    String SELECT_ALL_SQL = "SELECT * FROM ChiTietTaiKhoan";
    String SELECT_BY_ID_SQL = "select * from ChiTietTaiKhoan where userid =?";

    @Override
    public void insert(ChiTietTaiKhoan entity) {
        JDBCHelper.executeUpdate(INSERT_SQL, entity.getUserid(), entity.getHoten(), entity.getEmail(), entity.getAnhdaidien(), entity.getCccd(),entity.getBanglaixe(),entity.getSdt(),entity.getNgaysinh(),entity.isGioitinh(),entity.getDiachi(),entity.getSodu());
    }

    @Override
    public void update(ChiTietTaiKhoan entity) {
        JDBCHelper.executeUpdate(UPDATE_SQL, entity.getHoten(), entity.getEmail(), entity.getAnhdaidien(), entity.getCccd(),entity.getBanglaixe(),entity.getSdt(),entity.getNgaysinh(),entity.isGioitinh(),entity.getDiachi(),entity.getSodu(),entity.getUserid());
    }

    @Override
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<ChiTietTaiKhoan> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietTaiKhoan selectByID(String key) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<ChiTietTaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    @Override
    public List<ChiTietTaiKhoan> selectByKey(String key) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<ChiTietTaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    @Override
    protected List<ChiTietTaiKhoan> selectBySQL(String sql, Object... args) {
       List<ChiTietTaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                ChiTietTaiKhoan cttk = new ChiTietTaiKhoan();
                cttk.setUserid(rs.getInt("userid"));
                cttk.setHoten(rs.getString("hoten"));
                cttk.setEmail(rs.getString("email"));
                cttk.setAnhdaidien(rs.getString("anhdaidien"));
                cttk.setCccd(rs.getString("cccd"));
                cttk.setBanglaixe(rs.getString("banglaixe"));
                cttk.setSdt(rs.getString("sdt"));
                cttk.setNgaysinh(rs.getDate("ngaysinh"));
                cttk.setGioitinh(rs.getBoolean("gioitinh"));
                cttk.setDiachi(rs.getString("diachi"));
                cttk.setSodu(rs.getFloat("sodu"));
                list.add(cttk);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

}
