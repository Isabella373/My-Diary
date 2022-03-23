package ui;

import javax.swing.*;
import java.awt.*;

public class SaveSuccessPage extends JFrame {
    public SaveSuccessPage() {
        super("");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("Successfully Saved");

        JPanel p = addBackground();
        this.setContentPane(p);

        addButton(p);

        p.setLayout(null);

        this.setVisible(true);
    }


    private void addButton(JPanel p) {
        JButton loadButton = new JButton("Successfully Saved");
        loadButton.setBounds(100, 400, 500, 100);
        loadButton.setFont(new Font("bold",Font.BOLD, 40));
        loadButton.setBackground(Color.GREEN);
        loadButton.setForeground(Color.BLACK);
        p.add(loadButton);
    }


    private JPanel addBackground() {

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        String path = "/Users/isabella/Desktop/CPSC 210/project_h2j2s/data/Screen Shot 2022-03-21 at 12.58.18.png";
        BackgroundPanel imgPanel = new BackgroundPanel(panelWidth, panelHeight, path);

        return imgPanel;
    }
}