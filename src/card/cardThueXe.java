/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.DichVuDAO;
import DAO.ChiTietXeDAO;
import DAO.HangXeDAO;
import DAO.HopDongDAO;
import DAO.VoucherDAO;
import Hepler.DateHelper;
import static Hepler.DateHelper.addDays;
import static Hepler.DateHelper.isValidDate;
import static Hepler.DateHelper.resetTime;
import Hepler.DialogHelper;
import entyti.DichVu;
import entyti.ChiTietXe;
import entyti.HangXe;
import entyti.HopDong;
import entyti.Voucher;
import form.TaoHopDongDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 04dkh
 */
public class cardThueXe extends javax.swing.JPanel {

    HangXeDAO hxd = new HangXeDAO();
    DichVuDAO dvd = new DichVuDAO();
    ChiTietXeDAO ctxd = new ChiTietXeDAO();
    VoucherDAO vcd = new VoucherDAO();
    HopDongDAO hdd = new HopDongDAO();
    List<ChiTietXe> list_xe = new ArrayList<>();
    List<ChiTietXe> listallxe = new ArrayList<>();
    List<DichVu> list_dichvu = new ArrayList<>();
    String voucher = null;
    String soghe = "4";
    String diaChi = null;
    int index = 0;
    int maloaixe = 1;
    int size_list = -1;
    Date ngayThue = null;
    int songaythue = 1;
    String maxe = null;

    /**
     * Creates new form ThueXe
     */
    public cardThueXe() {
        initComponents();
        fillcbb_dichvu();
        fillcbb_hangxe();
        fillcbb_soghe();
        setForm(getListXe(soghe, maloaixe), 0);
    }

    public void openHopDong() {
        try {
            TaoHopDongDialog hopdong = new TaoHopDongDialog(null, true, maxe, list_dichvu, ngayThue, songaythue, diaChi, voucher);
            hopdong.setVisible(true);
        } catch (Exception e) {
        }
    }

    public void getFrom() {
        maxe = txt_maxe.getText();
        ngayThue = DateHelper.toDate(txt_ngaythue.getText(), "dd/MM/yyyy");
        songaythue = Integer.parseInt(txt_songaythue.getText());
        getDiaChi();
    }

    public void getDiaChi() {
        String thanhpho = null;
        String huyen = null;
        String xa = null;
        String diachichitiet = null;
        if (cbb_thanhpho.getSelectedIndex() == 0) {
            thanhpho = null;
        } else {
            thanhpho = cbb_thanhpho.getSelectedItem().toString() + " ";
        }
        if (cbb_huyen.getSelectedIndex() == 0) {
            huyen = null;
        } else {
            huyen = cbb_huyen.getSelectedItem().toString() + " ";
        }
        if (cbb_xa.getSelectedIndex() == 0) {
            xa = null;
        } else {
            xa = cbb_xa.getSelectedItem().toString() + " ";
        }
        if (txt_diachi.getText() == null) {
            diachichitiet = null;
        } else {
            diachichitiet = txt_diachi.getText();
        }
        diaChi = thanhpho + huyen + xa + diachichitiet;
    }

    public int tinhSoNgayThue(int songaythue) {
        int max = -1;
        for (int i = 0; i <= songaythue; i++) {
            if (kiemtraxe(i)) {
                break;
            } else {
                if (max < i) {
                    max = i;
                }
            }
        }
        return max;
    }

