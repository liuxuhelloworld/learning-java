package innerclass.anonymous;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.*;

public class TalkingClock {
    public static String getClassName() {
        return new Object(){}.getClass().getEnclosingClass().getName();
    }

    public void start(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TalkingClock 4, the time is " + Instant.ofEpochMilli(e.getWhen()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };

        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}
