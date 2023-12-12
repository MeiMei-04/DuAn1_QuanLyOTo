/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.ChiTietTaiKhoanDAO;
import DAO.ChiTietXeDAO;
import DAO.DichVuDAO;
import DAO.HopDongDAO;
import DAO.HopDongDAO;
import DAO.PhuPhiDAO;
import DAO.ThemDichVuDAO;
import DAO.ThemPhuPhiDAO;
import DAO.VoucherDAO;
import Hepler.DialogHelper;
import Hepler.ImagesHelper;
import entyti.ChiTietTaiKhoan;
import entyti.ChiTietXe;
import entyti.DichVu;
import entyti.HopDong;
import entyti.PhuPhi;
import entyti.TaiKhoan;
import entyti.ThemDichVu;
import entyti.ThemPhuPhi;
import entyti.Voucher;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author truon
 */
public class cardHopDong extends javax.swing.JPanel {

    HopDong hd = new HopDong();
    HopDongDAO hdd = new HopDongDAO();
    ChiTietTaiKhoanDAO cttkd = new ChiTietTaiKhoanDAO();
    ChiTietXeDAO ctxd = new ChiTietXeDAO();
    VoucherDAO vcd = new VoucherDAO();
    ThemDichVuDAO tdvd = new ThemDichVuDAO();
    DichVuDAO dvd = new DichVuDAO();
    ThemPhuPhiDAO tppd = new ThemPhuPhiDAO();
    PhuPhiDAO ppd = new PhuPhiDAO();
    String mahopdong = null;
    String path = "src/imghopdong/";

    /**
     * Creates new form HopDong
     */
    public cardHopDong() {
        initComponents();
        fill_Table_Hopdong(getListHopDongAll());
    }

    public void sendMail() {
        try {
            if (hd.getTinhtranghopdong() != 4) {
                DialogHelper.alert(this, "Hợp Đồng Không Thuộc Diện Chỉnh Sửa");
            }
            TaiKhoan tk = Hepler.AuthHelper.user;
            ImagesHelper.capturePanel(jPanel1, mahopdong);
            Hepler.Email.sendEmail(tk.getEmail(), "Hợp Đồng Quá Hạn", "Vui Lòng Bàn Giao Lại Xe Cho Cơ Sở Thuê", path, mahopdong + ".png");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi Truy Vấn");
            return;
        }
    }

