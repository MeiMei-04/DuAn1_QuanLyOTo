/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.HopDong;
import java.util.List;

/**
 *
 * @author truon
 */
public class ThemHopDongDAO extends QuanLyOToDAO<HopDong, String> {

    String INSERT_SQL = "INSERT INTO HopDong(MaHopDong,MaXe,Userid,GhiChu,NgayThue,NgayTra,MaDichVu,MaVouncher,ThanhTien) values(?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL_SQL = "SELECT * FROM HopDong";
    String SELECT_BY_ID_SQL = "SELECT*FROM HopDong WHERE MaHopDong = ?";

    @Override
    public void insert(HopDong entity) {
         JDBCHelper.executeUpdate(INSERT_SQL, entity.getMahopdong(),entity.getMaxe(),entity.getUserid(),entity.getGhichu(),entity.getNgaythue(),entity.getNgaytra(),entity.getMadichvu(),entity.getMavoucher(),entity.getThanhtien());

    }

    @Override
    public void update(HopDong entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update_1(HopDong entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HopDong> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public HopDong selectByID(String key) {
           // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<HopDong> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    @Override
    public HopDong selectByID_1(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HopDong> selectByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<HopDong> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
