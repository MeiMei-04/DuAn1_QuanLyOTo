/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import DAO.TaiKhoanDAO;
import Hepler.DialogHelper;
import entyti.TaiKhoan;

/**
 *
 * @author Hieu
 */
public class DoiMatKhauDialog extends javax.swing.JDialog {
    TaiKhoanDAO tkd = new TaiKhoanDAO();
    /**
     * Creates new form DoiMatKhauDialog
     */
    public DoiMatKhauDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Đổi Mật Khẩu");
        setIconImage(Hepler.ImagesHelper.getAppIcon());
        setLocationRelativeTo(null);
        seticon();
    }
    public void seticon() {
        Hepler.ImagesHelper.setIconlabel(lbl_anh, "src\\IMAGE\\reload.png");
        Hepler.ImagesHelper.setIconlabel(lbl_confirm, "src\\IMAGE\\security.png");
        Hepler.ImagesHelper.setIconlabel(lbl_pass, "src\\IMAGE\\password.png");
        Hepler.ImagesHelper.setIconlabel(lbl_pass1, "src\\IMAGE\\password.png");
    }
    public boolean veirfy(){
        if(txt_matkhaucu.getPassword().equals("")){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            txt_matkhaucu.requestFocus();
            return false;
        }
        if(txt_matkhaumoi.getPassword().equals("")){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            txt_matkhaumoi.requestFocus();
            return false;
        }
        if(txt_matkhauxacnhan.getPassword().equals("")){
            DialogHelper.alert(this, "Thông Tin Không Được Để Trống");
            txt_matkhauxacnhan.requestFocus();
            return false;
        }
        if (!String.valueOf(txt_matkhauxacnhan.getPassword()).equals(String.valueOf(txt_matkhaumoi.getPassword()))) {
            DialogHelper.alert(this, "Mật Khẩu Xác Nhận Phải Nhập Trùng");
            txt_matkhauxacnhan.requestFocus();
            return false;
        }
        if (String.valueOf(txt_matkhaumoi.getPassword()).length() < 6) {
            DialogHelper.alert(this, "Mật Khẩu Kí tự Lớn hơn 6");
            txt_matkhaumoi.requestFocus();
            return false;
        }
        TaiKhoan tk = Hepler.AuthHelper.user;
        if(!tk.getMatkhau().equalsIgnoreCase(String.valueOf(txt_matkhaucu.getPassword()))){
            DialogHelper.alert(this, "Mật Khẩu Bạn Nhập Không Đúng");
            txt_matkhaucu.requestFocus();
        }
        return true;
    }
    void update() {
        TaiKhoan tk = Hepler.AuthHelper.user;
        tk.setMatkhau(String.valueOf(txt_matkhaumoi.getPassword()));
            try {
                tkd.update(tk);
                DialogHelper.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
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

        jPanel1 = new javax.swing.JPanel();
        lbl_matkhaucu = new javax.swing.JLabel();
        txt_matkhaucu = new javax.swing.JPasswordField();
        lbl_matkhaumoi = new javax.swing.JLabel();
        txt_matkhaumoi = new javax.swing.JPasswordField();
        lbl_matkhauxacnhan = new javax.swing.JLabel();
        txt_matkhauxacnhan = new javax.swing.JPasswordField();
        btn_xacnhan = new javax.swing.JButton();
        cb_hienthimatkhau = new javax.swing.JCheckBox();
        pnl_anh = new javax.swing.JPanel();
        lbl_anh = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        lbl_confirm = new javax.swing.JLabel();
        lbl_pass1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));

        lbl_matkhaucu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_matkhaucu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_matkhaucu.setText("MẬT KHẨU CŨ");
        lbl_matkhaucu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_matkhaucuMouseClicked(evt);
            }
        });

        txt_matkhaucu.setText("jPasswordField1");

        lbl_matkhaumoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_matkhaumoi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_matkhaumoi.setText("MẬT KHẨU MỚI");
        lbl_matkhaumoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_matkhaumoiMouseClicked(evt);
            }
        });

        txt_matkhaumoi.setText("jPasswordField1");

        lbl_matkhauxacnhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_matkhauxacnhan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_matkhauxacnhan.setText("XÁC NHẬN MẬT KHẨU MỚI");
        lbl_matkhauxacnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_matkhauxacnhanMouseClicked(evt);
            }
        });

        txt_matkhauxacnhan.setText("jPasswordField1");

        btn_xacnhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xacnhan.setForeground(new java.awt.Color(255, 102, 51));
        btn_xacnhan.setText("Xác Nhận");
        btn_xacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhanActionPerformed(evt);
            }
        });

        cb_hienthimatkhau.setForeground(new java.awt.Color(255, 255, 255));
        cb_hienthimatkhau.setText("HIỂN THỊ MẬT KHẨU");
        cb_hienthimatkhau.setContentAreaFilled(false);
        cb_hienthimatkhau.setFocusPainted(false);
        cb_hienthimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_hienthimatkhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_anhLayout = new javax.swing.GroupLayout(pnl_anh);
        pnl_anh.setLayout(pnl_anhLayout);
        pnl_anhLayout.setHorizontalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        pnl_anhLayout.setVerticalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhLayout.createSequentialGroup()
                .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lbl_matkhaucu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txt_matkhaucu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_matkhauxacnhan)
                                    .addComponent(txt_matkhauxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_hienthimatkhau)
                                    .addComponent(btn_xacnhan)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_matkhaumoi)
                                    .addComponent(txt_matkhaumoi))))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_matkhaucu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_matkhaucu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_matkhaumoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_matkhaumoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_matkhauxacnhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_matkhauxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_hienthimatkhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_xacnhan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_hienthimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hienthimatkhauActionPerformed
        // TODO add your handling code here:
        if (cb_hienthimatkhau.isSelected()) {
            txt_matkhaucu.setEchoChar((char) 0); // password visible
            txt_matkhaumoi.setEchoChar((char) 0); // password visible
            txt_matkhauxacnhan.setEchoChar((char) 0); // password visible
        } else {
            txt_matkhaucu.setEchoChar('*'); // password hidden
            txt_matkhaumoi.setEchoChar('*'); // password hidden
            txt_matkhauxacnhan.setEchoChar('*'); // password hidden
        }
    }//GEN-LAST:event_cb_hienthimatkhauActionPerformed

    private void btn_xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhanActionPerformed
        // TODO add your handling code here:
        if(veirfy()){
            update();
        }
    }//GEN-LAST:event_btn_xacnhanActionPerformed

    private void lbl_matkhaucuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_matkhaucuMouseClicked
        // TODO add your handling code here:
        txt_matkhaucu.setText("");
    }//GEN-LAST:event_lbl_matkhaucuMouseClicked

    private void lbl_matkhaumoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_matkhaumoiMouseClicked
        // TODO add your handling code here:
        txt_matkhaumoi.setText("");
    }//GEN-LAST:event_lbl_matkhaumoiMouseClicked

    private void lbl_matkhauxacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_matkhauxacnhanMouseClicked
        // TODO add your handling code here:
        txt_matkhauxacnhan.setText("");
    }//GEN-LAST:event_lbl_matkhauxacnhanMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xacnhan;
    private javax.swing.JCheckBox cb_hienthimatkhau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JLabel lbl_confirm;
    private javax.swing.JLabel lbl_matkhaucu;
    private javax.swing.JLabel lbl_matkhaumoi;
    private javax.swing.JLabel lbl_matkhauxacnhan;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_pass1;
    private javax.swing.JPanel pnl_anh;
    private javax.swing.JPasswordField txt_matkhaucu;
    private javax.swing.JPasswordField txt_matkhaumoi;
    private javax.swing.JPasswordField txt_matkhauxacnhan;
    // End of variables declaration//GEN-END:variables
}
