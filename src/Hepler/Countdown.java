/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author hieud
 */
public class Countdown {

    static int interval;
    static Timer timer;

    public static void demnguoc1phut() {
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 60; // 60 seconds
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(interval);
                interval--;
                if (interval == 0) {
                    timer.cancel();
                }
            }
        }, delay, period);
    }
}