    public boolean kiemtraxe(int ngaythue) {
        Date ngayTra = null;
        Date ngaythue_fake = null;
        ngaythue_fake = (Date) ngayThue.clone();
        ngayTra = Hepler.DateHelper.addDays(ngaythue_fake, ngaythue);
        try {
            HopDong hd = hdd.selectByID_MAXE_NULL(maxe, ngayTra);
            if (hd != null) {
                return true;  // Hợp đồng đã đặt cho ngày đó
            } else {
                List<HopDong> list = hdd.selectByID_MAXE_TRANGTHAIDANGTHUE(maxe);
                if (list != null) {
                    for (HopDong hopdong : list) {
                        Date NgayTao = Hepler.DateHelper.resetTime(hopdong.getNgaythue());
                        Date ngayHetHan = Hepler.DateHelper.resetTime(hopdong.getNgayhethan());
                        long soNgayQuaHan = TimeUnit.DAYS.convert(ngayHetHan.getTime() - NgayTao.getTime(), TimeUnit.MILLISECONDS);
                        for (int i = 0; i <= (int) soNgayQuaHan; i++) {
                            Date ngayTaoHopDongTam = (Date) NgayTao.clone();
                            Date ngayHienTai = Hepler.DateHelper.resetTime(Hepler.DateHelper.addDays(ngayTaoHopDongTam, i));
                            if (ngayThue.compareTo(ngayHienTai) == 0) {
                                DialogHelper.alert(this, "Bạn Chỉ Có Thể Thuê Sau Ngày:" + Hepler.DateHelper.toString(ngayHetHan, "dd/MM/yyyy"));
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public boolean vadidate() {
        try {
            int songaythue = Integer.parseInt(txt_songaythue.getText());
        } catch (Exception e) {
            txt_songaythue.requestFocus();
            DialogHelper.alert(this, "Vui Lòng Nhập Định Dạng Số");
            return false;
        }
        if (Integer.parseInt(txt_songaythue.getText()) < 1) {
            txt_songaythue.requestFocus();
            DialogHelper.alert(this, "Số NGày THuê Lớn Hơn 0");
            return false;
        }
        if (txt_songaythue.getText().equals("")) {
            txt_songaythue.requestFocus();
            DialogHelper.alert(this, "Số Ngày Thuê Không Được Để Trống");
            return false;
        }
        if (txt_ngaythue.getText().equals("")) {
            txt_ngaythue.requestFocus();
            DialogHelper.alert(this, "Ngày Thuê Không Được Để Trống");
            return false;
        }
        if (!isValidDate(txt_ngaythue.getText(), "dd/MM/yyyy")) {
            txt_ngaythue.requestFocus();
            DialogHelper.alert(this, "Vui Lòng Nhập Đúng định dạng dd/MM/yyyy");
            return false;
        }
        if (!Hepler.DateHelper.isFutureDate(txt_ngaythue.getText(), "dd/MM/yyyy")) {
            txt_ngaythue.requestFocus();
            DialogHelper.alert(this, "Vui Lòng Nhập Ngày Lớn Hơn Hoặc Bằng Ngày Hiện");
            return false;
        }
        return true;
    }

    public void kiemtravoucher() {
        String phantramgiamgia = null;
        voucher = txt_voucher.getText();
        try {
            Voucher vc = vcd.selectByID_MAVOUCHER(voucher);
            if (vc.getGiatri() == 1) {
                phantramgiamgia = "Bạn Được Giảm 5% Tổng Giá Trị Hợp Đồng";
            } else if (vc.getGiatri() == 2) {
                phantramgiamgia = "Bạn Được Giảm 10% Tổng Giá Trị Hợp Đồng";
            } else if (vc.getGiatri() == 3) {
                phantramgiamgia = "Bạn Được Giảm 15% Tổng Giá Trị Hợp Đồng";
            } else {
                phantramgiamgia = null;
            }
            DialogHelper.alert(this, "Voucher Tồn Tại"
                    + "\n" + phantramgiamgia);
        } catch (Exception e) {
            DialogHelper.alert(this, "Voucher Không Tồn Tại");
            voucher = null;
            System.out.println(e.getMessage());
        }
    }

    public void fill_table_dichvu() {
        DefaultTableModel model = (DefaultTableModel) tbl_tdv.getModel();
        model.setRowCount(0);
        for (DichVu dv : list_dichvu) {
            Object[] row = {
                dv.getMadichvu(),
                dv.getTendichvu(),
                Hepler.MoneyFormatter.formatMoney(dv.getDongia())
            };
            model.addRow(row);
        }
    }

    public void getListDichVu(String tendichvu) {
        try {
            DichVu dv = dvd.selectByID_TENDICHVU(tendichvu);
            boolean flag = false;
            for (DichVu dichVu : list_dichvu) {
                if (dichVu.getTendichvu().equals(tendichvu)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list_dichvu.add(dv);
            } else {
                DialogHelper.alert(this, "Dịch Vụ Đã Được Chọn");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<ChiTietXe> getListXe(String soghe, int maloaixe) {
        list_xe.clear();
        try {
            listallxe = ctxd.selectAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (maloaixe == 0 && soghe == null) {
            return listallxe;
        }
        for (ChiTietXe ctx : listallxe) {
            if (ctx.getMahangxe() == maloaixe && ctx.getSoghe() == Integer.parseInt(soghe)) {
                list_xe.add(ctx);
            }
        }
        return list_xe;
    }

    public void setForm(List<ChiTietXe> list, int index) {
        if (list.isEmpty()) {
            DialogHelper.alert(this, "Dòng Xe Này Hiện Chưa CÓ Xe");
            return;
        }
        ChiTietXe ctx = list.get(index);
        size_list = list.size() - 1;
        txt_maxe.setText(ctx.getMaxe());
        txt_tenxe.setText(ctx.getTenxe());
        seticon(ctx.getAnhxe());
        txt_giathue.setText(Hepler.MoneyFormatter.formatMoney(ctx.getGiathue()));
        txt_trangthai.setText(ctx.getTrangthaixe());
    }

    public void fillcbb_dichvu() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbb_dichvu.getModel();
            model.removeAllElements();
            List<DichVu> list = dvd.selectAll();
            for (DichVu dv : list) {
                if (!dv.isTrangthai()) {
                    model.addElement(dv.getTendichvu());
                }
            }
            cbb_hangxe.setSelectedIndex(0);
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

    public void seticon(String string) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhxe, "src\\imgxe\\" + string);

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
        jLabel1 = new javax.swing.JLabel();
        lbl_timtheosoghe = new javax.swing.JLabel();
        cbb_hangxe = new javax.swing.JComboBox<>();
        cbb_soghe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_giathue = new javax.swing.JTextField();
        btn_dau = new javax.swing.JButton();
        btn_truoc = new javax.swing.JButton();
        btn_sau = new javax.swing.JButton();
        btn_cuoi = new javax.swing.JButton();
        btn_timkiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_voucher = new javax.swing.JLabel();
        lbl_dichvu = new javax.swing.JLabel();
        txt_voucher = new javax.swing.JTextField();
        txt_songaythue = new javax.swing.JTextField();
        lbl_songaythue = new javax.swing.JLabel();
        lbl_songaythue1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ngaythue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        cbb_xa = new javax.swing.JComboBox<>();
        cbb_huyen = new javax.swing.JComboBox<>();
        cbb_thanhpho = new javax.swing.JComboBox<>();
        btn_chondichvu = new javax.swing.JButton();
        cbb_dichvu = new javax.swing.JComboBox<>();
        btn_kiemtra = new javax.swing.JButton();
        btn_thue = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_tdv = new javax.swing.JTable();
        btn_XoaDichVu = new javax.swing.JButton();

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

        txt_maxe.setEnabled(false);

        txt_tenxe.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TRẠNG THÁI XE");

        txt_trangthai.setColumns(20);
        txt_trangthai.setRows(5);
        txt_trangthai.setEnabled(false);
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
                .addComponent(lbl_anhxe, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        anhLayout.setVerticalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anhxe, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HÃNG");

        lbl_timtheosoghe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_timtheosoghe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_timtheosoghe.setText("SỐ GHẾ");

        cbb_hangxe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_hangxe.setForeground(new java.awt.Color(255, 102, 51));
        cbb_hangxe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "TOYOTA", "CHEVROLET", "FORD", "HONDA", "SSANGYONG", "LANDROVER" }));

        cbb_soghe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_soghe.setForeground(new java.awt.Color(255, 102, 51));
        cbb_soghe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "4", "7", "16", "29" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ĐƠN GIÁ");

        txt_giathue.setEnabled(false);

        btn_dau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_dau.setForeground(new java.awt.Color(255, 102, 51));
        btn_dau.setText("|<");
        btn_dau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dauActionPerformed(evt);
            }
        });

        btn_truoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_truoc.setForeground(new java.awt.Color(255, 102, 51));
        btn_truoc.setText("<<");
        btn_truoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_truocActionPerformed(evt);
            }
        });

        btn_sau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sau.setForeground(new java.awt.Color(255, 102, 51));
        btn_sau.setText(">>");
        btn_sau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sauActionPerformed(evt);
            }
        });

