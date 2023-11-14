/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package form;

import DAO.TaiKhoanDAO;
import Hepler.DialogHelper;
import Hepler.Email;
import entyti.TaiKhoan;
import java.util.Random;
import Hepler.EmailValidator;
import java.util.Date;

/**
 *
 * @author hieud
 */
public class DangKyDialog extends java.awt.Dialog {

    EmailValidator evl = new EmailValidator();
    TaiKhoanDAO dao = new TaiKhoanDAO();
    String formattedCode = null;
    private static long lastEventTime = 0;

    /**
     * Creates new form DangKyDialog
     */
    public DangKyDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Đăng Ký");
        seticon();
        setLocationRelativeTo(null);
        setIconImage(Hepler.ImagesHelper.getAppIcon());
    }

    public void seticon() {
        Hepler.ImagesHelper.setIconlabel(lbl_anh, "src\\IMAGE\\log-in.png");
        Hepler.ImagesHelper.setIconlabel(lbl_confirm, "src\\IMAGE\\security.png");
        Hepler.ImagesHelper.setIconlabel(lbl_email, "src\\IMAGE\\mail.png");
        Hepler.ImagesHelper.setIconlabel(lbl_maxacnhan, "src\\IMAGE\\otp.png");
        Hepler.ImagesHelper.setIconlabel(lbl_pass, "src\\IMAGE\\password.png");
        Hepler.ImagesHelper.setIconlabel(lbl_taikhoan, "src\\IMAGE\\user.png");
        Hepler.ImagesHelper.setIconButton(btn_dangky, "src\\IMAGE\\edit-button.png");
        Hepler.ImagesHelper.setIconButton(btn_nhanma, "src\\IMAGE\\send_ma.png");
    }

    public boolean verify() {
        if (!Hepler.alphaHelper.isAlphaNumeric(txt_taikhoan.getText())) {
            DialogHelper.alert(this, "Tài Khoản Chỉ Bao Gồm Số Và Chữ");
            txt_taikhoan.requestFocus();
            return false;
        }
        if (!String.valueOf(txt_passwordconfirm.getPassword()).equals(String.valueOf(txt_password.getPassword()))) {
            DialogHelper.alert(this, "Mật Khẩu Xác Nhận Phải Nhập Trùng");
            txt_passwordconfirm.requestFocus();
            return false;
        }
        if (txt_taikhoan.getText().equals("")) {
            DialogHelper.alert(this, "Tài Khoản Không Được Để Trống");
            txt_taikhoan.requestFocus();
            return false;
        }
        if (String.valueOf(txt_password.getPassword()).equals("")) {
            DialogHelper.alert(this, "Mật Khẩu Không Được Để Trống");
            txt_taikhoan.requestFocus();
            return false;
        }
        if (String.valueOf(txt_passwordconfirm.getPassword()).equals("")) {
            DialogHelper.alert(this, "Mật Khẩu Xác Nhận Không Được Để Trống");
            txt_passwordconfirm.requestFocus();
            return false;
        }
        if (txt_email.getText().equals("")) {
            DialogHelper.alert(this, "Email Không Được Để Trống");
            txt_email.requestFocus();
            return false;
        }
        if (String.valueOf(txt_password.getPassword()).length() < 6) {
            DialogHelper.alert(this, "Mật Khẩu Kí tự Lớn hơn 6");
            txt_password.requestFocus();
            return false;
        }
        if (!txt_maxacnhan.getText().equalsIgnoreCase(String.valueOf(formattedCode))) {
            DialogHelper.alert(this, "Mã Xác Thực Không Đúng");
            return false;
        }
        return true;

    }

    public void clearForm() {
        txt_taikhoan.setText("");
        txt_password.setText("");
        txt_passwordconfirm.setText("");
        txt_email.setText("");
        txt_maxacnhan.setText("");
    }

    //getForm lấy dữ liệu từ form
    TaiKhoan getForm() {
        try {
            TaiKhoan tk = new TaiKhoan();
            tk.setTaikhoan(txt_taikhoan.getText());
            tk.setMatkhau(String.valueOf(txt_password.getPassword()));
            tk.setEmail(txt_email.getText());
            tk.setTrangthai(false);
            tk.setVaitro(false);
            return tk;
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi Lấy Dữ Liệu Từ Form");
            return null;
        }

    }

    public void insert() {
        TaiKhoan tk = getForm();
        try {
            dao.insert(tk);
            clearForm();
            DialogHelper.alert(this, "Đăng Ký Thành Công");
            formattedCode = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            DialogHelper.alert(this, "Đăng Ký Không Thành Công");

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        pnl_anh = new javax.swing.JPanel();
        lbl_anh = new javax.swing.JLabel();
        lbl_taikhoan = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();
        lbl_confirm = new javax.swing.JLabel();
        txt_taikhoan = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        lbl_maxacnhan = new javax.swing.JLabel();
        txt_maxacnhan = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_passwordconfirm = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btn_dangky = new javax.swing.JButton();
        btn_nhanma = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        background.setBackground(new java.awt.Color(255, 102, 51));

        pnl_anh.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_anhLayout = new javax.swing.GroupLayout(pnl_anh);
        pnl_anh.setLayout(pnl_anhLayout);
        pnl_anhLayout.setHorizontalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhLayout.createSequentialGroup()
                .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_anhLayout.setVerticalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lbl_taikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_taikhoanMouseClicked(evt);
            }
        });

        lbl_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_passMouseClicked(evt);
            }
        });

        lbl_confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_confirmMouseClicked(evt);
            }
        });

        txt_taikhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_taikhoan.setForeground(new java.awt.Color(255, 102, 51));
        txt_taikhoan.setText("Tài Khoản");
        txt_taikhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_taikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_taikhoanMouseClicked(evt);
            }
        });
        txt_taikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_taikhoanActionPerformed(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 102, 51));
        txt_email.setText("Email");
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_emailMouseClicked(evt);
            }
        });

        lbl_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_emailMouseClicked(evt);
            }
        });

        lbl_maxacnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_maxacnhanMouseClicked(evt);
            }
        });

        txt_maxacnhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_maxacnhan.setForeground(new java.awt.Color(255, 102, 51));
        txt_maxacnhan.setText("Mã Xác Nhận");
        txt_maxacnhan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_maxacnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_maxacnhanMouseClicked(evt);
            }
        });

        txt_password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 102, 51));
        txt_password.setText("pass");
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordMouseClicked(evt);
            }
        });

        txt_passwordconfirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_passwordconfirm.setForeground(new java.awt.Color(255, 102, 51));
        txt_passwordconfirm.setText("pass");
        txt_passwordconfirm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_passwordconfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordconfirmMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Đăng Ký");

        btn_dangky.setBackground(new java.awt.Color(255, 102, 51));
        btn_dangky.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_dangky.setForeground(new java.awt.Color(255, 255, 255));
        btn_dangky.setText("Đăng Ký");
        btn_dangky.setBorder(null);
        btn_dangky.setFocusPainted(false);
        btn_dangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangkyActionPerformed(evt);
            }
        });

        btn_nhanma.setBackground(new java.awt.Color(255, 102, 51));
        btn_nhanma.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_nhanma.setForeground(new java.awt.Color(255, 255, 255));
        btn_nhanma.setText("Nhận Mã");
        btn_nhanma.setBorder(null);
        btn_nhanma.setFocusPainted(false);
        btn_nhanma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhanmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(pnl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                        .addComponent(lbl_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_passwordconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                        .addComponent(lbl_email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                        .addComponent(lbl_maxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_maxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                .addComponent(btn_dangky, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_nhanma, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(lbl_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(lbl_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_password))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel6)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_anh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(51, 51, 51)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_passwordconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_maxacnhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_maxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_dangky, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btn_nhanma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_taikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_taikhoanMouseClicked
        // TODO add your handling code here:
        txt_taikhoan.setText("");
    }//GEN-LAST:event_txt_taikhoanMouseClicked

    private void txt_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseClicked
        // TODO add your handling code here:
        txt_password.setText("");
    }//GEN-LAST:event_txt_passwordMouseClicked

    private void txt_passwordconfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordconfirmMouseClicked
        // TODO add your handling code here:
        txt_passwordconfirm.setText("");
    }//GEN-LAST:event_txt_passwordconfirmMouseClicked

    private void txt_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseClicked
        // TODO add your handling code here:
        txt_email.setText("");
    }//GEN-LAST:event_txt_emailMouseClicked

    private void txt_maxacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maxacnhanMouseClicked
        // TODO add your handling code here:
        txt_maxacnhan.setText("");
    }//GEN-LAST:event_txt_maxacnhanMouseClicked

    private void lbl_taikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_taikhoanMouseClicked
        // TODO add your handling code here:
        txt_taikhoan.requestFocus();
    }//GEN-LAST:event_lbl_taikhoanMouseClicked

    private void lbl_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_passMouseClicked
        // TODO add your handling code here:
        txt_password.requestFocus();
    }//GEN-LAST:event_lbl_passMouseClicked

    private void lbl_confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_confirmMouseClicked
        // TODO add your handling code here:
        txt_passwordconfirm.requestFocus();
    }//GEN-LAST:event_lbl_confirmMouseClicked

    private void lbl_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_emailMouseClicked
        // TODO add your handling code here:
        txt_email.requestFocus();
    }//GEN-LAST:event_lbl_emailMouseClicked

    private void lbl_maxacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_maxacnhanMouseClicked
        // TODO add your handling code here:
        txt_maxacnhan.requestFocus();
    }//GEN-LAST:event_lbl_maxacnhanMouseClicked

    private void btn_nhanmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanmaActionPerformed
        // TODO add your handling code here:
        long currentTime = new Date().getTime();
        if (currentTime - lastEventTime > 60000) { // 60000 milliseconds = 1 minute
            if (evl.validate(txt_email.getText())) {
                Random rand = new Random();
                int code = rand.nextInt(999999);
                formattedCode = String.format("%06d", code);
                Email.sendEmail(txt_email.getText(), "Xác Minh Tài Khoản", String.valueOf(formattedCode));
            } else {
                DialogHelper.alert(this, "Email Không Đúng Định Dạng");
            }
            lastEventTime = currentTime;
        } else {
            DialogHelper.alert(this, "Vui Lòng Chờ Trong Ít Phút");
        }


    }//GEN-LAST:event_btn_nhanmaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txt_taikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_taikhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_taikhoanActionPerformed

    private void btn_dangkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangkyActionPerformed
        // TODO add your handling code here:
        if (verify()) {
            insert();
        }
    }//GEN-LAST:event_btn_dangkyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_dangky;
    private javax.swing.JButton btn_nhanma;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JLabel lbl_confirm;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_maxacnhan;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JLabel lbl_taikhoan;
    private javax.swing.JPanel pnl_anh;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_maxacnhan;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_passwordconfirm;
    private javax.swing.JTextField txt_taikhoan;
    // End of variables declaration//GEN-END:variables
}
