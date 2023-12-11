/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entyti.ChiTietXe;
import java.util.List;
import Hepler.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class ChiTietXeDAO {

    String INSERT = "INSERT INTO ChiTietXe ("
            + "MaXe, "
            + "TenXe, "
            + "SoGhe, "
            + "GiaThue, "
            + "Anh_Xe, "
            + "Mahangxe, "
            + "trangthaixe) "
            + "VALUES (?,?,?,?,?,?,?)";
    String UPDATE = "UPDATE ChiTietXe SET "
            + "TenXe =?,"
            + "SoGhe = ?,"
            + "GiaThue = ?,"
            + "Anh_Xe = ?,"
            + "mahangxe=?,"
            + "trangthaixe=? "
            + "WHERE MaXe =?";
    String DELETE = "DELETE FROM ChiTietXe WHERE MaXe =?";
    String SELECT_ALL = "SELECT * FROM ChiTietXe";
    String SELECT_BY_ID_MAXE = "SELECT*FROM ChiTietXe WHERE MaXe = ?";
    String SELECT_BY_ID_TENXE = "SELECT*FROM ChiTietXe WHERE TENXE = ?";
    String SELECT_BY_ID_TENXEtim = "SELECT*FROM ChiTietXe WHERE TENXE like ?";
    String UPDATE_CHITIETXE = "UPDATE CHITIETXE SET TRANGTHAIXE = ? WHERE MAXE = ?";

    public void insert(ChiTietXe entity) {
        JDBCHelper.executeUpdate(INSERT,
                entity.getMaxe(),
                entity.getTenxe(),
                entity.getSoghe(),
                entity.getGiathue(),
                entity.getAnhxe(),
                entity.getMahangxe(),
                entity.getTrangthaixe()
        );
    }

    public void update(ChiTietXe entity) {
        JDBCHelper.executeUpdate(UPDATE,
                entity.getTenxe(),
                entity.getSoghe(),
                entity.getGiathue(),
                entity.getAnhxe(),
                entity.getMahangxe(),
                entity.getTrangthaixe(),
                entity.getMaxe());
    }
    public void update_CHITIETXE(ChiTietXe entity) {
        JDBCHelper.executeUpdate(UPDATE_CHITIETXE,
                entity.getTrangthaixe(),
                entity.getMaxe());
    }
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<ChiTietXe> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public ChiTietXe selectByID_MAXE(String MAXE) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<ChiTietXe> list = selectBySQL(SELECT_BY_ID_MAXE, MAXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    public ChiTietXe selectByID_TENXE(String TENXE) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<ChiTietXe> list = selectBySQL(SELECT_BY_ID_TENXE, TENXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    public List<ChiTietXe> selectByID_TENXETim(String TENXE) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<ChiTietXe> list = selectBySQL(SELECT_BY_ID_TENXEtim, TENXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    protected List<ChiTietXe> selectBySQL(String sql, Object... args) {
        List<ChiTietXe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                ChiTietXe xe = new ChiTietXe();
                xe.setMaxe(rs.getString("MaXe"));
                xe.setTenxe(rs.getString("TenXe"));
                xe.setSoghe(rs.getInt("SoGhe"));
                xe.setGiathue(rs.getInt("GiaThue"));
                xe.setAnhxe(rs.getString("Anh_Xe"));
                xe.setMahangxe(rs.getInt("mahangxe"));
                xe.setTrangthaixe(rs.getString("trangthaixe"));
                list.add(xe);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

}
