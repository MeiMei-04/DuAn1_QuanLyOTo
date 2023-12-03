/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.ChiTietTaiKhoan;
import entyti.HopDong;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truon
 */
public class ThemHopDongDAO {

    String INSERT = "INSERT INTO HopDong(MaHopDong,MaXe,Userid,GhiChu,NgayThue,NgayTra,MaVouncher,ThanhTien,DiaDiemNhanXe) values(?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM HopDong";
    String SELECT_BY_ID_SQL_MAHOPDONG = "SELECT*FROM HopDong WHERE MaHopDong = ?";
    String SELECT_BY_ID_SQL_USERID = "SELECT*FROM HopDong WHERE userid = ?";
    String update = "UPDATE HopDong SET ThoiHanHopDong = 0 WHERE MaHopDong =?";

    public void insert(HopDong entity) {
        JDBCHelper.executeUpdate(INSERT, entity.getMahopdong(), entity.getMaxe(), entity.getUserid(), entity.getGhichu(), entity.getNgaythue(), entity.getNgaytra(), entity.getMavoucher(), entity.getThanhtien(), entity.getDiadiemnhanxe());

    }

    public void update(HopDong entity) {
        JDBCHelper.executeUpdate(update, entity.getMahopdong());
    }

    public List<HopDong> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public HopDong selectByID_MAHOPDONG(String MAHOPDONG) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<HopDong> list = selectBySQL(SELECT_BY_ID_SQL_MAHOPDONG, MAHOPDONG);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }


    public List<HopDong> selectByID_USERID(String USERID) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<HopDong> list = selectBySQL(SELECT_BY_ID_SQL_USERID, USERID);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }

    protected List<HopDong> selectBySQL(String sql, Object... args) {
        List<HopDong> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                HopDong hp = new HopDong();
                hp.setMahopdong(rs.getString("MaHopDong"));
                hp.setMaxe(rs.getString("MaXe"));
                hp.setUserid(rs.getInt("Userid"));
                hp.setGhichu(rs.getString("GhiChu"));
                hp.setNgaythue(rs.getDate("NgayThue"));
                hp.setNgaytra(rs.getDate("NgayTra"));
                hp.setMavoucher(rs.getString("MaVouncher"));
                hp.setThanhtien(rs.getInt("ThanhTien"));
                hp.setTrangthaihopdong(rs.getBoolean("ThoiHanHopDong"));
                hp.setDiadiemnhanxe(rs.getString("DiaDiemNhanXe"));
                list.add(hp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }


}
