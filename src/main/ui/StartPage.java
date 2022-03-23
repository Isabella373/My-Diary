package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame {
    StartPage page;

    public static void main(String[] args) {
        StartPage startPage = new StartPage();
    }


    public StartPage() {
        super("");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("My Diary");

        JPanel p = addBackground();
        this.setContentPane(p);

        p.setLayout(null);
        // helper method to add button
        addButton(p);


        this.setVisible(true);
    }

    private void addButton(JPanel p) {
        JButton loadButton = new JButton("Load");
        loadButton.setBounds(300, 400, 200, 100);
        loadButton.setFont(new Font("bold",Font.BOLD, 40));
        loadButton.setBackground(Color.GREEN);
        loadButton.setForeground(Color.BLACK);
        p.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(false);
                    new SecondPage().setVisible(true);

            }
        });
    }


    private JPanel addBackground() {

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        String path = "/Users/isabella/Desktop/CPSC 210/project_h2j2s/data/Screen Shot 2022-03-21 at 12.58.18.png";
        BackgroundPanel imgPanel = new BackgroundPanel(panelWidth, panelHeight, path);

        return imgPanel;
    }


}
