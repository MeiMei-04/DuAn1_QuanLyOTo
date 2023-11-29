/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class HopDongDAO {
        public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static ResultSet rs = null;
    public List<Object[]> getSoHopDong() {
        String sql = "{CALL sp_ThongKeHopDong}";
        String[] cols = {"MaHopDong", "MaXe", "Userid", "GhiChu","NgayThue","NgayTra","MaVouncher","ThanhTien","ThoiHanHopDong"};
        return this.getListOfArray(sql, cols);
    }
    
}
