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
public class TaiKhoanDAO{

    String INSERT = "INSERT INTO TaiKhoan ("
            + "TaiKhoan,"
            + "MatKhau,"
            + "Email,"
            + "Trangthai,"
            + "VaiTro) values(?,?,?,?,?)";
    String UPDATE = "UPDATE TaiKhoan SET matkhau=? WHERE taikhoan =?";
    String UPDATE_TRANGTHAI = "UPDATE TaiKhoan SET TrangThai=? WHERE userid =?";
    String DELETE = "DELETE FROM TaiKhoan WHERE TaiKhoan =?";
    String SELECT_ALL = "SELECT * FROM TaiKhoan";
    String SELECT_BY_ID_SQL_DOITUONG_TAIKHOAN = "select * from taikhoan where taikhoan =?";
    String SELECT_BY_ID_SQL_LIST_USERID = "select * from taikhoan where userid =?";

    public void insert(TaiKhoan entity) {
        JDBCHelper.executeUpdate(INSERT, 
                entity.getTaikhoan(), 
                entity.getMatkhau(), 
                entity.getEmail(),
                entity.isTrangthai(), 
                entity.isVaitro()
        );
    }

    public void update(TaiKhoan entity) {
        JDBCHelper.executeUpdate(UPDATE,entity.getMatkhau(),entity.getTaikhoan());
    }

    public void delete(String TAIKHOAN) {
        JDBCHelper.executeUpdate(DELETE, TAIKHOAN);
    }

    public List<TaiKhoan> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public TaiKhoan selectByID_TAIKHOAN(String TAIKHOAN) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<TaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL_DOITUONG_TAIKHOAN, TAIKHOAN);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

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

    public void update_trangthai(TaiKhoan entity) {
        JDBCHelper.executeUpdate(UPDATE_TRANGTHAI,entity.isTrangthai(),entity.getUserid());
    }

    public TaiKhoan selectByID_USERID(String USERID) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<TaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL_LIST_USERID, USERID);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }

}
