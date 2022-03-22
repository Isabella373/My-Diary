package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private int width = 0;
    private int height = 0;
    private String imgPath = "";

    public BackgroundPanel(int width, int height, String imgPath) {
        this.width = width;
        this.height = height;
        this.imgPath = imgPath;
        setSize(width, height);
        setVisible(true);
    }

    public BackgroundPanel(double width, double height, String path) {
        this.width = (int) width;
        this.height = (int) height;
        this.imgPath = path;
        setSize((int)width, (int)height);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics gs) {
        Graphics2D g = (Graphics2D) gs;
        super.paintComponent(g);

        //Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgPath));
        Image image = null;
        try {
            image = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        gs.drawImage(image, 0, 0, width, height, this);
    }
}
