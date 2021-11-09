package _20211104;

import javax.swing.*;
import java.util.Objects;

public class Noten extends JFrame {

    JPanel contentpane = new JPanel(null);

    JTextField textklassenarbeit1 = new JTextField();
    JTextField textklassenarbeit2 = new JTextField();
    JTextField textmundlich = new JTextField();

    JTextField outdurchschnitt = new JTextField();
    JTextField outnotetext = new JTextField();

    public Noten() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 500, 500);

        setContentPane(contentpane);

        JLabel label1klassenarbeit = new JLabel("1. Klassenarbeit");
        label1klassenarbeit.setBounds(30, 30, 100, 30);
        contentpane.add(label1klassenarbeit);

        textklassenarbeit1.setBounds(150, 30, 100, 30);
        textklassenarbeit1.setHorizontalAlignment(JTextField.CENTER);
        contentpane.add(textklassenarbeit1);

        JButton neu = new JButton("Neu");
        neu.setBounds(300, 30, 100, 30);
        neu.addActionListener(e -> clear());
        contentpane.add(neu);

        JLabel label2klassenarbeit = new JLabel("2. Klassenarbeit");
        label2klassenarbeit.setBounds(30, 90, 100, 30);
        contentpane.add(label2klassenarbeit);

        textklassenarbeit2.setBounds(150, 90, 100, 30);
        textklassenarbeit2.setHorizontalAlignment(JTextField.CENTER);
        contentpane.add(textklassenarbeit2);

        JButton calc = new JButton("Berechnen");
        calc.setBounds(300, 90, 100, 30);
        calc.addActionListener(e -> calc());
        contentpane.add(calc);


        JLabel labelmundlich = new JLabel("Mündlich");
        labelmundlich.setBounds(30, 150, 100, 30);
        contentpane.add(labelmundlich);

        textmundlich.setBounds(150, 150, 100, 30);
        textmundlich.setHorizontalAlignment(JTextField.CENTER);
        contentpane.add(textmundlich);

        JButton beenden = new JButton("Beenden");
        beenden.setBounds(300, 150, 100, 30);
        beenden.addActionListener(e -> System.exit(1));
        contentpane.add(beenden);

        JLabel image = new JLabel("");
        image.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/res/Grades.png"))));
        image.setBounds(20, 210, 130, 160);
        contentpane.add(image);

        JLabel labeloutdurchschnitt = new JLabel("Notendurchschnitt");
        labeloutdurchschnitt.setBounds(160, 250, 120, 30);
        contentpane.add(labeloutdurchschnitt);

        outdurchschnitt.setBounds(290, 250, 100, 30);
        outdurchschnitt.setEditable(false);
        outdurchschnitt.setHorizontalAlignment(JTextField.CENTER);
        contentpane.add(outdurchschnitt);

        JLabel labelouttext = new JLabel("Zeugnisnote");
        labelouttext.setBounds(160, 310, 120, 30);
        contentpane.add(labelouttext);

        outnotetext.setBounds(290, 310, 100, 30);
        outnotetext.setEditable(false);
        outnotetext.setHorizontalAlignment(JTextField.CENTER);
        contentpane.add(outnotetext);

        setVisible(true);
    }

    private void calc() {
        try {
            int klassenarbeit1 = Integer.parseInt(textklassenarbeit1.getText());
            int klassenarbeit2 = Integer.parseInt(textklassenarbeit2.getText());
            int mundlich = Integer.parseInt(textmundlich.getText());
            if (klassenarbeit1 <= 6 &&
                    klassenarbeit2 <= 6 &&
                    mundlich <= 6) {
                Leistungen leistung = new Leistungen(
                        Integer.parseInt(textklassenarbeit1.getText()),
                        Integer.parseInt(textklassenarbeit2.getText()),
                        Integer.parseInt(textmundlich.getText())
                );

                outdurchschnitt.setText(String.valueOf(leistung.berechnedurchschnitt()));
                outnotetext.setText(leistung.einschatzung());
            }
        }
        catch (NumberFormatException ignored){

        }
    }

    private void clear(){
        textklassenarbeit1.setText("");
        textklassenarbeit2.setText("");
        textmundlich.setText("");
        outnotetext.setText("");
        outdurchschnitt.setText("");
    }

    public static void main(String[] args) {
        new Noten();
    }
}
