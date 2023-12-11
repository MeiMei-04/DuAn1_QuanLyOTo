/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import DAO.ChiTietTaiKhoanDAO;
import DAO.ChiTietXeDAO;
import DAO.HopDongDAO;
import entyti.ChiTietTaiKhoan;
import entyti.ChiTietXe;
import entyti.HopDong;
import entyti.TaiKhoan;

/**
 *
 * @author Hieu
 */
public class ThongTinTraXe extends javax.swing.JDialog {

    HopDongDAO hdd = new HopDongDAO();
    ChiTietTaiKhoanDAO cttkd = new ChiTietTaiKhoanDAO();
    ChiTietXeDAO ctxd = new ChiTietXeDAO();
    /**
     * Creates new form ThongTinTraXe
     */
    String diachi = null;
    String trangthaixe = null;
    String mahopdong = null;

    public ThongTinTraXe(java.awt.Frame parent, boolean modal, String mahopdong) {
        super(parent, modal);
        initComponents();
        this.mahopdong = mahopdong;
        setTitle("Nhập Địa Chỉ Trả Xe");
        setLocationRelativeTo(null);
    }

    public void getForm() {
        trangthaixe = txt_trangThaiXe.getText();
        diachi = txt_DiaChiGuiXe.getText();
    }

    public void update_xe_TinhTrangXe(String maxe) {
        getForm();
        ChiTietXe ctx = new ChiTietXe();
        ctx.setMaxe(maxe);
        ctx.setTrangthaixe(trangthaixe);
        ctxd.update_CHITIETXE(ctx);
    }

    public void update_HopDong_TRANGTHAI() {
        HopDong hd = new HopDong();
        hd.setMahopdong(mahopdong);
        hd.setTinhtranghopdong(5);
        hdd.update_trangthai(hd);
    }

    public void update_HopDong_NGAYTRAXE() {
        HopDong hd = new HopDong();
        hd.setMahopdong(mahopdong);
        hd.setNgaytraxe(Hepler.DateHelper.now());
        hdd.update_NGAYTRAXE(hd);
    }

    public void update_xe() {
        try {
            HopDong hd = hdd.selectByID_MAHOPDONG(mahopdong);
            TaiKhoan tk = Hepler.AuthHelper.user;
            ChiTietTaiKhoan cttk = cttkd.selectByID_DOITUONG(String.valueOf(tk.getUserid()));
            if (hd.getThoihanhopdong() > 0) {
                ChiTietTaiKhoan cttknew_1 = new ChiTietTaiKhoan();
                cttknew_1.setUserid(tk.getUserid());
                int phuphiquahan = hd.getThoihanhopdong() * 2 + 5;
                int tienquahan = cttk.getSodu() * phuphiquahan / 100;
                if (cttk.getSodu() - tienquahan < 0) {
                    Hepler.DialogHelper.alert(this, "Tiền Của Bạn Không Đủ Vui Lòng Nạp Thêm");
                    return;
                } else {
                    cttknew_1.setSodu(cttk.getSodu() - tienquahan);
                    cttkd.update_sodu(cttknew_1);
                }
            } else {
                ChiTietTaiKhoan cttknew = new ChiTietTaiKhoan();
                int tienlayxe = (hd.getThanhtien() * 5) / 100;
                if (cttk.getSodu() - tienlayxe < 0) {
                    Hepler.DialogHelper.alert(this, "Tiền Của Bạn Không Đủ Vui Lòng Nạp Thêm");
                    return;
                } else {
                    cttknew.setUserid(tk.getUserid());
                    cttknew.setSodu(cttk.getSodu() - tienlayxe);
                }
                cttkd.update_sodu(cttknew);
            }
            update_xe_TinhTrangXe(hd.getMaxe());
            update_HopDong_NGAYTRAXE();
            update_HopDong_TRANGTHAI();
            Hepler.DialogHelper.alert(this, "Trả Xe Thành Công");
            this.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Hepler.DialogHelper.alert(this, "Trả Xe Thất Bại");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_trangThaiXe = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_DiaChiGuiXe = new javax.swing.JTextArea();
        btn_HoanTat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nhập Trạng Thái Xe");

        txt_trangThaiXe.setColumns(20);
        txt_trangThaiXe.setRows(5);
        jScrollPane1.setViewportView(txt_trangThaiXe);

        jLabel2.setText("Địa Điểm Gửi Xe");

        txt_DiaChiGuiXe.setColumns(20);
        txt_DiaChiGuiXe.setRows(5);
        jScrollPane2.setViewportView(txt_DiaChiGuiXe);

        btn_HoanTat.setText("Hoàn Tất");
        btn_HoanTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HoanTatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_HoanTat))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_HoanTat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HoanTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HoanTatActionPerformed
        // TODO add your handling code here:
        if (Hepler.DialogHelper.confirm(this, "Bạn Có Đồng Ý Trả Xe Không")) {
            update_xe();
        } else {
            return;
        }
    }//GEN-LAST:event_btn_HoanTatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_HoanTat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_DiaChiGuiXe;
    private javax.swing.JTextArea txt_trangThaiXe;
    // End of variables declaration//GEN-END:variables
}