/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entyti.HopDong;

/**
 *
 * @author truon
 */
public class HopDongDAO {

    String INSERT = "INSERT INTO HopDong("
            + "MaHopDong,"
            + "MaXe,"
            + "Userid,"
            + "NgayThue,"
            + "Ngayhethan,"
            + "NgayTraXe,"
            + "songayquahan,"
            + "MaVoucher,"
            + "ThanhTien,"
            + "Thoihanhopdong,"
            + "DiaDiemNhanXe,"
            + "tinhtranghopdong) "
            + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM HopDong";
    String SELECT_BY_ID_SQL_MAHOPDONG = "SELECT*FROM HopDong WHERE MaHopDong = ?";
    String SELECT_BY_ID_SQL_USERID = "SELECT*FROM HopDong WHERE userid = ?";
    String SELECT_BY_ID_MAXE = "SELECT*FROM HopDong WHERE MAXE = ?";
    String SELECT_BY_ID_MAXE_NULL = "SELECT*FROM HopDong WHERE MAXE = ? AND  NGAYTRAXE IS NULL ";
    String UPDATE = "UPDATE HopDong SET "
            + "MaXe = ?,"
            + "NgayThue = ?,"
            + "Ngayhethan = ?,"
            + "NgayTraXe = ? ,"
            + "songayquahan = ?,"
            + "MaVoucher = ?,"
            + "ThanhTien = ?,"
            + "Thoihanhopdong = ?,"
            + "DiaDiemNhanXe = ?,"
            + "tinhtranghopdong = ?"
            + "WHERE MaHopDong =?";
    String UPDATE_TRANGTHAI = "UPDATE HOPDONG SET tinhtranghopdong = ? WHERE MAHOPDONG= ?";
    
    public void update_trangthai(HopDong entity){
        JDBCHelper.executeUpdate(UPDATE_TRANGTHAI,
                entity.getTinhtranghopdong(),
                entity.getMahopdong()
        );
    }
    public void insert(HopDong entity) {
        JDBCHelper.executeUpdate(INSERT, 
                entity.getMahopdong(), 
                entity.getMaxe(), 
                entity.getUserid(), 
                entity.getNgaythue(), 
                entity.getNgayhethan(),
                entity.getNgaytraxe(),
                entity.getSongayquahan(),
                entity.getMavoucher(), 
                entity.getThanhtien(), 
                entity.getThoihanhopdong(),
                entity.getDiadiemnhanxe(),
                entity.getTinhtranghopdong()
        );

    }

    public void update(HopDong entity) {
        JDBCHelper.executeUpdate(UPDATE,
                entity.getMaxe(),
                entity.getNgaythue(),
                entity.getNgayhethan(),
                entity.getNgaytraxe(),
                entity.getSongayquahan(),
                entity.getMavoucher(),
                entity.getThanhtien(),
                entity.getThoihanhopdong(),
                entity.getDiadiemnhanxe(),
                entity.getTinhtranghopdong(),
                entity.getMahopdong());
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
    public List<HopDong> selectByID_MAXE_NULL(String MAXE) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<HopDong> list = selectBySQL(SELECT_BY_ID_MAXE_NULL, MAXE);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }
    public List<HopDong> selectByID_MAXE(String MAXE) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<HopDong> list = selectBySQL(SELECT_BY_ID_MAXE, MAXE);
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
                HopDong hd = new HopDong();
                hd.setMahopdong(rs.getString("MaHopDong"));
                hd.setMaxe(rs.getString("MaXe"));
                hd.setUserid(rs.getInt("Userid"));
                hd.setNgaythue(rs.getDate("NgayThue"));
                hd.setNgayhethan(rs.getDate("NgayHetHan"));
                hd.setNgaytraxe(rs.getDate("NgayTraXe"));
                hd.setMavoucher(rs.getString("MaVoucher"));
                hd.setThanhtien(rs.getInt("ThanhTien"));
                hd.setThoihanhopdong(rs.getInt("ThoiHanHopDong"));
                hd.setDiadiemnhanxe(rs.getString("DiaDiemNhanXe"));
                hd.setTinhtranghopdong(rs.getInt("TinhTrangHopDong"));
                list.add(hd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }


}
