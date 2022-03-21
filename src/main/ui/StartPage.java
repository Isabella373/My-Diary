package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.UserGUI.init;

public class StartPage extends JFrame {
    private JPanel contentPane;


    public static void main(String[] args) {
        init();
    }

    public StartPage() {

        JFrame frame = new JFrame("");
        frame.setSize(600,2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle();

        JPanel panel = new JPanel();
        frame.add(panel);

        // setting the width and the height of frame
/*
        JLayeredPane lp = new JLayeredPane();
        JPanel jp = new JPanel();
        JLabel l = new JLabel();

        String str1 = "data/backGround1/Screen Shot ";
        String str2 = "2022-03-21 at 09.31.13.png";
        String path = str1 + str2;
        ImageIcon img = new ImageIcon(path);

        l.setIcon(img);

        jp.setBounds(0,0, img.getIconWidth(),img.getIconHeight());
        jp.add(l);


        lp.add(jp, JLayeredPane.DEFAULT_LAYER);

        frame.setLayeredPane(lp);
        */

        addButton(panel);

        addBackground();




    }


    private void setTitle() {
        setTitle("My Diary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //must not ignore setLayout method
        contentPane.setLayout(null);
    }

    private static void addButton(JPanel panel) {
        panel.setLayout(null);
        // helper method to add button
        JButton loadButton = new JButton("Load");
        loadButton.setBackground(Color.GREEN);
        loadButton.setForeground(Color.BLACK);
        loadButton.setBounds(300,100,200,100);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new SecondPage("Main Panel");
                frame.setVisible(true);
                frame.setLayout(null);

            }
        });
        panel.add(loadButton);

    }


    private void addBackground() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        double panelWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double panelHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 25 - 25 - 20;
        String path = "data/Screen Shot 2022-03-21 at 12.58.18.png";
        BackgroundPanel imgPanel = new BackgroundPanel(panelWidth, panelHeight,path);
        imgPanel.setOpaque(false);
        setLayout(null);

        this.contentPane.add(imgPanel, -1);
    }



}
