/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entyti.Xe;
import java.util.List;
import Hepler.JDBCHelper;
import entyti.TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class ThueXeDAO extends QuanLyOToDAO<Xe, String>{

    String INSERT_SQL = "INSERT INTO TaiKhoan (TaiKhoan,MatKhau,Email,Trangthai,VaiTro) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE TaiKhoan SET MatKhau=?,email = ?,TrangThai=?, VaiTro = ? WHERE TaiKhoan =?";
    String DELETE_SQL = "DELETE FROM TaiKhoan WHERE TaiKhoan =?";
    String SELECT_ALL_SQL = "SELECT * FROM xe";
    String SELECT_BY_ID_SQL = "SELECT*FROM TaiKhoan WHERE TaiKhoan = ?";

    @Override
    public void insert(Xe entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Xe entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Xe> selectAll() {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public Xe selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<Xe> selectBySQL(String sql, Object... args) {
        List<Xe> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                Xe xe = new Xe();
                xe.setMaxe(rs.getString("MaXe"));
                xe.setTenxe(rs.getString("TenXe"));
                xe.setSoghe(rs.getInt("SoGhe"));
                xe.setTrangthaixethue(rs.getBoolean("TrangThai"));
                xe.setGiathue(rs.getFloat("GiaThue"));
                xe.setAnhxe(rs.getString("Anh_Xe"));
                xe.setMaloaixe(rs.getString("MaLoaiXe"));
                list.add(xe);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }
    
}
