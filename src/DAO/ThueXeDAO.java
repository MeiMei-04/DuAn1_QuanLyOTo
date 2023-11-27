/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entyti.Xe;
import java.util.List;
import Hepler.JDBCHelper;
import entyti.TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class ThueXeDAO extends QuanLyOToDAO<Xe, String> {

    String INSERT_SQL = "INSERT INTO Xe (MaXe, TenXe, SoGhe, TrangThai, GiaThue, Anh_Xe, MaLoaiXe, GhiChu) VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Xe SET TenXe=?,SoGhe = ?,TrangThai=?, GiaThue = ?,Anh_Xe = ?,MaLoaiXe=?,GhiChu=? WHERE MaXe =?";
    String DELETE_SQL = "DELETE FROM Xe WHERE MaXe =?";
    String SELECT_ALL_SQL = "SELECT * FROM xe";
    String SELECT_BY_ID_SQL = "SELECT*FROM xe WHERE MaXe = ?";

    @Override
    public void insert(Xe entity) {
        JDBCHelper.executeUpdate(INSERT_SQL, entity.getMaxe(), entity.getTenxe(), entity.getSoghe(), entity.isTrangthaixethue(),entity.getGiathue(), entity.getAnhxe(),entity.getMaloaixe(),entity.getGhichu());
    }

    @Override
    public void update(Xe entity) {
        JDBCHelper.executeUpdate(UPDATE_SQL, entity.getTenxe(), entity.getSoghe(), entity.isTrangthaixethue(),entity.getGiathue(), entity.getAnhxe(),entity.getMaloaixe(),entity.getGhichu(), entity.getMaxe());
    }

    @Override
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<Xe> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public Xe selectByID(String id) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<Xe> list = selectBySQL(SELECT_BY_ID_SQL, id);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    @Override
    protected List<Xe> selectBySQL(String sql, Object... args) {
        List<Xe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                Xe xe = new Xe();
                xe.setMaxe(rs.getString("MaXe"));
                xe.setTenxe(rs.getString("TenXe"));
                xe.setSoghe(rs.getInt("SoGhe"));
                xe.setTrangthaixethue(rs.getBoolean("TrangThai"));
                xe.setGiathue(rs.getInt("GiaThue"));
                xe.setAnhxe(rs.getString("Anh_Xe"));
                xe.setMaloaixe(rs.getString("MaLoaiXe"));
                xe.setGhichu(rs.getString("ghichu"));
                list.add(xe);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Xe> selectByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update_1(Xe entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Xe selectByID_1(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
