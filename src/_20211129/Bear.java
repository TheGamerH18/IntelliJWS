package _20211129;

import javax.swing.*;
import java.awt.*;

public class Bear extends JFrame {

    public Bear() {
        setBounds(new Rectangle(300, 300));
        setContentPane(new BearPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Bear();
    }
}
