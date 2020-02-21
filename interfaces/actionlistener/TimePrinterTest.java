package interfaces.actionlistener;

import javax.swing.*;

public class TimePrinterTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();

        Timer timer = new Timer(1000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
