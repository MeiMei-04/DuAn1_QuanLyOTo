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
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NapMaThe extends javax.swing.JFrame implements Runnable, ThreadFactory {

    ChiTietTaiKhoanDAO cttkd = new ChiTietTaiKhoanDAO();
    NapCardDAO ncd = new NapCardDAO();
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private boolean stop = false;
    Result result = null;
    private final MultiFormatReader reader = new MultiFormatReader();
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public NapMaThe() {
        initComponents();
        initWebcam();
        setTitle("Nạp Card");
        setLocationRelativeTo(null);
    }
    public void congtien(){
        TaiKhoan tk = Hepler.AuthHelper.user;
        try {
            ChiTietTaiKhoan cttk = cttkd.selectByID(String.valueOf(tk.getUserid()));
            cttk.setSodu(cttk.getSodu()+laygiatri());
            cttkd.update_1(cttk);
        } catch (Exception e) {
        }
        
    }
    public float laygiatri() {
        try {
            List<NapCard> list = ncd.selectAll();
            for (NapCard nc : list) {
                if (result.equals(nc.getManap())) {
                    return nc.getGiatri();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
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
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
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
                    result_field.setText(result.getText());
                    break; // Break the loop once a QR code is successfully read
                }
            } catch (NotFoundException e) {
                //No result...
            }

            if (stop) {
                break;
            }
        } while (true);
        congtien();
        this.dispose();
    }

    public void stop() {
        stop = true;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        pnl_qrcam = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result_field.setBorder(null);
        background.add(result_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 470, 20));

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 470, 10));

        jLabel1.setForeground(new java.awt.Color(105, 105, 105));
        jLabel1.setText("Resultado");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        pnl_qrcam.setBackground(new java.awt.Color(250, 250, 250));
        pnl_qrcam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        pnl_qrcam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background.add(pnl_qrcam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 300));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnl_qrcam;
    private javax.swing.JTextField result_field;
    // End of variables declaration//GEN-END:variables

}
