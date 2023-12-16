/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.Voucher;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author truon
 */
public class VoucherDAO{
    String INSERT="INSERT INTO Voucher("
            + "MaVoucher,"
            + "NoiDung,"
            + "GiaTri,"
            + "TrangThai) "
            + "values(?,?,?,?)";
    String UPDATE="UPDATE Voucher set NoiDung=?,GiaTri=?,TrangThai=? where MaVoucher=?";
    String UPDATE_TRANGTHAI = "UPDATE Voucher set TrangThai=1 where MaVoucher=?";
    String DELETE="  DELETE FROM Voucher WHERE MaVoucher=?";
    String SELECT_ALL="SELECT * FROM Voucher";
    String SELECT_BY_ID_MAVOUCHER=" SELECT * FROM Voucher WHERE MaVoucher=? and trangthai = 0";
    String SELECT_BY_ID_NoiDung=" SELECT * FROM Voucher WHERE NoiDung like ?";
    String SELECT_BY_ID_MAVOUCHER1=" SELECT * FROM Voucher WHERE MaVoucher=? ";
    public void insert(Voucher entity) {
       JDBCHelper.executeUpdate(INSERT, 
               entity.getMavoucher(),
               entity.getNoidung(),
               entity.getGiatri(),
               entity.isTrangthai()
       );
    }
    public void update_Trangthai(String key){
        JDBCHelper.executeUpdate(UPDATE_TRANGTHAI, key);
    }
    public void update(Voucher entity) {
       JDBCHelper.executeUpdate(UPDATE, entity.getNoidung(),entity.getGiatri(),entity.isTrangthai(),entity.getMavoucher());
    }

    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<Voucher> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public Voucher selectByID_MAVOUCHER(String MAVOUCHER) {
        List<Voucher> list = selectBySQL(SELECT_BY_ID_MAVOUCHER, MAVOUCHER);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
      public Voucher selectByID_MAVOUCHER1(String MAVOUCHER) {
        List<Voucher> list = selectBySQL(SELECT_BY_ID_MAVOUCHER1, MAVOUCHER);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public List<Voucher> selectByID_NoiDung(String NoiDung) {
        List<Voucher> list = selectBySQL(SELECT_BY_ID_NoiDung, NoiDung);
        if(list.isEmpty()){
            return null;
        }
        return list;
    }

    protected List<Voucher> selectBySQL(String sql, Object... args) {
       List<Voucher> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                Voucher ch = new Voucher();
                ch.setMavoucher(rs.getString("MaVoucher"));
                ch.setNoidung(rs.getString("NoiDung"));
                ch.setGiatri(rs.getInt("GiaTri"));
                ch.setTrangthai(rs.getBoolean("TrangThai"));
                list.add(ch);
            }
           rs.getStatement().getConnection().close();
           return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }  
    }

}
