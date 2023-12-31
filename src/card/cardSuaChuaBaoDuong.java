/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.SuaChuaBaoDuongDAO;
import Hepler.DialogHelper;
import entyti.SuaChuaBaoDuong;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class cardSuaChuaBaoDuong extends javax.swing.JPanel {

    /**
     * Creates new form SuaChuaBaoDuong
     */
    public cardSuaChuaBaoDuong() {
        initComponents();
        filltable();
    }
    SuaChuaBaoDuongDAO dao = new SuaChuaBaoDuongDAO();
    int row = -1;

    private void filltable() {
        var model = (DefaultTableModel) tblSuaChuaBaoDuong.getModel();
        model.setRowCount(0);
        try {
            List<SuaChuaBaoDuong> list = dao.selectAll();
            for (SuaChuaBaoDuong dv : list) {
                Object[] row = {dv.getMaxe(),
                    dv.getLangannhat(),
                    dv.getNgaysuachua(),
                    dv.getNoidung()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Loi Try van");
        }
    }

    void edit() {
        String madv = (String) tblSuaChuaBaoDuong.getValueAt(this.row, 0);
        SuaChuaBaoDuong dv = dao.selectByID(madv);
        this.setFrom(dv);
    }

    void setFrom(SuaChuaBaoDuong scbd) {
        txtMaXe.setText(scbd.getMaxe());
        txtLanGanNhat.setText(Hepler.DateHelper.toString(scbd.getLangannhat(), "dd/mm/yyyy"));
        txtNgaySuaChua.setText(Hepler.DateHelper.toString(scbd.getNgaysuachua(), "dd/mm/yyyy"));
        txtNoiDung.setText(scbd.getNoidung());
    }

    void clearFrom() {
        SuaChuaBaoDuong dv = new SuaChuaBaoDuong();
        this.setFrom(dv);
        this.row = -1;
    }

    SuaChuaBaoDuong getFrom() {
        SuaChuaBaoDuong scbd = new SuaChuaBaoDuong();
        scbd.setMaxe(txtMaXe.getText());
        scbd.setLangannhat(Hepler.DateHelper.toDate(txtLanGanNhat.getText(), "dd/mm/yyyy"));
        scbd.setNgaysuachua(Hepler.DateHelper.toDate(txtNgaySuaChua.getText(), "dd/mm/yyyy"));
        scbd.setNoidung(txtNoiDung.getText());
        return scbd;
    }

    void update() {
        SuaChuaBaoDuong dv = getFrom();
        if (dv != null) {
            try {
                dao.update(dv);
                this.filltable();
                DialogHelper.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
            }

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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        SuaChuaBaoDuong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLanGanNhat = new javax.swing.JTextField();
        txtNgaySuaChua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnBatDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnSau = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSuaChuaBaoDuong = new javax.swing.JTable();
        btnGui = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMaXe = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Xe", "Sửa Chữa Gần Nhất"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton3.setText("<<");

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 102, 51));
        jButton7.setText("Gửi ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        SuaChuaBaoDuong.setBackground(new java.awt.Color(255, 102, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sửa Chữa và Bảo Dưỡng ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Repair and maintenance");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MÃ XE");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NGÀY SỬA CHỮA");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NỘI DUNG");

        txtNgaySuaChua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySuaChuaActionPerformed(evt);
            }
        });

        btnBatDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBatDau.setForeground(new java.awt.Color(255, 102, 51));
        btnBatDau.setText("|<");
        btnBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatDauActionPerformed(evt);
            }
        });

        btnLui.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLui.setForeground(new java.awt.Color(255, 102, 51));
        btnLui.setText("<<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btnSau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSau.setForeground(new java.awt.Color(255, 102, 51));
        btnSau.setText(">>");
        btnSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauActionPerformed(evt);
            }
        });

        btnCuoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCuoi.setForeground(new java.awt.Color(255, 102, 51));
        btnCuoi.setText(">|");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        tblSuaChuaBaoDuong.setBackground(new java.awt.Color(255, 102, 51));
        tblSuaChuaBaoDuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Xe", "Lần Gần Nhất", "Ngày Sửa chữa"
            }
        ));
        tblSuaChuaBaoDuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSuaChuaBaoDuongMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblSuaChuaBaoDuong);

        btnGui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGui.setForeground(new java.awt.Color(255, 102, 51));
        btnGui.setText("GỬI");
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LẦN GẦN NHẤT");

        txtNoiDung.setColumns(20);
        txtNoiDung.setRows(5);
        jScrollPane1.setViewportView(txtNoiDung);

        javax.swing.GroupLayout SuaChuaBaoDuongLayout = new javax.swing.GroupLayout(SuaChuaBaoDuong);
        SuaChuaBaoDuong.setLayout(SuaChuaBaoDuongLayout);
        SuaChuaBaoDuongLayout.setHorizontalGroup(
            SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuaChuaBaoDuongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuaChuaBaoDuongLayout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(SuaChuaBaoDuongLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))))
                    .addGroup(SuaChuaBaoDuongLayout.createSequentialGroup()
                        .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel5)
                                .addComponent(txtLanGanNhat)
                                .addComponent(txtNgaySuaChua)
                                .addComponent(jScrollPane1)
                                .addGroup(SuaChuaBaoDuongLayout.createSequentialGroup()
                                    .addComponent(btnBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSau, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtMaXe))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuaChuaBaoDuongLayout.createSequentialGroup()
                                .addComponent(btnGui)
                                .addGap(162, 162, 162)))))
                .addGap(14, 14, 14))
        );
        SuaChuaBaoDuongLayout.setVerticalGroup(
            SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuaChuaBaoDuongLayout.createSequentialGroup()
                .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuaChuaBaoDuongLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel12))
                    .addGroup(SuaChuaBaoDuongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SuaChuaBaoDuongLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtLanGanNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySuaChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(SuaChuaBaoDuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatDau)
                    .addComponent(btnLui)
                    .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSau, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGui, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SuaChuaBaoDuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SuaChuaBaoDuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaySuaChuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySuaChuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySuaChuaActionPerformed

    private void btnBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatDauActionPerformed
        row = 0;
        edit();    // TODO add your handling code here:
    }//GEN-LAST:event_btnBatDauActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        update();   // TODO add your handling code here:
    }//GEN-LAST:event_btnGuiActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        if (row > 0) {
            row--;
            edit();
        }           // TODO add your handling code here:
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        row = tblSuaChuaBaoDuong.getRowCount() - 1;
        System.out.println(row);
        edit();// TODO add your handling code here:
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btnSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauActionPerformed
        if (row < tblSuaChuaBaoDuong.getRowCount() - 1) {
            row++;
            edit();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnSauActionPerformed

    private void tblSuaChuaBaoDuongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuaChuaBaoDuongMousePressed
         if (evt.getClickCount() == 2) {
            this.row = tblSuaChuaBaoDuong.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblSuaChuaBaoDuongMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SuaChuaBaoDuong;
    private javax.swing.JButton btnBatDau;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnGui;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnSau;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblSuaChuaBaoDuong;
    private javax.swing.JTextField txtLanGanNhat;
    private javax.swing.JTextField txtMaXe;
    private javax.swing.JTextField txtNgaySuaChua;
    private javax.swing.JTextArea txtNoiDung;
    // End of variables declaration//GEN-END:variables

}
