/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import java.awt.Color;

/**
 *
 * @author hieud
 */
public class TaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form TaiKhoan
     */
    public TaiKhoan() {
        initComponents();
        seticon();
    }

    public void seticon() {
        Hepler.ImagesHelper.setIconlabel(lbl_anhdaidien, "src\\IMAGE\\anhthe1.jpg");
        Hepler.ImagesHelper.setIconlabel(lbl_anhbanglai1, "src\\IMAGE\\banglaixe1.jpg");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngr_gioitinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_trangthai = new javax.swing.JLabel();
        lbl_userid = new javax.swing.JLabel();
        pnl_anhbanglai = new javax.swing.JPanel();
        lbl_anhbanglai1 = new javax.swing.JLabel();
        btn_ChonAnh = new javax.swing.JButton();
        btn_Chonbangolai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_anhdaidien = new javax.swing.JLabel();
        lbl_capnhatthongtin = new javax.swing.JLabel();
        lbl_hovaten = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        txt_sodienthoai = new javax.swing.JTextField();
        lbl_sodienthoai = new javax.swing.JLabel();
        txt_cancuoc = new javax.swing.JTextField();
        lbl_cancuoc = new javax.swing.JLabel();
        pnl_gioitinh = new javax.swing.JPanel();
        rdo_nu = new javax.swing.JRadioButton();
        rdo_nam = new javax.swing.JRadioButton();
        lbl_diachi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diachi = new javax.swing.JTextArea();
        btn_capnhatthongtin = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(985, 660));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(985, 660));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lbl_trangthai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_trangthai.setText("Trạng Thái: Chưa Kích Hoạt");

        lbl_userid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_userid.setText("USERID: 1");

        pnl_anhbanglai.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh Bằng Lái"));
        pnl_anhbanglai.setOpaque(false);
        pnl_anhbanglai.setPreferredSize(new java.awt.Dimension(400, 200));

        lbl_anhbanglai1.setPreferredSize(new java.awt.Dimension(299, 193));

        javax.swing.GroupLayout pnl_anhbanglaiLayout = new javax.swing.GroupLayout(pnl_anhbanglai);
        pnl_anhbanglai.setLayout(pnl_anhbanglaiLayout);
        pnl_anhbanglaiLayout.setHorizontalGroup(
            pnl_anhbanglaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhbanglaiLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_anhbanglai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnl_anhbanglaiLayout.setVerticalGroup(
            pnl_anhbanglaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhbanglaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhbanglai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btn_ChonAnh.setBackground(new java.awt.Color(255, 204, 204));
        btn_ChonAnh.setText("Chọn Ảnh");
        btn_ChonAnh.setFocusPainted(false);
        btn_ChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonAnhActionPerformed(evt);
            }
        });

        btn_Chonbangolai.setBackground(new java.awt.Color(255, 204, 204));
        btn_Chonbangolai.setText("Chọn Ảnh");
        btn_Chonbangolai.setFocusPainted(false);
        btn_Chonbangolai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonbangolaiActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh Đại Diện"));
        jPanel3.setOpaque(false);

        lbl_anhdaidien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anhdaidien.setPreferredSize(new java.awt.Dimension(110, 164));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhdaidien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhdaidien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_Chonbangolai)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_trangthai)
                                        .addComponent(lbl_userid, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(btn_ChonAnh))
                                .addGap(86, 86, 86)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_trangthai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_userid)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btn_ChonAnh)
                .addGap(18, 18, 18)
                .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Chonbangolai)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        lbl_capnhatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_capnhatthongtin.setText("Cập Nhật Thông Tin");

        lbl_hovaten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_hovaten.setText("Họ Và Tên");

        txt_hoten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_email.setText("Email");

        txt_sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_sodienthoai.setText("Số Điện Thoại");

        txt_cancuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_cancuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_cancuoc.setText("Căn Cước");

        pnl_gioitinh.setBackground(new java.awt.Color(102, 102, 102));
        pnl_gioitinh.setBorder(javax.swing.BorderFactory.createTitledBorder("Giới Tính"));

        btngr_gioitinh.add(rdo_nu);
        rdo_nu.setText("Nữ");

        btngr_gioitinh.add(rdo_nam);
        rdo_nam.setText("Nam");

        javax.swing.GroupLayout pnl_gioitinhLayout = new javax.swing.GroupLayout(pnl_gioitinh);
        pnl_gioitinh.setLayout(pnl_gioitinhLayout);
        pnl_gioitinhLayout.setHorizontalGroup(
            pnl_gioitinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gioitinhLayout.createSequentialGroup()
                .addComponent(rdo_nu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdo_nam)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_gioitinhLayout.setVerticalGroup(
            pnl_gioitinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gioitinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_gioitinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_nu)
                    .addComponent(rdo_nam))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_diachi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_diachi.setText("Địa Chỉ");

        txt_diachi.setColumns(20);
        txt_diachi.setRows(5);
        jScrollPane1.setViewportView(txt_diachi);

        btn_capnhatthongtin.setBackground(new java.awt.Color(255, 204, 204));
        btn_capnhatthongtin.setText("Cập Nhật Thông Tin");
        btn_capnhatthongtin.setFocusPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(lbl_capnhatthongtin)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_diachi)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_capnhatthongtin))
                                .addContainerGap(259, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_hovaten)
                                    .addComponent(lbl_email)
                                    .addComponent(pnl_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txt_hoten))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_cancuoc)
                                    .addComponent(lbl_sodienthoai)
                                    .addComponent(lbl_cancuoc)
                                    .addComponent(txt_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_capnhatthongtin)
                        .addGap(33, 33, 33)
                        .addComponent(lbl_hovaten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_sodienthoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_cancuoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cancuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnl_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_diachi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_capnhatthongtin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ChonbangolaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonbangolaiActionPerformed
        // TODO add your handling code here:
        Hepler.ImagesHelper.chonAnh();
    }//GEN-LAST:event_btn_ChonbangolaiActionPerformed

    private void btn_ChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonAnhActionPerformed
        // TODO add your handling code here:
        Hepler.ImagesHelper.chonAnh();
    }//GEN-LAST:event_btn_ChonAnhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChonAnh;
    private javax.swing.JButton btn_Chonbangolai;
    private javax.swing.JButton btn_capnhatthongtin;
    private javax.swing.ButtonGroup btngr_gioitinh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anhbanglai1;
    private javax.swing.JLabel lbl_anhdaidien;
    private javax.swing.JLabel lbl_cancuoc;
    private javax.swing.JLabel lbl_capnhatthongtin;
    private javax.swing.JLabel lbl_diachi;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_hovaten;
    private javax.swing.JLabel lbl_sodienthoai;
    private javax.swing.JLabel lbl_trangthai;
    private javax.swing.JLabel lbl_userid;
    private javax.swing.JPanel pnl_anhbanglai;
    private javax.swing.JPanel pnl_gioitinh;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTextField txt_cancuoc;
    private javax.swing.JTextArea txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_sodienthoai;
    // End of variables declaration//GEN-END:variables
}
