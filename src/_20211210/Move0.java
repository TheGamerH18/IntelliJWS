package _20211210;

import tools.Tools;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Move0 {

    Integer[][] field = new Integer[3][3];
    Tools tools = new Tools();

    public Move0() {
        JFrame f = new JFrame("Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        f.setSize(500, 500);
        Label l = new Label();
        l.setText("This is a demonstration");
        f.add(l);
        f.setVisible(true);

        Kaylistener k = new Kaylistener();
        f.addKeyListener(k);

        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], 1);
        }
        field[0][0] = 0;
        while (true) {
            for (int i = 0; i < field.length; i++) {
                Arrays.fill(field[i], 1);
            }
            field[k.posy][k.posx] = 0;

            tools.printmulti(field);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Move0();
    }
}
