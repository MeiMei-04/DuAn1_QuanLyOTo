
package card;

import DAO.DichVuDAO;
import DAO.VoucherDAO;
import Hepler.DialogHelper;
import entyti.DichVu;
import entyti.Voucher;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 04dkh
 */
public class cardDichVu extends javax.swing.JPanel {

    /**
     * Creates new form DichVu
     */
    public cardDichVu() {
        initComponents();
        filltable();
        filltableVoucher();
    }
    DichVuDAO dao = new DichVuDAO();
    VoucherDAO vdao = new VoucherDAO();
    int row = -1;


    private void filltable() {
        DefaultTableModel model = (DefaultTableModel) tbldichvu.getModel();
        model.setRowCount(0);
        try {
            List<DichVu> list = dao.selectAll();
            for (DichVu dv : list) {
                Object[] row = {dv.getMadichvu(),
                    dv.getTendichvu(),
                    dv.getDongia(),
                    dv.getGhichu()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Loi Try van");
        }
    }

    void edit() {
        String madv = (String) tbldichvu.getValueAt(this.row, 0);
        DichVu dv = dao.selectByID(madv);
        this.setFrom(dv);
    }
    // Load tu bang len from

    void setFrom(DichVu vd) {
        txtMaDichVu.setText(vd.getMadichvu());
        txtTenDichVu.setText(vd.getTendichvu());
        txtGhiChu.setText(vd.getGhichu());
        txtDonGia.setText(String.valueOf(vd.getDongia()));

    }

    void clearFrom() {
        DichVu dv = new DichVu();
        this.setFrom(dv);
        this.row = -1;
    }

    DichVu getFrom() {
        DichVu dv = new DichVu();
        dv.setMadichvu(txtMaDichVu.getText());
        dv.setTendichvu(txtTenDichVu.getText());
        dv.setDongia(Float.valueOf(txtDonGia.getText()));
        dv.setGhichu(txtGhiChu.getText());
        return dv;
    }

    void insert() {
        DichVu dv = getFrom();
        if (dv != null) {
            try {
                dao.insert(dv);
                this.filltable();
                this.clearFrom();
                DialogHelper.alert(this, "Thêm  mới thành công !");
            } catch (Exception e) {
                DialogHelper.alert(this, "Thêm mới thất bại !");
                e.printStackTrace();
            }

        } else {
            return;
        }

    }

    void update() {
        DichVu dv = getFrom();
        if (dv != null) {
            try {
                dao.update(dv);
                this.filltable();
                DialogHelper.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
                e.printStackTrace();
            }

        }
    }

    void delete() {
        String madv = txtMaDichVu.getText();
        if (DialogHelper.confirm(this, "Bạn muốn xóa dịch vụ này!")) {
            try {
                dao.delete(madv);
                this.filltable();
                this.clearFrom();
                DialogHelper.alert(this, "bạn xóa thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại");
            }
        }
    }

    private void filltableVoucher() {
        DefaultTableModel model = (DefaultTableModel) tblVoucher.getModel();
        model.setRowCount(0);
        try {
            List<Voucher> list = vdao.selectAll();
            for (Voucher vh : list) {
                Object[] row = {vh.getMavoucher(),
                    vh.getNoidung(),
                    vh.isTrangthai()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Loi Try van");
        }
    }

    void setFromvoucher(Voucher vh) {
        txtMavoucher.setText(vh.getMavoucher());
        txtNoiDung.setText(vh.getNoidung());
        rdoChuaDung.setSelected(vh.isTrangthai());
        rdoDaDung.setSelected(!vh.isTrangthai());

    }

    void clearFromvoucher() {
        Voucher vh = new Voucher();
        this.setFromvoucher(vh);
        this.row = -1;
    }

    Voucher getFromVoucher() {
        Voucher vh = new Voucher();
        vh.setMavoucher(txtMavoucher.getText());
        vh.setNoidung(txtNoiDung.getText());
        vh.setTrangthai(rdoChuaDung.isSelected());
        return vh;
    }
     void editVoucher() {
        String mavc = (String) tblVoucher.getValueAt(this.row, 0);
        Voucher vh = vdao.selectByID(mavc);
        this.setFromvoucher(vh);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Trangthai = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaDichVu = new javax.swing.JTextField();
        txtTenDichVu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btncuoi = new javax.swing.JButton();
        btnlui = new javax.swing.JButton();
        Btndau = new javax.swing.JButton();
        btnsau = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldichvu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtMavoucher = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rdoDaDung = new javax.swing.JRadioButton();
        rdoChuaDung = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(946, 692));

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DỊCH VỤ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MÃ DỊCH VỤ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TÊN DỊCH VỤ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ĐƠN GIÁ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GHI CHÚ");

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 70));

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 102, 51));
        btnThem.setText("THÊM");
        btnThem.setRequestFocusEnabled(false);
        btnThem.setVerifyInputWhenFocusTarget(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 102, 51));
        btnSua.setText("SỬA");
        btnSua.setRequestFocusEnabled(false);
        btnSua.setVerifyInputWhenFocusTarget(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMoi.setForeground(new java.awt.Color(255, 102, 51));
        btnMoi.setText("MỚI");
        btnMoi.setRequestFocusEnabled(false);
        btnMoi.setVerifyInputWhenFocusTarget(false);
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 102, 51));
        btnXoa.setText("XÓA");
        btnXoa.setRequestFocusEnabled(false);
        btnXoa.setVerifyInputWhenFocusTarget(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btncuoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncuoi.setForeground(new java.awt.Color(255, 102, 51));
        btncuoi.setText(">|");
        btncuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncuoiActionPerformed(evt);
            }
        });

        btnlui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlui.setForeground(new java.awt.Color(255, 102, 51));
        btnlui.setText("<<");
        btnlui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluiActionPerformed(evt);
            }
        });

        Btndau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Btndau.setForeground(new java.awt.Color(255, 102, 51));
        Btndau.setText("|<");
        Btndau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtndauActionPerformed(evt);
            }
        });

        btnsau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsau.setForeground(new java.awt.Color(255, 102, 51));
        btnsau.setText(">>");
        btnsau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Btndau, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlui, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsau, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnlui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btndau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btncuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 51, 0));

        tbldichvu.setBackground(new java.awt.Color(255, 102, 51));
        tbldichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Đơn Giá", "Ghi Chú"
            }
        ));
        tbldichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbldichvuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbldichvu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenDichVu)
                    .addComponent(txtDonGia)
                    .addComponent(txtGhiChu)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(291, 291, 291))
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Dịch Vụ", jPanel1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Voucher");

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane2MousePressed(evt);
            }
        });

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Voucher", "Nội dung", "Trạng thái"
            }
        ));
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblVoucherMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblVoucher);

        jLabel7.setText("Mã Voucher:");

        jLabel8.setText("Nội dung:");

        txtNoiDung.setColumns(20);
        txtNoiDung.setRows(5);
        jScrollPane3.setViewportView(txtNoiDung);

        jLabel9.setText("Trang thái:");

        jPanel4.setLayout(new java.awt.GridLayout());

        Trangthai.add(rdoDaDung);
        rdoDaDung.setText("Đã dùng");
        jPanel4.add(rdoDaDung);

        Trangthai.add(rdoChuaDung);
        rdoChuaDung.setText("Chưa dùng");
        jPanel4.add(rdoChuaDung);

        jPanel5.setLayout(new java.awt.GridLayout());

        jButton1.setText("Thêm");
        jPanel5.add(jButton1);

        jButton2.setText("Sửa");
        jPanel5.add(jButton2);

        jButton3.setText("Xóa");
        jPanel5.add(jButton3);

        jButton4.setText("Mới");
        jPanel5.add(jButton4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                            .addComponent(txtMavoucher)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMavoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Voucher", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearFrom();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btncuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncuoiActionPerformed
        row = tbldichvu.getRowCount() - 1;
        System.out.println(row);
        edit();
    }//GEN-LAST:event_btncuoiActionPerformed

    private void btnluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluiActionPerformed
        if (row > 0) {
            row--;
            edit();
        }
    }//GEN-LAST:event_btnluiActionPerformed

    private void BtndauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtndauActionPerformed
        row = 0;
        edit();
    }//GEN-LAST:event_BtndauActionPerformed

    private void btnsauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsauActionPerformed
        if (row < tbldichvu.getRowCount() - 1) {
            row++;
            edit();
        }
    }//GEN-LAST:event_btnsauActionPerformed

    private void tbldichvuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldichvuMousePressed
        if (evt.getClickCount() == 2) {
            this.row = tbldichvu.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tbldichvuMousePressed

    private void jScrollPane2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MousePressed

    private void tblVoucherMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMousePressed
         if (evt.getClickCount() == 2) {
            this.row = tblVoucher.getSelectedRow();
            this.editVoucher();
        }
    }//GEN-LAST:event_tblVoucherMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btndau;
    private javax.swing.ButtonGroup Trangthai;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btncuoi;
    private javax.swing.JButton btnlui;
    private javax.swing.JButton btnsau;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoChuaDung;
    private javax.swing.JRadioButton rdoDaDung;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTable tbldichvu;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtMavoucher;
    private javax.swing.JTextArea txtNoiDung;
    private javax.swing.JTextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables
}