    public List<HopDong> loctheongayhientai(List<HopDong> list_all) {
        List<HopDong> list = new ArrayList<>();
        Date datenow = Hepler.DateHelper.resetTime(Hepler.DateHelper.now());
        try {
            for (HopDong hd : list_all) {
                Date ngayThue = Hepler.DateHelper.resetTime(hd.getNgaythue());
                Date ngayTra = Hepler.DateHelper.resetTime(hd.getNgayhethan());
                if (datenow.equals(ngayThue) || datenow.equals(ngayTra)) {
                    System.out.println("a");
                    list.add(hd);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void banGiaoXe(String mahopdong) {
        if (this.mahopdong == null) {
            DialogHelper.alert(this, "Vui Lòng Chọn Hợp Đồng");
        }
        HopDong hd = hdd.selectByID_MAHOPDONG(mahopdong);
        if (hd.getTinhtranghopdong() == 5 || hd.getTinhtranghopdong() == 2) {
            DialogHelper.alert(this, "Hợp Đồng Không Thuộc Diện Chỉnh Sửa");
        } else {
            HopDong hdnew = new HopDong();
            hdnew.setMahopdong(mahopdong);
            hdnew.setTinhtranghopdong(3);
            hdd.update_trangthai(hdnew);
            DialogHelper.alert(this, "Bàn Giao Xe Thành CÔng");
            fill_Table_Hopdong(loctheongayhientai(find_cbb()));
        }
    }

    public void xacNhanTraXe(String mahopdong) {
        if (this.mahopdong == null) {
            DialogHelper.alert(this, "Vui Lòng Chọn Hợp Đồng");
        }
        if (hd.getTinhtranghopdong() == 2) {
            DialogHelper.alert(this, "Hợp Đồng Không Thuộc Diện Chỉnh Sửa");
        } else {
            HopDong hd = new HopDong();
            hd.setMahopdong(mahopdong);
            hd.setTinhtranghopdong(5);
            hdd.update_trangthai(hd);
            DialogHelper.alert(this, "Hoàn Thành");
            fill_Table_Hopdong(loctheongayhientai(find_cbb()));
        }
    }

    public void setimg(String anhxe) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhxe, "src\\imgxe\\" + anhxe);
    }

    public void fill_phuphi(String mahopdong) {
        DefaultTableModel model = (DefaultTableModel) tbl_phuphi.getModel();
        model.setRowCount(0);
        List<PhuPhi> list_pp = new ArrayList<>();
        try {
            List<ThemPhuPhi> list_tpp = tppd.selectByID_MAHOPDONG_LIST(mahopdong);
            for (ThemPhuPhi tpp : list_tpp) {
                PhuPhi pp = ppd.selectByID_MAPHUPHI(tpp.getMaphuphi());
                list_pp.add(pp);
            }
            for (PhuPhi pp : list_pp) {
                String giatri = pp.getGiatri() + "%";
                Object[] row = {
                    pp.getTenphuphi(),
                    giatri
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fill_dichvu(String mahopdong) {
        DefaultTableModel model = (DefaultTableModel) tbl_dichvu.getModel();
        model.setRowCount(0);
        List<DichVu> list_dv = new ArrayList<>();
        try {
            List<ThemDichVu> list_tdv = tdvd.selectByKey_MAHOPDONG(mahopdong);
            for (ThemDichVu tdv : list_tdv) {
                DichVu dv = dvd.selectByID_MADICHVU(tdv.getMadichvu());
                list_dv.add(dv);
            }
            for (DichVu dv : list_dv) {
                Object[] row = {
                    dv.getTendichvu(),
                    dv.getDongia()
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setForm(String mahopdong) {
        try {
            HopDong hd = hdd.selectByID_MAHOPDONG(mahopdong);
            ChiTietXe ctx = ctxd.selectByID_MAXE(hd.getMaxe());
            setimg(ctx.getAnhxe());
            txt_mahopdong.setText(mahopdong);
            txt_maxe.setText(ctx.getMaxe());
            txt_tenxe.setText(ctx.getTenxe());
            txt_soghe.setText(String.valueOf(ctx.getSoghe()));
            txt_hangxe.setText(ctx.tenhangxe(ctx.getMahangxe()));
            txt_dongia.setText(Hepler.MoneyFormatter.formatMoney(ctx.getGiathue()));
            txt_Trangthai.setText(ctx.getTrangthaixe());
            txt_ngaythue.setText(Hepler.DateHelper.toString(hd.getNgaythue(), "dd/MM/yyyy"));
            txt_ngaytra.setText(Hepler.DateHelper.toString(hd.getNgayhethan(), "dd/MM/yyyy"));
            txt_diachi.setText(hd.getDiadiemnhanxe());
            txt_voucher.setText(hd.getMavoucher());
            Voucher vc = vcd.selectByID_MAVOUCHER(hd.getMavoucher());
            if (vc == null) {
                txt_giatri.setText("0%");
            } else {
                txt_giatri.setText(String.valueOf(vc.getGiatri()) + "%");
            }
            fill_dichvu(mahopdong);
            fill_phuphi(mahopdong);
            txt_tongtien.setText(Hepler.MoneyFormatter.formatMoney(hd.getThanhtien()));
            txt_trangthaihopdong.setText(hd.tenTrangThai(hd.getTinhtranghopdong()));
            txt_ngayquahan.setText(String.valueOf(hd.getSongayquahan()));
        } catch (Exception e) {
        }
    }

    public List<HopDong> find_text(String text) {
        String text_find = "%" + text + "%";
        List<HopDong> list = new ArrayList<>();
        try {
            List<ChiTietTaiKhoan> list_cttk = cttkd.selectByID_Tim(text_find);
            for (ChiTietTaiKhoan cttk : list_cttk) {
                HopDong hd = hdd.selectByID_USERID_HD(String.valueOf(cttk.getUserid()));
                list.add(hd);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Không Tìm Thấy Thông Tin Phù Hợp");
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<HopDong> getListHopDongAll() {
        List<HopDong> list = new ArrayList<>();
        try {
            list = hdd.selectAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<HopDong> find_cbb() {
        List<HopDong> list = new ArrayList<>();
        int index = cbb_trangthai.getSelectedIndex() + 1;
        try {
            list = hdd.selectByID_TRANGTHAI(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void fill_Table_Hopdong(List<HopDong> list) {
        TaiKhoan tk = Hepler.AuthHelper.user;
        DefaultTableModel model = (DefaultTableModel) tblHopDong.getModel();
        model.setRowCount(0);
        try {
            for (HopDong hd : list) {
                ChiTietXe ctx = ctxd.selectByID_MAXE(hd.getMaxe());
                ChiTietTaiKhoan cttk = cttkd.selectByID_DOITUONG(String.valueOf(hd.getUserid()));
                String tenxe = ctx.getTenxe();
                String hoten = cttk.getHoten();
                String sdt = cttk.getSdt();
                String cancuoc = cttk.getCccd();
                Object[] row = {
                    hd.getMahopdong(),
                    tenxe,
                    hoten,
                    sdt,
                    cancuoc,
                    hd.getNgaythue(),
                    hd.getNgayhethan(),
                    hd.getThanhtien(),
                    hd.tenTrangThai(hd.getTinhtranghopdong())
                };
                model.addRow(row);
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

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        ttxe = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_maxe = new javax.swing.JTextField();
        txt_tenxe = new javax.swing.JTextField();
        txt_soghe = new javax.swing.JTextField();
        txt_hangxe = new javax.swing.JTextField();
        txt_dongia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Trangthai = new javax.swing.JTextArea();
        anh = new javax.swing.JPanel();
        lbl_anhxe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_mahopdong = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbl_voucher = new javax.swing.JLabel();
        txt_voucher = new javax.swing.JTextField();
        txt_ngaytra = new javax.swing.JTextField();
        lbl_songaythue = new javax.swing.JLabel();
        lbl_songaythue1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ngaythue = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        txt_giatri = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_tongtien = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txt_trangthaihopdong = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_ngayquahan = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_diachi = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dichvu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_phuphi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHopDong = new javax.swing.JTable();
        btn_xuatdanhsach = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        btn_bangiaoxe = new javax.swing.JButton();
        btn_xacnhantraxe = new javax.swing.JButton();
        btn_sendmail = new javax.swing.JButton();
        cbb_trangthai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_locngay = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 51));
        setPreferredSize(new java.awt.Dimension(1026, 660));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));

        background.setBackground(new java.awt.Color(255, 102, 51));

        ttxe.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MÃ XE");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TÊN XE");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SỐ GHẾ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("HÃNG XE");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ĐƠN GIÁ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Trạng Thái");

        txt_Trangthai.setColumns(20);
        txt_Trangthai.setRows(5);
        jScrollPane1.setViewportView(txt_Trangthai);

        anh.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        anh.setOpaque(false);
        anh.setPreferredSize(new java.awt.Dimension(402, 284));

        lbl_anhxe.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout anhLayout = new javax.swing.GroupLayout(anh);
        anh.setLayout(anhLayout);
        anhLayout.setHorizontalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_anhxe, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );
        anhLayout.setVerticalGroup(
            anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anhLayout.createSequentialGroup()
                .addComponent(lbl_anhxe, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MÃ HỢP ĐỒNG");

        javax.swing.GroupLayout ttxeLayout = new javax.swing.GroupLayout(ttxe);
        ttxe.setLayout(ttxeLayout);
        ttxeLayout.setHorizontalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ttxeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_dongia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_hangxe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_soghe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenxe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_maxe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txt_mahopdong, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE))))
        );
        ttxeLayout.setVerticalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ttxeLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_mahopdong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_maxe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tenxe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_soghe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_hangxe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 178));

        lbl_voucher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_voucher.setForeground(new java.awt.Color(255, 255, 255));
        lbl_voucher.setText("VOUCHER");

        lbl_songaythue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_songaythue.setForeground(new java.awt.Color(255, 255, 255));
        lbl_songaythue.setText("NGÀY TRẢ");

        lbl_songaythue1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_songaythue1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_songaythue1.setText("ĐỊA CHỈ NHẬN XE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NGÀY THUÊ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("GIÁ TRỊ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("TỔNG TIỀN");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("TÌNH TRẠNG HỢP ĐỒNG");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("NGÀY QUÁ HẠN");

        txt_diachi.setColumns(20);
        txt_diachi.setRows(5);
        jScrollPane4.setViewportView(txt_diachi);

        jPanel5.setBackground(new java.awt.Color(255, 102, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DỊCH VỤ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N

        tbl_dichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dịch vụ", "Giá"
            }
        ));
        jScrollPane2.setViewportView(tbl_dichvu);
        if (tbl_dichvu.getColumnModel().getColumnCount() > 0) {
            tbl_dichvu.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 102, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PHỤ PHÍ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15), new java.awt.Color(255, 255, 255))); // NOI18N

        tbl_phuphi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Phụ phí", "Giá trị"
            }
        ));
        jScrollPane5.setViewportView(tbl_phuphi);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_songaythue1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_voucher)
                                    .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_giatri, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_ngaythue, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_songaythue)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(txt_trangthaihopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ngayquahan, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_songaythue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngaythue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_songaythue1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_voucher)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giatri, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_trangthaihopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayquahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ttxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ttxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("TT. HỢP ĐỒNG", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hợp Đồng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setInheritsPopupMenu(true);

        tblHopDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hợp Đồng", "Tên Xe", "Họ Tên", "Số Điện Thoại", "Căn Cước Công Dân", "Ngày Thuê", "Ngày Hết Hạn", "Thành Tiền", "Trạng Thái"
            }
        ));
        tblHopDong.setSelectionForeground(new java.awt.Color(255, 102, 51));
        tblHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHopDongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHopDong);

