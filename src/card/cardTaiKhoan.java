/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.ChiTietTaiKhoanDAO;
import DAO.TaiKhoanDAO;
import Hepler.DateHelper;
import Hepler.DialogHelper;
import entyti.ChiTietTaiKhoan;
import entyti.TaiKhoan;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author hieud
 */
public class cardTaiKhoan extends javax.swing.JPanel {

    TaiKhoanDAO tkd = new TaiKhoanDAO();
    ChiTietTaiKhoanDAO cttkdao = new ChiTietTaiKhoanDAO();
    String banglai = null;
    String anhdaidien = null;
    private static String readurl_banglai = "src/imgbanglainew/";
    private static String writeurl_banglai = "src/imgbanglai/";
    private static String readurl_anhdaidien = "src/imganhdaidiennew/";
    private static String writeurl_anhdaidien = "src/imganhdaidien/";

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
        cttk.setNgaysinh(DateHelper.toDate(txt_ngaysinh.getText(),"dd/MM/yyyy"));
        cttk.setEmail(txt_email.getText());
        cttk.setSdt(txt_sodienthoai.getText());
        cttk.setCccd(txt_cancuoc.getText());
        cttk.setDiachi(txt_diachi.getText());
        cttk.setAnhdaidien(anhdaidien);
        cttk.setBanglaixe(banglai);
        if (rdo_nu.isSelected()) {
            cttk.setGioitinh(true);
        } else {
            cttk.setGioitinh(false);
        }
        return cttk;
    }

    public void setForm() {
        String trangthai = null;
        TaiKhoan tk = Hepler.AuthHelper.user;
        lbl_userid.setText("USERID: " + String.valueOf(tk.getUserid()));
        if (tk.isTrangthai()) {
            trangthai = "Đã Xác Thực ";
        } else {
            trangthai = "Chưa Xác Thực ";
        }
        lbl_trangthaithaikhoan.setText("Trạng Thái :" + trangthai);
        try {
            ChiTietTaiKhoan cttk = cttkdao.selectByID(String.valueOf(tk.getUserid()));
            txt_hoten.setText(cttk.getHoten());
            txt_ngaysinh.setText(DateHelper.toString(cttk.getNgaysinh(), "dd/MM/yyyy"));
            System.out.println(cttk.getNgaysinh());
            txt_sodienthoai.setText(cttk.getSdt());
            txt_cancuoc.setText(cttk.getCccd());
            txt_diachi.setText(cttk.getDiachi());
            if(cttk.isGioitinh()){
                rdo_nu.setSelected(true);
            }else{
                rdo_nam.setSelected(true);
            }
            anhdaidien = cttk.getAnhdaidien();
            banglai = cttk.getBanglaixe();
            txt_email.setText(cttk.getEmail());
            setImg(anhdaidien, banglai);
            lbl_sodu.setText("Số Dư: "+String.valueOf(cttk.getSodu()));
        } catch (Exception e) {
        }
    }

    public void insert() {
        ChiTietTaiKhoan cttk = getForm();
        if (cttk != null) {
            try {
                cttkdao.insert(cttk);
                DialogHelper.alert(this, "Cập nhật thông tin thành công !!!");
            } catch (Exception e) {
                System.out.println("them thong tin that bai");
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

    public boolean verify(){
        if(txt_hoten.getText().equals("")){
            DialogHelper.alert(this, "Vui lòng nhập họ tên");
            txt_hoten.requestFocus();
           return false;
        }
        if(txt_ngaysinh.getText().equals("")){
            DialogHelper.alert(this, "Vui lòng nhập ngày sinh");
            txt_ngaysinh.requestFocus();
           return false;
        }
        if (!Hepler.Validate.isValidDate(txt_ngaysinh.getText())) {
            DialogHelper.alert(this, "Vui lòng nhập đúng định dạng dd/mm/yyyy");
            txt_ngaysinh.requestFocus();
            return false;
        }
        if(txt_cancuoc.getText().equals("")){
            DialogHelper.alert(this, "Vui lòng nhập số CCCD");
            txt_cancuoc.requestFocus();
           return false;
        }
        if (txt_sodienthoai.getText().length() > 12) {
            DialogHelper.alert(this, "Số CCCD không được quá 12 kí tự");
            txt_sodienthoai.requestFocus();
            return false;
        }
        if(txt_email.getText().equals("")){
            DialogHelper.alert(this, "Email không được để trống");
            txt_email.requestFocus();
           return false;
        }
        if(txt_diachi.getText().equals("")){
            DialogHelper.alert(this, "Địa chỉ không được để trống");
            txt_diachi.requestFocus();
           return false;
        }
        if(txt_sodienthoai.getText().equals("")){
            DialogHelper.alert(this, "Số điện thoại không được để trống");
            txt_sodienthoai.requestFocus();
           return false;
        }
        if (txt_sodienthoai.getText().length() > 10) {
            DialogHelper.alert(this, "Số điện thoại không được quá 10 kí tự");
            txt_sodienthoai.requestFocus();
            return false;
        }
        if (anhdaidien == null) {
            DialogHelper.alert(this, "Vui lòng thêm ảnh đại diện");
            return false;
        }
        if (banglai == null) {
            DialogHelper.alert(this, "Vui lòng thêm ảnh đại diện");
            return false;
        }
        return true;
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
        lbl_trangthaithaikhoan = new javax.swing.JLabel();
        lbl_userid = new javax.swing.JLabel();
        pnl_anhbanglai = new javax.swing.JPanel();
        lbl_anhbanglai = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
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

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(985, 660));

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(985, 660));

        lbl_trangthaithaikhoan.setBackground(new java.awt.Color(255, 102, 51));
        lbl_trangthaithaikhoan.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_trangthaithaikhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_trangthaithaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_trangthaithaikhoan.setText("Trạng Thái :");
        lbl_trangthaithaikhoan.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_userid.setBackground(new java.awt.Color(255, 102, 51));
        lbl_userid.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_userid.setForeground(new java.awt.Color(255, 255, 255));
        lbl_userid.setText("User ID : ");

        pnl_anhbanglai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Bằng Lái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12), new java.awt.Color(255, 255, 255))); // NOI18N
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Đại Diện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        lbl_anhdaidien.setForeground(new java.awt.Color(255, 255, 255));
        lbl_anhdaidien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_anhdaidien.setPreferredSize(new java.awt.Dimension(110, 164));
        lbl_anhdaidien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhdaidienMouseClicked(evt);
            }
        });

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

        lbl_capnhatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_capnhatthongtin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_capnhatthongtin.setText("Cập Nhật Thông Tin");

        txt_hoten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_email.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("Email");

        txt_sodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_sodienthoai.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_sodienthoai.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sodienthoai.setText("Số Điện Thoại");

        txt_cancuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_cancuoc.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_cancuoc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cancuoc.setText("Căn Cước");

        pnl_gioitinh.setBackground(new java.awt.Color(255, 102, 51));
        pnl_gioitinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giới Tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12), new java.awt.Color(255, 255, 255))); // NOI18N
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

        lbl_diachi.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_diachi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_diachi.setText("Địa Chỉ");

        txt_diachi.setColumns(20);
        txt_diachi.setRows(5);
        jScrollPane1.setViewportView(txt_diachi);

        btn_capnhatthongtin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_capnhatthongtin.setForeground(new java.awt.Color(255, 102, 51));
        btn_capnhatthongtin.setText("Cập Nhật Thông Tin");
        btn_capnhatthongtin.setFocusPainted(false);
        btn_capnhatthongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatthongtinActionPerformed(evt);
            }
        });

        lbl_ngaysinh.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_ngaysinh.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ngaysinh.setText("Ngày Sinh");

        txt_ngaysinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_hovaten.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_hovaten.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hovaten.setText("Họ Và Tên");

        lbl_sodu.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_sodu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sodu.setText("Số Dư: ");

        btn_napsodu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_napsodu.setForeground(new java.awt.Color(255, 102, 51));
        btn_napsodu.setText("Nạp Số Dư");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(lbl_capnhatthongtin)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_userid))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(lbl_cancuoc)
                        .addGap(370, 370, 370))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_napsodu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_capnhatthongtin))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_sodienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                            .addComponent(lbl_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_sodu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cancuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(115, 115, 115))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_capnhatthongtin)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_userid)
                    .addComponent(lbl_trangthaithaikhoan)
                    .addComponent(lbl_sodu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_hovaten)
                            .addComponent(lbl_sodienthoai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ngaysinh)
                            .addComponent(lbl_cancuoc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cancuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbl_email)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnl_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_diachi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(pnl_anhbanglai, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_capnhatthongtin)
                    .addComponent(btn_napsodu))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capnhatthongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatthongtinActionPerformed
        insert();
    }//GEN-LAST:event_btn_capnhatthongtinActionPerformed

    private void lbl_anhdaidienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhdaidienMouseClicked
        anhdaidien = Hepler.ImagesHelper.chonAnh();
        Hepler.ImagesHelper.convertImgTo110x164(readurl_anhdaidien, anhdaidien, writeurl_anhdaidien);
        setImg(anhdaidien, banglai);
    }//GEN-LAST:event_lbl_anhdaidienMouseClicked

    private void lbl_anhbanglaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhbanglaiMouseClicked
        banglai = Hepler.ImagesHelper.chonAnh();
        Hepler.ImagesHelper.convertImgTo280x180(readurl_banglai, banglai, writeurl_banglai);
        setImg(anhdaidien, banglai);
    }//GEN-LAST:event_lbl_anhbanglaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhatthongtin;
    private javax.swing.JButton btn_napsodu;
    private javax.swing.ButtonGroup btngr_gioitinh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JPanel pnl_gioitinh;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTextField txt_cancuoc;
    private javax.swing.JTextArea txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_sodienthoai;
    // End of variables declaration//GEN-END:variables
}
