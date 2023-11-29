/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entyti.TaiKhoan;
import java.util.List;
import Hepler.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class TaiKhoanDAO extends QuanLyOToDAO<TaiKhoan, String> {

    String INSERT_SQL = "INSERT INTO TaiKhoan (TaiKhoan,MatKhau,Email,Trangthai,VaiTro) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan SET matkhau=? WHERE taikhoan =?";
    String UPDATE_SQL_1 = "UPDATE TaiKhoan SET TrangThai=? WHERE userid =?";
    String DELETE_SQL = "DELETE FROM TaiKhoan WHERE TaiKhoan =?";
    String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    String SELECT_BY_ID_SQL = "select * from taikhoan where taikhoan =?";
    String SELECT_BY_ID_SQL_1 = "select * from taikhoan where userid =?";

    @Override
    public void insert(TaiKhoan entity) {
        JDBCHelper.executeUpdate(INSERT_SQL, entity.getTaikhoan(), entity.getMatkhau(), entity.getEmail(), entity.isTrangthai(), entity.isVaitro());
    }

    @Override
    public void update(TaiKhoan entity) {
        JDBCHelper.executeUpdate(UPDATE_SQL,entity.getMatkhau(),entity.getTaikhoan());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectByID(String id) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<TaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL, id);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    @Override
    protected List<TaiKhoan> selectBySQL(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setUserid(rs.getInt("userid"));
                tk.setTaikhoan(rs.getString("TaiKhoan"));
                tk.setMatkhau(rs.getString("MatKhau"));
                tk.setEmail(rs.getString("Email"));
                tk.setVaitro(rs.getBoolean("VaiTro"));
                tk.setTrangthai(rs.getBoolean("Trangthai"));
                list.add(tk);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaiKhoan> selectByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update_1(TaiKhoan entity) {
        JDBCHelper.executeUpdate(UPDATE_SQL_1,entity.isTrangthai(),entity.getUserid());
    }

    @Override
    public TaiKhoan selectByID_1(String key) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<TaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL_1, key);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

    @Override
    public void update_2(TaiKhoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
