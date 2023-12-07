/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import card.cardTaiKhoan;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import Hepler.AuthHelper;
import Hepler.openweb;
import card.cardThongKe;
import card.cardDichVu;
import card.cardHopDong;
import card.cardSuaChuaBaoDuong;
import card.cardTaiKhoan_QuanLy;
import card.cardThueXe;
import card.cardTrangChu;
import card.cardXeThue;

/**
 *
 * @author truon
 */
public class TrangChu extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public TrangChu() {
        initComponents();
        setTitle("Quản Lý Thuê Oto");
        seticon();
        setIconImage(Hepler.ImagesHelper.getAppIcon());
        openDangNhap();
        showFrom(new cardTrangChu());
        updateStatus_off();
    }
    public void openGioiThieu(){
        String filePath = "src\\POLYCAR-main\\contact.html";
        try {
            Hepler.openweb.openWebPage(filePath);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateStatus_off() {
        pnl_baoduong.setVisible(false);
        pnl_thongke.setVisible(false);
        pnl_dichvu.setVisible(false);
        pnl_taikhoan.setVisible(false);
        pnl_thuexe.setVisible(false);
        pnl_hopdong.setVisible(false);
    }

    public void updateStatus_on_true() {
        pnl_baoduong.setVisible(true);
        pnl_thongke.setVisible(true);
        pnl_dichvu.setVisible(true);
        pnl_taikhoan.setVisible(true);
        pnl_thuexe.setVisible(true);
        pnl_hopdong.setVisible(true);
    }

    public void updateStatus_on_false() {
        pnl_taikhoan.setVisible(true);
        pnl_thuexe.setVisible(true);
        pnl_hopdong.setVisible(true);
    }

    public void openChucnang() {
        try {
            if (!AuthHelper.authenticated()) {
                new DangNhapDialog(this, false).setVisible(true);
            } else {
                if (AuthHelper.isManager()) {
                    updateStatus_on_true();
                } else {
                    updateStatus_on_false();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // bó tay
    public void openBaoDuong() {
        try {
            if (!AuthHelper.authenticated()) {
                new DangNhapDialog(this, false).setVisible(true);
            } else {
                if (AuthHelper.isManager()) {
                    showFrom(new cardSuaChuaBaoDuong());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openThongKe() {
        try {
            if (!AuthHelper.authenticated()) {
                new DangNhapDialog(this, false).setVisible(true);
            } else {
                if (AuthHelper.isManager()) {
                    showFrom(new cardThongKe());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openDangXuat() {
        try {
            if (!AuthHelper.authenticated()) {
                new DangNhapDialog(this, false).setVisible(true);
            } else {
                AuthHelper.logoff();
                updateStatus_off();
                showFrom(new cardTrangChu());
                new DangNhapDialog(this, false).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openDangNhap() {
        try {
            if (!AuthHelper.authenticated()) {
                new DangNhapDialog(this, false).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openThueXe() {
        try {
            if (AuthHelper.authenticated()) {
                if (AuthHelper.isManager()) {
                    showFrom(new cardXeThue());
                } else {
                    showFrom(new cardThueXe());

                }
            } else {
                openDangNhap();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openTaiKhoan() {
        try {
            if (AuthHelper.authenticated()) {

                if (AuthHelper.isManager()) {
                    showFrom(new cardTaiKhoan_QuanLy());
                } else {
                    showFrom(new cardTaiKhoan());

                }
            } else {
                openDangNhap();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openDichVu() {
        try {
            if (AuthHelper.authenticated()) {

                if (AuthHelper.isManager()) {
                    showFrom(new cardDichVu());
                }
            } else {
                openDangNhap();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // đăng khoa
    public void openHopDong() {
        try {
            if (AuthHelper.authenticated()) {
                showFrom(new cardHopDong());
            } else {
                openDangNhap();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void seticon() {
        Hepler.ImagesHelper.setIconlabel(lbl_logo, "src\\IMAGE\\car_logo.png");
        Hepler.ImagesHelper.setIconlabel(lbl_TrangChu, "src\\IMAGE\\home.png");
        Hepler.ImagesHelper.setIconlabel(lbl_taikhoan, "src\\IMAGE\\user.png");
        Hepler.ImagesHelper.setIconlabel(lbl_thuexe, "src\\IMAGE\\car-rental.png");
        Hepler.ImagesHelper.setIconlabel(lbl_hopdong, "src\\IMAGE\\rental.png");
        Hepler.ImagesHelper.setIconlabel(lbl_DichVU, "src\\IMAGE\\car.png");
        Hepler.ImagesHelper.setIconlabel(lbl_ThongKe, "src\\IMAGE\\contract.png");
        Hepler.ImagesHelper.setIconlabel(lbl_BaoDuong, "src\\IMAGE\\maintenance.png");
        Hepler.ImagesHelper.setIconlabel(lbl_gioithieu, "src\\IMAGE\\earth-globe.png");
        Hepler.ImagesHelper.setIconlabel(lbl_DangXuat, "src\\IMAGE\\log-out.png");
        Hepler.ImagesHelper.setIconlabel(lbl_chucnang, "src\\IMAGE\\cross-functional.png");
    }

    private void onHover(JPanel panel) {
        panel.setBackground(new Color(255, 140, 76));
    }

    private void onClick(JPanel panel) {
        panel.setBackground(new Color(255, 153, 0));
    }

    private void onLeaveClick(JPanel panel) {
        panel.setBackground(new Color(255, 102, 51));
    }

    private void onLeaveHover(JPanel panel) {
        panel.setBackground(new Color(255, 102, 51));
    }

    public void showFrom(Component com) {
        pnl_Body.removeAll();
        pnl_Body.add(com);
        pnl_Body.revalidate();
        pnl_Body.repaint();
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
        pnl_Menu = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        pnl_TrangChu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_TrangChu = new javax.swing.JLabel();
        pnl_taikhoan = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_taikhoan = new javax.swing.JLabel();
        pnl_thuexe = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbl_thuexe = new javax.swing.JLabel();
        pnl_hopdong = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lbl_hopdong = new javax.swing.JLabel();
        pnl_dichvu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lbl_DichVU = new javax.swing.JLabel();
        pnl_thongke = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lbl_ThongKe = new javax.swing.JLabel();
        pnl_baoduong = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lbl_BaoDuong = new javax.swing.JLabel();
        pnl_dangxuat = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lbl_DangXuat = new javax.swing.JLabel();
        pnl_gioithieu = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lbl_gioithieu = new javax.swing.JLabel();
        pnl_chucnang = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lbl_chucnang = new javax.swing.JLabel();
        pnl_Body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 204));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1200, 680));

        pnl_Menu.setBackground(new java.awt.Color(255, 102, 0));
        pnl_Menu.setPreferredSize(new java.awt.Dimension(200, 680));

        pnl_TrangChu.setBackground(new java.awt.Color(255, 102, 0));
        pnl_TrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_TrangChuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_TrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_TrangChuMouseExited(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_TrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TrangChu.setText("TRANG CHỦ");

        javax.swing.GroupLayout pnl_TrangChuLayout = new javax.swing.GroupLayout(pnl_TrangChu);
        pnl_TrangChu.setLayout(pnl_TrangChuLayout);
        pnl_TrangChuLayout.setHorizontalGroup(
            pnl_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TrangChuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_TrangChuLayout.setVerticalGroup(
            pnl_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_taikhoan.setBackground(new java.awt.Color(255, 102, 0));
        pnl_taikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_taikhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_taikhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_taikhoanMouseExited(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_taikhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_taikhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_taikhoan.setText("TÀI KHOẢN");

        javax.swing.GroupLayout pnl_taikhoanLayout = new javax.swing.GroupLayout(pnl_taikhoan);
        pnl_taikhoan.setLayout(pnl_taikhoanLayout);
        pnl_taikhoanLayout.setHorizontalGroup(
            pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_taikhoan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_taikhoanLayout.setVerticalGroup(
            pnl_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_taikhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_taikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_thuexe.setBackground(new java.awt.Color(255, 102, 0));
        pnl_thuexe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_thuexeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_thuexeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_thuexeMouseExited(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_thuexe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_thuexe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_thuexe.setText("THUÊ XE");

        javax.swing.GroupLayout pnl_thuexeLayout = new javax.swing.GroupLayout(pnl_thuexe);
        pnl_thuexe.setLayout(pnl_thuexeLayout);
        pnl_thuexeLayout.setHorizontalGroup(
            pnl_thuexeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_thuexeLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_thuexe, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_thuexeLayout.setVerticalGroup(
            pnl_thuexeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_thuexeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_thuexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_hopdong.setBackground(new java.awt.Color(255, 102, 0));
        pnl_hopdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_hopdongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_hopdongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_hopdongMouseExited(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_hopdong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_hopdong.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hopdong.setText("HỢP ĐỒNG");

        javax.swing.GroupLayout pnl_hopdongLayout = new javax.swing.GroupLayout(pnl_hopdong);
        pnl_hopdong.setLayout(pnl_hopdongLayout);
        pnl_hopdongLayout.setHorizontalGroup(
            pnl_hopdongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_hopdongLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_hopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_hopdongLayout.setVerticalGroup(
            pnl_hopdongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_hopdongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_hopdong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_dichvu.setBackground(new java.awt.Color(255, 102, 0));
        pnl_dichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_dichvuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_dichvuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_dichvuMouseExited(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_DichVU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_DichVU.setForeground(new java.awt.Color(255, 255, 255));
        lbl_DichVU.setText("DỊCH VỤ");

        javax.swing.GroupLayout pnl_dichvuLayout = new javax.swing.GroupLayout(pnl_dichvu);
        pnl_dichvu.setLayout(pnl_dichvuLayout);
        pnl_dichvuLayout.setHorizontalGroup(
            pnl_dichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dichvuLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_DichVU, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_dichvuLayout.setVerticalGroup(
            pnl_dichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_dichvuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_DichVU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_thongke.setBackground(new java.awt.Color(255, 102, 0));
        pnl_thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_thongkeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_thongkeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_thongkeMouseExited(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_ThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ThongKe.setText("THỐNG KÊ");

        javax.swing.GroupLayout pnl_thongkeLayout = new javax.swing.GroupLayout(pnl_thongke);
        pnl_thongke.setLayout(pnl_thongkeLayout);
        pnl_thongkeLayout.setHorizontalGroup(
            pnl_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_thongkeLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_thongkeLayout.setVerticalGroup(
            pnl_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_thongkeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_baoduong.setBackground(new java.awt.Color(255, 102, 0));
        pnl_baoduong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_baoduongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_baoduongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_baoduongMouseExited(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_BaoDuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_BaoDuong.setForeground(new java.awt.Color(255, 255, 255));
        lbl_BaoDuong.setText("BẢO DƯỠNG");

        javax.swing.GroupLayout pnl_baoduongLayout = new javax.swing.GroupLayout(pnl_baoduong);
        pnl_baoduong.setLayout(pnl_baoduongLayout);
        pnl_baoduongLayout.setHorizontalGroup(
            pnl_baoduongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_baoduongLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_BaoDuong, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_baoduongLayout.setVerticalGroup(
            pnl_baoduongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_baoduongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_BaoDuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_dangxuat.setBackground(new java.awt.Color(255, 102, 0));
        pnl_dangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_dangxuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_dangxuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_dangxuatMouseExited(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_DangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_DangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lbl_DangXuat.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout pnl_dangxuatLayout = new javax.swing.GroupLayout(pnl_dangxuat);
        pnl_dangxuat.setLayout(pnl_dangxuatLayout);
        pnl_dangxuatLayout.setHorizontalGroup(
            pnl_dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dangxuatLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_dangxuatLayout.setVerticalGroup(
            pnl_dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_dangxuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_DangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_gioithieu.setBackground(new java.awt.Color(255, 102, 0));
        pnl_gioithieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_gioithieuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_gioithieuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_gioithieuMouseExited(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_gioithieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_gioithieu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gioithieu.setText("GIỚI THIỆU");

        javax.swing.GroupLayout pnl_gioithieuLayout = new javax.swing.GroupLayout(pnl_gioithieu);
        pnl_gioithieu.setLayout(pnl_gioithieuLayout);
        pnl_gioithieuLayout.setHorizontalGroup(
            pnl_gioithieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gioithieuLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_gioithieu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        pnl_gioithieuLayout.setVerticalGroup(
            pnl_gioithieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_gioithieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_gioithieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_chucnang.setBackground(new java.awt.Color(255, 102, 0));
        pnl_chucnang.setPreferredSize(new java.awt.Dimension(154, 32));
        pnl_chucnang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_chucnangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_chucnangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_chucnangMouseExited(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_chucnang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_chucnang.setForeground(new java.awt.Color(255, 255, 255));
        lbl_chucnang.setText("CHỨC NĂNG");

        javax.swing.GroupLayout pnl_chucnangLayout = new javax.swing.GroupLayout(pnl_chucnang);
        pnl_chucnang.setLayout(pnl_chucnangLayout);
        pnl_chucnangLayout.setHorizontalGroup(
            pnl_chucnangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_chucnangLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_chucnang)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnl_chucnangLayout.setVerticalGroup(
            pnl_chucnangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_chucnangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_chucnang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_MenuLayout = new javax.swing.GroupLayout(pnl_Menu);
        pnl_Menu.setLayout(pnl_MenuLayout);
        pnl_MenuLayout.setHorizontalGroup(
            pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_MenuLayout.createSequentialGroup()
                .addGroup(pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_MenuLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_MenuLayout.createSequentialGroup()
                        .addGroup(pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pnl_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_taikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_thuexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_hopdong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_dichvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_baoduong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl_dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_gioithieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addGroup(pnl_MenuLayout.createSequentialGroup()
                        .addComponent(pnl_chucnang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_MenuLayout.setVerticalGroup(
            pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_MenuLayout.createSequentialGroup()
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_gioithieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_chucnang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_thuexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_hopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_baoduong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_dichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_Body.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Body.setOpaque(false);
        pnl_Body.setPreferredSize(new java.awt.Dimension(985, 680));
        pnl_Body.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(pnl_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl_Body, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_Menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_TrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_TrangChuMouseClicked
        // TODO add your handling code here:
        onClick(pnl_TrangChu);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
        showFrom(new cardTrangChu());
    }//GEN-LAST:event_pnl_TrangChuMouseClicked

    private void pnl_taikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_taikhoanMouseClicked
        // TODO add your handling code here:
        onClick(pnl_taikhoan);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
        openTaiKhoan();
    }//GEN-LAST:event_pnl_taikhoanMouseClicked

    private void pnl_thuexeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_thuexeMouseClicked
        // TODO add your handling code here:
        onClick(pnl_thuexe);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
        openThueXe();
    }//GEN-LAST:event_pnl_thuexeMouseClicked

    private void pnl_hopdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_hopdongMouseClicked
        // TODO add your handling code here:
        onClick(pnl_hopdong);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
//        openHopDong();
    }//GEN-LAST:event_pnl_hopdongMouseClicked

    private void pnl_dichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dichvuMouseClicked
        // TODO add your handling code here:
        onClick(pnl_dichvu);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
        openDichVu();
    }//GEN-LAST:event_pnl_dichvuMouseClicked

    private void pnl_thongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_thongkeMouseClicked
        // TODO add your handling code here:
        onClick(pnl_thongke);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
        openThongKe();
    }//GEN-LAST:event_pnl_thongkeMouseClicked

    private void pnl_baoduongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_baoduongMouseClicked
        // TODO add your handling code here:
        onClick(pnl_baoduong);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
//        openBaoDuong();
    }//GEN-LAST:event_pnl_baoduongMouseClicked

    private void pnl_gioithieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_gioithieuMouseClicked
        // TODO add your handling code here:
        onClick(pnl_gioithieu);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_chucnang);
//        openGioiThieu();
    }//GEN-LAST:event_pnl_gioithieuMouseClicked

    private void pnl_dangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dangxuatMouseClicked
        // TODO add your handling code here:
        onClick(pnl_dangxuat);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_TrangChu);
        onLeaveClick(pnl_chucnang);
        openDangXuat();
    }//GEN-LAST:event_pnl_dangxuatMouseClicked

    private void pnl_TrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_TrangChuMouseEntered
        // TODO add your handling code here:
        onHover(pnl_TrangChu);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_TrangChuMouseEntered

    private void pnl_taikhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_taikhoanMouseEntered
        // TODO add your handling code here:
        onHover(pnl_taikhoan);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_taikhoanMouseEntered

    private void pnl_thuexeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_thuexeMouseEntered
        // TODO add your handling code here:
        onHover(pnl_thuexe);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_thuexeMouseEntered

    private void pnl_hopdongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_hopdongMouseEntered
        // TODO add your handling code here:
        onHover(pnl_hopdong);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_hopdongMouseEntered

    private void pnl_dichvuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dichvuMouseEntered
        // TODO add your handling code here:
        onHover(pnl_dichvu);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_dichvuMouseEntered

    private void pnl_thongkeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_thongkeMouseEntered
        // TODO add your handling code here:
        onHover(pnl_thongke);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_thongkeMouseEntered

    private void pnl_baoduongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_baoduongMouseEntered
        // TODO add your handling code here:
        onHover(pnl_baoduong);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_baoduongMouseEntered

    private void pnl_gioithieuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_gioithieuMouseEntered
        // TODO add your handling code here:
        onHover(pnl_gioithieu);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_dangxuat);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_gioithieuMouseEntered

    private void pnl_dangxuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dangxuatMouseEntered
        // TODO add your handling code here:
        onHover(pnl_dangxuat);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_chucnang);
    }//GEN-LAST:event_pnl_dangxuatMouseEntered

    private void pnl_TrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_TrangChuMouseExited
        // TODO add your handling code here:
        pnl_TrangChu.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_TrangChuMouseExited

    private void pnl_taikhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_taikhoanMouseExited
        // TODO add your handling code here:
        pnl_taikhoan.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_taikhoanMouseExited

    private void pnl_thuexeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_thuexeMouseExited
        // TODO add your handling code here:
        pnl_thuexe.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_thuexeMouseExited

    private void pnl_hopdongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_hopdongMouseExited
        // TODO add your handling code here:
        pnl_hopdong.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_hopdongMouseExited

    private void pnl_dichvuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dichvuMouseExited
        // TODO add your handling code here:
        pnl_dichvu.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_dichvuMouseExited

    private void pnl_thongkeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_thongkeMouseExited
        // TODO add your handling code here:
        pnl_thongke.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_thongkeMouseExited

    private void pnl_baoduongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_baoduongMouseExited
        // TODO add your handling code here:
        pnl_baoduong.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_baoduongMouseExited

    private void pnl_gioithieuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_gioithieuMouseExited
        // TODO add your handling code here:
        pnl_gioithieu.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_gioithieuMouseExited

    private void pnl_dangxuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dangxuatMouseExited
        // TODO add your handling code here:
        pnl_dangxuat.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_dangxuatMouseExited

    private void pnl_chucnangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_chucnangMouseClicked
        // TODO add your handling code here:
        onClick(pnl_chucnang);
        onLeaveClick(pnl_taikhoan);
        onLeaveClick(pnl_thuexe);
        onLeaveClick(pnl_hopdong);
        onLeaveClick(pnl_dichvu);
        onLeaveClick(pnl_thongke);
        onLeaveClick(pnl_baoduong);
        onLeaveClick(pnl_gioithieu);
        onLeaveClick(pnl_dangxuat);
        onLeaveClick(pnl_TrangChu);
        openChucnang();
    }//GEN-LAST:event_pnl_chucnangMouseClicked

    private void pnl_chucnangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_chucnangMouseEntered
        // TODO add your handling code here:
        onHover(pnl_chucnang);
        onLeaveHover(pnl_taikhoan);
        onLeaveHover(pnl_thuexe);
        onLeaveHover(pnl_hopdong);
        onLeaveHover(pnl_dichvu);
        onLeaveHover(pnl_thongke);
        onLeaveHover(pnl_baoduong);
        onLeaveHover(pnl_gioithieu);
        onLeaveHover(pnl_TrangChu);
        onLeaveHover(pnl_dangxuat);
    }//GEN-LAST:event_pnl_chucnangMouseEntered

    private void pnl_chucnangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_chucnangMouseExited
        pnl_chucnang.setBackground(new Color(255, 102, 0));
    }//GEN-LAST:event_pnl_chucnangMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_BaoDuong;
    private javax.swing.JLabel lbl_DangXuat;
    private javax.swing.JLabel lbl_DichVU;
    private javax.swing.JLabel lbl_ThongKe;
    private javax.swing.JLabel lbl_TrangChu;
    private javax.swing.JLabel lbl_chucnang;
    private javax.swing.JLabel lbl_gioithieu;
    private javax.swing.JLabel lbl_hopdong;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_taikhoan;
    private javax.swing.JLabel lbl_thuexe;
    private javax.swing.JPanel pnl_Body;
    private javax.swing.JPanel pnl_Menu;
    private javax.swing.JPanel pnl_TrangChu;
    private javax.swing.JPanel pnl_baoduong;
    private javax.swing.JPanel pnl_chucnang;
    private javax.swing.JPanel pnl_dangxuat;
    private javax.swing.JPanel pnl_dichvu;
    private javax.swing.JPanel pnl_gioithieu;
    private javax.swing.JPanel pnl_hopdong;
    private javax.swing.JPanel pnl_taikhoan;
    private javax.swing.JPanel pnl_thongke;
    private javax.swing.JPanel pnl_thuexe;
    // End of variables declaration//GEN-END:variables
}
