/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.DanhGia;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class DanhGiaDAO {

    String INSERT = "INSERT INTO danhgia ("
            + "userid, "
            + "MAHOPDONG, "
            + "noidung, "
            + "ngaydanhgia, "
            + "sosaodanhgia)"
            + "VALUES (?,?,?,?,?)";
    String UPDATE = "UPDATE danhgia SET "
            + "noidung = ?,"
            + "ngaydanhgia = ?,"
            + "sosaodanhgia = ? "
            + "WHERE userid =?";
    String UPDATE_TRANGTHAI = "UPDATE DANHGIA SET TRANGTHAI =1 where userid = ?";
    String DELETE = "DELETE FROM danhgia WHERE userid =?";
    String SELECT_ALL = "SELECT * FROM danhgia";
    String SELECT_BY_ID_MAXE = "SELECT*FROM DANHGIA WHERE userid = ?";
    String SELECT_BY_ID_USERID = "SELECT*FROM DANHGIA WHERE USERID = ? AND TRANGTHAI = 0";

    public void insert(DanhGia entity) {
        JDBCHelper.executeUpdate(INSERT,
                entity.getUserid(),
                entity.getMahopdong(),
                entity.getNoidung(),
                entity.getNgaydanhgia(),
                entity.getSosaodanhgia()
        );
    }
    public void update_trangthai(int userid){
        JDBCHelper.executeUpdate(UPDATE_TRANGTHAI, userid);
    }
    public void update(DanhGia entity) {
        JDBCHelper.executeUpdate(UPDATE,
                entity.getNoidung(),
                entity.getNgaydanhgia(),
                entity.getSosaodanhgia(),
                entity.getUserid()
        );
    }

    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<DanhGia> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public List<DanhGia> selectByID_userid(String userid) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<DanhGia> list = selectBySQL(SELECT_BY_ID_USERID, userid);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }
    
    
    public DanhGia selectByID_userid_doituong(String userid) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<DanhGia> list = selectBySQL(SELECT_BY_ID_USERID, userid);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }
    
    protected List<DanhGia> selectBySQL(String sql, Object... args) {
        List<DanhGia> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                DanhGia dg = new DanhGia();
                dg.setUserid(rs.getInt("UserID"));
                dg.setMahopdong(rs.getString("mahopdong"));
                dg.setNoidung(rs.getString("NoiDung"));
                dg.setNgaydanhgia(rs.getDate("NgayDanhGia"));
                dg.setSosaodanhgia(rs.getInt("SoSaoDanhGia"));
                dg.setTrangthai(rs.getBoolean("Trangthai"));
                list.add(dg);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }
}
