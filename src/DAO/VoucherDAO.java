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
public class VoucherDAO extends QuanLyOToDAO<Voucher, String>{
    String INSERT_SQL="INSERT INTO Vouncher(MaVouncher,NoiDung,TrangThai) values(?,?,?)";
    String UPDATE_SQL="UPDATE Vouncher set NoiDung=?,TrangThai=? where MaVouncher=?";
    String DELETE_SQL="  DELETE FROM Vouncher WHERE MaVouncher=?";
    String SELECT_ALL_SQL="SELECT * FROM Vouncher";
    String SELECT_BY_ID_SQL=" SELECT * FROM Vouncher WHERE MaVouncher=?";
    
    @Override
    public void insert(Voucher entity) {
       JDBCHelper.executeUpdate(INSERT_SQL, entity.getMavoucher(),entity.getNoidung(),entity.isTrangthai());
    }

    @Override
    public void update(Voucher entity) {
       JDBCHelper.executeUpdate(UPDATE_SQL, entity.getNoidung(),entity.isTrangthai());
    }

    @Override
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<Voucher> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public Voucher selectByID(String key) {
        List<Voucher> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Voucher> selectByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<Voucher> selectBySQL(String sql, Object... args) {
       List<Voucher> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                Voucher ch = new Voucher();
                ch.setMavoucher(rs.getString("MaVouncher"));
                ch.setNoidung(rs.getString("NoiDung"));
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
