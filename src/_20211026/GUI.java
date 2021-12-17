package _20211026;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GUI extends JFrame {

    private final Font globalFont = new Font("Tahoma", Font.PLAIN, 12);

    private final JTextField jTextField;
    private final JPanel contentPane;

    public GUI() {
        setTitle("GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 150, 329, 169);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        jTextField = new JTextField();
        jTextField.setFont(globalFont);
        jTextField.setBounds(20, 46, 190, 20);
        contentPane.add(jTextField);

        JLabel jLabel = new JLabel("New window Title");
        jLabel.setFont(globalFont);
        jLabel.setBounds(10, 18, 154, 14);
        contentPane.add(jLabel);

        JLabel image = new JLabel("");
        image.setBounds(230, 11,72,75);
        image.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/image.jpg"))));
        contentPane.add(image);

        JButton btchange = new JButton("Change");
        btchange.setFont(globalFont);
        btchange.addActionListener(e -> changetitle());
        btchange.setBounds(20,82,89,25);
        contentPane.add(btchange);

        JButton btclose = new JButton("Close");
        btclose.setFont(globalFont);
        btclose.addActionListener(e -> close());
        btclose.setBounds(121,82,89,25);
        contentPane.add(btclose);
    }

    private void changetitle() {
        setTitle(jTextField.getText());
    }

    private void close() {
        dispose();
        System.exit(0);
    }
}
