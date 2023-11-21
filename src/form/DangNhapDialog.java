/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package form;

import DAO.TaiKhoanDAO;
import Hepler.DialogHelper;
import entyti.TaiKhoan;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author hieud
 */
public class DangNhapDialog extends java.awt.Dialog {

    TaiKhoanDAO tkd = new TaiKhoanDAO();

    /**
     * Creates new form DangNhapDialog
     */
    public DangNhapDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Đăng Nhập");
        seticon();
        setLocationRelativeTo(null);
        setIconImage(Hepler.ImagesHelper.getAppIcon());
    }

    public void seticon() {
        Hepler.ImagesHelper.setIconlabel(lbl_logo, "src\\IMAGE\\car_logo_login.png");
        Hepler.ImagesHelper.setIconlabel(lbl_iconuser, "src\\IMAGE\\user.png");
        Hepler.ImagesHelper.setIconlabel(lbl_iconpassword, "src\\IMAGE\\password.png");
        Hepler.ImagesHelper.setIconlabel(lbl_quenmatkhau, "src\\IMAGE\\forgot.png");
        Hepler.ImagesHelper.setIconlabel(lbl_dangky, "src\\IMAGE\\register.png");
        Hepler.ImagesHelper.setIconButton(btn_DangNhap, "src\\IMAGE\\enter.png");
    }

    public boolean verify() {
        if (!Hepler.alphaHelper.isAlphaNumeric(txt_tendangnhap.getText())) {
            DialogHelper.alert(this, "Tài Khoản Chỉ Bao Gồm Số Và Chữ");
            txt_tendangnhap.requestFocus();
            return false;
        }
        if (txt_tendangnhap.getText().length() > 19) {
            DialogHelper.alert(this, "Giới Hạn Nhập 20 Kí Tự");
            txt_tendangnhap.requestFocus();
            return false;
        }
        if (txt_tendangnhap.getText().equals("")) {
            txt_tendangnhap.requestFocus();
            Hepler.DialogHelper.alert(this, "Vui lòng nhập tên đăng nhập");
            return false;
        }
        if (String.valueOf(txt_password.getPassword()).equals("")) {
            txt_password.requestFocus();
            Hepler.DialogHelper.alert(this, "Vui lòng nhập mật khâu");
            return false;
        }
        return true;

    }

    public void dangNhap() {
        if (verify()) {
            TaiKhoan tk = tkd.selectByID(txt_tendangnhap.getText());
            if (tk == null) {
                txt_tendangnhap.requestFocus();
                Hepler.DialogHelper.alert(this, "Tài Khoản Không Tồn Tại");

            } else if (!String.valueOf(txt_password.getPassword()).equals(tk.getMatkhau())) {
                txt_password.requestFocus();
                Hepler.DialogHelper.alert(this, "Sai mật khẩu");
            } else {
                Hepler.AuthHelper.user = tk;// khai bao nhan vien dang nhap
                Hepler.DialogHelper.alert(this, "Đăng nhập thành công");
                this.dispose();
            }
        }
    }

    public void openDangKy() {
        try {
            new DangKyDialog(null, true).setVisible(true);
        } catch (Exception e) {
        }
    }
    public void quenMatKhau() {
        try {
            new QuenMatKhauDialog(null, true).setVisible(true);
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlbackground = new javax.swing.JPanel();
        pnl_anh = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_tendangnhap = new javax.swing.JTextField();
        lbl_iconuser = new javax.swing.JLabel();
        lbl_iconpassword = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        cb_hienthimatkhau = new javax.swing.JCheckBox();
        lbl_quenmatkhau = new javax.swing.JLabel();
        btn_DangNhap = new javax.swing.JButton();
        lbl_dangky = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlbackground.setBackground(new java.awt.Color(255, 102, 51));

        pnl_anh.setBackground(new java.awt.Color(255, 255, 255));

        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnl_anhLayout = new javax.swing.GroupLayout(pnl_anh);
        pnl_anh.setLayout(pnl_anhLayout);
        pnl_anhLayout.setHorizontalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhLayout.createSequentialGroup()
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_anhLayout.setVerticalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhLayout.createSequentialGroup()
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME!");

        txt_tendangnhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tendangnhap.setForeground(new java.awt.Color(255, 102, 51));
        txt_tendangnhap.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_tendangnhap.setText("dangkhoa2004");
        txt_tendangnhap.setBorder(null);
        txt_tendangnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_tendangnhapMouseClicked(evt);
            }
        });

        lbl_iconuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_iconuserMouseClicked(evt);
            }
        });

        lbl_iconpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_iconpasswordMouseClicked(evt);
            }
        });

        txt_password.setForeground(new java.awt.Color(255, 102, 51));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_password.setText("khoacute");
        txt_password.setBorder(null);
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordMouseClicked(evt);
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

        lbl_quenmatkhau.setForeground(new java.awt.Color(255, 255, 255));
        lbl_quenmatkhau.setText("QUÊN MẬT KHẨU");
        lbl_quenmatkhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lbl_quenmatkhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_quenmatkhauMouseClicked(evt);
            }
        });

        btn_DangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_DangNhap.setForeground(new java.awt.Color(255, 102, 51));
        btn_DangNhap.setText("ĐĂNG NHẬP");
        btn_DangNhap.setBorder(null);
        btn_DangNhap.setFocusPainted(false);
        btn_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangNhapActionPerformed(evt);
            }
        });

        lbl_dangky.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dangky.setText("ĐĂNG KÝ TÀI KHOẢN");
        lbl_dangky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dangkyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(154, 154, 154))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_dangky)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_iconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_iconpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cb_hienthimatkhau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_quenmatkhau))
                    .addComponent(txt_password)
                    .addComponent(btn_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_tendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_iconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_hienthimatkhau)
                            .addComponent(lbl_quenmatkhau))
                        .addGap(18, 18, 18)
                        .addComponent(btn_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_iconpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_dangky)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlbackgroundLayout = new javax.swing.GroupLayout(pnlbackground);
        pnlbackground.setLayout(pnlbackgroundLayout);
        pnlbackgroundLayout.setHorizontalGroup(
            pnlbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbackgroundLayout.createSequentialGroup()
                .addGroup(pnlbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlbackgroundLayout.setVerticalGroup(
            pnlbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbackgroundLayout.createSequentialGroup()
                .addComponent(pnl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlbackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlbackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_hienthimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hienthimatkhauActionPerformed
        // TODO add your handling code here:
        if (cb_hienthimatkhau.isSelected()) {
            txt_password.setEchoChar((char) 0); // password visible
        } else {
            txt_password.setEchoChar('*'); // password hidden
        }
    }//GEN-LAST:event_cb_hienthimatkhauActionPerformed

    private void txt_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseClicked
        // TODO add your handling code here:
        txt_password.setText("");
    }//GEN-LAST:event_txt_passwordMouseClicked

    private void txt_tendangnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tendangnhapMouseClicked
        // TODO add your handling code here:
        txt_tendangnhap.setText("");
    }//GEN-LAST:event_txt_tendangnhapMouseClicked

    private void lbl_iconuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iconuserMouseClicked
        // TODO add your handling code here:
        txt_tendangnhap.requestFocus();
    }//GEN-LAST:event_lbl_iconuserMouseClicked

    private void lbl_iconpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iconpasswordMouseClicked
        // TODO add your handling code here:
        txt_password.requestFocus();
    }//GEN-LAST:event_lbl_iconpasswordMouseClicked

    private void lbl_dangkyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dangkyMouseClicked
        // TODO add your handling code here:
        openDangKy();
    }//GEN-LAST:event_lbl_dangkyMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangNhapActionPerformed
        // TODO add your handling code here:
        dangNhap();
    }//GEN-LAST:event_btn_DangNhapActionPerformed

    private void lbl_quenmatkhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_quenmatkhauMouseClicked
        // TODO add your handling code here:
        quenMatKhau();
    }//GEN-LAST:event_lbl_quenmatkhauMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangNhap;
    private javax.swing.JCheckBox cb_hienthimatkhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_dangky;
    private javax.swing.JLabel lbl_iconpassword;
    private javax.swing.JLabel lbl_iconuser;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_quenmatkhau;
    private javax.swing.JPanel pnl_anh;
    private javax.swing.JPanel pnlbackground;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_tendangnhap;
    // End of variables declaration//GEN-END:variables
}
