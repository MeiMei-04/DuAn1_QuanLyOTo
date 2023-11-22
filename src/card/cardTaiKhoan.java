/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.TaiKhoanDAO;
import Hepler.DialogHelper;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author hieud
 */
public class cardTaiKhoan extends javax.swing.JPanel {
    TaiKhoanDAO tkd = new TaiKhoanDAO();
    String banglai = null;
    String anhdaidien = null;
    private static String readurl_banglai = "src/imgbanglainew/" ;
    private static String writeurl_banglai = "src/imgbanglai/" ;
    private static String readurl_anhdaidien = "src/imganhdaidiennew/" ;
    private static String writeurl_anhdaidien = "src/imganhdaidien/" ;
    /**
     * Creates new form TaiKhoan
     */
    public cardTaiKhoan() {
        initComponents();
    }
    public void setImg(String anhdaidien,String banglai) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhdaidien, "src\\imganhdaidien\\"+anhdaidien); 
        Hepler.ImagesHelper.setIconlabel(lbl_anhbanglai, "src\\imgbanglai\\"+banglai);
    }
    public void setForm(){
            try {
                    List<entyti.TaiKhoan> list = tkd.selectAll();
                    for (entyti.TaiKhoan tk : list) {
                        if(tk.equals(Hepler.AuthHelper.user)){
                        }
                    }
                } catch (Exception e) {
                    DialogHelper.alert(this, "Vui Lòng Chọn Tên Đăng Nhập");
                    System.out.println(e.getMessage());
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

        btngr_gioitinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnl_anhbanglai = new javax.swing.JPanel();
        lbl_anhbanglai = new javax.swing.JLabel();
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
        txt_userid = new javax.swing.JTextField();
        lbl_userid = new javax.swing.JLabel();
        txt_trangthaikhachhang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(985, 660));

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(985, 660));

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));

        pnl_anhbanglai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Bằng Lái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_anhbanglai.setForeground(new java.awt.Color(255, 255, 255));
        pnl_anhbanglai.setOpaque(false);
        pnl_anhbanglai.setPreferredSize(new java.awt.Dimension(400, 200));

        lbl_anhbanglai.setPreferredSize(new java.awt.Dimension(300, 200));

        javax.swing.GroupLayout pnl_anhbanglaiLayout = new javax.swing.GroupLayout(pnl_anhbanglai);
        pnl_anhbanglai.setLayout(pnl_anhbanglaiLayout);
        pnl_anhbanglaiLayout.setHorizontalGroup(
            pnl_anhbanglaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_anhbanglaiLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lbl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        pnl_anhbanglaiLayout.setVerticalGroup(
            pnl_anhbanglaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhbanglaiLayout.createSequentialGroup()
                .addComponent(lbl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        btn_ChonAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ChonAnh.setForeground(new java.awt.Color(255, 102, 51));
        btn_ChonAnh.setText("Chọn Ảnh");
        btn_ChonAnh.setFocusPainted(false);
        btn_ChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonAnhActionPerformed(evt);
            }
        });

        btn_Chonbangolai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Chonbangolai.setForeground(new java.awt.Color(255, 102, 51));
        btn_Chonbangolai.setText("Chọn Ảnh");
        btn_Chonbangolai.setFocusPainted(false);
        btn_Chonbangolai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonbangolaiActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Đại Diện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Chonbangolai)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btn_ChonAnh)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ChonAnh, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_Chonbangolai)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        lbl_capnhatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_capnhatthongtin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_capnhatthongtin.setText("Cập Nhật Thông Tin");

        lbl_hovaten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_hovaten.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hovaten.setText("Họ Và Tên");

        txt_hoten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("Email");

        txt_sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_sodienthoai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sodienthoai.setText("Số Điện Thoại");

        txt_cancuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_cancuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_cancuoc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancuoc.setText("Căn Cước");

        pnl_gioitinh.setBackground(new java.awt.Color(255, 102, 51));
        pnl_gioitinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giới Tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_gioitinh.setForeground(new java.awt.Color(255, 255, 255));

        btngr_gioitinh.add(rdo_nu);
        rdo_nu.setForeground(new java.awt.Color(255, 255, 255));
        rdo_nu.setText("Nữ");

        btngr_gioitinh.add(rdo_nam);
        rdo_nam.setForeground(new java.awt.Color(255, 255, 255));
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
        lbl_diachi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_diachi.setText("Địa Chỉ");

        txt_diachi.setColumns(20);
        txt_diachi.setRows(5);
        jScrollPane1.setViewportView(txt_diachi);

        btn_capnhatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_capnhatthongtin.setForeground(new java.awt.Color(255, 102, 51));
        btn_capnhatthongtin.setText("Cập Nhật Thông Tin");
        btn_capnhatthongtin.setFocusPainted(false);

        txt_userid.setRequestFocusEnabled(false);

        lbl_userid.setBackground(new java.awt.Color(255, 102, 51));
        lbl_userid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_userid.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userid.setText("USERID");

        jLabel2.setBackground(new java.awt.Color(255, 102, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trạng Thái Tài Khoản");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 121, Short.MAX_VALUE)
                                .addComponent(lbl_capnhatthongtin)
                                .addGap(112, 112, 112))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_hovaten)
                                    .addComponent(lbl_email)
                                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txt_hoten))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_trangthaikhachhang)
                                        .addComponent(txt_cancuoc)
                                        .addComponent(lbl_sodienthoai)
                                        .addComponent(lbl_cancuoc)
                                        .addComponent(txt_sodienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_diachi)
                            .addComponent(pnl_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_userid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_userid)
                            .addComponent(btn_capnhatthongtin))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_capnhatthongtin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_userid)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_userid, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trangthaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_hovaten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_capnhatthongtin)
                .addGap(56, 56, 56))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ChonbangolaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonbangolaiActionPerformed
        // TODO add your handling code here:
        
        banglai = Hepler.ImagesHelper.chonAnh();
        Hepler.ImagesHelper.convertImgTo280x180(readurl_banglai,banglai,writeurl_banglai);
        setImg(anhdaidien, banglai);
        
        
    }//GEN-LAST:event_btn_ChonbangolaiActionPerformed

    private void btn_ChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonAnhActionPerformed
        // TODO add your handling code here:
        
        
        anhdaidien = Hepler.ImagesHelper.chonAnh();
        Hepler.ImagesHelper.convertImgTo110x164(readurl_anhdaidien,anhdaidien,writeurl_anhdaidien);
        setImg(anhdaidien, banglai);
        
    }//GEN-LAST:event_btn_ChonAnhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChonAnh;
    private javax.swing.JButton btn_Chonbangolai;
    private javax.swing.JButton btn_capnhatthongtin;
    private javax.swing.ButtonGroup btngr_gioitinh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anhbanglai;
    private javax.swing.JLabel lbl_anhdaidien;
    private javax.swing.JLabel lbl_cancuoc;
    private javax.swing.JLabel lbl_capnhatthongtin;
    private javax.swing.JLabel lbl_diachi;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_hovaten;
    private javax.swing.JLabel lbl_sodienthoai;
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
    private javax.swing.JTextField txt_trangthaikhachhang;
    private javax.swing.JTextField txt_userid;
    // End of variables declaration//GEN-END:variables
}
