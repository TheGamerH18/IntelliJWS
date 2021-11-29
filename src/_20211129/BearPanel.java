package _20211129;

import javax.swing.*;
import java.awt.*;

public class BearPanel extends JPanel {

    public BearPanel() {
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(255, 255, 0));
        g.drawOval(20, 0, 20, 20);
        g.drawOval(30, 10, 50, 50);
        g.drawOval(70, 0, 20, 20);
        g.setColor(new Color(0, 0, 255));
        g.drawOval(40, 20, 10, 10);
        g.drawOval(60, 20, 10, 10);
        g.setColor(new Color(255, 0, 0));
        g.drawRect(47, 35, 15, 15);
        g.setColor(new Color(255, 255, 0));
        g.drawRect(30, 60, 50, 50);
        g.drawOval(0, 50, 30, 30);
        g.drawOval(0, 90, 30, 30);
        g.drawOval(80, 50, 30, 30);
        g.drawOval(80, 90, 30, 30);
    }
}