        btn_cuoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cuoi.setForeground(new java.awt.Color(255, 102, 51));
        btn_cuoi.setText(">|");
        btn_cuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuoiActionPerformed(evt);
            }
        });

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
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
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenxe)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_maxe)
                            .addComponent(txt_giathue)))
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ttxeLayout.createSequentialGroup()
                                .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbb_hangxe, 0, 169, Short.MAX_VALUE)
                                    .addComponent(cbb_soghe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(ttxeLayout.createSequentialGroup()
                                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_timtheosoghe)
                                            .addComponent(jLabel1)
                                            .addComponent(btn_timkiem))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ttxeLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_dau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_truoc)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cuoi)))
                        .addContainerGap())))
        );
        ttxeLayout.setVerticalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ttxeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(btn_timkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_hangxe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lbl_timtheosoghe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cuoi)
                    .addComponent(btn_sau)
                    .addComponent(btn_truoc)
                    .addComponent(btn_dau))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN THUÊ XE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 178));

        lbl_voucher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_voucher.setForeground(new java.awt.Color(255, 255, 255));
        lbl_voucher.setText("VOUCHER");

        lbl_dichvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_dichvu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dichvu.setText("DỊCH VỤ");

        lbl_songaythue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_songaythue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_songaythue.setText("SỐ NGÀY THUÊ");

        lbl_songaythue1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_songaythue1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_songaythue1.setText("ĐỊA CHỈ NHẬN XE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NGÀY THUÊ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PHƯỜNG / XÃ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("QUẬN / HUYỆN");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("THÀNH PHỐ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ĐỊA CHỈ CHI TIẾT");

        cbb_xa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_xa.setForeground(new java.awt.Color(255, 102, 51));
        cbb_xa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "An Đồng", "An Hòa", "An Hòa", "An Hồng", "An Hưng", "An Lư", "An Sơn", "An Thái", "An Thắng", "An Thọ", "An Tiến", "Bạch Đằng", "Bát Trang", "Bắc Hưng", "Bắc Sơn", "Cao Minh", "Cao Nhân", "Cấp Tiến", "Chiến Thắng", "Chính Mỹ", "Cổ Am", "Cộng Hiền", "Du Lễ", "Dũng Tiến", "Dương Quan", "Đại Bản", "Đại Đồng", "Đại Hà", "Đại Hợp", "Đại Thắng", "Đặng Cương", "Đoàn Lập", "Đoàn Xá", "Đồng Bài", "Đông Hưng", "Đồng Minh", "Đông Phương", "Đông Sơn", "Đồng Thái", "Gia Đức", "Gia Luận", "Gia Minh", "Giang Biên", "Hiền Hào", "Hiệp Hòa", "Hòa Bình", "Hòa Bình", "Hoa Động", "Hoàng Châu", "Hoàng Động", "Hồng Phong", "Hồng Thái", "Hợp Thành", "Hùng Thắng", "Hùng Tiến", "Hưng Nhân", "Hữu Bằng", "Kênh Giang", "Khởi Nghĩa", "Kiền Bái", "Kiến Quốc", "Kiến Thiết", "Kỳ Sơn", "Lại Xuân", "Lâm Động", "Lập Lễ", "Lê Lợi", "Lê Thiện", "Liên Am", "Liên Khê", "Lưu Kiếm", "Lưu Kỳ", "Lý Học", "Minh Tân", "Minh Tân", "Mỹ Đồng", "Mỹ Đức", "Nam Hưng", "Nam Sơn", "Nghĩa Lộ", "Ngũ Đoan", "Ngũ Lão", "Ngũ Phúc", "Nhân Hòa", "Phả Lễ", "Phù Long", "Phù Ninh", "Phục Lễ", "Quang Hưng", "Quang Phục", "Quảng Thanh", "Quang Trung", "Quốc Tuấn", "Quốc Tuấn", "Quyết Tiến", "Tam Cường", "Tam Đa", "Tam Hưng", "Tân Dân", "Tân Dương", "Tân Hưng", "Tân Liên", "Tân Phong", "Tân Tiến", "Tân Trào", "Tân Viên", "Tây Hưng", "Thái Sơn", "Thanh Lương", "Thanh Sơn", "Thắng Thủy", "Thiên Hương", "Thuận Thiên", "Thủy Đường", "Thụy Hương", "Thủy Sơn", "Thủy Triều", "Tiên Cường", "Tiên Minh", "Tiền Phong", "Tiên Thanh", "Tiên Thắng", "Toàn Thắng", "Trân Châu", "Trấn Dương", "Trung Hà", "Trung Lập", "Trường Thành", "Trường Thọ", "Tú Sơn", "Tự Cường", "Văn Phong", "Việt Hải", "Việt Tiến", "Vĩnh An", "Vĩnh Long", "Vĩnh Phong", "Vinh Quang", "Vinh Quang", "Vĩnh Tiến", "Xuân Đám" }));

        cbb_huyen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_huyen.setForeground(new java.awt.Color(255, 102, 51));
        cbb_huyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "Đồ Sơn", "Dương Kinh", "Hải An", "Hồng Bàng", "Kiến An", "Lê Chân", "Ngô Quyền", "An Dương", "An Lão", "Bạch Long Vĩ", "Cát Hải", "Kiến Thuỵ", "Thủy Nguyên", "Tiên Lãng", "Vĩnh Bảo", "Hồng Bàng" }));

        cbb_thanhpho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_thanhpho.setForeground(new java.awt.Color(255, 102, 51));
        cbb_thanhpho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "Hải Phòng" }));

        btn_chondichvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_chondichvu.setForeground(new java.awt.Color(255, 102, 51));
        btn_chondichvu.setText("CHỌN DỊCH VỤ");
        btn_chondichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chondichvuActionPerformed(evt);
            }
        });

        cbb_dichvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbb_dichvu.setForeground(new java.awt.Color(255, 102, 51));
        cbb_dichvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Vui lòng chọn dịch vụ)", "Xăng xe", "Đưa đón sân bay", "Cứu hộ đường cao tốc", "Thuê người lái" }));

        btn_kiemtra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_kiemtra.setForeground(new java.awt.Color(255, 102, 51));
        btn_kiemtra.setText("KIỂM TRA");
        btn_kiemtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kiemtraActionPerformed(evt);
            }
        });

        btn_thue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thue.setForeground(new java.awt.Color(255, 102, 51));
        btn_thue.setText("THUÊ");
        btn_thue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thueActionPerformed(evt);
            }
        });

        tbl_tdv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Dịch Vụ"
            }
        ));
        jScrollPane3.setViewportView(tbl_tdv);

        btn_XoaDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XoaDichVu.setForeground(new java.awt.Color(255, 102, 51));
        btn_XoaDichVu.setText("XÓA DỊCH VỤ");
        btn_XoaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jSeparator3)
                .addGap(110, 110, 110))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(cbb_dichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbl_dichvu)
                                        .addGap(150, 150, 150)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_XoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_chondichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_songaythue1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(cbb_xa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbb_huyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)))
                                .addComponent(btn_thue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_voucher, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_kiemtra))
                                .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txt_ngaythue, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_songaythue)
                                        .addComponent(txt_songaythue)))))
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_thanhpho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngaythue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_songaythue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_songaythue)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_songaythue1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_xa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_huyen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_thanhpho, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dichvu)
                    .addComponent(btn_XoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_dichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chondichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_voucher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kiemtra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_thue)
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ttxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ttxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        String tenxe = (String) cbb_hangxe.getSelectedItem();
        soghe = cbb_soghe.getSelectedItem().toString();
        try {
            HangXe hx = hxd.selectByID_TENHANGXE(tenxe);
            maloaixe = hx.getMahangxe();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setForm(getListXe(soghe, maloaixe), 0);
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_dauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dauActionPerformed
        // TODO add your handling code here:
        index = 0;
        setForm(getListXe(soghe, maloaixe), index);
    }//GEN-LAST:event_btn_dauActionPerformed

    private void btn_cuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuoiActionPerformed
        // TODO add your handling code here:
        index = size_list;
        setForm(getListXe(soghe, maloaixe), index);

    }//GEN-LAST:event_btn_cuoiActionPerformed

    private void btn_sauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sauActionPerformed
        // TODO add your handling code here:
        index++;
        btn_truoc.setEnabled(true);
        if (index > size_list) {
            Hepler.DialogHelper.alert(this, "Danh Sách Đang Cuối");
            index = size_list;
            btn_sau.setEnabled(false);
        } else {
            setForm(getListXe(soghe, maloaixe), index);
        }
    }//GEN-LAST:event_btn_sauActionPerformed

    private void btn_truocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_truocActionPerformed
        // TODO add your handling code here:
        index--;
        btn_sau.setEnabled(true);
        if (index < 0) {
            Hepler.DialogHelper.alert(this, "Danh Sách Đang ở đầu");
            index = 0;
            btn_truoc.setEnabled(false);
        } else {
            setForm(getListXe(soghe, maloaixe), index);
        }
    }//GEN-LAST:event_btn_truocActionPerformed

    private void btn_chondichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chondichvuActionPerformed
        // TODO add your handling code here:
        String tendv = cbb_dichvu.getSelectedItem().toString();
        getListDichVu(tendv);
        fill_table_dichvu();
    }//GEN-LAST:event_btn_chondichvuActionPerformed

    private void btn_thueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thueActionPerformed
        // TODO add your handling code here:
        if (vadidate()) {
            getFrom();
            int songaytoida = tinhSoNgayThue(songaythue);
            if (songaytoida > songaythue || songaytoida == songaythue) {
                openHopDong();
            } else {
                if (songaytoida > 0) {
                    DialogHelper.alert(this, "Bạn Chỉ Có thể Thuê Tối Đa " + songaytoida + " Ngày");
                }

            }
        }

    }//GEN-LAST:event_btn_thueActionPerformed

    private void btn_kiemtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kiemtraActionPerformed
        // TODO add your handling code here:
        kiemtravoucher();
    }//GEN-LAST:event_btn_kiemtraActionPerformed

    private void btn_XoaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaDichVuActionPerformed
        // TODO add your handling code here:
        try {
            int row = tbl_tdv.getSelectedRow();
            list_dichvu.remove(row);
            fill_table_dichvu();
        } catch (Exception e) {
            DialogHelper.alert(this, "Vui Lòng Chọn DỊch Vụ Ạ");
        }
    }//GEN-LAST:event_btn_XoaDichVuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anh;
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_XoaDichVu;
    private javax.swing.JButton btn_chondichvu;
    private javax.swing.JButton btn_cuoi;
    private javax.swing.JButton btn_dau;
    private javax.swing.JButton btn_kiemtra;
    private javax.swing.JButton btn_sau;
    private javax.swing.JButton btn_thue;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_truoc;
    private javax.swing.JComboBox<String> cbb_dichvu;
    private javax.swing.JComboBox<String> cbb_hangxe;
    private javax.swing.JComboBox<String> cbb_huyen;
    private javax.swing.JComboBox<String> cbb_soghe;
    private javax.swing.JComboBox<String> cbb_thanhpho;
    private javax.swing.JComboBox<String> cbb_xa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_anhxe;
    private javax.swing.JLabel lbl_dichvu;
    private javax.swing.JLabel lbl_songaythue;
    private javax.swing.JLabel lbl_songaythue1;
    private javax.swing.JLabel lbl_timtheosoghe;
    private javax.swing.JLabel lbl_voucher;
    private javax.swing.JTable tbl_tdv;
    private javax.swing.JPanel ttxe;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_giathue;
    private javax.swing.JTextField txt_maxe;
    private javax.swing.JTextField txt_ngaythue;
    private javax.swing.JTextField txt_songaythue;
    private javax.swing.JTextField txt_tenxe;
    private javax.swing.JTextArea txt_trangthai;
    private javax.swing.JTextField txt_voucher;
    // End of variables declaration//GEN-END:variables
}