        btn_xuatdanhsach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xuatdanhsach.setForeground(new java.awt.Color(255, 102, 51));
        btn_xuatdanhsach.setText("Xuất danh sách");
        btn_xuatdanhsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatdanhsachActionPerformed(evt);
            }
        });

        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(255, 102, 51));
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        btn_bangiaoxe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_bangiaoxe.setForeground(new java.awt.Color(255, 102, 51));
        btn_bangiaoxe.setText("Bàn Giao Xe");
        btn_bangiaoxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bangiaoxeActionPerformed(evt);
            }
        });

        btn_xacnhantraxe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xacnhantraxe.setForeground(new java.awt.Color(255, 102, 51));
        btn_xacnhantraxe.setText("Xác Nhận Trả Xe");
        btn_xacnhantraxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhantraxeActionPerformed(evt);
            }
        });

        btn_sendmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sendmail.setForeground(new java.awt.Color(255, 102, 51));
        btn_sendmail.setText("Gửi Email Đến Hạn Trả Xe");
        btn_sendmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendmailActionPerformed(evt);
            }
        });

        cbb_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Đã Hủy", "Đang Thuê", "Hết Hạn", "Hoàn Thành" }));

        jLabel1.setText("Tìm Kiếm Theo Họ Tên");

        btn_locngay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_locngay.setForeground(new java.awt.Color(255, 102, 51));
        btn_locngay.setText("Lọc Theo Ngày Hiện Tại");
        btn_locngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locngayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(318, Short.MAX_VALUE)
                        .addComponent(btn_sendmail)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xacnhantraxe)
                        .addGap(18, 18, 18)
                        .addComponent(btn_bangiaoxe)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xuatdanhsach)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_timkiem))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_locngay)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_locngay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xuatdanhsach)
                    .addComponent(btn_bangiaoxe)
                    .addComponent(btn_xacnhantraxe)
                    .addComponent(btn_sendmail))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 970, -1));

        tabs.addTab("DS. HỢP ĐỒNG", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xuatdanhsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatdanhsachActionPerformed
        xuatEXCL();
    }//GEN-LAST:event_btn_xuatdanhsachActionPerformed

    private void btn_bangiaoxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bangiaoxeActionPerformed
        // TODO add your handling code here:
        banGiaoXe(mahopdong);
    }//GEN-LAST:event_btn_bangiaoxeActionPerformed

    private void btn_xacnhantraxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhantraxeActionPerformed
        // TODO add your handling code here:
        xacNhanTraXe(mahopdong);
    }//GEN-LAST:event_btn_xacnhantraxeActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        String text = txt_timkiem.getText();
        if (text.equals("")) {
            fill_Table_Hopdong(find_cbb());
            System.out.println("1");
        } else {
            fill_Table_Hopdong(find_text(text));
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void tblHopDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopDongMouseClicked
        // TODO add your handling code here:
        tabs.setSelectedIndex(0);
        int row = tblHopDong.getSelectedRow();
        mahopdong = (String) tblHopDong.getValueAt(row, 0);
        setForm(mahopdong);
    }//GEN-LAST:event_tblHopDongMouseClicked

    private void btn_locngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locngayActionPerformed
        // TODO add your handling code here:
        String text = txt_timkiem.getText();
        if (text.equals("")) {
            fill_Table_Hopdong(loctheongayhientai(find_cbb()));
        } else {
            fill_Table_Hopdong(loctheongayhientai(find_text(text)));
        }
    }//GEN-LAST:event_btn_locngayActionPerformed

    private void btn_sendmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendmailActionPerformed
        // TODO add your handling code here:
        sendMail();
    }//GEN-LAST:event_btn_sendmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anh;
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_bangiaoxe;
    private javax.swing.JButton btn_locngay;
    private javax.swing.JButton btn_sendmail;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xacnhantraxe;
    private javax.swing.JButton btn_xuatdanhsach;
    private javax.swing.JComboBox<String> cbb_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_anhxe;
    private javax.swing.JLabel lbl_songaythue;
    private javax.swing.JLabel lbl_songaythue1;
    private javax.swing.JLabel lbl_voucher;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHopDong;
    private javax.swing.JTable tbl_dichvu;
    private javax.swing.JTable tbl_phuphi;
    private javax.swing.JPanel ttxe;
    private javax.swing.JTextArea txt_Trangthai;
    private javax.swing.JTextArea txt_diachi;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_giatri;
    private javax.swing.JTextField txt_hangxe;
    private javax.swing.JTextField txt_mahopdong;
    private javax.swing.JTextField txt_maxe;
    private javax.swing.JTextField txt_ngayquahan;
    private javax.swing.JTextField txt_ngaythue;
    private javax.swing.JTextField txt_ngaytra;
    private javax.swing.JTextField txt_soghe;
    private javax.swing.JTextField txt_tenxe;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_tongtien;
    private javax.swing.JTextField txt_trangthaihopdong;
    private javax.swing.JTextField txt_voucher;
    // End of variables declaration//GEN-END:variables
    void xuatEXCL() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Hợp Đồng");
                Row titleRow = sheet.createRow(0);
                Cell titleCell = titleRow.createCell(0);
                titleCell.setCellValue("Danh sách hợp đồng");
                Row rowCol = sheet.createRow(1);// dòng thứ nhất
                for (int i = 0; i < tblHopDong.getColumnCount(); i++) {

                    Cell cell = rowCol.createCell(i);// lui sang phải
                    cell.setCellValue(tblHopDong.getColumnName(i));
                }

                for (int j = 0; j < tblHopDong.getRowCount(); j++) {
                    Row row = sheet.createRow(j+2 );//thông tin sau i
                    for (int k = 0; k < tblHopDong.getColumnCount(); k++) {
                        Cell cell = row.createCell(k );// sang phải
                        if (tblHopDong.getValueAt(j, k) != null) {
                            cell.setCellValue(tblHopDong.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                onpenFile(saveFile.toString());
            } else {
                DialogHelper.alert(this, "loiiiii");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }

    }

    void onpenFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println("e");
        }

    }
}
