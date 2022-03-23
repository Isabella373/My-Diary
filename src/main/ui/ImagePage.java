package ui;

import model.Category;
import model.PreviousDiary;
import model.TodayDiary;
import persistance.JsonReader;
import persistance.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ImagePage extends JFrame {

    private PreviousDiary previousDiary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STONE = "./data/todaydiary.txt";
    private ArrayList<Integer> list;

    public ImagePage() {
        super("");

        previousDiary = new PreviousDiary("My Diaries");
        jsonWriter = new JsonWriter(JSON_STONE);
        jsonReader = new JsonReader(JSON_STONE);
        list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);

        loadDiaries();

        List<TodayDiary> diaries = previousDiary.getPreviousDiary();

        for (TodayDiary td : diaries) {
            if (td.getCategory() == Category.HAPPY) {
               list.set(0,list.get(0) + 1);
            } else if (td.getCategory() == Category.SAD) {
                list.set(1, list.get(1) + 1);
            } else if (td.getCategory() == Category.ANGRY) {
                list.set(2, list.get(2) + 1);
            } else {
                list.set(3, list.get(3) + 1);
            }
        }

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("My Diary");
        this.setLayout(null);

        JPanel p = new JPanel();
        this.setContentPane(p);
        p.setLayout(null);


        ArrayList<Integer> values = list;
        ArrayList<String> labels = new ArrayList<>();
        labels.add(0,"Happy");
        labels.add(1,"Sad");
        labels.add(2,"Angry");
        labels.add(3,"Calm");

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.lightGray);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);

        String title = "Feeling Bar Chart";

        BarChart bc = new BarChart(values, labels, colors, title);
        bc.setVisible(true);
        bc.setBounds(100, 100,600,500);
        bc.setOpaque(false);



        p.add(bc);
        p.setVisible(true);
        JLabel label1 = new JLabel();
        label1.setFont(new Font("bold", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        label1.setText("Happy " + list.get(0).toString());
        p.setLayout(null);
        p.add(label1);

        label1.setBounds(120, 600,150, 30);

        JLabel label2 = new JLabel();
        label2.setFont(new Font("bold", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);
        label2.setText("Sad " + list.get(1).toString());
        p.add(label2);
        label2.setBounds(290, 600,150, 30);

        JLabel label3 = new JLabel();
        label3.setFont(new Font("bold", Font.BOLD, 20));
        label3.setForeground(Color.BLACK);
        label3.setText("Angry " + list.get(2).toString());
        p.add(label3);
        label3.setBounds(450, 600,150, 30);

        JLabel label4 = new JLabel();
        label4.setFont(new Font("bold", Font.BOLD, 20));
        label4.setForeground(Color.BLACK);
        label4.setText("Calm " + list.get(3).toString());
        p.add(label4);
        label4.setBounds(580, 600,150, 30);



    }

    private void loadDiaries() {
        try {
            previousDiary = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STONE);

        }
    }



}
