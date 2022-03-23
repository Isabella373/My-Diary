package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BarChart extends JPanel {
    private ArrayList<Integer> values;
    private ArrayList<String> labels;
    private ArrayList<Color> colors;
    private String title;

    public BarChart(ArrayList<Integer> values,ArrayList<String> labels,ArrayList<Color> colors,String title) {
        this.labels = labels;
        this.values = values;
        this.colors = colors;
        this.title = title;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (values == null || values.size() == 0) {
            return;
        }

        int minValue = 0;
        int maxValue = 0;
        for (int i = 0; i < values.size(); i++) {
            if (minValue > values.get(i)) {
                minValue = values.get(i);
            }
            if (maxValue < values.get(i)) {
                maxValue = values.get(i);
            }
        }

        Dimension dim = getSize();
        int panelWidth = dim.width;
        int panelHeight = dim.height;
        int barWidth = panelWidth / values.size();

        setLabel(g, minValue, maxValue, panelWidth, panelHeight, barWidth);
    }


    //EFFECTS: set the label for the chart bar
    private void setLabel(Graphics g, int minValue, int maxValue, int panelWidth, int panelHeight, int barWidth) {
        Font titleFont = new Font("", Font.BOLD,20);
        FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);

        Font labelFont = new Font("", Font.PLAIN,15);
        FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

        setConstant(g, panelWidth, titleFont, titleFontMetrics);

        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue) {
            return;
        }

        double scale = (panelHeight - top - bottom) / (maxValue - minValue);
        g.setFont(labelFont);
        createBar(g, maxValue, barWidth, labelFontMetrics, top, scale);
    }



    //EFFECTS: determine the width of the bar chart
    private void setConstant(Graphics g, int panelWidth, Font titleFont, FontMetrics titleFontMetrics) {
        int titleWidth = titleFontMetrics.stringWidth(title);
        int stringHeight = titleFontMetrics.getAscent();
        int stringWidth = (panelWidth - titleWidth) / 2;
        g.setFont(titleFont);
        g.drawString(title, stringWidth,stringHeight);
    }


    // EFFECTS: create the bar we want;
    private void createBar(Graphics g, int maxValue, int barW, FontMetrics labelFontMetrics, int top, double scale) {
        for (int j = 0; j < values.size(); j++) {
            int valueP = j * barW + 1;
            int valueQ = top;
            int height = (int) (values.get(j) * scale);
            if (values.get(j) >= 0) {
                valueQ += (int) ((maxValue - values.get(j)) * scale);
            } else {
                valueQ += (int) (maxValue * scale);
                height = -height;
            }
            g.setColor(colors.get(j));
            g.fillRect(valueP, valueQ, barW - 2, height);
            g.setColor(Color.BLACK);
            g.drawRect(valueP,valueQ, barW - 2, height);

        }
    }


}
