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
public class DichVuDAO {

    String INSERT = "INSERT INTO DichVu(MaDichVu,TenDichVu,GhiChu,DonGia) values(?,?,?,?)";
    String UPDATE = "UPDATE DichVu SET TenDichVu=?,GhiChu = ?,DonGia=? WHERE MaDichVu =?";
    String DELETE = "DELETE FROM DichVu WHERE MaDichVu =?";
    String SELECT_ALL = "SELECT * FROM DichVu";
    String SELECT_BY_ID_MADICHVU = "SELECT*FROM DichVu WHERE MaDichVu = ?";
    String SELECT_BY_ID_TENDICHVU = "SELECT*FROM DichVu WHERE tendichvu = ?";

    public void insert(DichVu entity) {
        JDBCHelper.executeUpdate(INSERT, entity.getMadichvu(), entity.getTendichvu(), entity.getGhichu(), entity.getDongia());
    }

    public void update(DichVu entity) {
        JDBCHelper.executeUpdate(UPDATE, entity.getTendichvu(), entity.getGhichu(), entity.getDongia(), entity.getMadichvu());
    }

    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<DichVu> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public List<DichVu> selectByID_ListTendichvu(String TENDICHVU) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<DichVu> list = selectBySQL(SELECT_BY_ID_TENDICHVU, TENDICHVU);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    public DichVu selectByID_MADICHVU(String madichvu) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<DichVu> list = selectBySQL(SELECT_BY_ID_MADICHVU, madichvu);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

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

    public DichVu selectByID_TENDICHVU(String TENDICHVU) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<DichVu> list = selectBySQL(SELECT_BY_ID_TENDICHVU, TENDICHVU);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }
}
