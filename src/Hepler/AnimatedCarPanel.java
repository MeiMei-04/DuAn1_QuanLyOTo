/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Hieu
 */
public class AnimatedCarPanel extends JPanel {
    private int xOffset = 0;
    private boolean movingRight = true;

    public AnimatedCarPanel() {
        Timer timer = new Timer(10, e -> {
            if (movingRight) {
                xOffset++;
                if (xOffset > getWidth() - 150) {
                    movingRight = false;
                }
            } else {
                xOffset--;
                if (xOffset < 0) {
                    movingRight = true;
                }
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.fillRect(xOffset + 75, 150, 150, 75);
        g2.fillRect(xOffset + 105, 105, 90, 45);
        g2.setColor(Color.BLACK);
        g2.fillOval(xOffset + 90, 210, 45, 45);
        g2.fillOval(xOffset + 165, 210, 45, 45);
    }
}