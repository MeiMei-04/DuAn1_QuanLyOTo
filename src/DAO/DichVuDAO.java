/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.DichVu;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author truon
 */
public class DichVuDAO extends QuanLyOToDAO<DichVu, String>{
    String INSERT_SQL="INSERT INTO DichVu(MaDichVu,TenDichVu,GhiChu,DonGia) values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE DichVu SET TenDichVu=?,GhiChu = ?,DonGia=? WHERE MaDichVu =?";
    String DELETE_SQL = "DELETE FROM DichVu WHERE MaDichVu =?";
    String SELECT_ALL_SQL = "SELECT * FROM DichVu";
    String SELECT_BY_ID_SQL = "SELECT*FROM DichVu WHERE MaDichVu = ?";
    @Override
    public void insert(DichVu entity) {
        JDBCHelper.executeUpdate(INSERT_SQL, entity.getMadichvu(),entity.getTendichvu(),entity.getGhichu(),entity.getDongia());
    }

    @Override
    public void update(DichVu entity) {
         JDBCHelper.executeUpdate(UPDATE_SQL, entity.getTendichvu(),entity.getGhichu(),entity.getDongia(),entity.getMadichvu());
    }

    @Override
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<DichVu> selectAll() {
         return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public DichVu selectByID(String key) {
 // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<DichVu> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);    }

    @Override
    protected List<DichVu> selectBySQL(String sql, Object... args) {
                List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                DichVu dv = new DichVu();
                dv.setMadichvu(rs.getString("MaDichVu"));
                dv.setTendichvu(rs.getString("TenDichVu"));
                dv.setGhichu(rs.getString("GhiChu"));
                dv.setDongia(rs.getInt("DonGia"));
                list.add(dv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DichVu> selectByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
