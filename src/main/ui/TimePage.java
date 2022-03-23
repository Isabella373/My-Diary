package ui;

import model.TodayDiary;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TimePage extends JFrame {
    public TimePage(TodayDiary td) {
        super("");

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("Create My Diary");
        this.setLayout(null);
        this.setVisible(true);

        JLabel label = new JLabel();
        label.setFont(new Font("italic",Font.ITALIC,30));
        label.setForeground(Color.ORANGE);
        label.setText("What Time Is It?");
        label.setBounds(40,10,800,50);
        this.add(label);

        this.setLayout(null);

        this.setVisible(true);

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        this.setContentPane(contentPanel);
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel month = new JLabel("MONTH");
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

        JLabel date = new JLabel("DATE");
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

        JLabel week = new JLabel("DAY");
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





    }
}
