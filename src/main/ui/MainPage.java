package ui;

import org.junit.jupiter.api.AfterAll;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    JButton bar;
    JTextField diaryField;
    JButton save;
    JButton add;
    JButton quit;

    public MainPage() {
        super("");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("My Diary");
        this.setLayout(null);

        JPanel p = new JPanel();
        this.setContentPane(p);


        save = new JButton("Save");
        save.setFont(new Font("Bond", Font.BOLD, 30));
        save.setBorderPainted(true);
        save.setBackground(Color.GREEN);
        save.setForeground(Color.BLACK);
        save.setOpaque(true);
        p.add(save);

        add = new JButton("+");
        add.setFont(new Font("Bond", Font.BOLD, 30));
        add.setBorderPainted(true);
        add.setBackground(Color.PINK);
        add.setForeground(Color.BLACK);
        add.setOpaque(true);
        p.add(add);

        quit = new JButton("Quit");
        quit.setFont(new Font("Bond", Font.BOLD, 30));
        quit.setBorderPainted(true);
        quit.setBackground(Color.RED);
        quit.setForeground(Color.BLACK);
        quit.setOpaque(true);
        p.add(quit);
        p.setOpaque(false);

        bar = new JButton("Column Chart [HAPPY * SAD * ANGRY * CALM]");
        bar.setFont(new Font("Bond", Font.BOLD, 30));
        bar.setBorderPainted(true);
        bar.setBackground(Color.GREEN);
        bar.setForeground(Color.BLACK);
        bar.setOpaque(false);
        p.add(bar);

    }
}
