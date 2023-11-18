/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.DanhGia;
import entyti.TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieud
 */
public class DanhGiaDAO extends QuanLyOToDAO<DanhGia, String>{
    String INSERT_SQL = "INSERT INTO TaiKhoan (TaiKhoan,MatKhau,Email,Trangthai,VaiTro) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan SET MatKhau=?,email = ?,TrangThai=?, VaiTro = ? WHERE TaiKhoan =?";
    String DELETE_SQL = "DELETE FROM TaiKhoan WHERE TaiKhoan =?";
    String SELECT_ALL_SQL = "SELECT * FROM danhgia";
    String SELECT_BY_ID_SQL = "SELECT TaiKhoan.UserID,danhgia.MaXe,ChiTietTaiKhoan.HoTen,ChiTietTaiKhoan.AnhDaiDien,danhgia.NoiDung,danhgia.NgayDanhGia,danhgia.SoSaoDanhGia FROM TaiKhoan  INNER JOIN ChiTietTaiKhoan  ON TaiKhoan.UserID = ChiTietTaiKhoan.UserID  INNER JOIN danhgia  ON ChiTietTaiKhoan.UserID = danhgia.UserID  where maxe = ?";
    @Override
    public void insert(DanhGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(DanhGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DanhGia> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public DanhGia selectByID(String key) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<DanhGia> list = selectBySQL(SELECT_BY_ID_SQL, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    @Override
    protected List<DanhGia> selectBySQL(String sql, Object... args) {
        List<DanhGia> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                DanhGia dg = new DanhGia();
                dg.setId(rs.getInt("userid"));
                dg.setMaxe(rs.getString("Maxe"));
                dg.setNoidung(rs.getString("noidung"));
//                dg.setAnhdaidien(rs.getString("anhdaidien"));
//                dg.setHoten(rs.getString("hoten"));
                dg.setNgaydanhgia(rs.getDate("ngaydanhgia"));
                dg.setSosaodanhgia(rs.getInt("sosaodanhgia"));
                list.add(dg);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DanhGia> selectByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
