package ui;

import model.Category;
import model.PreviousDiary;
import model.TodayDiary;
import persistance.JsonReader;
import persistance.JsonWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TimePage extends JFrame {


    private PreviousDiary previousDiary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STONE = "./data/todaydiary.txt";




    public TimePage(TodayDiary td) {
        super("");


        TodayDiary todayDiary = td;


        previousDiary = new PreviousDiary("My Diaries");
        jsonWriter = new JsonWriter(JSON_STONE);
        jsonReader = new JsonReader(JSON_STONE);

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("Create My Diary");
        this.setLayout(null);
        this.setVisible(true);


        JLabel label = new JLabel();
        label.setFont(new Font("bold", Font.BOLD, 30));
        label.setForeground(Color.ORANGE);
        label.setText("Please Enter your Story");


        this.setLayout(null);

        this.setVisible(true);

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JLabel month = new JLabel("MONTH");
        month.setBounds(40, 20, 80, 40);
        month.setBackground(Color.pink);
        month.setOpaque(true);
        contentPanel.add(month);
        JComboBox comboBox1 = new JComboBox();
        comboBox1.addItem("January");
        comboBox1.addItem("February");
        comboBox1.addItem("March");
        comboBox1.addItem("April");
        comboBox1.addItem("May");
        comboBox1.addItem("June");
        comboBox1.addItem("July");
        comboBox1.addItem("August");
        comboBox1.addItem("September");
        comboBox1.addItem("October");
        comboBox1.addItem("November");
        comboBox1.addItem("December");
        contentPanel.add(comboBox1);
        comboBox1.setBounds(130, 20, 120, 40);
        comboBox1.setEditable(true);

        JLabel date = new JLabel("DATE");
        date.setBounds(300, 20, 80, 40);
        date.setBackground(Color.pink);
        date.setOpaque(true);
        contentPanel.add(date);
        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem("1");
        comboBox2.addItem("2");
        comboBox2.addItem("3");
        comboBox2.addItem("4");
        comboBox2.addItem("5");
        comboBox2.addItem("6");
        comboBox2.addItem("7");
        comboBox2.addItem("8");
        comboBox2.addItem("9");
        comboBox2.addItem("10");
        comboBox2.addItem("11");
        comboBox2.addItem("12");
        comboBox2.addItem("13");
        comboBox2.addItem("14");
        comboBox2.addItem("15");
        comboBox2.addItem("16");
        comboBox2.addItem("17");
        comboBox2.addItem("18");
        comboBox2.addItem("19");
        comboBox2.addItem("20");
        comboBox2.addItem("21");
        comboBox2.addItem("22");
        comboBox2.addItem("23");
        comboBox2.addItem("24");
        comboBox2.addItem("25");
        comboBox2.addItem("26");
        comboBox2.addItem("27");
        comboBox2.addItem("28");
        comboBox2.addItem("29");
        comboBox2.addItem("30");
        comboBox2.addItem("31");
        contentPanel.add(comboBox2);
        comboBox2.setBounds(390, 20, 120, 40);
        comboBox2.setEditable(true);
        comboBox2.getSelectedItem();

        JLabel week = new JLabel("DAY");
        week.setBounds(560, 20, 80, 40);
        week.setBackground(Color.pink);
        contentPanel.add(week);
        week.setOpaque(true);
        JComboBox comboBox3 = new JComboBox();
        comboBox3.addItem("MONDAY");
        comboBox3.addItem("TUESDAY");
        comboBox3.addItem("WEDNESDAY");
        comboBox3.addItem("THURSDAY");
        comboBox3.addItem("FRIDAY");
        comboBox3.addItem("SATURDAY");
        comboBox3.addItem("SUNDAY");
        contentPanel.add(comboBox3);
        comboBox3.setBounds(650, 20, 120, 40);
        comboBox3.setEditable(true);
        comboBox3.getSelectedItem();

        label.setBounds(40, 120, 800, 50);

        contentPanel.add(label);
        label.setBounds(200, 100, 800, 40);

        JTextArea text = new JTextArea("");
        text.setFont(new Font("Bond", Font.BOLD, 20));
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setOpaque(true);
        contentPanel.add(text);
        text.setBounds(0, 160, 800, 600);
        text.setLineWrap(true);
        text.setEditable(true);


        JButton save = new JButton("Save");
        save.setFont(new Font("Bond", Font.BOLD, 30));
        save.setBounds(698, 80, 100, 60);
        save.setBackground(Color.GREEN);
        save.setForeground(Color.BLACK);
        save.setOpaque(true);
        contentPanel.add(save);


        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadDiaries();

                String monthString = comboBox1.getSelectedItem().toString();
                String dateString = comboBox2.getSelectedItem().toString();
                String dayString = comboBox3.getSelectedItem().toString();
                TodayDiary td;
                String words = text.getText();
                String title = monthString + " / " + dateString + " / " + dayString;
                td = new TodayDiary(title, todayDiary.getCategory(), "");
                td.addWords(words);
                previousDiary.addDiary(td);

                savePreviousDiaries();
                TimePage.this.setVisible(false);
                new MainPage().setVisible(true);


            }
        });

        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Bond", Font.BOLD, 30));
        quit.setBounds(2, 80, 100, 60);
        quit.setBackground(Color.GREEN);
        quit.setForeground(Color.BLACK);
        quit.setOpaque(true);
        contentPanel.add(quit);

        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadDiaries();
                TimePage.this.setVisible(false);
                new MainPage().setVisible(true);


            }
        });


    }

    // EFFECTS: saves all the diaries to file
    private void savePreviousDiaries() {

        try {
            jsonWriter.open();
            jsonWriter.write(previousDiary);
            jsonWriter.close();
            System.out.println("Saved" + previousDiary.getName() + "to " + JSON_STONE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STONE);
        }

    }

    // MODIFIES: this
    // EFFECTS: loads previous diaries from the file
    private void loadDiaries() {
        try {
            previousDiary = jsonReader.read();
            System.out.println("Loaded " + previousDiary.getName() + " from " + JSON_STONE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STONE);

        }
    }
}
