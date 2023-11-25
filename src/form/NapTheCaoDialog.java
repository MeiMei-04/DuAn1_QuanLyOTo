/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import DAO.ChiTietTaiKhoanDAO;
import DAO.NapCardDAO;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import entyti.ChiTietTaiKhoan;
import entyti.NapCard;
import entyti.TaiKhoan;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author HieuCute
 */
public class NapTheCaoDialog extends javax.swing.JDialog implements Runnable, ThreadFactory {

    boolean flag = false;
    ChiTietTaiKhoanDAO cttkd = new ChiTietTaiKhoanDAO();
    NapCardDAO ncd = new NapCardDAO();
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private boolean stop = false;
    Result result = null;
    private final MultiFormatReader reader = new MultiFormatReader();
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    /**
     * Creates new form NapTheCaoDialog
     */
    public NapTheCaoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initWebcam();
        setTitle("Nạp Card");
        setLocationRelativeTo(null);
    }

    public void congtien() {
        TaiKhoan tk = Hepler.AuthHelper.user;
        try {
            ChiTietTaiKhoan cttk = cttkd.selectByID(String.valueOf(tk.getUserid()));
            float tongtien = -1;
            tongtien = cttk.getSodu() + laygiatri();
            if (laygiatri() < 0) {
                Hepler.DialogHelper.alert(this, "Thẻ Đã Tồn Tại");
                return;
            }
            cttk.setSodu(tongtien);
            cttkd.update_1(cttk);
            Hepler.DialogHelper.alert(this, "Nạp Thành Công");
            ncd.delete(String.valueOf(result));
        } catch (Exception e) {
            Hepler.DialogHelper.alert(this, "Nạp Thất Bại");
            System.out.println(e.getMessage());
        }

    }

    public float laygiatri() {
        try {
            NapCard nc = ncd.selectByID(String.valueOf(result));
            return nc.getGiatri();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -2;
        }
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        pnl_qrcam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis(); // Get the start time
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                break;
            }

            // Check if 30 seconds have passed
            if (System.currentTimeMillis() - startTime > 20000) {
                System.out.println("20 seconds have passed");
                break;
            }

            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            } else {
                System.out.println("Webcam is not open");
                break;
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = reader.decode(bitmap);
                if (result != null) {
                    laygiatri();
                    congtien();
                    break; // Break the loop once a QR code is successfully read
                }
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }

            if (stop) {
                break;
            }
        } while (true);
        webcam.close();
        this.dispose();

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
        pnl_qrcam = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_qrcam.setBackground(new java.awt.Color(250, 250, 250));
        pnl_qrcam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        pnl_qrcam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background.add(pnl_qrcam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel pnl_qrcam;
    // End of variables declaration//GEN-END:variables

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
