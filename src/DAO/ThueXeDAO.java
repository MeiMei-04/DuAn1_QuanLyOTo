/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entyti.Xe;
import java.util.List;
import Hepler.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class ThueXeDAO {

    String INSERT = "INSERT INTO Xe (MaXe, TenXe, SoGhe, TrangThai, GiaThue, Anh_Xe, MaLoaiXe, GhiChu) VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE = "UPDATE Xe SET TenXe=?,SoGhe = ?,TrangThai=?, GiaThue = ?,Anh_Xe = ?,MaLoaiXe=?,GhiChu=? WHERE MaXe =?";
    String DELETE = "DELETE FROM Xe WHERE MaXe =?";
    String SELECT_ALL = "SELECT * FROM xe";
    String SELECT_BY_ID_MAXE = "SELECT*FROM xe WHERE MaXe = ?";
    String UPDATE_TRANGTHAI = "UPDATE Xe SET TrangThai=? WHERE MaXe =?";

    public void insert(Xe entity) {
        JDBCHelper.executeUpdate(INSERT, entity.getMaxe(), entity.getTenxe(), entity.getSoghe(), entity.isTrangthaixethue(),entity.getGiathue(), entity.getAnhxe(),entity.getMaloaixe(),entity.getGhichu());
    }

    public void update(Xe entity) {
        JDBCHelper.executeUpdate(UPDATE, entity.getTenxe(), entity.getSoghe(), entity.isTrangthaixethue(),entity.getGiathue(), entity.getAnhxe(),entity.getMaloaixe(),entity.getGhichu(), entity.getMaxe());
    }

    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<Xe> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public Xe selectByID_MAXE(String MAXE) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<Xe> list = selectBySQL(SELECT_BY_ID_MAXE, MAXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

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


    public void update_TRANTHAI(Xe entity) {
        JDBCHelper.executeUpdate(UPDATE_TRANGTHAI, entity.isTrangthaixethue(), entity.getMaxe());
    }

}
