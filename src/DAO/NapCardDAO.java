/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.NapCard;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class NapCardDAO extends QuanLyOToDAO<NapCard, String>{
    
    String INSERT_SQL = "INSERT INTO MaNap(MaNapTien,NoiDung,GiaTri,TrangThai) values(?,?,?,?)";
    String DELETE_SQL = "DELETE FROM MaNap WHERE MaNapTien =?";
    String SELECT_ALL_SQL = "SELECT * FROM MaNap";
    String SELECT_BY_ID_SQL = "SELECT*FROM MaNap WHERE MaNapTien = ?";
    

    @Override
    public void insert(NapCard entity) {
        JDBCHelper.executeUpdate(INSERT_SQL,entity.getManap(),entity.getNoidung(),entity.getGiatri(),entity.isTrangthai());

    }

    @Override
    public void update(NapCard entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public List<NapCard> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public NapCard selectByID(String key) {
        List<NapCard> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NapCard> selectByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<NapCard> selectBySQL(String sql, Object... args) {
        List<NapCard> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                NapCard NC = new NapCard();
                NC.setManap(rs.getString("MaNapTien"));
                NC.setNoidung(rs.getString("NoiDung"));
                NC.setGiatri(rs.getInt("GiaTri"));
                NC.setTrangthai(rs.getBoolean("TrangThai"));
                list.add(NC);
            }
           rs.getStatement().getConnection().close();
           return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }  
    }

    @Override
    public void update_1(NapCard entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NapCard selectByID_1(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
