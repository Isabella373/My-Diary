package ui;

import model.Category;
import model.PreviousDiary;
import model.TodayDiary;
import persistance.JsonReader;
import persistance.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        newList();

        loadDiaries();
        List<TodayDiary> diaries = previousDiary.getPreviousDiary();

        generateList(diaries);

        JPanel p = setBase();


        ArrayList<Integer> values = list;
        ArrayList<String> labels = labelList();

        ArrayList<Color> colors = colorList();

        String title = "Feeling Bar Chart";

        newBarchart(p, values, labels, colors, title);

        happyLabel(p);

        placeLabel(p);

        backButtonListener(p);


    }
    //EFFECTS: add a listener to the Go Back Button

    private void backButtonListener(JPanel p) {
        JButton back = backButton(p);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImagePage.this.setVisible(false);
                new MainPage().setVisible(true);

            }
        });
    }

    // EFFECTS: place all three label

    private void placeLabel(JPanel p) {
        sadLabel(p, "Sad ", 1, 290);
        angryLabel(p, "Angry ", 2, 450);
        sadLabel(p, "Calm ", 3, 580);
    }

    //EFFECTS: get a list of Labels for bar

    private ArrayList<String> labelList() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add(0,"Happy");
        labels.add(1,"Sad");
        labels.add(2,"Angry");
        labels.add(3,"Calm");
        return labels;
    }

    //EFFECTS: create the list of Color we want for bar

    private ArrayList<Color> colorList() {
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.lightGray);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        return colors;
    }

    //EFFECTS: Create a new Go Back Button

    private JButton backButton(JPanel p) {
        JButton back = new JButton("Go Back");
        back.setFont(new Font("Bond", Font.BOLD, 30));
        back.setBounds(600, 660, 150, 60);
        back.setBackground(Color.pink);
        back.setForeground(Color.BLACK);
        back.setOpaque(true);
        p.add(back);
        return back;
    }

    //EFFECTS: set a new angry label for the angry bar

    private void angryLabel(JPanel p, String s, int i, int i2) {
        JLabel label3 = new JLabel();
        label3.setFont(new Font("bold", Font.BOLD, 20));
        label3.setForeground(Color.BLACK);
        label3.setText(s + list.get(i).toString());
        p.add(label3);
        label3.setBounds(i2, 600, 150, 30);
    }

    //EFFECTS: set a new sad label for the sad bar

    private void sadLabel(JPanel p, String s, int i, int i2) {
        angryLabel(p, s, i, i2);
    }

    // EFFECTS: Create a new Label for the Happy bar

    private void happyLabel(JPanel p) {
        JLabel label1 = new JLabel();
        label1.setFont(new Font("bold", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        label1.setText("Happy " + list.get(0).toString());
        p.setLayout(null);
        p.add(label1);

        label1.setBounds(120, 600,150, 30);
    }
    //EFFECTS: Create a new Barchart

    private void newBarchart(JPanel p, ArrayList<Integer> v, ArrayList<String> l, ArrayList<Color> c, String t) {
        BarChart bc = new BarChart(v, l, c, t);
        bc.setVisible(true);
        bc.setBounds(100, 100,600,500);
        bc.setOpaque(false);
        p.add(bc);
        p.setVisible(true);
    }

    // EFFECTS: set a new Panel

    private JPanel setBase() {
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("My Diary");
        this.setLayout(null);

        JPanel p = new JPanel();
        this.setContentPane(p);
        p.setLayout(null);
        return p;
    }

    // MODIFIES: this;
    // EFFECTS: change the list by th category

    private void generateList(List<TodayDiary> diaries) {
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
    }

    //EFFECTS: Create a new List

    private void newList() {
        list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
    }

    private void loadDiaries() {
        try {
            previousDiary = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STONE);

        }
    }



}
