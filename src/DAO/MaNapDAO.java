/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hepler.JDBCHelper;
import entyti.MaNap;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class MaNapDAO{
    
    String INSERT= "INSERT INTO MaNap("
            + "MaNapTien,"
            + "NoiDung,"
            + "GiaTri,"
            + "TrangThai) "
            + "values(?,?,?,?)";
    String DELETE = "DELETE FROM MaNap WHERE MaNapTien =?";
    String SELECT_ALL = "SELECT * FROM MaNap";
    String UPDATE = "UPDATE MAPNAP SET "
            + "TRANGTHAI = 1 "
            + "WHERE MANAPTIEN = ?";
    String SELECT_BY_ID_DOITUONG_MANAPTIEN = "SELECT*FROM MaNap WHERE MaNapTien = ?";
    

    public void insert(MaNap entity) {
        JDBCHelper.executeUpdate(INSERT,
                entity.getManap(),
                entity.getNoidung(),
                entity.getGiatri(),
                entity.isTrangthai()
        );

    }
    public void update(String key){
        JDBCHelper.executeUpdate(UPDATE, key);
    }
    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<MaNap> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public MaNap selectByID(String MANAPTIEN) {
        List<MaNap> list = selectBySQL(SELECT_BY_ID_DOITUONG_MANAPTIEN, MANAPTIEN);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    protected List<MaNap> selectBySQL(String sql, Object... args) {
        List<MaNap> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                MaNap NC = new MaNap();
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
}
