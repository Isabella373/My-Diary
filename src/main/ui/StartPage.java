package ui;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JFrame {

    public static void main(String[] args) {
        StartPage startPage = new StartPage();
    }



    public StartPage() {
        super("");

        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("My Diary");
        //this.setLayout(null);

        JPanel p = addBackground();
        this.setContentPane(p);

        p.setLayout(null);
        // helper method to add button
        addButton(p);


        this.setVisible(true);
    }

    private void addButton(JPanel p) {
        JButton loadButton = new JButton("Load");
        loadButton.setBackground(Color.GREEN);
        loadButton.setForeground(Color.BLACK);
        loadButton.setBounds(150, 100, 200, 100);
        p.add(loadButton);

        //loadButton.addActionListener(new ActionListener() {
           // @Override
           // public void actionPerformed(ActionEvent e) {
            //    startPage.dispose();

                //JFrame frame = new SecondPage();
                //frame.setVisible(true);
                //frame.setSize(600,600);
                //frame.setLocation(100,50);
         //   }
      //  });

    }


    private JPanel addBackground() {

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        String path = "/Users/isabella/Desktop/CPSC 210/project_h2j2s/data/Screen Shot 2022-03-21 at 12.58.18.png";
        BackgroundPanel imgPanel = new BackgroundPanel(panelWidth, panelHeight, path);

        return imgPanel;
    }


}
