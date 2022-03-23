package ui;

import model.Category;
import model.TodayDiary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeelingPage extends JFrame {
    private ImageIcon iconHappy = new ImageIcon("data/HAPPY.jpg");
    private ImageIcon iconSad = new ImageIcon("data/SAD.jpg");
    private ImageIcon iconAngry = new ImageIcon("data/ANGRY.jpg");
    private ImageIcon iconCalm = new ImageIcon("data/CALM.jpg");
    private ImageIcon iconWhat = new ImageIcon("data/what.png");

    private JLabel l1 = new JLabel(iconHappy, JLabel.CENTER);
    private JLabel l2 = new JLabel(iconSad, JLabel.CENTER);
    private JLabel l3 = new JLabel(iconAngry, JLabel.CENTER);
    private JLabel l4 = new JLabel(iconCalm, JLabel.CENTER);
    private JLabel l5 = new JLabel(iconWhat, JLabel.CENTER);

    DragMouseAdapter listener = new DragMouseAdapter();


    public FeelingPage() {
        super("");

        newFrame();


        allAddListener();

        JButton button = new JButton(iconWhat);
        button.setFocusable(false);

        allSetTransfer();

        button.setTransferHandler(new TransferHandler("icon"));

        createLayout(l1,l2,l3,l4,button);
        this.setBounds(0,0,800,800);

        howAreYouLabel();

        JButton next = nextButton();
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FeelingPage.this.setVisible(false);
                Icon img = button.getIcon();
                TodayDiary td = new TodayDiary("", Category.HAPPY,"");
                td = getTodayDiary(img, td);
                new TimePage(td).setVisible(true);

            }
        });

    }

    private TodayDiary getTodayDiary(Icon img, TodayDiary td) {
        if (img == iconHappy) {
            td = new TodayDiary("", Category.HAPPY,"");
        } else if (img == iconSad) {
            td = new TodayDiary("", Category.SAD,"");
        } else if (img == iconAngry) {
            td = new TodayDiary("", Category.ANGRY,"");
        } else if (img == iconCalm) {
            td = new TodayDiary("", Category.CALM,"");
        }
        return td;
    }

    //EFFECTS: a new frame for this class

    private void newFrame() {
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setTitle("Create My Diary");
        this.setLayout(null);
        this.setVisible(true);
    }

    //EFFECTS: get a new NEXT button

    private JButton nextButton() {
        JButton next = new JButton("NEXT");
        next.setFont(new Font("Bond", Font.BOLD, 30));
        next.setBounds(680, 700, 100, 50);
        next.setBackground(Color.PINK);
        next.setForeground(Color.BLACK);
        next.setOpaque(true);
        this.add(next);
        return next;
    }

    // EFFECTS: set a "How Are You" Label

    private void howAreYouLabel() {
        JButton loadButton = new JButton("How are you?");
        loadButton.setBounds(100, 650, 500, 100);
        loadButton.setFont(new Font("bold",Font.BOLD, 40));
        loadButton.setBackground(Color.GREEN);
        loadButton.setForeground(Color.BLACK);
        this.add(loadButton);
    }

    // EFFECTS: set transfer handler for all the labels

    private void allSetTransfer() {
        l1.setTransferHandler(new TransferHandler("icon"));
        l2.setTransferHandler(new TransferHandler("icon"));
        l3.setTransferHandler(new TransferHandler("icon"));
        l4.setTransferHandler(new TransferHandler("icon"));
        l5.setTransferHandler(new TransferHandler("icon"));
    }

    // EFFECTS: add listener for all the labels;

    private void allAddListener() {
        l1.addMouseListener(listener);
        l2.addMouseListener(listener);
        l3.addMouseListener(listener);
        l4.addMouseListener(listener);
        l5.addMouseListener(listener);
    }

    private void createLayout(JLabel l1, JLabel l2, JLabel l3, JLabel l4, JButton button) {
        Container pane = getContentPane();
        pane.setSize(800,800);
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        setLabelsPosition(l1, l2, l3, l4, button, gl);

        pack();
    }

    // EFFECTS：set the position of each label and button
    private void setLabelsPosition(JLabel l1, JLabel l2, JLabel l3, JLabel l4, JButton button, GroupLayout gl) {
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(l1)
                        .addGap(30)
                        .addComponent(l2)
                        .addGap(30)
                        .addComponent(l3)
                        .addGap(30)
                        .addComponent(l4))
                .addComponent(button, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Integer.MAX_VALUE)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(l1)
                        .addComponent(l2)
                        .addComponent(l3)
                        .addComponent(l4))
                .addGap(30)
                .addComponent(button)
        );
    }


}
