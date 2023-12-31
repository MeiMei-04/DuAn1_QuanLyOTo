/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.PhuPhi;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class PhuPhiDAO {
    String INSERT = "INSERT INTO PhuPhi("
            + "MaPhuPhi,"
            + "TenPhuPhi,"
            + "GiaTri)"
            + "values(?,?,?)";
    String UPDATE = "UPDATE PhuPhi SET "
            + "TenPhuPhi = ?,"
            + "GiaTri = ? "
            + "WHERE MaPhuPhi =?";
    
    String DELETE = "DELETE FROM PhuPhi WHERE MaPhuPhi =?";
    String SELECT_ALL = "SELECT * FROM PhuPhi";
    String SELECT_BY_ID_MAPHUPHI = "select * from PhuPhi where MaPhuPhi =?";
    String SELECT_BY_ID_tenphuphi = "select * from PhuPhi where TenPhuPhi like ? ";
    String UPDATE_TRANGTHAI ="UPDATE PHUPHI SET TRANGTHAI = 1 WHERE MAPHUPHI = ?";
    public void insert(PhuPhi entity) {
        JDBCHelper.executeUpdate(INSERT,
                entity.getMaphuphi(),
                entity.getTenphuphi(),
                entity.getGiatri()
        );
    }
    public void update_trangthai(String key){
        JDBCHelper.executeUpdate(UPDATE_TRANGTHAI, key);
    }
    //sửa
    public void update(PhuPhi entity) {
        JDBCHelper.executeUpdate(UPDATE, 
                entity.getTenphuphi(),
                entity.getGiatri(),
                entity.getMaphuphi()
        );
    }
    //xóa
    public void delete(String maphuphi) {
        JDBCHelper.executeUpdate(DELETE, maphuphi);
    }
    //trả về danh sách tất cả các bản ghi
    public List<PhuPhi> selectAll() {
        return selectBySQL(SELECT_ALL);
    }
    //trả về 1 đối tượng PhuPhi khi userid =
    public PhuPhi selectByID_MAPHUPHI(String maphuphi) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<PhuPhi> list = selectBySQL(SELECT_BY_ID_MAPHUPHI, maphuphi);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }
    
     public List<PhuPhi> selectByID_tenphuphi(String tenphuphi) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<PhuPhi> list = selectBySQL(SELECT_BY_ID_tenphuphi, tenphuphi);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list;
    }


    protected List<PhuPhi> selectBySQL(String sql, Object... args) {
        List<PhuPhi> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                PhuPhi pp = new PhuPhi();
                pp.setMaphuphi(rs.getString("MaPhuPhi"));
                pp.setTenphuphi(rs.getString("TenPhuPhi"));
                pp.setGiatri(rs.getInt("GiaTri"));
                pp.setTrangthai(rs.getBoolean("Trangthai"));
                list.add(pp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

}
