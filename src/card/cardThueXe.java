/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package card;

import DAO.DanhGiaDAO;
import DAO.DichVuDAO;
import DAO.ThemDichVuDAO;
import DAO.ChiTietXeDAO;
import DAO.VoucherDAO;
import Hepler.DialogHelper;
import entyti.DanhGia;
import entyti.DichVu;
import entyti.ThemDichVu;
import entyti.Voucher;
import entyti.ChiTietXe;
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

    private TaoHopDongDialog hopDongDialog;
    DanhGiaDAO dgd = new DanhGiaDAO();
    DichVuDAO dvd = new DichVuDAO();
    ChiTietXeDAO txd = new ChiTietXeDAO();
    ThemDichVuDAO tdvd = new ThemDichVuDAO();
    VoucherDAO vcd = new VoucherDAO();
    List<ThemDichVu> list_dichvu = new ArrayList<>();
    String diadiemnhanxe = null;
    int index = 0;
    int size = 0;
    int row = -1;
    String item = null;
    String maxe = null;
    int songaythue = 1;
    int tiendichvu = 0;
    String mavoucher = null;

    /**
     * Creates new form ThueXe
     */
    public cardThueXe() {
        initComponents();
//        setForm(locxe(item), 0);
        list_dichvu.clear();
    }
    public void kiemtravoucher(){
        String voucher  = txt_voucher.getText();
        try {
            Voucher vc = vcd.selectByID_MAVOUCHER(voucher);
            if(voucher.equalsIgnoreCase(vc.getMavoucher())){
                if(vc.getGiatri()==1){
                    DialogHelper.alert(this, "Voucher giảm giá 5%");
                }else if(vc.getGiatri()==2){
                    DialogHelper.alert(this, "Voucher giảm giá 10%");
                }else if(vc.getGiatri()==3){
                    DialogHelper.alert(this, "Voucher giảm giá 15%");
                }else{
                    DialogHelper.alert(this, "Voucher không tồn tại");
                }
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Voucher không tồn tại");
            System.out.println(e.getMessage());
        }
    }
//    public void openHopDong() {
//        try {
//            hopDongDialog = new TaoHopDongDialog(null, true, maxe, songaythue, mavoucher, list_dichvu,diadiemnhanxe);
//            hopDongDialog.setVisible(true);
//
//            // Kiểm tra trạng thái của form sau khi nó đã đóng
//            if (!hopDongDialog.isVisible()) {
//                setForm(locxe(item), 0);
//            } else {
//                System.out.println("Form vẫn còn mở.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void seticon(String string) {
        Hepler.ImagesHelper.setIconlabel(lbl_anhxe, "src\\imgxe\\" + string);

    }

