package logging;

import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.*;

public class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;

    private static Logger logger = Logger.getLogger("com.liuxuhelloworld.corejava");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ExitListener());

        label = new JLabel();
        add(label);

        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener {

    }

    private class ExitListener implements ActionListener {

    }
}
