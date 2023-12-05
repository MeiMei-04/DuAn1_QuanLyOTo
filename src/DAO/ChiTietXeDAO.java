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

    String INSERT = "INSERT INTO Xe ("
            + "MaXe, "
            + "TenXe, "
            + "SoGhe, "
            + "GiaThue, "
            + "Anh_Xe, "
            + "Mahangxe, "
            + "trangthaithue) "
            + "VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE = "UPDATE Xe SET"
            + "TenXe=?,"
            + "SoGhe = ?,"
            + "GiaThue = ?,"
            + "Anh_Xe = ?,"
            + "mahangxe=?,"
            + "trangthaithue=? "
            + "WHERE MaXe =?";
    String DELETE = "DELETE FROM Xe WHERE MaXe =?";
    String SELECT_ALL = "SELECT * FROM xe";
    String SELECT_BY_ID_MAXE = "SELECT*FROM xe WHERE MaXe = ?";

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
