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

        TodayDiary todayDiary = initial(td);

        base();

        JLabel label = remindLabel();

        this.setLayout(null);

        this.setVisible(true);

        JPanel contentPanel = getPanel();

        JComboBox comboBox1 = getjComboBox1(contentPanel);

        JComboBox comboBox2 = getjComboBox2(contentPanel);

        JComboBox comboBox3 = getjComboBox3(contentPanel);

        label.setBounds(40, 120, 800, 50);

        contentPanel.add(label);
        label.setBounds(200, 100, 800, 40);

        JTextArea text = getjTextArea(contentPanel);

        button(todayDiary, contentPanel, comboBox1, comboBox2, comboBox3, text);


    }

    private void button(TodayDiary todayDiary, JPanel cp, JComboBox c1, JComboBox c2, JComboBox c3, JTextArea text) {
        JButton save = saveButton(cp, "Save", 698);


        addListener(todayDiary, c1, c2, c3, text, save);

        JButton quit = saveButton(cp, "Quit", 2);

        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadDiaries();
                TimePage.this.setVisible(false);
                new MainPage().setVisible(true);


            }
        });
    }

    //MODIFIES: this
    //EFFECTS: add the mouse Listener to your save button

    private void addListener(TodayDiary todayDiary, JComboBox c1, JComboBox c2, JComboBox c3, JTextArea t, JButton s) {
        s.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadDiaries();

                String monthString = c1.getSelectedItem().toString();
                String dateString = c2.getSelectedItem().toString();
                String dayString = c3.getSelectedItem().toString();
                TodayDiary td;
                String words = t.getText();
                String title = monthString + " / " + dateString + " / " + dayString;
                td = new TodayDiary(title, todayDiary.getCategory(), "");
                td.addWords(words);
                previousDiary.addDiary(td);

                savePreviousDiaries();
                TimePage.this.setVisible(false);
                new MainPage().setVisible(true);


            }
        });
    }

    ////EFFECTS: get a new button to save the diaries

    private JButton saveButton(JPanel contentPanel, String save2, int i) {
        JButton save = new JButton(save2);
        save.setFont(new Font("Bond", Font.BOLD, 30));
        save.setBounds(i, 80, 100, 60);
        save.setBackground(Color.GREEN);
        save.setForeground(Color.BLACK);
        save.setOpaque(true);
        contentPanel.add(save);
        return save;
    }

    ////EFFECTS: get a new JTextArea to write in the user's story

    private JTextArea getjTextArea(JPanel contentPanel) {
        JTextArea text = new JTextArea("");
        text.setFont(new Font("Bond", Font.BOLD, 20));
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setOpaque(true);
        contentPanel.add(text);
        text.setBounds(0, 160, 800, 600);
        text.setLineWrap(true);
        text.setEditable(true);
        return text;
    }

    //EFFECTS: get a new JComboBox to show the day

    private JComboBox getjComboBox3(JPanel contentPanel) {
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
        return comboBox3;
    }

    //EFFECTS: get a new JComboBox to show the date

    private JComboBox getjComboBox2(JPanel contentPanel) {
        JLabel date = new JLabel("DATE");
        date.setBounds(300, 20, 80, 40);
        date.setBackground(Color.pink);
        date.setOpaque(true);
        contentPanel.add(date);
        JComboBox comboBox2 = new JComboBox();
        oneTo20(comboBox2);
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
        return comboBox2;
    }

    // EFFECTS; just extract the 1 to 20 date

    private void oneTo20(JComboBox comboBox2) {
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
    }

    //EFFECTS: get a new JComboBox to show the month
    private JComboBox getjComboBox1(JPanel contentPanel) {
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
        return comboBox1;
    }

    //EFFECTS: get a new Panel as content panel

    private JPanel getPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(contentPanel);
        contentPanel.setLayout(null);
        return contentPanel;
    }

    //EFFECTS: create a label that remind you enter a story

    private JLabel remindLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("bold", Font.BOLD, 30));
        label.setForeground(Color.ORANGE);
        label.setText("Please Enter your Story");
        return label;
    }

    //EFFECTS:create the frame size and title

    private void base() {
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("Create My Diary");
        this.setLayout(null);
        this.setVisible(true);
    }

    //EFFECTS: initialize the field

    private TodayDiary initial(TodayDiary td) {
        TodayDiary todayDiary = td;

        previousDiary = new PreviousDiary("My Diaries");
        jsonWriter = new JsonWriter(JSON_STONE);
        jsonReader = new JsonReader(JSON_STONE);
        return todayDiary;
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
