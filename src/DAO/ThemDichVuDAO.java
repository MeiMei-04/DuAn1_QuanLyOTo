/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.ThemDichVu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truon
 */
public class ThemDichVuDAO {
    String INSERT = "INSERT INTO themdichvu (mahopdong,madichvu) values(?,?)";
    String UPDATE = "UPDATE TaiKhoan SET  madichvu=? WHERE mahopdong =?";
    String DELETE_SQL = "DELETE FROM themdichvu WHERE mahopdong =?";
    String SELECT_ALL = "SELECT * FROM themdichvu";
    String SELECT_BY_ID_MAHOPDONG = "select * from themdichvu where mahopdong =?";
    
    public void insert(ThemDichVu entity) {
        JDBCHelper.executeUpdate(INSERT,entity.getMahopdong(),entity.getMadichvu());
    }

    public void update(ThemDichVu entity) {
        JDBCHelper.executeUpdate(UPDATE, entity.getMadichvu(), entity.getMahopdong());
    }
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    public List<ThemDichVu> selectAll() {
        return selectBySQL(SELECT_ALL);
    }


    public List<ThemDichVu> selectByKey_MAHOPDONG(String MAHOPDONG) {
        List<ThemDichVu> list = selectBySQL(SELECT_BY_ID_MAHOPDONG, MAHOPDONG);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    protected List<ThemDichVu> selectBySQL(String sql, Object... args) {
        List<ThemDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                ThemDichVu tdv = new ThemDichVu();
                tdv.setMadichvu(rs.getString("madichvu"));
                tdv.setMahopdong(rs.getString("mahopdong"));
                list.add(tdv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }
}
