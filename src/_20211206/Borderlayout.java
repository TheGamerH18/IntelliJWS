package _20211206;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Borderlayout extends JFrame {

    public Borderlayout() {
        setTitle("BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setLayout(new BorderLayout(10, 10));

        Color[] colors = {Color.red, Color.yellow, Color.blue, Color.magenta};
        String[] positions = {BorderLayout.NORTH, BorderLayout.WEST, BorderLayout.EAST, BorderLayout.SOUTH};

        if(colors.length != positions.length) {
            System.out.println("Inconsistent Args");
            System.exit(1);
        }

        ArrayList<JPanel> panels = new ArrayList<>() {{
            for(int i = 0; i < colors.length; i++) {
                add(new JPanel());
                get(i).setBackground(colors[i]);
                get(i).setPreferredSize(new Dimension(1, 1));
            }
        }};

        //for (int i = 0; i < panels.size(); i++) add(panels.get(i), positions[i]);

        JPanel lastpanel = new JPanel(new BorderLayout(20, 20));
        add(lastpanel, BorderLayout.CENTER);

        for(int i = 0; i < 10; i++) {
            JPanel panel = new JPanel(new BorderLayout(20, 20));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            panel.setBackground(colors[new Random().nextInt(4)]);

            for (int i1 = 0; i1 < panels.size(); i1++) {
                //lastpanel.add(panels.get(i1), positions[i1]);
                lastpanel.add(new JPanel() {{ setBackground(colors[new Random().nextInt(4)]);}}, BorderLayout.EAST);
                lastpanel.add(panel,BorderLayout.CENTER);
            }
            lastpanel.add(panel, BorderLayout.CENTER);
            lastpanel = panel;
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Borderlayout();
    }
}
