/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.HangXe;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class HangXeDAO {

    String INSERT = "INSERT INTO HangXe ("
            + "TenHangXe"
            + "values(?)";
    String UPDATE = "UPDATE HangXe SET "
            + "TenHangXe = ?"
            + "WHERE MaHangXe =?";

    String DELETE = "DELETE FROM HangXe WHERE MaHangXe =?";
    String SELECT_ALL = "SELECT * FROM HangXe";
    String SELECT_BY_ID_TENHANGXE = "select * from HangXe where TenHangXe =?";
    String SELECT_BY_ID_MAHANGXE = "select * from HangXe where mahangxe =?";

    public void insert(HangXe entity) {
        JDBCHelper.executeUpdate(INSERT,
                entity.getMahangxe(),
                entity.getTenhangxe()
        );
    }

    //sửa
    public void update(HangXe entity) {
        JDBCHelper.executeUpdate(UPDATE,
                entity.getTenhangxe(),
                entity.getMahangxe()
        );
    }

    //xóa
    public void delete(String MaHangXe) {
        JDBCHelper.executeUpdate(DELETE, MaHangXe);
    }

    //trả về danh sách tất cả các bản ghi
    public List<HangXe> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    //trả về 1 đối tượng HangXe khi userid =
    public HangXe selectByID_MAHANGXE(int MAHANGXE) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<HangXe> list = selectBySQL(SELECT_BY_ID_MAHANGXE, MAHANGXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }
    public HangXe selectByID_TENHANGXE(String TenHangXe) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<HangXe> list = selectBySQL(SELECT_BY_ID_TENHANGXE, TenHangXe);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }
    protected List<HangXe> selectBySQL(String sql, Object... args) {
        List<HangXe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                HangXe hx = new HangXe();
                hx.setMahangxe(rs.getInt("MaHangXe"));
                hx.setTenhangxe(rs.getString("TenHangXe"));
                list.add(hx);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

}
