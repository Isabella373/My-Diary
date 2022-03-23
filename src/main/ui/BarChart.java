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

        Font titleFont = new Font("", Font.BOLD,20);
        FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);

        Font labelFont = new Font("", Font.PLAIN,15);
        FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

        int titleWidth = titleFontMetrics.stringWidth(title);
        int stringHeight = titleFontMetrics.getAscent();
        int stringWidth = (panelWidth - titleWidth) / 2;
        g.setFont(titleFont);
        g.drawString(title, stringWidth,stringHeight);

        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue) {
            return;
        }

        double scale = (panelHeight - top - bottom) / (maxValue - minValue);
        stringHeight = panelHeight - labelFontMetrics.getDescent();
        g.setFont(labelFont);
        for (int j = 0; j < values.size(); j++) {
            int valueP = j * barWidth + 1;
            int valueQ = top;
            int height = (int) (values.get(j) * scale);
            if (values.get(j) >= 0) {
                valueQ += (int) ((maxValue - values.get(j)) * scale);
            } else {
                valueQ += (int) (maxValue * scale);
                height = -height;
            }
            g.setColor(colors.get(j));
            g.fillRect(valueP, valueQ,barWidth - 2, height);
            g.setColor(Color.BLACK);
            g.drawRect(valueP,valueQ,barWidth - 2, height);

            int labelWidth = labelFontMetrics.stringWidth(labels.get(j));
            stringWidth = j * barWidth + (barWidth - labelWidth);
        }
    }


}
