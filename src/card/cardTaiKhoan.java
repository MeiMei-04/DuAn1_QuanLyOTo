/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.ChiTietTaiKhoanDAO;
import DAO.TaiKhoanDAO;
import Hepler.DateHelper;
import Hepler.DialogHelper;
import Hepler.ImagesHelper;
import entyti.ChiTietTaiKhoan;
import entyti.TaiKhoan;
import form.DoiMatKhauDialog;
import form.NapTheCaoDialog;
import java.io.File;
import org.bridj.util.Pair;

/**
 *
 * @author hieud
 */
public class cardTaiKhoan extends javax.swing.JPanel {

    private NapTheCaoDialog napcardDialog;
    TaiKhoanDAO tkd = new TaiKhoanDAO();
    ChiTietTaiKhoanDAO cttkdao = new ChiTietTaiKhoanDAO();
    String selectedFilePath_anhdaidien = null;
    String selectedFileName_anhdaidien = null;
    String selectedFilePath_banglai = null;
    String selectedFileName_banglai = null;
    private static final String writeurl_banglai = "src/imgbanglai/";
    private static final String writeurl_anhdaidien = "src/imganhdaidien/";

    /**
     * Creates new form TaiKhoan
     */
    public cardTaiKhoan() {
        initComponents();
        setForm();
    }

