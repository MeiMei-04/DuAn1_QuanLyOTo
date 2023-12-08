/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.ChiTietXeDAO;
import DAO.HangXeDAO;
import Hepler.DialogHelper;
import Hepler.ImagesHelper;
import entyti.ChiTietXe;
import entyti.HangXe;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 04dkh
 */
public class cardXeThue extends javax.swing.JPanel {

    ChiTietXeDAO ctxd = new ChiTietXeDAO();
    HangXeDAO hxd = new HangXeDAO();
    List<ChiTietXe> list_soghe = new ArrayList<>();
    private static final String writeurl_xe = "src/imgxe/";
    String selectedFilePath_xe = null;
    String selectedFileName_xe = null;

    /**
     * Creates new form cardXeThue
     */
    public cardXeThue() {
        initComponents();
        fillcbb_hangxe();
        fillcbb_soghe();
        filltable_danhsachxe();
    }

    public void setFom(ChiTietXe ctx) {
        String tenxe = null;
        try {
            HangXe hx = hxd.selectByID_MAHANGXE(ctx.getMahangxe());
            tenxe = hx.getTenhangxe();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setimg(ctx.getAnhxe());
        cbb_soghe.setSelectedItem(String.valueOf(ctx.getSoghe()));
        cbb_hangxe.setSelectedItem(tenxe);
        txt_giathue.setText(String.valueOf(ctx.getGiathue()));
        txt_maxe.setText(ctx.getMaxe());
        txt_trangthai.setText(ctx.getTrangthaixe());
        txt_tenxe.setText(ctx.getTenxe());
        selectedFileName_xe = ctx.getAnhxe();
    }

    public void xoaxe() {
        String maxe = txt_maxe.getText();
        try {
            ctxd.delete(maxe);
            DialogHelper.alert(this, "Xoá Xe Thành Công");
            filltable_danhsachxe();
        } catch (Exception e) {
            DialogHelper.alert(this, "Xoá Xe Thất Bại");
            System.out.println(e.getMessage());
        }
    }

    public void suaxe() {
        ChiTietXe ctx = getform();
        try {
            ctxd.update(ctx);
            DialogHelper.alert(this, "Sửa Xe Thành Công");
            filltable_danhsachxe();
        } catch (Exception e) {
            DialogHelper.alert(this, "Sửa Xe Thất Bại");
            System.out.println(e.getMessage());
        }
    }

    public void themxe() {
        ChiTietXe ctx = getform();
        try {
            ctxd.insert(ctx);
            DialogHelper.alert(this, "Thêm Xe Thành Công");
            filltable_danhsachxe();
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm Xe Thất Bại");
            System.out.println(e.getMessage());
        }
    }

    public ChiTietXe getform() {
        int mahangxe = 0;
        try {
            HangXe hx = hxd.selectByID_TENHANGXE(cbb_hangxe.getSelectedItem().toString());
            mahangxe = hx.getMahangxe();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ChiTietXe ctx = new ChiTietXe();
        ctx.setMaxe(txt_maxe.getText());
        ctx.setTenxe(txt_tenxe.getText());
        ctx.setTrangthaixe(txt_trangthai.getText());
        ctx.setSoghe(Integer.parseInt(cbb_soghe.getSelectedItem().toString()));
        ctx.setMahangxe(mahangxe);
        ctx.setGiathue(Integer.parseInt(txt_giathue.getText()));
        ctx.setAnhxe(selectedFileName_xe);
        return ctx;
    }

    public void xoa_form() {
        selectedFileName_xe = null;
        setimg(selectedFileName_xe);
        cbb_soghe.setSelectedIndex(0);
        cbb_hangxe.setSelectedIndex(0);
        txt_maxe.setText("");
        txt_tenxe.setText("");
        txt_giathue.setText("");
        txt_trangthai.setText("");

    }

    public void setimg(String anhxe) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhxe, "src\\imgxe\\" + anhxe);
    }

