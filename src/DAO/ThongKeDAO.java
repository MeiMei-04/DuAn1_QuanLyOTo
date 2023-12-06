/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author truon
 */
public class ThongKeDAO {

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


    public List<Object[]> getDoanhThu(int thang,int nam) {
        String sql = "{CALL sp_DoanhThu(?,?)}";
        String[] cols = {"tenxe", "soghe", "soluong","Doanhthu", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(sql, cols,thang,nam);
    }
   

    public List<Integer> selectMonth() {
        String sql = "SELECT DISTINCT Month(NgayThue) month FROM HopDong ORDER BY month ASC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
        public List<Integer> selectYear() {
        String sql = "SELECT DISTINCT Year(NgayThue) year FROM HopDong ORDER BY year ASC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
