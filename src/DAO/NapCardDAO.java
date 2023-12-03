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
public class NapCardDAO{
    
    String INSERT= "INSERT INTO MaNap(MaNapTien,NoiDung,GiaTri,TrangThai) values(?,?,?,?)";
    String DELETE = "DELETE FROM MaNap WHERE MaNapTien =?";
    String SELECT_ALL = "SELECT * FROM MaNap";
    String SELECT_BY_ID_DOITUONG_MANAPTIEN = "SELECT*FROM MaNap WHERE MaNapTien = ?";
    

    public void insert(NapCard entity) {
        JDBCHelper.executeUpdate(INSERT,entity.getManap(),entity.getNoidung(),entity.getGiatri(),entity.isTrangthai());

    }

    public void delete(String key) {
        JDBCHelper.executeUpdate(DELETE, key);
    }

    public List<NapCard> selectAll() {
        return selectBySQL(SELECT_ALL);
    }

    public NapCard selectByID(String MANAPTIEN) {
        List<NapCard> list = selectBySQL(SELECT_BY_ID_DOITUONG_MANAPTIEN, MANAPTIEN);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
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
}