    public void filltable_danhsachxe() {
        DefaultTableModel model = (DefaultTableModel) tbl_danhsachxe.getModel();
        model.setRowCount(0);
        try {
            List<ChiTietXe> list = ctxd.selectAll();
            for (ChiTietXe ctx : list) {
                Object[] row = {
                    ctx.getMaxe(),
                    ctx.getTenxe(),
                    ctx.getSoghe(),
                    ctx.getGiathue(),
                    ctx.getAnhxe(),
                    ctx.tenhangxe(ctx.getMahangxe()),
                    ctx.getTrangthaixe()
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fillcbb_hangxe() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_hangxe.getModel();
            model.removeAllElements();
            List<HangXe> list = hxd.selectAll();
            for (HangXe hx : list) {
                model.addElement(hx.getTenhangxe());
            }
            cbb_hangxe.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fillcbb_soghe() {

        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_soghe.getModel();
            model.removeAllElements();
            Set<String> uniqueSeatNumbers = new HashSet<>();
            List<ChiTietXe> list = ctxd.selectAll();
            for (ChiTietXe ctx : list) {
                String soghe = String.valueOf(ctx.getSoghe());
                // Kiểm tra xem số ghế đã xuất hiện hay chưa
                if (uniqueSeatNumbers.add(soghe)) {
                    model.addElement(soghe);
                }
            }
            cbb_soghe.setSelectedIndex(0);
        } catch (Exception e) {
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

        background = new javax.swing.JPanel();
        ttxe = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_maxe = new javax.swing.JTextField();
        txt_tenxe = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_trangthai = new javax.swing.JTextArea();
        anh = new javax.swing.JPanel();
        lbl_anhxe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_timtheosoghe = new javax.swing.JLabel();
        cbb_hangxe = new javax.swing.JComboBox<>();
        cbb_soghe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_giathue = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btn_chonanh = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhsachxe = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 51));

        background.setBackground(new java.awt.Color(255, 102, 51));

        ttxe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN XE THUÊ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        ttxe.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MÃ XE");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TÊN XE");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TRẠNG THÁI XE");

        txt_trangthai.setColumns(20);
        txt_trangthai.setRows(5);
        jScrollPane1.setViewportView(txt_trangthai);

        anh.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        anh.setOpaque(false);
        anh.setPreferredSize(new java.awt.Dimension(402, 284));

        lbl_anhxe.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout anhLayout = new javax.swing.GroupLayout(anh);
        anh.setLayout(anhLayout);
        anhLayout.setHorizontalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anhLayout.createSequentialGroup()
                .addComponent(lbl_anhxe, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
        anhLayout.setVerticalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anhxe, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ẢNH XE");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HÃNG");

        lbl_timtheosoghe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_timtheosoghe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_timtheosoghe.setText("SỐ GHẾ");

        cbb_hangxe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_hangxe.setForeground(new java.awt.Color(255, 102, 51));
        cbb_hangxe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "TOYOTA", "CHEVROLET", "FORD", "HONDA", "SSANGYONG", "LANDROVER" }));
        cbb_hangxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_hangxeActionPerformed(evt);
            }
        });

        cbb_soghe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_soghe.setForeground(new java.awt.Color(255, 102, 51));
        cbb_soghe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "4", "7", "16", "29" }));
        cbb_soghe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_sogheActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ĐƠN GIÁ");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 102, 51));
        jButton4.setText("|<");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 102, 51));
        jButton5.setText("<<");

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 102, 51));
        jButton6.setText(">>");

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 102, 51));
        jButton7.setText(">|");

        btn_chonanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_chonanh.setForeground(new java.awt.Color(255, 102, 51));
        btn_chonanh.setText("Chọn");
        btn_chonanh.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_chonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonanhActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ttxeLayout = new javax.swing.GroupLayout(ttxe);
        ttxe.setLayout(ttxeLayout);
        ttxeLayout.setHorizontalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ttxeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(btn_chonanh, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ttxeLayout.createSequentialGroup()
                            .addComponent(btnTim)
                            .addGap(18, 18, 18)
                            .addComponent(txtTim))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ttxeLayout.createSequentialGroup()
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton7))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ttxeLayout.createSequentialGroup()
                            .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_timtheosoghe)
                                .addComponent(cbb_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(cbb_hangxe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ttxeLayout.createSequentialGroup()
                            .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel6))
                            .addGap(36, 36, 36)
                            .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_maxe, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_tenxe, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_giathue, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        ttxeLayout.setVerticalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ttxeLayout.createSequentialGroup()
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(btn_chonanh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addComponent(anh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(lbl_timtheosoghe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_hangxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_maxe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tenxe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_giathue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN THUÊ XE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 178));

        tbl_danhsachxe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ XE", "TÊN XE", "SỐ GHẾ", "GIÁ THUÊ", "Ảnh Xe", "Mã Hãng Xe", "TRẠNG THÁI XE"
            }
        ));
        tbl_danhsachxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhsachxeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_danhsachxe);

        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 102, 51));
        btn_them.setText("THÊM");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_moi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_moi.setForeground(new java.awt.Color(255, 102, 51));
        btn_moi.setText("MỚI");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 102, 51));
        btn_sua.setText("SỬA");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 102, 51));
        btn_xoa.setText("XÓA");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btn_them)
                .addGap(18, 18, 18)
                .addComponent(btn_moi)
                .addGap(18, 18, 18)
                .addComponent(btn_sua)
                .addGap(18, 18, 18)
                .addComponent(btn_xoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_moi)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ttxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(ttxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbb_sogheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_sogheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_sogheActionPerformed

    private void cbb_hangxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_hangxeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_hangxeActionPerformed

    private void btn_chonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonanhActionPerformed
        // TODO add your handling code here:
        try {
            ImagesHelper.Pair<String, String> xe = ImagesHelper.chonAnh();
            if (xe != null) {
                selectedFilePath_xe = xe.getFirst();
                selectedFileName_xe = xe.getSecond();
            } else {
                DialogHelper.alert(this, "Lỗi Chọn Ảnh");
            }
            Hepler.ImagesHelper.convertImgTo280x180(selectedFilePath_xe, selectedFileName_xe, writeurl_xe);
            setimg(selectedFileName_xe);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btn_chonanhActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        // TODO add your handling code here:
        xoa_form();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        themxe();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        suaxe();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        xoaxe();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tbl_danhsachxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhsachxeMouseClicked
        // TODO add your handling code here:
        int row = tbl_danhsachxe.getSelectedRow();
        String maxe = (String) tbl_danhsachxe.getValueAt(row, 0);
        try {
            ChiTietXe ctx = ctxd.selectByID_MAXE(maxe);
            setFom(ctx);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_danhsachxeMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String tenXe = "%" + txtTim.getText() + "%";
        DefaultTableModel model = (DefaultTableModel) tbl_danhsachxe.getModel();
        model.setRowCount(0);
        try {
            List<ChiTietXe> list = ctxd.selectByID_TENXETim(tenXe);
            for (ChiTietXe ctx : list) {
                Object[] row = {
                    ctx.getMaxe(),
                    ctx.getTenxe(),
                    ctx.getSoghe(),
                    ctx.getGiathue(),
                    ctx.getAnhxe(),
                    ctx.tenhangxe(ctx.getMahangxe()),
                    ctx.getTrangthaixe()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anh;
    private javax.swing.JPanel background;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btn_chonanh;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_hangxe;
    private javax.swing.JComboBox<String> cbb_soghe;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_anhxe;
    private javax.swing.JLabel lbl_timtheosoghe;
    private javax.swing.JTable tbl_danhsachxe;
    private javax.swing.JPanel ttxe;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txt_giathue;
    private javax.swing.JTextField txt_maxe;
    private javax.swing.JTextField txt_tenxe;
    private javax.swing.JTextArea txt_trangthai;
    // End of variables declaration//GEN-END:variables
}