//    public List<ChiTietXe> locxe(String soghe) {
//        List<ChiTietXe> list = new ArrayList<>();
//        try {
//            List<ChiTietXe> allXe = txd.selectAll();
//            if (soghe != null) {
//                for (ChiTietXe xe : allXe) {
//                    if (xe.getSoghe() == Integer.valueOf(soghe) && xe.isTrangthaixethue() == false) {
//                        list.add(xe);
//                    }
//                }
//            } else {
//                for (ChiTietXe xe : allXe) {
//                    if (xe.isTrangthaixethue() == false) {
//                        list.add(xe);
//                    }
//                }
////                list = allXe;
//            }
//        } catch (Exception e) {
//            // handle exception
//            System.out.println(e.getMessage());
//        }
//        return list;
//    }

    public void setForm(List<ChiTietXe> list, int index) {
  
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
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        anh = new javax.swing.JPanel();
        lbl_anhxe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_timtheosoghe = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_voucher = new javax.swing.JLabel();
        lbl_dichvu = new javax.swing.JLabel();
        txt_voucher = new javax.swing.JTextField();
        txt_songaythue = new javax.swing.JTextField();
        lbl_songaythue = new javax.swing.JLabel();
        lbl_songaythue1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 51));

        background.setBackground(new java.awt.Color(255, 102, 51));

        ttxe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN XE THUÊ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        ttxe.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MÃ XE");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MÃ LOẠI XE");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TÊN XE");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TRẠNG THÁI XE");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TÌM KIẾM");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HÃNG");

        lbl_timtheosoghe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_timtheosoghe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_timtheosoghe.setText("SỐ GHẾ");

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 102, 51));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "TOYOTA", "CHEVROLET", "FORD", "HONDA", "SSANGYONG", "LANDROVER" }));

        jComboBox5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(255, 102, 51));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "4", "7", "16", "29" }));

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

        javax.swing.GroupLayout ttxeLayout = new javax.swing.GroupLayout(ttxe);
        ttxe.setLayout(ttxeLayout);
        ttxeLayout.setHorizontalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ttxeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10)
                            .addComponent(jComboBox4, 0, 169, Short.MAX_VALUE)
                            .addGroup(ttxeLayout.createSequentialGroup()
                                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_timtheosoghe)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ttxeLayout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))
                            .addComponent(jTextField3)
                            .addComponent(jTextField6)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)))))
        );
        ttxeLayout.setVerticalGroup(
            ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ttxeLayout.createSequentialGroup()
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ttxeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lbl_timtheosoghe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ttxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 102, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "An Đồng", "An Hòa", "An Hòa", "An Hồng", "An Hưng", "An Lư", "An Sơn", "An Thái", "An Thắng", "An Thọ", "An Tiến", "Bạch Đằng", "Bát Trang", "Bắc Hưng", "Bắc Sơn", "Cao Minh", "Cao Nhân", "Cấp Tiến", "Chiến Thắng", "Chính Mỹ", "Cổ Am", "Cộng Hiền", "Du Lễ", "Dũng Tiến", "Dương Quan", "Đại Bản", "Đại Đồng", "Đại Hà", "Đại Hợp", "Đại Thắng", "Đặng Cương", "Đoàn Lập", "Đoàn Xá", "Đồng Bài", "Đông Hưng", "Đồng Minh", "Đông Phương", "Đông Sơn", "Đồng Thái", "Gia Đức", "Gia Luận", "Gia Minh", "Giang Biên", "Hiền Hào", "Hiệp Hòa", "Hòa Bình", "Hòa Bình", "Hoa Động", "Hoàng Châu", "Hoàng Động", "Hồng Phong", "Hồng Thái", "Hợp Thành", "Hùng Thắng", "Hùng Tiến", "Hưng Nhân", "Hữu Bằng", "Kênh Giang", "Khởi Nghĩa", "Kiền Bái", "Kiến Quốc", "Kiến Thiết", "Kỳ Sơn", "Lại Xuân", "Lâm Động", "Lập Lễ", "Lê Lợi", "Lê Thiện", "Liên Am", "Liên Khê", "Lưu Kiếm", "Lưu Kỳ", "Lý Học", "Minh Tân", "Minh Tân", "Mỹ Đồng", "Mỹ Đức", "Nam Hưng", "Nam Sơn", "Nghĩa Lộ", "Ngũ Đoan", "Ngũ Lão", "Ngũ Phúc", "Nhân Hòa", "Phả Lễ", "Phù Long", "Phù Ninh", "Phục Lễ", "Quang Hưng", "Quang Phục", "Quảng Thanh", "Quang Trung", "Quốc Tuấn", "Quốc Tuấn", "Quyết Tiến", "Tam Cường", "Tam Đa", "Tam Hưng", "Tân Dân", "Tân Dương", "Tân Hưng", "Tân Liên", "Tân Phong", "Tân Tiến", "Tân Trào", "Tân Viên", "Tây Hưng", "Thái Sơn", "Thanh Lương", "Thanh Sơn", "Thắng Thủy", "Thiên Hương", "Thuận Thiên", "Thủy Đường", "Thụy Hương", "Thủy Sơn", "Thủy Triều", "Tiên Cường", "Tiên Minh", "Tiền Phong", "Tiên Thanh", "Tiên Thắng", "Toàn Thắng", "Trân Châu", "Trấn Dương", "Trung Hà", "Trung Lập", "Trường Thành", "Trường Thọ", "Tú Sơn", "Tự Cường", "Văn Phong", "Việt Hải", "Việt Tiến", "Vĩnh An", "Vĩnh Long", "Vĩnh Phong", "Vinh Quang", "Vinh Quang", "Vĩnh Tiến", "Xuân Đám" }));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 102, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Trống)", "Đồ Sơn", "Dương Kinh", "Hải An", "Hồng Bàng", "Kiến An", "Lê Chân", "Ngô Quyền", "An Dương", "An Lão", "Bạch Long Vĩ", "Cát Hải", "Kiến Thuỵ", "Thủy Nguyên", "Tiên Lãng", "Vĩnh Bảo", "Hồng Bàng" }));

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 102, 51));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hải Phòng" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 51));
        jButton1.setText("CHỌN DỊCH VỤ");

        jComboBox6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(255, 102, 51));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Vui lòng chọn dịch vụ)", "Xăng xe", "Đưa đón sân bay", "Cứu hộ đường cao tốc", "Thuê người lái" }));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 102, 51));
        jButton2.setText("KIỂM TRA");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 102, 51));
        jButton3.setText("THUÊ");

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
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbl_dichvu)
                                    .addGap(283, 283, 283))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_songaythue1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)))
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_voucher, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2))
                                .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_songaythue)
                                        .addComponent(txt_songaythue)))))
                        .addContainerGap(71, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lbl_dichvu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_voucher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anh;
    private javax.swing.JPanel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbl_anhxe;
    private javax.swing.JLabel lbl_dichvu;
    private javax.swing.JLabel lbl_songaythue;
    private javax.swing.JLabel lbl_songaythue1;
    private javax.swing.JLabel lbl_timtheosoghe;
    private javax.swing.JLabel lbl_voucher;
    private javax.swing.JPanel ttxe;
    private javax.swing.JTextField txt_songaythue;
    private javax.swing.JTextField txt_voucher;
    // End of variables declaration//GEN-END:variables
}
