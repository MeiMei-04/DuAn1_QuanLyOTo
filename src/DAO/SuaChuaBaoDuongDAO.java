/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.SuaChuaBaoDuong;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class SuaChuaBaoDuongDAO extends QuanLyOToDAO<SuaChuaBaoDuong, String>{
    String INSERT_SQL="INSERT INTO SuaChuaBaoDuong(maxe,noidung,langannhat,ngaysuachua) values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE SuaChuaBaoDuong SET noidung=? WHERE maxe =?";
    String DELETE_SQL = "DELETE FROM SuaChuaBaoDuong WHERE maxe =?";
    String SELECT_ALL_SQL = "SELECT * FROM SuaChuaBaoDuong";
    String SELECT_BY_ID_SQL = "SELECT*FROM SuaChuaBaoDuong WHERE maxe = ?";
    
    @Override
    public void insert(SuaChuaBaoDuong entity) {
        JDBCHelper.executeUpdate(INSERT_SQL,entity.getMaxe(),entity.getNoidung(),entity.getLangannhat(),entity.getNgaysuachua());
    }

    @Override
    public void update(SuaChuaBaoDuong entity) {
        JDBCHelper.executeUpdate(UPDATE_SQL, entity.getNoidung(),entity.getMaxe());
    }

    @Override
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<SuaChuaBaoDuong> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public SuaChuaBaoDuong selectByID(String key) {
        List<SuaChuaBaoDuong> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);  
    }

    @Override
    public List<SuaChuaBaoDuong> selectByKey(String key) {
        List<SuaChuaBaoDuong> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;  
    }

    @Override
    protected List<SuaChuaBaoDuong> selectBySQL(String sql, Object... args) {
        List<SuaChuaBaoDuong> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                SuaChuaBaoDuong scbd = new SuaChuaBaoDuong();
                scbd.setMaxe(rs.getString("maxe"));
                scbd.setNoidung(rs.getString("noidung"));
                scbd.setLangannhat(rs.getDate("langannhat"));
                scbd.setNgaysuachua(rs.getDate("Ngaysuachua"));
                list.add(scbd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update_1(SuaChuaBaoDuong entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SuaChuaBaoDuong selectByID_1(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update_2(SuaChuaBaoDuong entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
