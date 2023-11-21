/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.DanhGiaDAO;
import DAO.DichVuDAO;
import DAO.ThueXeDAO;
import Hepler.AuthHelper;
import entyti.DanhGia;
import entyti.DichVu;
import entyti.Xe;
import form.TaoHopDongDialog;
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
    int row = -1;
    String item = null;

    /**
     * Creates new form ThueXe
     */
    public cardThueXe() {
        initComponents();
        fillcbbDichVu();
        setForm(locxe(item), 0);
    }

    public void openThuexe() {
        try {
            new TaoHopDongDialog(null, true).setVisible(true);
        } catch (Exception e) {
        }
    }
    
    public void openHopDong() {
        try {
            if (AuthHelper.authenticated()) {
                new TaoHopDongDialog(null, true).setVisible(true);
            } else {
                openHopDong();
            }

        } catch (Exception e) {
        }
    }
    
    

    public void seticon(String string) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhxe, "src\\imgxe\\" + string);

    }

    public List<DanhGia> getlistdanhgia(String maxe) {
        List<DanhGia> list = new ArrayList<>();
        try {
            list = dgd.selectByKey(maxe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    private void filltableDanhGia(List<DanhGia> list) {
        DefaultTableModel model = (DefaultTableModel) tbl_danhgia.getModel();
        model.setRowCount(0);
        try {
            if (!list.isEmpty()) {
                for (DanhGia dg : list) {
                    Object[] row = {dg.getHoten(),
                        dg.getNoidung(),
                        dg.getSosaodanhgia(),
                        dg.getNgaydanhgia()
                    };
                    model.addRow(row);
                }
            } else {
                return;
            }

        } catch (Exception e) {
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
            txt_noidung.setText(xe.getGhichu());
        } catch (Exception e) {
            Hepler.DialogHelper.alert(this, "Lỗi Truy Vấn");
            System.out.println(e.getMessage());
        }
    }
    // đăng khoa
    public void showFrom(Component com) {
        background.removeAll();
        background.add(com);
        background.revalidate();
        background.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
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
        lbl_voucher = new javax.swing.JLabel();
        lbl_dichvu = new javax.swing.JLabel();
        txt_voucher = new javax.swing.JTextField();
        btn_Thuexe = new javax.swing.JButton();
        txt_songaythue = new javax.swing.JTextField();
        lbl_songaythue = new javax.swing.JLabel();
        cbb_loaixe = new javax.swing.JComboBox<>();
        lbl_timtheosoghe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 51));

        background.setBackground(new java.awt.Color(255, 102, 51));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_danhgiaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        lbl_voucher.setForeground(new java.awt.Color(255, 255, 255));
        lbl_voucher.setText("Vocher");

        lbl_dichvu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dichvu.setText("Dich Vụ");

        btn_Thuexe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Thuexe.setForeground(new java.awt.Color(255, 102, 51));
        btn_Thuexe.setText("Thuê Xe");
        btn_Thuexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThuexeActionPerformed(evt);
            }
        });

        lbl_songaythue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_songaythue.setText("Số Ngày Thuê");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbb_DichVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_voucher)
                    .addComponent(txt_songaythue)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_voucher)
                            .addComponent(lbl_dichvu)
                            .addComponent(lbl_songaythue))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 346, Short.MAX_VALUE)
                        .addComponent(btn_Thuexe)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbl_dichvu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_voucher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_songaythue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_songaythue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btn_Thuexe)
                .addGap(23, 23, 23))
        );

        cbb_loaixe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_loaixe.setForeground(new java.awt.Color(255, 102, 51));
        cbb_loaixe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "4", "7", "16", "29" }));
        cbb_loaixe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_loaixeActionPerformed(evt);
            }
        });

        lbl_timtheosoghe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_timtheosoghe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_timtheosoghe.setText("Tìm Theo Số Ghế:");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ttxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(lbl_timtheosoghe)
                                .addGap(18, 18, 18)
                                .addComponent(cbb_loaixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(pnl_danhgia, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(pnl_danhgia, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_loaixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_timtheosoghe))
                        .addGap(38, 38, 38)
                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ttxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        index--;
        btn_next.setEnabled(true);
        if (index < 0) {
            Hepler.DialogHelper.alert(this, "Danh Sách Đang ở đầu");
            index =0;
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
            index =size;
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

    private void btn_ThuexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThuexeActionPerformed
        // TODO add your handling code here:
        openHopDong();
    }//GEN-LAST:event_btn_ThuexeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anh;
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_Thuexe;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox<String> cbb_DichVu;
    private javax.swing.JComboBox<String> cbb_loaixe;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_anhxe;
    private javax.swing.JLabel lbl_dichvu;
    private javax.swing.JLabel lbl_giathue;
    private javax.swing.JLabel lbl_maloaixe;
    private javax.swing.JLabel lbl_maxe;
    private javax.swing.JLabel lbl_noidung;
    private javax.swing.JLabel lbl_soghe;
    private javax.swing.JLabel lbl_songaythue;
    private javax.swing.JLabel lbl_tenxe;
    private javax.swing.JLabel lbl_timtheosoghe;
    private javax.swing.JLabel lbl_trangthai;
    private javax.swing.JLabel lbl_voucher;
    private javax.swing.JPanel pnl_danhgia;
    private javax.swing.JTable tbl_danhgia;
    private javax.swing.JPanel ttxe;
    private javax.swing.JTextArea txt_noidung;
    private javax.swing.JTextField txt_songaythue;
    private javax.swing.JTextField txt_voucher;
    // End of variables declaration//GEN-END:variables
}
