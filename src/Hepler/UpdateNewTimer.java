/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.*;

/**
 *
 * @author Hieu
 */
public class UpdateNewTimer implements Runnable {

    public interface MethodInterface {

        void execute();
    }
    private MethodInterface method;

    public UpdateNewTimer(MethodInterface method) {
        this.method = method;
    }

    @Override
    public void run() {
        while (true) {
            method.execute();
            try {
                Thread.sleep(1000); // Pause the thread for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
