/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.NopPhuPhi;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class NopPhuPhiDAO {
    String INSERT = "INSERT INTO NopPhuPhi ("
            + "mahopdong,"
            + "maphuphi"
            + "values(?,?)";
    String DELETE = "DELETE FROM NopPhuPhi WHERE mahopdong =?";
    String SELECT_ALL = "SELECT * FROM NopPhuPhi";
    String SELECT_BY_ID_MAHOPDONG = "select * from NopPhuPhi where mahopdong =?";
    
    public void insert(NopPhuPhi entity) {
        JDBCHelper.executeUpdate(INSERT,
                entity.getMahopdong(),
                entity.getMaphuphi()
        );
    }
    //xóa
    public void delete(String mahopdong) {
        JDBCHelper.executeUpdate(DELETE, mahopdong);
    }
    //trả về danh sách tất cả các bản ghi
    public List<NopPhuPhi> selectAll() {
        return selectBySQL(SELECT_ALL);
    }
    //trả về 1 đối tượng NopPhuPhi khi userid =
    public NopPhuPhi selectByID_MAHOPDONG(String mahopdong) {
        // Tạo một danh sách các đối tượng TaiKhoan từ kết quả truy vấn SQL
        List<NopPhuPhi> list = selectBySQL(SELECT_BY_ID_MAHOPDONG, mahopdong);
        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            // Nếu danh sách trống, trả về null
            return null;
        }

        // Nếu không, trả về phần tử đầu tiên trong danh sách
        return list.get(0);
    }


    protected List<NopPhuPhi> selectBySQL(String sql, Object... args) {
        List<NopPhuPhi> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                NopPhuPhi npp = new NopPhuPhi();
                npp.setMahopdong(rs.getString("mahopdong"));
                npp.setMaphuphi(rs.getString("MaNopPhuPhi"));
                list.add(npp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }
}
