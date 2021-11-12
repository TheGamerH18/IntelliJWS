package _20211112;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TextAreas extends JFrame{

    JTextArea textArea = new JTextArea();

    public TextAreas() {
        setTitle("JTextArea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 320, 500);

        JPanel contentpane = new JPanel(null);
        contentpane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentpane);

        textArea.setBounds(25,25,260,400);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("With the class JTextArea, you can create a Input or Output field with multiple lines");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 25, 260, 400);
        scrollPane.setViewportView(textArea);
        getContentPane().add(scrollPane);

        JButton button = new JButton("Output");
        button.setBounds(25, 430, 100, 30);
        button.addActionListener(e -> System.out.println(textArea.getText()));
        getContentPane().add(button);
    }

    public static void main(String[] args) {
        new TextAreas().setVisible(true);
    }
}
