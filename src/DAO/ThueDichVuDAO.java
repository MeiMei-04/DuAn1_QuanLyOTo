/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.TaiKhoan;
import entyti.ThueDichVu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truon
 */
public class ThueDichVuDAO {
    String INSERT = "INSERT INTO themdichvu (userid,maxe,madichvu) values(?,?,?)";
    String UPDATE = "UPDATE TaiKhoan SET  madichvu=? WHERE maxe =?";
    String UPDATE_MADICHVU = "UPDATE themdichvu set Maxe =?  WHERE madichvu =?";
    String DELETE_SQL = "DELETE FROM themdichvu WHERE maxe =?";
    String SELECT_ALL = "SELECT * FROM themdichvu";
    String SELECT_BY_ID_MAXE = "select * from themdichvu where maxe =?";
    
    public void insert(ThueDichVu entity) {
        JDBCHelper.executeUpdate(INSERT,entity.getUserid() ,entity.getMaxe(), entity.getDichvu());
    }

    public void update(ThueDichVu entity) {
        JDBCHelper.executeUpdate(UPDATE, entity.getDichvu(), entity.getMaxe());
    }

    public void update_MADICHVU(ThueDichVu entity) {
        JDBCHelper.executeUpdate(UPDATE_MADICHVU, entity.getMaxe(), entity.getDichvu());
    }

    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    public List<ThueDichVu> selectAll() {
        return selectBySQL(SELECT_ALL);
    }


    public List<ThueDichVu> selectByKey_MAXE(String MAXE) {
        List<ThueDichVu> list = selectBySQL(SELECT_BY_ID_MAXE, MAXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    protected List<ThueDichVu> selectBySQL(String sql, Object... args) {
        List<ThueDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                ThueDichVu tdv = new ThueDichVu();
                tdv.setUserid(rs.getInt("userid"));
                tdv.setMaxe(rs.getString("maxe"));
                tdv.setDichvu(rs.getString("madichvu"));
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
