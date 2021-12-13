package _20211213;

import javax.swing.*;
import java.awt.*;

public class BasicMenu extends JFrame {
    public BasicMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(new Rectangle(500, 500));

        JMenu menu, submenu;
        JMenuBar mb = new JMenuBar();

        menu = new JMenu("Menu");
        submenu = new JMenu("Sub Menu");

        menu.add(new JMenu("Item 1"));
        menu.add(new JMenu("Item 2"));
        menu.add(new JMenu("Item 3"));
        submenu.add(new JMenu("Item 4"));
        submenu.add(new JMenu("Item 5"));
        menu.add(submenu);

        mb.add(menu);
        setJMenuBar(mb);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BasicMenu();
    }
}
