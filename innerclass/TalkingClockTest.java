package innerclass;

import javax.swing.*;

public class TalkingClockTest {
    public static void main(String[] args) {
        TalkingClock clock1 = new TalkingClock(1000, true);
        clock1.start();

        TalkingClock clock2 = new TalkingClock(1000, false);
        TalkingClock.TimePrinter listener = clock2.new TimePrinter();
        clock2.start(listener);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
