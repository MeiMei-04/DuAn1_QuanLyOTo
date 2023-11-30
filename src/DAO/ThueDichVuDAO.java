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
public class ThueDichVuDAO extends QuanLyOToDAO<ThueDichVu, String>{
    String INSERT_SQL = "INSERT INTO themdichvu (userid,maxe,madichvu) values(?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan SET  madichvu=? WHERE maxe =?";
    String UPDATE_SQL_1 = "UPDATE themdichvu set Maxe =?  WHERE madichvu =?";
    String UPDATE_SQL_2 = "UPDATE themdichvu SET TrangThai=? WHERE userid =?";
    String DELETE_SQL = "DELETE FROM themdichvu WHERE maxe =?";
    String SELECT_ALL_SQL = "SELECT * FROM themdichvu";
    String SELECT_BY_ID_SQL = "select * from themdichvu where maxe =?";
    String SELECT_BY_ID_SQL_1 = "select * from taikhoan where userid =?";
    
    @Override
    public void insert(ThueDichVu entity) {
        JDBCHelper.executeUpdate(INSERT_SQL,entity.getUserid() ,entity.getMaxe(), entity.getDichvu());
    }

    @Override
    public void update(ThueDichVu entity) {
        JDBCHelper.executeUpdate(UPDATE_SQL, entity.getDichvu(), entity.getMaxe());
    }

    @Override
    public void update_1(ThueDichVu entity) {
        JDBCHelper.executeUpdate(UPDATE_SQL_1, entity.getMaxe(), entity.getDichvu());
    }

    @Override
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<ThueDichVu> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ThueDichVu selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ThueDichVu selectByID_1(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThueDichVu> selectByKey(String key) {
        List<ThueDichVu> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    @Override
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

    @Override
    public void update_2(ThueDichVu entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
