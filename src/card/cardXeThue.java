/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.ThueXeDAO;
import Hepler.DialogHelper;
import entyti.Xe;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 04dkh
 */
public class cardXeThue extends javax.swing.JPanel {
    ThueXeDAO dao = new ThueXeDAO();
    int row = -1;
    String anhxe = null;
    private static String readurl = "src/imgxenew/" ;
    private static String writeurl = "src/imgxe/" ;
    /**
     * Creates new form cardXeThue
     */
    public cardXeThue() {
        initComponents();
        filltable();
        seticon();
    }
    public void setimg(String path){
        Hepler.ImagesHelper.setIconlabel(lbl_anh, "src\\imgxe\\"+path);
    }
    public void seticon(){
        Hepler.ImagesHelper.setIconButton(btnMoi, "src\\IMAGE\\new.png");
        Hepler.ImagesHelper.setIconButton(btnSua, "src\\IMAGE\\update.png");
        Hepler.ImagesHelper.setIconButton(btnThem, "src\\IMAGE\\add.png");
        Hepler.ImagesHelper.setIconButton(btnXoa, "src\\IMAGE\\delete.png");
        Hepler.ImagesHelper.setIconButton(btn_chonanh, "src\\IMAGE\\pickimg.png");
    }
    
    public boolean verify(){
        if(txt_maxe.getText().equals("")){
            DialogHelper.alert(this, "Mã Xe Không Được Để Trống");
            txt_maxe.requestFocus();
           return false;
        }
        if(txt_tenxe.getText().equals("")){
            DialogHelper.alert(this, "Tên Xe Không Được Để Trống");
            txt_tenxe.requestFocus();
           return false;
        }
        if(txt_maloaixe.getText().equals("")){
            DialogHelper.alert(this, "MÃ Loại Xe Không Được Để Trống");
            txt_maloaixe.requestFocus();
           return false;
        }
        return true;
   }
    private void filltable(){
            DefaultTableModel model = (DefaultTableModel) tblXeThue.getModel();
            model.setRowCount(0);
            try {
                List<Xe> list= dao.selectAll();
                for(Xe xe : list){
                    Object[] row = {xe.getMaxe(),
                                    xe.getTenxe(),
                                    xe.getSoghe(),
                                    xe.getGiathue(),
                                    xe.getMaloaixe(),
                    };
                    model.addRow(row);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                DialogHelper.alert(this, "Lỗi Truy Vấn");
            }
        }
       
    void setForm(Xe ex){
        txt_maxe.setText(ex.getMaxe());
        txt_tenxe.setText(ex.getTenxe());
        txt_soghe.setText(String.valueOf(ex.getSoghe()));
        txt_giathue.setText(String.valueOf(ex.getGiathue()));
        txt_maloaixe.setText(ex.getMaloaixe());
        txt_noidung.setText(ex.getGhichu());
        setimg(ex.getAnhxe());
    }
    
    Xe getForm(){
        Xe xe = new Xe();
        xe.setAnhxe(anhxe);
        xe.setMaxe(txt_maxe.getText());
        xe.setTenxe(txt_tenxe.getText());
        xe.setSoghe(Integer.valueOf(txt_soghe.getText()));
        xe.setGiathue(Float.valueOf(txt_giathue.getText()));
        xe.setMaloaixe(txt_maloaixe.getText());
        xe.setGhichu(txt_noidung.getText());
        return xe;
    }
    
    void insert(){
        Xe xe = getForm();
        if(xe != null){
        try {
            dao.insert(xe);
            this.filltable();
            this.clearForm();
            DialogHelper.alert(this, "Thêm mới thành công !");
        }catch (Exception e) {
            DialogHelper.alert(this, "Thêm mới thất bại !");
            e.printStackTrace();
            }
        }else{
            return;
        }
    }
    
    void edit(){
        String Maxe = (String) tblXeThue.getValueAt(this.row,0);
        System.out.println(Maxe);
        Xe xe = dao.selectByID(Maxe);
        this.setForm(xe);
    }
    
    void delete(){
         String Maxe = txt_maxe.getText();
         if(DialogHelper.confirm(this, "Bạn muốn xóa dịch vụ này!")){
             try {
                 dao.delete(Maxe);
                 this.filltable();
                 this.clearForm();
                 System.out.println(anhxe);
                 Hepler.ImagesHelper.deleteImg(writeurl,anhxe);
                 DialogHelper.alert(this, "bạn xóa thành công");
             } catch (Exception e) {
                 DialogHelper.alert(this, "Xóa thất bại");
             }
         }
     }
    
    void clearForm(){
        Xe xe = new Xe();
        this.setForm(xe);
        this.row = -1;
    }

    void update(){
         Xe xe = getForm();
         if(xe != null){
             try {
                 dao.update(xe);
                 this.filltable();
                 DialogHelper.alert(this, "Cập nhật thành công");
             } catch (Exception e) {
                 DialogHelper.alert(this,"Cập nhật thất bại");
                 e.printStackTrace();
             }
         
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXeThue = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_maxe = new javax.swing.JTextField();
        txt_tenxe = new javax.swing.JTextField();
        txt_soghe = new javax.swing.JTextField();
        txt_giathue = new javax.swing.JTextField();
        txt_maloaixe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pnl_control = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        pnl_anh = new javax.swing.JPanel();
        lbl_anh = new javax.swing.JLabel();
        btn_chonanh = new javax.swing.JButton();
        pnlchucnang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_noidung = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 102, 51));

        jPanel1.setMinimumSize(new java.awt.Dimension(986, 681));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblXeThue.setBackground(new java.awt.Color(255, 102, 51));
        tblXeThue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ XE", "TÊN XE", "SỐ GHẾ", "GIÁ THUÊ", "MÃ LOẠI XE"
            }
        ));
        tblXeThue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblXeThueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblXeThue);

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MÃ XE");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TÊN XE");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SỐ GHẾ");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GIÁ THUÊ");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MÃ LOẠI XE");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GHI CHÚ");

        txt_maxe.setPreferredSize(new java.awt.Dimension(64, 30));

        txt_tenxe.setPreferredSize(new java.awt.Dimension(64, 30));
        txt_tenxe.setRequestFocusEnabled(false);

        txt_soghe.setPreferredSize(new java.awt.Dimension(64, 30));

        txt_giathue.setPreferredSize(new java.awt.Dimension(64, 30));

        txt_maloaixe.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("THÔNG TIN XE THUÊ");

        pnl_control.setBackground(new java.awt.Color(255, 102, 51));

        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst.setForeground(new java.awt.Color(255, 102, 51));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        pnl_control.add(btnFirst);

        btnPre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPre.setForeground(new java.awt.Color(255, 102, 51));
        btnPre.setText("<<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        pnl_control.add(btnPre);

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 102, 51));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnl_control.add(btnNext);

        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast.setForeground(new java.awt.Color(255, 102, 51));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        pnl_control.add(btnLast);

        pnl_anh.setBackground(new java.awt.Color(255, 102, 51));
        pnl_anh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_anh.setPreferredSize(new java.awt.Dimension(120, 120));

        lbl_anh.setBackground(new java.awt.Color(255, 255, 255));
        lbl_anh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_anh.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_anhLayout = new javax.swing.GroupLayout(pnl_anh);
        pnl_anh.setLayout(pnl_anhLayout);
        pnl_anhLayout.setHorizontalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        pnl_anhLayout.setVerticalGroup(
            pnl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        btn_chonanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_chonanh.setForeground(new java.awt.Color(255, 102, 51));
        btn_chonanh.setText("ẢNH");
        btn_chonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonanhActionPerformed(evt);
            }
        });

        pnlchucnang.setOpaque(false);
        pnlchucnang.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 20));

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 102, 51));
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlchucnang.add(btnThem);

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMoi.setForeground(new java.awt.Color(255, 102, 51));
        btnMoi.setText("MỚI");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        pnlchucnang.add(btnMoi);

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 102, 51));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlchucnang.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 102, 51));
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlchucnang.add(btnXoa);

        txt_noidung.setColumns(20);
        txt_noidung.setRows(5);
        jScrollPane2.setViewportView(txt_noidung);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(177, 177, 177))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_chonanh))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnl_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_maloaixe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_giathue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_soghe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tenxe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_maxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(pnlchucnang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_maxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_tenxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_giathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_maloaixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_chonanh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlchucnang, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        row=0;
        edit();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        if (row>0){
            row--;
            edit();
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if(row<tblXeThue.getRowCount() -1){
            row++;
            edit();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        row = tblXeThue.getRowCount() -1;
        System.out.println(row);
        edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btn_chonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonanhActionPerformed
        // TODO add your handling code here:
        anhxe = Hepler.ImagesHelper.chonAnh();
        Hepler.ImagesHelper.convertImgTo280x180(readurl,anhxe,writeurl);
        setimg(anhxe);
    }//GEN-LAST:event_btn_chonanhActionPerformed

    private void tblXeThueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblXeThueMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            this.row = tblXeThue.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblXeThueMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_chonanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JPanel pnl_anh;
    private javax.swing.JPanel pnl_control;
    private javax.swing.JPanel pnlchucnang;
    private javax.swing.JTable tblXeThue;
    private javax.swing.JTextField txt_giathue;
    private javax.swing.JTextField txt_maloaixe;
    private javax.swing.JTextField txt_maxe;
    private javax.swing.JTextArea txt_noidung;
    private javax.swing.JTextField txt_soghe;
    private javax.swing.JTextField txt_tenxe;
    // End of variables declaration//GEN-END:variables
}