    public void setImg(String anhdaidien, String banglai) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhdaidien, "src\\imganhdaidien\\" + anhdaidien);
        Hepler.ImagesHelper.setIconlabel(lbl_anhbanglai, "src\\imgbanglai\\" + banglai);
    }

    ChiTietTaiKhoan getForm() {
        ChiTietTaiKhoan cttk = new ChiTietTaiKhoan();
        TaiKhoan tk = Hepler.AuthHelper.user;
        cttk.setUserid(tk.getUserid());
        cttk.setHoten(txt_hoten.getText());
        cttk.setNgaysinh(DateHelper.toDate(txt_ngaysinh.getText(), "dd/MM/yyyy"));
        cttk.setSdt(txt_sodienthoai.getText());
        cttk.setCccd(txt_cancuoc.getText());
        cttk.setDiachi(txt_diachi.getText());
        cttk.setAnhdaidien(selectedFileName_anhdaidien);
        cttk.setBanglaixe(selectedFileName_banglai);
        if (rdo_nu.isSelected()) {
            cttk.setGioitinh(true);
        } else {
            cttk.setGioitinh(false);
        }
        cttk.setYeucauxacthuc(true);
        return cttk;
    }

    public void setForm() {
        String trangthai = null;
        TaiKhoan tk = Hepler.AuthHelper.user;
        lbl_userid.setText("USERID: " + String.valueOf(tk.getUserid()));
        txt_email.setText(tk.getEmail());
        if (tk.isTrangthai()) {
            trangthai = "Đã Xác Thực ";
        } else {
            trangthai = "Chưa Xác Thực ";
        }
        lbl_trangthaithaikhoan.setText("Trạng Thái :" + trangthai);
        try {
            ChiTietTaiKhoan cttk = cttkdao.selectByID_DOITUONG(String.valueOf(tk.getUserid()));
            txt_hoten.setText(cttk.getHoten());
            txt_ngaysinh.setText(DateHelper.toString(cttk.getNgaysinh(), "dd/MM/yyyy"));
            txt_sodienthoai.setText(cttk.getSdt());
            txt_cancuoc.setText(cttk.getCccd());
            txt_diachi.setText(cttk.getDiachi());
            if (cttk.isGioitinh()) {
                rdo_nu.setSelected(true);
            } else {
                rdo_nam.setSelected(true);
            }
            selectedFileName_anhdaidien = cttk.getAnhdaidien();
            selectedFileName_banglai = cttk.getBanglaixe();
            setImg(selectedFileName_anhdaidien, selectedFileName_banglai);
            lbl_sodu.setText("Số Dư: " + String.valueOf(cttk.getSodu()));
        } catch (Exception e) {
        }
    }

    public void insert() {
        ChiTietTaiKhoan cttk = getForm();
        if (cttk != null) {
            try {
                cttkdao.insert(cttk);
                DialogHelper.alert(this, "Thêm thông tin thành công !!!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                update();
            }
        }
    }

    public void update() {
        ChiTietTaiKhoan cttk = getForm();
        if (cttk != null) {
            try {
                cttkdao.update(cttk);
                DialogHelper.alert(this, "Cập nhật thông tin thành công !!!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thông tin thất bại !!!");
                e.printStackTrace();
            }
        }
    }

    public boolean verify() {
        if (txt_hoten.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập họ tên");
            txt_hoten.requestFocus();
            return false;
        }
        if (txt_ngaysinh.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập ngày sinh");
            txt_ngaysinh.requestFocus();
            return false;
        }
        if (!Hepler.Validate.isValidDate(txt_ngaysinh.getText())) {
            DialogHelper.alert(this, "Vui lòng nhập đúng định dạng dd/mm/yyyy");
            txt_ngaysinh.requestFocus();
            return false;
        }
        if (txt_cancuoc.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập số CCCD");
            txt_cancuoc.requestFocus();
            return false;
        }
        if (txt_sodienthoai.getText().length() > 12) {
            DialogHelper.alert(this, "Số CCCD không được quá 12 kí tự");
            txt_sodienthoai.requestFocus();
            return false;
        }
        if (txt_email.getText().equals("")) {
            DialogHelper.alert(this, "Email không được để trống");
            txt_email.requestFocus();
            return false;
        }
        if (txt_diachi.getText().equals("")) {
            DialogHelper.alert(this, "Địa chỉ không được để trống");
            txt_diachi.requestFocus();
            return false;
        }
        if (txt_sodienthoai.getText().equals("")) {
            DialogHelper.alert(this, "Số điện thoại không được để trống");
            txt_sodienthoai.requestFocus();
            return false;
        }
        if (txt_sodienthoai.getText().length() > 10) {
            DialogHelper.alert(this, "Số điện thoại không được quá 10 kí tự");
            txt_sodienthoai.requestFocus();
            return false;
        }
        if (selectedFileName_anhdaidien == null) {
            DialogHelper.alert(this, "Vui lòng thêm ảnh đại diện");
            return false;
        }
        if (selectedFileName_banglai == null) {
            DialogHelper.alert(this, "Vui lòng thêm ảnh đại diện");
            return false;
        }
        return true;
    }

    public void openDoiMatKhau() {
        try {
            new DoiMatKhauDialog(null, true).setVisible(true);
        } catch (Exception e) {
        }
    }

    public void openNapCard() {
        try {
            TaiKhoan tk = Hepler.AuthHelper.user;
            if (tk.isTrangthai()) {
                napcardDialog = new NapTheCaoDialog(null, true);
                napcardDialog.setVisible(true);
                if (!napcardDialog.isVisible()) {
                    setForm();
                }
            } else {
                DialogHelper.alert(this, "Vui Lòng Xác Thực Tài Khoản");
            }
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

        btngr_gioitinh = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        pnl_taikhoan = new javax.swing.JPanel();
        lbl_trangthaithaikhoan = new javax.swing.JLabel();
        lbl_userid = new javax.swing.JLabel();
        pnl_anhbanglai = new javax.swing.JPanel();
        lbl_anhbanglai = new javax.swing.JLabel();
        pnl_anhdaidien = new javax.swing.JPanel();
        lbl_anhdaidien = new javax.swing.JLabel();
        lbl_capnhatthongtin = new javax.swing.JLabel();
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
        lbl_ngaysinh = new javax.swing.JLabel();
        txt_ngaysinh = new javax.swing.JTextField();
        lbl_hovaten = new javax.swing.JLabel();
        lbl_sodu = new javax.swing.JLabel();
        btn_napsodu = new javax.swing.JButton();
        btn_doimatkhau = new javax.swing.JButton();
        pnl_xecuatoi = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_mahopdong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hopdong = new javax.swing.JTable();
        txt_hangxe = new javax.swing.JTextField();
        txt_maxe = new javax.swing.JTextField();
        txt_tenxe = new javax.swing.JTextField();
        txt_soghe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_giathue = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_trangthaixe = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txt_ngaythue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_dichvu = new javax.swing.JTable();
        txt_ngayhethan = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_phuphi = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_voucher = new javax.swing.JTextField();
        txt_giatri = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_tongtien = new javax.swing.JTextField();
        btn_cuoi = new javax.swing.JButton();
        btn_sau = new javax.swing.JButton();
        btn_truoc = new javax.swing.JButton();
        btn_dau = new javax.swing.JButton();
        btn_traxe = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(985, 660));

        pnl_taikhoan.setBackground(new java.awt.Color(255, 102, 51));
        pnl_taikhoan.setPreferredSize(new java.awt.Dimension(985, 660));

        lbl_trangthaithaikhoan.setBackground(new java.awt.Color(255, 102, 51));
        lbl_trangthaithaikhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_trangthaithaikhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_trangthaithaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_trangthaithaikhoan.setText("TRẠNG THÁI:");
        lbl_trangthaithaikhoan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_userid.setBackground(new java.awt.Color(255, 102, 51));
        lbl_userid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_userid.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userid.setText("USERID:");

        pnl_anhbanglai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ẢNH BẰNG LÁI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_anhbanglai.setForeground(new java.awt.Color(255, 255, 255));
        pnl_anhbanglai.setOpaque(false);
        pnl_anhbanglai.setPreferredSize(new java.awt.Dimension(400, 200));

        lbl_anhbanglai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_anhbanglai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anhbanglai.setPreferredSize(new java.awt.Dimension(300, 200));
        lbl_anhbanglai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhbanglaiMouseClicked(evt);
            }
        });

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

        pnl_anhdaidien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ẢNH ĐẠI DIỆN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_anhdaidien.setForeground(new java.awt.Color(255, 255, 255));
        pnl_anhdaidien.setOpaque(false);

        lbl_anhdaidien.setForeground(new java.awt.Color(255, 255, 255));
        lbl_anhdaidien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anhdaidien.setPreferredSize(new java.awt.Dimension(110, 164));
        lbl_anhdaidien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhdaidienMouseClicked(evt);
            }
        });

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

        lbl_capnhatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_capnhatthongtin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_capnhatthongtin.setText("CẬP NHẬP THÔNG TIN");

        txt_hoten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email.setEnabled(false);

        lbl_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("ĐỊA CHỈ EMAIL");

        txt_sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_sodienthoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_sodienthoai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sodienthoai.setText("SỐ ĐIỆN THOẠI");

        txt_cancuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_cancuoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cancuoc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancuoc.setText("CĂN CƯỚC CÔNG DÂN");

        pnl_gioitinh.setBackground(new java.awt.Color(255, 102, 51));
        pnl_gioitinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GIỚI TÍNH", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_gioitinh.setForeground(new java.awt.Color(255, 255, 255));

        rdo_nu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdo_nu.setForeground(new java.awt.Color(255, 255, 255));
        rdo_nu.setText("NỮ");

        rdo_nam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdo_nam.setForeground(new java.awt.Color(255, 255, 255));
        rdo_nam.setText("NAM");

        javax.swing.GroupLayout pnl_gioitinhLayout = new javax.swing.GroupLayout(pnl_gioitinh);
        pnl_gioitinh.setLayout(pnl_gioitinhLayout);
        pnl_gioitinhLayout.setHorizontalGroup(
            pnl_gioitinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gioitinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdo_nu, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(rdo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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

        lbl_diachi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_diachi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_diachi.setText("ĐỊA CHỈ");

        txt_diachi.setColumns(20);
        txt_diachi.setRows(5);
        jScrollPane1.setViewportView(txt_diachi);

        btn_capnhatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_capnhatthongtin.setForeground(new java.awt.Color(255, 102, 51));
        btn_capnhatthongtin.setText("CẬP NHẬP THÔNG TIN");
        btn_capnhatthongtin.setFocusPainted(false);
        btn_capnhatthongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatthongtinActionPerformed(evt);
            }
        });

        lbl_ngaysinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ngaysinh.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ngaysinh.setText("NGÀY SINH");

        txt_ngaysinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_hovaten.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_hovaten.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hovaten.setText("HỌ VÀ TÊN");

        lbl_sodu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_sodu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sodu.setText("SỐ DƯ:");

        btn_napsodu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_napsodu.setForeground(new java.awt.Color(255, 102, 51));
        btn_napsodu.setText("NẠP SỐ DƯ");
        btn_napsodu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_napsoduActionPerformed(evt);
            }
        });

        btn_doimatkhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_doimatkhau.setForeground(new java.awt.Color(255, 102, 51));
        btn_doimatkhau.setText("ĐỔI MẬT KHẨU");
        btn_doimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doimatkhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_taikhoanLayout = new javax.swing.GroupLayout(pnl_taikhoan);
        pnl_taikhoan.setLayout(pnl_taikhoanLayout);
        pnl_taikhoanLayout.setHorizontalGroup(
            pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(lbl_capnhatthongtin)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_taikhoanLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_anhdaidien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_userid))
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_cancuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_cancuoc))
                            .addComponent(btn_capnhatthongtin)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_taikhoanLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btn_napsodu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_doimatkhau))
                            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_hovaten)
                                    .addComponent(txt_hoten)
                                    .addComponent(lbl_ngaysinh)
                                    .addComponent(lbl_email)
                                    .addComponent(txt_email)
                                    .addComponent(pnl_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_diachi)
                                    .addComponent(jScrollPane1)
                                    .addComponent(lbl_trangthaithaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_sodienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                    .addComponent(lbl_sodu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_sodienthoai))))))
                .addGap(115, 115, 115))
        );
        pnl_taikhoanLayout.setVerticalGroup(
            pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_capnhatthongtin)
                .addGap(47, 47, 47)
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_userid)
                    .addComponent(lbl_trangthaithaikhoan)
                    .addComponent(lbl_sodu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_hovaten)
                            .addComponent(lbl_sodienthoai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_ngaysinh)
                            .addComponent(lbl_cancuoc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cancuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                                .addComponent(lbl_email)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnl_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_diachi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_napsodu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                                .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_capnhatthongtin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_doimatkhau))))
                    .addComponent(pnl_anhdaidien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        tabs.addTab("Tài Khoản", pnl_taikhoan);

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("XE CỦA TÔI");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã Hợp Đồng :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hãng Xe :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã Xe :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên Xe :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Số Ghế :");

        tbl_hopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hợp Đồng", "Mã Xe", "Ngày Thuê", "Ngày Trả", "Tình Trạng"
            }
        ));
        jScrollPane2.setViewportView(tbl_hopdong);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Giá Thuê :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Trạng Thái Xe :");

        txt_trangthaixe.setColumns(20);
        txt_trangthaixe.setRows(5);
        jScrollPane3.setViewportView(txt_trangthaixe);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ngày Thuê :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ngày Hết Hạn :");

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tbl_dichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Dịch Vụ", "Giá"
            }
        ));
        jScrollPane4.setViewportView(tbl_dichvu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phụ Phí", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tbl_phuphi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Phụ Phí", "Giá Trị"
            }
        ));
        jScrollPane5.setViewportView(tbl_phuphi);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mã Giảm Giá :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Discount :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tổng Tiền :");

        btn_cuoi.setForeground(new java.awt.Color(255, 102, 51));
        btn_cuoi.setText(">|");

        btn_sau.setForeground(new java.awt.Color(255, 102, 51));
        btn_sau.setText(">>");

        btn_truoc.setForeground(new java.awt.Color(255, 102, 51));
        btn_truoc.setText("<<");

        btn_dau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_dau.setForeground(new java.awt.Color(255, 102, 51));
        btn_dau.setText("|<");

        btn_traxe.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_traxe.setForeground(new java.awt.Color(255, 102, 51));
        btn_traxe.setText("Trả Xe");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txt_tenxe))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txt_maxe))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txt_hangxe))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txt_mahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_soghe)
                                                    .addComponent(txt_giathue)
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_ngaythue, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_ngayhethan, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_giatri, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(428, 428, 428)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_dau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_truoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_traxe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_sau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cuoi)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                            .addComponent(txt_mahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_hangxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_maxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_tenxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_giathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_ngaythue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_ngayhethan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_giatri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cuoi)
                    .addComponent(btn_sau)
                    .addComponent(btn_truoc)
                    .addComponent(btn_dau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_traxe)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_xecuatoiLayout = new javax.swing.GroupLayout(pnl_xecuatoi);
        pnl_xecuatoi.setLayout(pnl_xecuatoiLayout);
        pnl_xecuatoiLayout.setHorizontalGroup(
            pnl_xecuatoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_xecuatoiLayout.setVerticalGroup(
            pnl_xecuatoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabs.addTab("Xe Của Tôi", pnl_xecuatoi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_anhbanglaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhbanglaiMouseClicked
        ImagesHelper.Pair<String, String> banglai = Hepler.ImagesHelper.chonAnh();
        if (banglai != null) {
            selectedFilePath_banglai = banglai.getFirst();
            selectedFileName_banglai = banglai.getSecond();
        } else {
            DialogHelper.alert(this, "Lỗi Chọn Ảnh");
        }
        Hepler.ImagesHelper.convertImgTo280x180(selectedFilePath_banglai, selectedFileName_banglai, writeurl_banglai);
        setImg(selectedFileName_anhdaidien, selectedFileName_banglai);
    }//GEN-LAST:event_lbl_anhbanglaiMouseClicked

    private void lbl_anhdaidienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhdaidienMouseClicked
        ImagesHelper.Pair<String, String> anhdaidien = Hepler.ImagesHelper.chonAnh();
        if (anhdaidien != null) {
            selectedFilePath_anhdaidien = anhdaidien.getFirst();
            selectedFileName_anhdaidien = anhdaidien.getSecond();
        } else {
            DialogHelper.alert(this, "Lỗi Chọn Ảnh");
        }
        Hepler.ImagesHelper.convertImgTo110x164(selectedFilePath_anhdaidien, selectedFileName_anhdaidien, writeurl_anhdaidien);
        setImg(selectedFileName_anhdaidien, selectedFileName_banglai);
    }//GEN-LAST:event_lbl_anhdaidienMouseClicked

    private void btn_capnhatthongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatthongtinActionPerformed

        insert();
    }//GEN-LAST:event_btn_capnhatthongtinActionPerformed

    private void btn_napsoduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_napsoduActionPerformed
        // TODO add your handling code here:
        openNapCard();
    }//GEN-LAST:event_btn_napsoduActionPerformed

    private void btn_doimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doimatkhauActionPerformed
        // TODO add your handling code here:
        openDoiMatKhau();
    }//GEN-LAST:event_btn_doimatkhauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhatthongtin;
    private javax.swing.JButton btn_cuoi;
    private javax.swing.JButton btn_dau;
    private javax.swing.JButton btn_doimatkhau;
    private javax.swing.JButton btn_napsodu;
    private javax.swing.JButton btn_sau;
    private javax.swing.JButton btn_traxe;
    private javax.swing.JButton btn_truoc;
    private javax.swing.ButtonGroup btngr_gioitinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_anhbanglai;
    private javax.swing.JLabel lbl_anhdaidien;
    private javax.swing.JLabel lbl_cancuoc;
    private javax.swing.JLabel lbl_capnhatthongtin;
    private javax.swing.JLabel lbl_diachi;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_hovaten;
    private javax.swing.JLabel lbl_ngaysinh;
    private javax.swing.JLabel lbl_sodienthoai;
    private javax.swing.JLabel lbl_sodu;
    private javax.swing.JLabel lbl_trangthaithaikhoan;
    private javax.swing.JLabel lbl_userid;
    private javax.swing.JPanel pnl_anhbanglai;
    private javax.swing.JPanel pnl_anhdaidien;
    private javax.swing.JPanel pnl_gioitinh;
    private javax.swing.JPanel pnl_taikhoan;
    private javax.swing.JPanel pnl_xecuatoi;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_dichvu;
    private javax.swing.JTable tbl_hopdong;
    private javax.swing.JTable tbl_phuphi;
    private javax.swing.JTextField txt_cancuoc;
    private javax.swing.JTextArea txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_giathue;
    private javax.swing.JTextField txt_giatri;
    private javax.swing.JTextField txt_hangxe;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_mahopdong;
    private javax.swing.JTextField txt_maxe;
    private javax.swing.JTextField txt_ngayhethan;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_ngaythue;
    private javax.swing.JTextField txt_sodienthoai;
    private javax.swing.JTextField txt_soghe;
    private javax.swing.JTextField txt_tenxe;
    private javax.swing.JTextField txt_tongtien;
    private javax.swing.JTextArea txt_trangthaixe;
    private javax.swing.JTextField txt_voucher;
    // End of variables declaration//GEN-END:variables
}
