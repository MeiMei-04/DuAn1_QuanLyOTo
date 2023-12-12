/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.ChiTietTaiKhoanDAO;
import DAO.ChiTietXeDAO;
import DAO.DanhGiaDAO;
import DAO.HopDongDAO;
import Hepler.DialogHelper;
import entyti.ChiTietTaiKhoan;
import entyti.ChiTietXe;
import entyti.DanhGia;
import entyti.HopDong;
import entyti.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieud
 */
public class cardDanhGIa extends javax.swing.JPanel {

    DanhGiaDAO dgd = new DanhGiaDAO();
    ChiTietTaiKhoanDAO cttkd = new ChiTietTaiKhoanDAO();
    ChiTietXeDAO ctxd = new ChiTietXeDAO();
    List<DanhGia> all_danhgia = new ArrayList<>();
    HopDongDAO hdd = new HopDongDAO();

    /**
     * Creates new form cardDanhGIa
     */
    public cardDanhGIa() {
        initComponents();
        filltable_danhgia(getListDanhGia());
    }

    public void xoadanhgia(int userid) {
        int sosao_danhgia = cbb_saodanhgia.getSelectedIndex() + 1;
        TaiKhoan tk = Hepler.AuthHelper.user;
        if (userid == tk.getUserid()) {
            try {
                dgd.update_trangthai(tk.getUserid());
                DialogHelper.alert(this, "Xoá Thành Công");
                filltable_danhgia(getListDanhGia());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            DialogHelper.alert(this, "Chi Được Sửa Đánh Giá Của Bản Thân");
        }
    }

    public void themdanhgia() {
        TaiKhoan tk = Hepler.AuthHelper.user;
        HopDong hd = hdd.selectByID_USERID_HD(String.valueOf(tk.getUserid()));
        if (hd != null) {
            DanhGia dg = getForm();
            try {
                dgd.insert(dg);
                DialogHelper.alert(this, "Thêm Đánh Giá Thành Công");
                filltable_danhgia(getListDanhGia());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void suadanhgia(int userid) {
        int sosao_danhgia = cbb_saodanhgia.getSelectedIndex() + 1;
        TaiKhoan tk = Hepler.AuthHelper.user;
        if (userid == tk.getUserid()) {
            DanhGia dg = new DanhGia();
            dg.setUserid(tk.getUserid());
            dg.setNoidung(txt_noidung.getText());
            dg.setNgaydanhgia(Hepler.DateHelper.now());
            dg.setSosaodanhgia(sosao_danhgia);
            try {
                dgd.update(dg);
                DialogHelper.alert(this, "Sửa Thành Công");
                filltable_danhgia(getListDanhGia());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            DialogHelper.alert(this, "Chi Được Sửa Đánh Giá Của Bản Thân");
        }
    }

    public DanhGia getForm() {
        int sosao_danhgia = cbb_saodanhgia.getSelectedIndex() + 1;
        TaiKhoan tk = Hepler.AuthHelper.user;
        DanhGia dg = new DanhGia();
        HopDong hd = hdd.selectByID_USERID_HD(String.valueOf(tk.getUserid()));
        dg.setUserid(tk.getUserid());
        dg.setMahopdong(hd.getMahopdong());
        dg.setNoidung(txt_noidung.getText());
        dg.setNgaydanhgia(Hepler.DateHelper.now());
        dg.setSosaodanhgia(sosao_danhgia);
        return dg;
    }

    public List<DanhGia> getListDanhGia() {
        List<DanhGia> list = new ArrayList<>();
        try {
            all_danhgia = dgd.selectAll();
            for (DanhGia dg : all_danhgia) {
                if (!dg.isTrangthai()) {
                    list.add(dg);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void timkiem() {
        try {
            TaiKhoan tk = Hepler.AuthHelper.user;
            List<DanhGia> list_find_danhgia = dgd.selectByID_userid(String.valueOf(tk.getUserid()));
            filltable_danhgia(list_find_danhgia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filltable_danhgia(List<DanhGia> list) {
        DefaultTableModel model = (DefaultTableModel) tbl_danhgia.getModel();
        model.setRowCount(0);
        try {
            for (DanhGia dg : list) {
                ChiTietTaiKhoan cttk = cttkd.selectByID_DOITUONG(String.valueOf(dg.getUserid()));
                HopDong hd = hdd.selectByID_USERID_HD(String.valueOf(dg.getUserid()));
                ChiTietXe ctx = ctxd.selectByID_MAXE(hd.getMaxe());
                Object[] row = {
                    cttk.getHoten(),
                    ctx.getTenxe(),
                    dg.getNoidung(),
                    dg.getNgaydanhgia(),
                    dg.getSosaodanhgia()
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_danhgia = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_noidung = new javax.swing.JTextArea();
        cbb_saodanhgia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn_timkiem = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(300, 335));

        tbl_danhgia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Họ Tên", "Sản Phẩm", "Nội Dung", "Ngày Đánh Giá", "SỐ Sao Đánh Giá"
            }
        ));
        tbl_danhgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhgiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_danhgia);

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xoá");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel1.setText("Họ Tên");

        txt_hoten.setEnabled(false);

        jLabel2.setText("Nội Dung");

        txt_noidung.setColumns(20);
        txt_noidung.setRows(5);
        jScrollPane2.setViewportView(txt_noidung);

        cbb_saodanhgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel3.setText("Số Sao");

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_them)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_sua)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_xoa))
                                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbb_saodanhgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(btn_timkiem))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_saodanhgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_danhgiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhgiaMouseClicked
        // TODO add your handling code here:
        int row = -1;
        row = tbl_danhgia.getSelectedRow();
        String hoten = (String) tbl_danhgia.getValueAt(row, 0);
        try {
            ChiTietTaiKhoan cttk = cttkd.selectByID_DOITUONG_HOTEN(hoten);
            DanhGia dg = dgd.selectByID_userid_doituong(String.valueOf(cttk.getUserid()));
            txt_noidung.setText(dg.getNoidung());
            cbb_saodanhgia.setSelectedIndex(dg.getSosaodanhgia()-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tbl_danhgiaMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        timkiem();
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        themdanhgia();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int row = -1;
        row = tbl_danhgia.getSelectedRow();
        String hoten = (String) tbl_danhgia.getValueAt(row, 0);
        try {
            ChiTietTaiKhoan cttk = cttkd.selectByID_DOITUONG_HOTEN(hoten);
            suadanhgia(cttk.getUserid());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = -1;
        row = tbl_danhgia.getSelectedRow();
        String hoten = (String) tbl_danhgia.getValueAt(row, 0);
        try {
            ChiTietTaiKhoan cttk = cttkd.selectByID_DOITUONG_HOTEN(hoten);
            xoadanhgia(cttk.getUserid());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_saodanhgia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_danhgia;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextArea txt_noidung;
    // End of variables declaration//GEN-END:variables
}
