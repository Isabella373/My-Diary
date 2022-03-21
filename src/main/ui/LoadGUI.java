package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadGUI extends JFrame {
    private static final long serialVersionUID = 4994949944841194839L;
    private JPanel contentPane;
    private JTextField idTxt;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton load;
    private JButton back;

    public void loadGUI() {
        newPanel();

        addComponents();

        load = new JButton("Load");

        //Mouse Event
        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                evenLoad();
            }
        });

        // KeyBoard Event
        load.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                evenLoad();
            }
        });

        load.setBounds(239, 310, 93, 23);
        contentPane.add(load);

        goBack();
        back.setBounds(507, 310, 93, 23);
        contentPane.add(back);

        createTitle();


    }

    private void newPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        contentPane = new JPanel();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel idLabel = new JLabel("Please input your student number");
        idLabel.setBounds(68, 170, 91, 39);
        contentPane.add(idLabel);
    }

    private void addComponents() {
        idTxt = new JTextField();
        idTxt.setBounds(206, 179, 126, 21);
        contentPane.add(idTxt);
        idTxt.setColumns(10);

        passwordLabel = new JLabel("Please input password");
        passwordLabel.setBounds(68, 291, 150, 50);
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(68, 219, 150, 50);
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(206, 234, 126, 21);
        contentPane.add(passwordField);
    }

    private void goBack() {
        // Go back buttton
        back = new JButton("BACK");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserGUI.init();
                setVisible(false);

            }
        });
    }

    private void createTitle() {
        //title
        JLabel label = new JLabel("Welcome to use My Diary");
        label.setFont(new Font("bold", Font.BOLD | Font.ITALIC, 30));
        label.setBounds(142, 54, 386, 35);
        contentPane.add(label);
    }

    private void evenLoad() {
        String id = idTxt.getToolTipText();
        String password = new String(passwordField.getPassword());
        //? null? What is DOM
        String flag = null;
        if (flag.contains("Successful Loading")) {
            String[] bufs = flag.split("/");
            String name = bufs[1];
            JOptionPane.showMessageDialog(contentPane, "Welcome: " + name, "Welcome", JOptionPane.PLAIN_MESSAGE);
            UserGUI.init();
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(contentPane, flag, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}


