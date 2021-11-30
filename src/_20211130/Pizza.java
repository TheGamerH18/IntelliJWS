package _20211130;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class Pizza extends JFrame {

    public Pizza() {
        setLayout(null);
        setBounds(new Rectangle(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel sizelabel = new JLabel("Pizza größe <small, big>");
        sizelabel.setBounds(10, 10, 150, 30);
        add(sizelabel);

        JTextField sizetext = new JTextField();
        sizetext.setBounds(170, 10, 150, 30);
        add(sizetext);

        JLabel typelabel = new JLabel("Pizza Art");
        typelabel.setBounds(10, 40, 150, 30);
        add(typelabel);

        JTextField typetext = new JTextField();
        typetext.setBounds(170, 40, 150, 30);
        add(typetext);

        JLabel typdes = new JLabel("<html>Pizza Art <br/>a - Salami (10€ / 15€) <br/>b - Schinken (11€ / 17€) <br/>c- Veggie (9€ / 13€)</html>");
        typdes.setBounds(170, 90, 150, 60);
        add(typdes);

        JLabel pricenet = new JLabel("Preis Netto");
        pricenet.setBounds(10, 160, 150, 30);
        add(pricenet);

        JTextField pricenettext = new JTextField();
        pricenettext.setBounds(170, 160, 150, 30);
        add(pricenettext);

        JLabel pricebrut = new JLabel("Preis Brutto");
        pricebrut.setBounds(10, 200, 150, 30);
        add(pricebrut);

        JTextField pricebruttext = new JTextField();
        pricebruttext.setBounds(170, 200, 150, 30);
        add(pricebruttext);

        JButton calc = new JButton("Prei berechnen");
        calc.setBounds(10, 240, 150, 50);
        calc.addActionListener(e -> {
            //Input validation
            if(sizetext.getText().equals("") || typetext.getText().equals("")) return;

            // Input save
            String type = typetext.getText();
            boolean big = sizetext.getText().toLowerCase(Locale.ROOT).equals("big");
            String types = "";
            int price = 0;
            // Calc Net
            switch (type) {
                case "a" -> {
                    price = (big) ? 15 : 10;
                    types = "Salami";
                }
                case "b" -> {
                    price = (big) ? 17 : 11;
                    types = "Schinken";
                }
                case "c" -> {
                    price = (big) ? 13 : 9;
                    types = "Veggie";
                }
                default -> System.out.println("Switch default");
            }
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            pricenettext.setText(formatter.format(price));
            pricebruttext.setText(formatter.format(price * 1.19));
            if(!types.equals(""))
                savetofile(sizetext.getText().toUpperCase(), types, price, price*1.19);
        });
        add(calc);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Pizza();
    }
    private void savetofile(String size, String type, int price, double pricebrut) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bill.txt"))) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();

            String stringBuilder = "Pizza Store 123\n" +
                    "1x " + type + " " + size + "  " + formatter.format(price) + "\n" +
                    "------------------\n" +
                    "Netto:  " + price + "\n" +
                    "Brutto: " + pricebrut;

            writer.write(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
