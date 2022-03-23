package ui;

import model.PreviousDiary;
import model.TodayDiary;
import persistance.JsonReader;
import persistance.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MainPage extends JFrame {
    private PreviousDiary previousDiary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STONE = "./data/todaydiary.txt";


    public MainPage() {
        super("");

        previousDiary = new PreviousDiary("My Diaries");
        jsonWriter = new JsonWriter(JSON_STONE);
        jsonReader = new JsonReader(JSON_STONE);

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("My Diary");
        this.setLayout(null);

        JPanel p = new JPanel();
        this.setContentPane(p);
        p.setLayout(null);


        JButton save = new JButton("Save");
        save.setFont(new Font("Bond", Font.BOLD, 30));
        save.setBounds(190, 0, 100, 60);
        save.setBackground(Color.GREEN);
        save.setForeground(Color.BLACK);
        save.setOpaque(true);
        p.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage.this.setVisible(false);
                new SaveSuccessPage().setVisible(true);
                savePreviousDiaries();

            }
        });

        JButton add = new JButton("+");
        add.setFont(new Font("Bond", Font.BOLD, 30));
        add.setBounds(310, 0, 100, 60);
        add.setBackground(Color.PINK);
        add.setForeground(Color.BLACK);
        add.setOpaque(true);
        p.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage.this.setVisible(false);
                new FeelingPage().setVisible(true);
            }
        });


        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Bond", Font.BOLD, 30));
        quit.setBounds(430, 0, 100, 60);
        quit.setBackground(Color.RED);
        quit.setForeground(Color.BLACK);
        quit.setOpaque(true);
        p.add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage.this.setVisible(false);
                new YesOrNoPage().setVisible(true);

            }
        });

        JButton bar = new JButton("Column Chart [HAPPY * SAD * ANGRY * CALM]");
        bar.setFont(new Font("Bond", Font.BOLD, 30));
        bar.setBounds(20, 70, 760, 60);
        bar.setBackground(Color.BLUE);
        bar.setForeground(Color.BLACK);
        bar.setOpaque(true);
        p.add(bar);
        bar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage.this.setVisible(false);
                new ImagePage().setVisible(true);
            }
        });

        loadDiaries();

        List<TodayDiary> diaries = previousDiary.getPreviousDiary();
        int i = 0;
        for (TodayDiary td : diaries) {
            JLabel text = new JLabel("");
            text.setFont(new Font("Bond", Font.BOLD, 20));
            text.setBounds(0, 160 + i, 800, 50);
            text.setBackground(Color.BLACK);
            text.setForeground(Color.WHITE);
            text.setOpaque(true);
            text.setText(td.toString());
            i = i + 60;
            p.add(text);
        }
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


    private void loadDiaries() {
        try {
            previousDiary = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STONE);

        }
    }
}
