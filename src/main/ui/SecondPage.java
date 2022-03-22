package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SecondPage extends JFrame {
    public SecondPage() throws InterruptedException {
        super("");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("Loading");
        this.setVisible(true);
        //
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        String path = "/Users/isabella/Desktop/CPSC 210/project_h2j2s/data/Loading111.png";
        BackgroundPanel imgPanel = new BackgroundPanel(panelWidth, panelHeight, path);

        JPanel p = imgPanel;
        this.setContentPane(p);
        p.setLayout(null);
        this.setVisible(true);

        Timer t = new Timer(3000, null);
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                new MainPage().setVisible(true);
            }
        });
        t.start();


    }

}