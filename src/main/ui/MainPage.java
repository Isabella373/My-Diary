package ui;

import model.PreviousDiary;
import model.TodayDiary;
import persistance.JsonReader;
import persistance.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MainPage extends JFrame {
    JButton bar;
    JLabel text;
    JButton save;
    JButton add;
    JButton quit;
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
        p.setOpaque(false);
        p.setLayout(null);


        save = new JButton("Save");
        save.setFont(new Font("Bond", Font.BOLD, 30));
        save.setBounds(190, 0, 100, 60);
        save.setBorderPainted(true);
        save.setBackground(Color.GREEN);
        save.setForeground(Color.BLACK);
        save.setOpaque(true);
        p.add(save);

        add = new JButton("+");
        add.setFont(new Font("Bond", Font.BOLD, 30));
        add.setBounds(310, 0, 100, 60);
        add.setBorderPainted(true);
        add.setBackground(Color.PINK);
        add.setForeground(Color.BLACK);
        add.setOpaque(true);
        p.add(add);

        quit = new JButton("Quit");
        quit.setFont(new Font("Bond", Font.BOLD, 30));
        quit.setBounds(430, 0, 100, 60);
        quit.setBorderPainted(true);
        quit.setBackground(Color.RED);
        quit.setForeground(Color.BLACK);
        quit.setOpaque(true);
        p.add(quit);

        bar = new JButton("Column Chart [HAPPY * SAD * ANGRY * CALM]");
        bar.setFont(new Font("Bond", Font.BOLD, 30));
        bar.setBounds(20, 70, 760, 60);
        bar.setBorderPainted(true);
        bar.setBackground(Color.BLUE);
        bar.setForeground(Color.BLACK);
        bar.setOpaque(true);
        p.add(bar);

        loadDiaries();

        String str = printDiaries();
        text = new JLabel(str);
        text.setFont(new Font("Bond", Font.BOLD, 20));
        text.setBounds(0, 150, 800, 700);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setOpaque(true);
        p.add(text);

    }

    private String printDiaries() {
        List<TodayDiary> diaries = previousDiary.getPreviousDiary();
        String tx = "";
        for (TodayDiary td : diaries) {
            tx = tx + td.toString() + "\r\n";
        }
        return tx;
    }

    private void loadDiaries() {
        try {
            previousDiary = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STONE);

        }
    }
}
