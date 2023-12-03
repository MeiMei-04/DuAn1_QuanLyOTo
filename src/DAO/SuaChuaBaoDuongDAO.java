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
public class SuaChuaBaoDuongDAO{
    String INSERT="INSERT INTO SuaChuaBaoDuong(maxe,noidung,langannhat,ngaysuachua) values(?,?,?,?)";
    String UPDATE= "UPDATE SuaChuaBaoDuong SET noidung=? WHERE maxe =?";
    String DELETE= "DELETE FROM SuaChuaBaoDuong WHERE maxe =?";
    String SELECT_ALL = "SELECT * FROM SuaChuaBaoDuong";
    String SELECT_BY_ID_DOITUONG_MAXE = "SELECT*FROM SuaChuaBaoDuong WHERE maxe = ?";
    
    public void insert(SuaChuaBaoDuong entity) {
        JDBCHelper.executeUpdate(INSERT,entity.getMaxe(),entity.getNoidung(),entity.getLangannhat(),entity.getNgaysuachua());
    }

    public void update(SuaChuaBaoDuong entity) {
        JDBCHelper.executeUpdate(UPDATE, entity.getNoidung(),entity.getMaxe());
    }

    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<SuaChuaBaoDuong> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public SuaChuaBaoDuong selectByID(String MAXE) {
        List<SuaChuaBaoDuong> list = selectBySQL(SELECT_BY_ID_DOITUONG_MAXE, MAXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);  
    }

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

}
