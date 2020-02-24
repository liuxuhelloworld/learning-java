package innerclass.local;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.*;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TalkingClock 2, the time is " + Instant.ofEpochMilli(e.getWhen()));
                // if (beep) {
                if (TalkingClock.this.beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener  = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public void start(int interval, boolean beep) {
        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TalkingClock 3, the time is " + Instant.ofEpochMilli(e.getWhen()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}
