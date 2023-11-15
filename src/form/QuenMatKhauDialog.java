/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package form;

import DAO.TaiKhoanDAO;
import Hepler.DialogHelper;
import Hepler.EmailValidator;
import entyti.DichVu;
import entyti.TaiKhoan;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieud
 */
public class QuenMatKhauDialog extends java.awt.Dialog {
    private static long lastEventTime = 0;
    int row = -1, col = -1;
    TaiKhoanDAO tkd = new TaiKhoanDAO();
    String tentaikhoan = null;
    EmailValidator evl = new EmailValidator();

    /**
     * Creates new form QuenMatKhauDialog
     */
    public QuenMatKhauDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Quên Mật Khẩu");
        setLocationRelativeTo(null);
        seticon();
        setIconImage(Hepler.ImagesHelper.getAppIcon());
    }

    public void seticon() {
        Hepler.ImagesHelper.setIconlabel(lbl_anh, "src\\IMAGE\\forgot-password.png");
        Hepler.ImagesHelper.setIconButton(btn_timkiem, "src\\IMAGE\\search.png");
        Hepler.ImagesHelper.setIconButton(btn_laylaimk, "src\\IMAGE\\mail.png");
    }

    public boolean verify() {
        if (!evl.validate(txt_email.getText())) {
            DialogHelper.alert(this, "Email Không Đúng Định Dạng");
            txt_email.requestFocus();
            return false;
        }
        if (txt_email.getText().equals("")) {
            DialogHelper.alert(this, "Email Không Được Để Trống");
            txt_email.requestFocus();
            return false;
        }
        return true;
    }
    private boolean flag = false;
    private void filltable() {
        DefaultTableModel model = (DefaultTableModel) tabletaikhoan.getModel();
        model.setRowCount(0);
        try {
            List<TaiKhoan> list = tkd.selectAll();
            for (TaiKhoan tk : list) {
                if (tk.getEmail().equalsIgnoreCase(txt_email.getText())) {
                    Object[] row = {tk.getTaikhoan()
                    };
                    model.addRow(row);
                    flag = true;
                }
            }
            if(!flag){
                DialogHelper.alert(this, "Tài Khoản Hiện Chưa Đăng Ký");
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Loi Truy van");
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgorund = new javax.swing.JPanel();
        anh = new javax.swing.JPanel();
        lbl_anh = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabletaikhoan = new javax.swing.JTable();
        btn_laylaimk = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        backgorund.setBackground(new java.awt.Color(255, 255, 255));

        anh.setBackground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout anhLayout = new javax.swing.GroupLayout(anh);
        anh.setLayout(anhLayout);
        anhLayout.setHorizontalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        anhLayout.setVerticalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        txt_email.setText("Vui Lòng Nhập Email");

        btn_timkiem.setContentAreaFilled(false);
        btn_timkiem.setFocusPainted(false);
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tabletaikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tài Khoản"
            }
        ));
        tabletaikhoan.setGridColor(new java.awt.Color(255, 255, 255));
        tabletaikhoan.setOpaque(false);
        tabletaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletaikhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabletaikhoan);

        btn_laylaimk.setText("Lấy Lại Mật Khẩu");
        btn_laylaimk.setContentAreaFilled(false);
        btn_laylaimk.setFocusPainted(false);
        btn_laylaimk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laylaimkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgorundLayout = new javax.swing.GroupLayout(backgorund);
        backgorund.setLayout(backgorundLayout);
        backgorundLayout.setHorizontalGroup(
            backgorundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgorundLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgorundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgorundLayout.createSequentialGroup()
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_laylaimk))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        backgorundLayout.setVerticalGroup(
            backgorundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgorundLayout.createSequentialGroup()
                .addGroup(backgorundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgorundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgorundLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(backgorundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_timkiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_laylaimk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        add(backgorund, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        if(verify()){
            filltable();
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_laylaimkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laylaimkActionPerformed
        // TODO add your handling code here:
        long currentTime = new Date().getTime();
        if (currentTime - lastEventTime > 60000) { // 60000 milliseconds = 1 minute
            if (verify()) {
                try {
                    tentaikhoan = String.valueOf(tabletaikhoan.getValueAt(row, col));
                    List<TaiKhoan> list = tkd.selectAll();
                    for (TaiKhoan tk : list) {
                        if (tk.getTaikhoan().equalsIgnoreCase(tentaikhoan)) {
                            Hepler.Email.sendEmail(tk.getEmail(), "Thư Quên Mật Khẩu Tài Khoản: " + tk.getTaikhoan(), "Mật Khẩu Của Bạn Là: " + tk.getMatkhau());
                            DialogHelper.alert(this, "Vui Lòng Check Email");
                        }
                    }
                } catch (Exception e) {
                    DialogHelper.alert(this, "Vui Lòng Chọn Tên Đăng Nhập");
                    System.out.println(e.getMessage());
                }
            }
        } else {
            DialogHelper.alert(this, "Vui Lòng Chờ Trong Ít Phút");
        }
    }//GEN-LAST:event_btn_laylaimkActionPerformed

    private void tabletaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletaikhoanMouseClicked
        // TODO add your handling code here:
        row = tabletaikhoan.rowAtPoint(evt.getPoint());
        col = tabletaikhoan.columnAtPoint(evt.getPoint());

    }//GEN-LAST:event_tabletaikhoanMouseClicked

    /**
     * @param args the command line arguments
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anh;
    private javax.swing.JPanel backgorund;
    private javax.swing.JButton btn_laylaimk;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JTable tabletaikhoan;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables
}
