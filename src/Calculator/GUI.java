package Calculator;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {
        setLayout(null);
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenu menu = new JMenu("View") {{
            add(new JMenuItem("Default") {{
                addActionListener(e -> setContentPane(new DefaultView()));
            }});
            add(new JMenuItem("Extended") {{
                addActionListener(e -> setContentPane(new ExtendedView()));
            }});
        }};

        setJMenuBar(new JMenuBar(){{
            add(menu);
        }});

        setContentPane(new DefaultView());

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
