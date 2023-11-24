/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.ChiTietTaiKhoanDAO;
import DAO.NapCardDAO;
import DAO.TaiKhoanDAO;
import Hepler.DialogHelper;
import entyti.ChiTietTaiKhoan;
import entyti.DanhGia;
import entyti.NapCard;
import entyti.TaiKhoan;
import entyti.Voucher;
import entyti.Xe;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu
 */
public class cardTaiKhoan_QuanLy extends javax.swing.JPanel {
    ChiTietTaiKhoanDAO cttkd = new ChiTietTaiKhoanDAO();
    TaiKhoanDAO tkd = new TaiKhoanDAO();
    String userid = null;
    NapCardDAO  ndao = new NapCardDAO();
    /**
     * Creates new form cardTaiKhoan_QuanLy
     */
    public cardTaiKhoan_QuanLy() {
        initComponents();
        filltableTaiKhoan();
        filltableNapCard();
    }
    public void setImg(String anhdaidien, String banglai) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhdaidien, "src\\imganhdaidien\\" + anhdaidien);
        Hepler.ImagesHelper.setIconlabel(lbl_anhbanglai, "src\\imgbanglai\\" + banglai);
    }
    private void filltableTaiKhoan() {
        DefaultTableModel model = (DefaultTableModel) tbl_taikhoan.getModel();
        model.setRowCount(0);
        try {
            List<ChiTietTaiKhoan> list = cttkd.selectByKey("True");
            for (ChiTietTaiKhoan cttk : list) {
                Object[] row = {
                    cttk.getUserid(),
                    cttk.getHoten(),
                    cttk.getAnhdaidien(),
                    cttk.getCccd(),
                    cttk.getBanglaixe(),
                    cttk.getSdt(),
                    cttk.getNgaysinh(),
                    cttk.isGioitinh(),
                    cttk.getDiachi(),
                    cttk.getSodu()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Loi Try van");
        }
    }
    void setForm(ChiTietTaiKhoan cttk){
        String trangthai = null;
        TaiKhoan tk = tkd.selectByID_1(String.valueOf(cttk.getUserid()));
        txt_hoten.setText(cttk.getHoten());
        txt_cancuoc.setText(cttk.getCccd());
        txt_sodienthoai.setText(cttk.getSdt());
        txt_email.setText(tk.getEmail());
        if (tk.isTrangthai()) {
            trangthai = "Đã Xác Thực ";
        } else {
            trangthai = "Chưa Xác Thực ";
        }
        lbl_trangthaithaikhoan.setText("Trạng Thái :" + trangthai);
        setImg(cttk.getAnhdaidien(), cttk.getBanglaixe());
    }
    int row = -1;
    void edit(){
        userid =  String.valueOf(tbl_taikhoan.getValueAt(this.row,0));
        ChiTietTaiKhoan cttk = cttkd.selectByID(userid);
        this.setForm(cttk);
    }
    void update() {
        TaiKhoan tk = new TaiKhoan();
        tk.setTrangthai(true);
        tk.setUserid(Integer.parseInt(userid));
            try {
                tkd.update_1(tk);
                filltableTaiKhoan();
                DialogHelper.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
                e.printStackTrace();
            }
    }
    public void sendemailverifly(String email){
        Hepler.Email.sendEmail(email, "Yêu Cầu Xác Thực Tài Khoản", "Tài Khoản Của Bạn Chưa Đủ Điều Kiện Xác Thực, Vui Lòng Cập Nhật Lại Thông Tin Để Tiến Hành Xác Thực Tài Khoản", null);
    }
    
    
    
    
    
    
    
    
     private void filltableNapCard() {
        DefaultTableModel model = (DefaultTableModel) tblmanap.getModel();
        model.setRowCount(0);
        try {
            List<NapCard> list = ndao.selectAll();
            for (NapCard nc : list) {
                Object[] row = {nc.getManap(),
                    nc.getNoidung(),
                    nc.getGiatri(),
                    nc.isTrangthai()

                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Loi Try van");
        }
    }

    void setFromNapcard(NapCard nc) {
        txtMaNap.setText(nc.getManap());
        TxtNoiDung.setText(nc.getNoidung());
        txtGiaTri.setText(String.valueOf(nc.getGiatri()));
        if(!nc.isTrangthai()){
            rdochuanap.setSelected(true);
        }else{
            rdodanap.setSelected(true);
        }

    }

    void clearFromnapcard() {
        NapCard nc = new NapCard();
        this.setFromNapcard(nc);
        this.row = -1;
    }

    NapCard getFromNapcard() {
        
        NapCard nc = new NapCard();
        nc.setManap(txtMaNap.getText());
        nc.setNoidung(TxtNoiDung.getText());
        nc.setGiatri(Integer.parseInt(txtGiaTri.getText()));
        nc.setTrangthai(rdochuanap.isSelected());
        return nc;
    }

    void editNapcard() {
        String maNC = (String) tblmanap.getValueAt(this.row, 0);
        NapCard nc = ndao.selectByID(maNC);
        this.setFromNapcard(nc);
    }

    void insertNapCard() {
        NapCard nc = getFromNapcard();
        if (nc != null) {
            try {
                ndao.insert(nc);
                this.filltableNapCard();
                this.clearFromnapcard();
                DialogHelper.alert(this, "Thêm  mới thành công !");
            } catch (Exception e) {
                DialogHelper.alert(this, "Thêm mới thất bại !");
                e.printStackTrace();
            }

        } else {
            return;
        }
      
        filltableNapCard();
    }

    
        

    void deleteNapCard() {
        String manc = txtMaNap.getText();
        if (DialogHelper.confirm(this, "Bạn muốn xóa Voucher này!")) {
            try {
                ndao.delete(manc);
                this.filltableNapCard();
                this.clearFromnapcard();
                DialogHelper.alert(this, "bạn xóa thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại");
            }
        }
        filltableNapCard();
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        trangthai = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnl_taikhoan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_taikhoan = new javax.swing.JTable();
        pnl_anhbanglai = new javax.swing.JPanel();
        lbl_anhbanglai = new javax.swing.JLabel();
        lbl_hovaten = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        lbl_cancuoc = new javax.swing.JLabel();
        txt_cancuoc = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        pnl_anhdaidien = new javax.swing.JPanel();
        lbl_anhdaidien = new javax.swing.JLabel();
        lbl_sodienthoai = new javax.swing.JLabel();
        txt_sodienthoai = new javax.swing.JTextField();
        btn_guiemail = new javax.swing.JButton();
        btn_xacthuc = new javax.swing.JButton();
        lbl_trangthaithaikhoan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblmanap = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtNoiDung = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rdochuanap = new javax.swing.JRadioButton();
        rdodanap = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 102, 51));
        setPreferredSize(new java.awt.Dimension(985, 660));

        pnl_taikhoan.setOpaque(false);

        jScrollPane1.setOpaque(false);

        tbl_taikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Họ Tên", "AnhDaiDien", "CCCD", "BangLaiXe", "SDT", "NgaySinh", "GioiTinh", "DiaChi", "SoDu"
            }
        ));
        tbl_taikhoan.setOpaque(false);
        tbl_taikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_taikhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_taikhoan);

        pnl_anhbanglai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Bằng Lái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_anhbanglai.setForeground(new java.awt.Color(255, 255, 255));
        pnl_anhbanglai.setOpaque(false);
        pnl_anhbanglai.setPreferredSize(new java.awt.Dimension(400, 200));

        lbl_anhbanglai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_anhbanglai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anhbanglai.setPreferredSize(new java.awt.Dimension(300, 200));

        javax.swing.GroupLayout pnl_anhbanglaiLayout = new javax.swing.GroupLayout(pnl_anhbanglai);
        pnl_anhbanglai.setLayout(pnl_anhbanglaiLayout);
        pnl_anhbanglaiLayout.setHorizontalGroup(
            pnl_anhbanglaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_anhbanglaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_anhbanglaiLayout.setVerticalGroup(
            pnl_anhbanglaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhbanglaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lbl_hovaten.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_hovaten.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hovaten.setText("Họ Và Tên");

        txt_hoten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_cancuoc.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_cancuoc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancuoc.setText("Căn Cước");

        txt_cancuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_email.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("Email");

        pnl_anhdaidien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Đại Diện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_anhdaidien.setForeground(new java.awt.Color(255, 255, 255));
        pnl_anhdaidien.setOpaque(false);

        lbl_anhdaidien.setForeground(new java.awt.Color(255, 255, 255));
        lbl_anhdaidien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anhdaidien.setPreferredSize(new java.awt.Dimension(110, 164));

        javax.swing.GroupLayout pnl_anhdaidienLayout = new javax.swing.GroupLayout(pnl_anhdaidien);
        pnl_anhdaidien.setLayout(pnl_anhdaidienLayout);
        pnl_anhdaidienLayout.setHorizontalGroup(
            pnl_anhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_anhdaidienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhdaidien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_anhdaidienLayout.setVerticalGroup(
            pnl_anhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_anhdaidienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhdaidien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbl_sodienthoai.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_sodienthoai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sodienthoai.setText("Số Điện Thoại");

        txt_sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_guiemail.setText("Gửi Email Yêu Cầu Xác Thực");
        btn_guiemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guiemailActionPerformed(evt);
            }
        });

        btn_xacthuc.setText("Xác Thực Tài Khoản");
        btn_xacthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacthucActionPerformed(evt);
            }
        });

        lbl_trangthaithaikhoan.setBackground(new java.awt.Color(255, 102, 51));
        lbl_trangthaithaikhoan.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_trangthaithaikhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_trangthaithaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_trangthaithaikhoan.setText("Trạng Thái :");
        lbl_trangthaithaikhoan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnl_taikhoanLayout = new javax.swing.GroupLayout(pnl_taikhoan);
        pnl_taikhoan.setLayout(pnl_taikhoanLayout);
        pnl_taikhoanLayout.setHorizontalGroup(
            pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                        .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_hovaten)
                            .addComponent(lbl_cancuoc)
                            .addComponent(lbl_email)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(txt_cancuoc)
                            .addComponent(txt_email)
                            .addComponent(lbl_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sodienthoai)))
                    .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                        .addComponent(btn_guiemail)
                        .addGap(161, 161, 161)
                        .addComponent(lbl_trangthaithaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_anhdaidien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xacthuc))
                .addGap(201, 201, 201))
        );
        pnl_taikhoanLayout.setVerticalGroup(
            pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                        .addComponent(lbl_hovaten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cancuoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cancuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_sodienthoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnl_anhdaidien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_guiemail)
                            .addComponent(btn_xacthuc))
                        .addGap(31, 31, 31))
                    .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_trangthaithaikhoan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Tài Khoản", pnl_taikhoan);

        jPanel3.setOpaque(false);

        tblmanap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MÃ NẠP TIỀN", "NỘI DUNG", "GIÁ TRỊ", "TRẠNG THÁI"
            }
        ));
        tblmanap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmanapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblmanapMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblmanap);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("Thẻ nạp");

        jLabel3.setText("Mã nạp tiền:");

        txtMaNap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNapActionPerformed(evt);
            }
        });

        jLabel4.setText("Nội dung:");

        TxtNoiDung.setColumns(20);
        TxtNoiDung.setRows(5);
        jScrollPane3.setViewportView(TxtNoiDung);

        jLabel5.setText("Giá trị:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng thái"));
        jPanel1.setLayout(new java.awt.GridLayout());

        trangthai.add(rdochuanap);
        rdochuanap.setText("Chưa nạp");
        jPanel1.add(rdochuanap);

        trangthai.add(rdodanap);
        rdodanap.setText("Đã Nạp");
        rdodanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdodanapActionPerformed(evt);
            }
        });
        jPanel1.add(rdodanap);

        jPanel4.setLayout(new java.awt.GridLayout());

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel4.add(btnThem);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoa);

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        jPanel4.add(btnMoi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(txtMaNap)
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(txtGiaTri))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaNap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mã Nạp", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_taikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_taikhoanMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            this.row = tbl_taikhoan.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tbl_taikhoanMouseClicked

    private void btn_xacthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacthucActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_xacthucActionPerformed

    private void btn_guiemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guiemailActionPerformed
        // TODO add your handling code here:
        sendemailverifly(txt_email.getText());
    }//GEN-LAST:event_btn_guiemailActionPerformed

    private void txtMaNapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNapActionPerformed

    private void rdodanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdodanapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdodanapActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       insertNapCard();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       deleteNapCard();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearFromnapcard();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblmanapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmanapMousePressed
        if (evt.getClickCount() == 2) {
            this.row = tblmanap.getSelectedRow();
            this.editNapcard();
        }
    }//GEN-LAST:event_tblmanapMousePressed

    private void tblmanapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmanapMouseClicked
      
    }//GEN-LAST:event_tblmanapMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtNoiDung;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_guiemail;
    private javax.swing.JButton btn_xacthuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_anhbanglai;
    private javax.swing.JLabel lbl_anhdaidien;
    private javax.swing.JLabel lbl_cancuoc;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_hovaten;
    private javax.swing.JLabel lbl_sodienthoai;
    private javax.swing.JLabel lbl_trangthaithaikhoan;
    private javax.swing.JPanel pnl_anhbanglai;
    private javax.swing.JPanel pnl_anhdaidien;
    private javax.swing.JPanel pnl_taikhoan;
    private javax.swing.JRadioButton rdochuanap;
    private javax.swing.JRadioButton rdodanap;
    private javax.swing.JTable tbl_taikhoan;
    private javax.swing.JTable tblmanap;
    private javax.swing.ButtonGroup trangthai;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMaNap;
    private javax.swing.JTextField txt_cancuoc;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_sodienthoai;
    // End of variables declaration//GEN-END:variables
}
