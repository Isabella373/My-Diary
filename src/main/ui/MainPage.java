package ui;

import exception.LogException;
import model.EventLog;
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
    private static final String FILE_DESCRIPTOR = "...file";
    private PreviousDiary previousDiary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STONE = "./data/todaydiary.txt";
    private ComboBoxModel<String> printCombo;


    public MainPage() {
        super("");

        initial();

        JPanel p = base();


        saveButton(p);

        addButton(p);


        quitButton(p);
        barCharButton(p);

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

    //EFFECTS: create a new char button to show the bar chart

    private void barCharButton(JPanel p) {
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
    }

    //EFFECTS: create a new quit button

    private void quitButton(JPanel p) {
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
    }


    //EFFECTS: create a new add button
    private void addButton(JPanel p) {
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
    }

    //EFFECTS: create a new save button

    private void saveButton(JPanel p) {
        JButton save = new JButton(new PrintLogAction());
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
    }

    // EFFECTS: return a panel as the base

    private JPanel base() {
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

    // MODIFIES: this
    //EFFECTS: initialize the field

    private void initial() {
        previousDiary = new PreviousDiary("My Diaries");
        jsonWriter = new JsonWriter(JSON_STONE);
        jsonReader = new JsonReader(JSON_STONE);
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

    private class PrintLogAction extends AbstractAction {
        PrintLogAction() {
            super("Print log to...");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            Printer screenPrinter = new Printer(MainPage.this);
            try {
                screenPrinter.printLog(EventLog.getInstance());
            } catch (LogException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "System Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }



}

