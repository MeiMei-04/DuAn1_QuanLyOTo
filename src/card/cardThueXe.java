/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.DanhGiaDAO;
import DAO.DichVuDAO;
import DAO.ThueXeDAO;
import Hepler.DialogHelper;
import entyti.DanhGia;
import entyti.DichVu;
import entyti.Xe;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 04dkh
 */
public class cardThueXe extends javax.swing.JPanel {

    DanhGiaDAO dgd = new DanhGiaDAO();
    DichVuDAO dvd = new DichVuDAO();
    ThueXeDAO txd = new ThueXeDAO();
    int index = 0;
    int size = 0;
    String item = null;

    /**
     * Creates new form ThueXe
     */
    public cardThueXe() {
        initComponents();
        fillcbbDichVu();
        setForm(locxe(item), 0);
    }

//    public void seticonDanhGia(String anh) {
//        Hepler.ImagesHelper.setIconlabel(lbl_anh, "src\\ICON\\" + anh);
//    }
//
//    public void setFormDanhGia(String id) {
//        try {
//            System.out.println(id);
//            List<DanhGia> list = new ArrayList<>();
//            DanhGia dg = dgd.selectByID(id);
//            list.add(dg);
//            seticonDanhGia(dg.getAnhdaidien());
//            lbl_tennguoidung.setText(dg.getHoten());
//            System.out.println(dg.getHoten());
//            lbl_sosao.setText(dg.getSosaodanhgia() + " sao");
//            txt_danhgia.setText(dg.getNoidung());
//            System.out.println(dg.getNoidung());
//        } catch (Exception e) {
//            Hepler.DialogHelper.alert(this, "Lỗi Truy Vấn");
//            System.out.println(e.getMessage());
//        }
//    }
    public void seticon(String string) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhxe, "src\\imgxe\\" + string);

    }

    public void showFrom(Component com) {
        pnl_danhgia.removeAll();
        pnl_danhgia.add(com);
        pnl_danhgia.revalidate();
        pnl_danhgia.repaint();
    }
    public List<DanhGia> getlistdanhgia(String maxe) {
        List<DanhGia> list = new ArrayList<>();
        try {
            List<DanhGia> alldanhgia = dgd.selectAll();
            if (maxe != null) {
                for (DanhGia dg : alldanhgia) {
                    if (dg.getMaxe().equalsIgnoreCase(maxe)) {
                        list.add(dg);
                    }
                }
            } else {
                list = alldanhgia;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    int row = -1;

    private void filltableDanhGia(List<DanhGia> list) {

        DefaultTableModel model = (DefaultTableModel) tbl_danhgia.getModel();
        model.setRowCount(0);
        try {
            
            for (DanhGia dg :list) {
                Object[] row = {dg.getHoten(),
                    dg.getNoidung(),
                    dg.getSosaodanhgia(),
                    dg.getNgaydanhgia()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Loi Truy van");
            System.out.println(e.getMessage());
        }
    }

    public void fillcbbDichVu() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_DichVu.getModel();
            model.removeAllElements();
            List<DichVu> list = dvd.selectAll();
            for (DichVu dv : list) {
                model.addElement(dv.getTendichvu());
            }
            cbb_DichVu.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Xe> locxe(String soghe) {
        List<Xe> list = new ArrayList<>();
        try {
            List<Xe> allXe = txd.selectAll();
            if (soghe != null) {
                for (Xe xe : allXe) {
                    if (xe.getSoghe() == Integer.valueOf(soghe)) {
                        list.add(xe);
                    }
                }
            } else {
                list = allXe;
            }
        } catch (Exception e) {
            // handle exception
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void setForm(List<Xe> list, int index) {
        try {
            String trangthai = null;
            Xe xe = list.get(index);
            size = list.size() - 1;
            Hepler.ImagesHelper.checkfile("src\\imgxe\\" + xe.getAnhxe());
            System.out.println(xe.getAnhxe());
            seticon(xe.getAnhxe()); //set ảnh xe
            lbl_maxe.setText("Mã Xe: " + xe.getMaxe());
            filltableDanhGia(getlistdanhgia(xe.getMaxe()));
//            setFormDanhGia(xe.getMaxe());
            lbl_tenxe.setText("Tên Xe: " + xe.getTenxe());
            lbl_soghe.setText("Số Ghế: " + xe.getSoghe());
            if (xe.isTrangthaixethue()) {
                trangthai = "Đã Thuê";
            } else {
                trangthai = "Chưa Thuê";
            }
            lbl_trangthai.setText("Trạng Thái: " + trangthai);
            lbl_giathue.setText("Giá Thuê: " + xe.getGiathue());
            lbl_maloaixe.setText("Loại Xe: " + xe.getMaloaixe());
        } catch (Exception e) {
            Hepler.DialogHelper.alert(this, "Lỗi Truy Vấn");
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

        backgournd = new javax.swing.JPanel();
        anh = new javax.swing.JPanel();
        lbl_anhxe = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        pnl_danhgia = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_danhgia = new javax.swing.JTable();
        ttxe = new javax.swing.JPanel();
        lbl_maxe = new javax.swing.JLabel();
        lbl_tenxe = new javax.swing.JLabel();
        lbl_soghe = new javax.swing.JLabel();
        lbl_trangthai = new javax.swing.JLabel();
        lbl_giathue = new javax.swing.JLabel();
        lbl_maloaixe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_noidung = new javax.swing.JTextArea();
        lbl_noidung = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbb_DichVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbb_loaixe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 51));

        backgournd.setBackground(new java.awt.Color(255, 102, 51));

        anh.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        anh.setOpaque(false);
        anh.setPreferredSize(new java.awt.Dimension(402, 284));

        lbl_anhxe.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout anhLayout = new javax.swing.GroupLayout(anh);
        anh.setLayout(anhLayout);
        anhLayout.setHorizontalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhxe, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        anhLayout.setVerticalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anhxe, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        btn_back.setBackground(new java.awt.Color(255, 102, 51));
        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("<");
        btn_back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_back.setBorderPainted(false);
        btn_back.setContentAreaFilled(false);
        btn_back.setFocusPainted(false);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(255, 102, 51));
        btn_next.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_next.setForeground(new java.awt.Color(255, 255, 255));
        btn_next.setText(">");
        btn_next.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_next.setBorderPainted(false);
        btn_next.setContentAreaFilled(false);
        btn_next.setFocusPainted(false);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        pnl_danhgia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl_danhgia.setForeground(new java.awt.Color(255, 255, 255));
        pnl_danhgia.setOpaque(false);
        pnl_danhgia.setPreferredSize(new java.awt.Dimension(350, 345));

        jScrollPane3.setOpaque(false);

        tbl_danhgia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ Tên", "Nội Dung", "Số Sao", "Ngày Đánh GIá"
            }
        ));
        tbl_danhgia.setOpaque(false);
        jScrollPane3.setViewportView(tbl_danhgia);

        javax.swing.GroupLayout pnl_danhgiaLayout = new javax.swing.GroupLayout(pnl_danhgia);
        pnl_danhgia.setLayout(pnl_danhgiaLayout);
        pnl_danhgiaLayout.setHorizontalGroup(
            pnl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnl_danhgiaLayout.setVerticalGroup(
            pnl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );

        ttxe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Xe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        ttxe.setOpaque(false);

        lbl_maxe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_maxe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_maxe.setText("Mã Xe");

        lbl_tenxe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_tenxe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tenxe.setText("Tên Xe");

        lbl_soghe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_soghe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_soghe.setText("Số Ghế");

        lbl_trangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_trangthai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_trangthai.setText("Trạng Thái");

        lbl_giathue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_giathue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_giathue.setText("Giá Thuê");

        lbl_maloaixe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_maloaixe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_maloaixe.setText("Mã Loại Xe");

        txt_noidung.setColumns(20);
        txt_noidung.setRows(5);
        jScrollPane1.setViewportView(txt_noidung);

        lbl_noidung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_noidung.setForeground(new java.awt.Color(255, 255, 255));
        lbl_noidung.setText("Ghi Chú");

        javax.swing.GroupLayout ttxeLayout = new javax.swing.GroupLayout(ttxe);
        ttxe.setLayout(ttxeLayout);
        ttxeLayout.setHorizontalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ttxeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_maloaixe)
                    .addComponent(lbl_tenxe)
                    .addComponent(lbl_soghe)
                    .addComponent(lbl_trangthai)
                    .addComponent(lbl_giathue)
                    .addComponent(lbl_maxe)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(lbl_noidung)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        ttxeLayout.setVerticalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ttxeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_maxe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_tenxe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_soghe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_trangthai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_giathue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_maloaixe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_noidung)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thuê Xe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 178));

        cbb_DichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_DichVu.setForeground(new java.awt.Color(255, 102, 51));
        cbb_DichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vocher");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Dich Vụ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 51));
        jButton1.setText("Thuê Xe");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbb_DichVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 250, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        cbb_loaixe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_loaixe.setForeground(new java.awt.Color(255, 102, 51));
        cbb_loaixe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "4", "7", "16", "29" }));
        cbb_loaixe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_loaixeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tìm Theo Số Ghế:");

        javax.swing.GroupLayout backgourndLayout = new javax.swing.GroupLayout(backgournd);
        backgournd.setLayout(backgourndLayout);
        backgourndLayout.setHorizontalGroup(
            backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgourndLayout.createSequentialGroup()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgourndLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ttxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgourndLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgourndLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbb_loaixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_danhgia, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        backgourndLayout.setVerticalGroup(
            backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgourndLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgourndLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(pnl_danhgia, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgourndLayout.createSequentialGroup()
                        .addGroup(backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_loaixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(backgourndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgourndLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ttxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(backgourndLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgournd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgournd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        index--;
        btn_next.setEnabled(true);
        if (index < 0) {
            Hepler.DialogHelper.alert(this, "Danh Sách Đang ở đầu");
            btn_back.setEnabled(false);
        } else {
            setForm(locxe(item), index);
        }

    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        index++;
        btn_back.setEnabled(true);
        if (index > size) {
            Hepler.DialogHelper.alert(this, "Danh Sách Đang Cuối");
            btn_next.setEnabled(false);
        } else {
            setForm(locxe(item), index);
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void cbb_loaixeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_loaixeActionPerformed
        // TODO add your handling code here:
        item = String.valueOf(cbb_loaixe.getSelectedItem());
        index = 0;
        if (item.equalsIgnoreCase("Tất Cả")) {
            item = null;
        }
        btn_back.setEnabled(false);
        btn_next.setEnabled(true);
        setForm(locxe(item), index);
    }//GEN-LAST:event_cbb_loaixeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anh;
    private javax.swing.JPanel backgournd;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cbb_DichVu;
    private javax.swing.JComboBox<String> cbb_loaixe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_anhxe;
    private javax.swing.JLabel lbl_giathue;
    private javax.swing.JLabel lbl_maloaixe;
    private javax.swing.JLabel lbl_maxe;
    private javax.swing.JLabel lbl_noidung;
    private javax.swing.JLabel lbl_soghe;
    private javax.swing.JLabel lbl_tenxe;
    private javax.swing.JLabel lbl_trangthai;
    private javax.swing.JPanel pnl_danhgia;
    private javax.swing.JTable tbl_danhgia;
    private javax.swing.JPanel ttxe;
    private javax.swing.JTextArea txt_noidung;
    // End of variables declaration//GEN-END:variables
}
