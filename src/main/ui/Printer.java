package ui;

import exception.LogException;
import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a screen printer for printing event log to screen.
 */
public class Printer extends JInternalFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JTextArea logArea;

    /**
     * Constructor sets up window in which log will be printed on screen
     *
     * @param parent the parent component
     */
    public Printer(Component parent) {
        super("Event log", false, true, false, false);
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane);
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    public void printLog(EventLog el) throws LogException {
        String text = "";
        for (Event next : el) {
            text = text + next.toString() + "\n\n";
        }
        System.out.println(text);
    }

    /**
     * Sets the position of window in which log will be printed relative to
     * parent
     *
     * @param parent the parent component
     */
    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - getWidth() - 20,
                parent.getHeight() - getHeight() - 20);
    }
}
