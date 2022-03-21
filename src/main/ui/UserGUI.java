package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserGUI extends JFrame {
    private JPanel contentPane;
    private static UserGUI frame;

    public static void main(String[] args) {
        init();
    }

    private JTextField textField;

    //?? choose the file you want to delete
    private JFileChooser chooser;

    // pathname is the path to file in which diary stored
    private static String pathname;

    public static void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserGUI frame = new UserGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the frame

    public UserGUI() {
        setTitle("My Diary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //must not ignore setLayout method
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(("Welcome to use MyDiary"));
        lblNewLabel.setBounds(132, 74, 386, 35);
        lblNewLabel.setFont(new Font("Bold", Font.BOLD | Font.ITALIC, 30));
        contentPane.add(lblNewLabel);

        JButton load = new JButton("Load");
        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLoad(); // the method of loading
            }

        });

        newKeyBoard(load);


    }

    private void newKeyBoard(JButton load) {
        // add a new KeyBoard Method
        load.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    eventLoad();
                }
            }
        });
        load.setBounds(65, 263, 124, 45);
        contentPane.add(load);
    }

    private void eventLoad() {
        setVisible(false);
        new LoadGUI().loadGUI();

    }
}
