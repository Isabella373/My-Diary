package ui;

import model.PreviousDiary;
import persistance.JsonReader;
import persistance.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;




public class YesOrNoPage extends JFrame {
    private PreviousDiary previousDiary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STONE = "./data/todaydiary.txt";

    public YesOrNoPage() {
        super("");

        previousDiary = new PreviousDiary("My Diaries");
        jsonWriter = new JsonWriter(JSON_STONE);
        jsonReader = new JsonReader(JSON_STONE);

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("Save Or Not");

        JPanel p = addBackground();
        this.setContentPane(p);

        addButton1(p);
        addButton2(p);

        JLabel label = new JLabel();
        label.setFont(new Font("italic",Font.ITALIC,40));
        label.setText("Do You Want to Save your Diary");
        label.setBounds(60,300,1000,200);
        p.add(label);

        p.setLayout(null);

        this.setVisible(true);
    }

    private void addButton2(JPanel p) {
        JButton button2 = new JButton("YES");
        button2.setBounds(100, 450, 200, 60);
        button2.setFont(new Font("bold",Font.BOLD, 30));
        button2.setBackground(Color.GREEN);
        button2.setForeground(Color.BLACK);
        button2.setOpaque(true);
        p.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveSuccessPage().setVisible(true);
                savePreviousDiaries();
            }
        });
    }

    // EFFECTS: saves all the diaries to file
    private void savePreviousDiaries() {
        // EFFECTS: saves all the diaries to file

        try {
            jsonWriter.open();
            jsonWriter.write(previousDiary);
            jsonWriter.close();
            System.out.println("Saved" + previousDiary.getName() + "to " + JSON_STONE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STONE);
        }

    }


    private void addButton1(JPanel p) {
        JButton button1 = new JButton("NO");
        button1.setBounds(350, 450, 200, 60);
        button1.setFont(new Font("bold",Font.BOLD, 30));
        button1.setBackground(Color.RED);
        button1.setOpaque(true);
        button1.setForeground(Color.BLACK);
        p.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GoodbyePage().setVisible(true);
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
