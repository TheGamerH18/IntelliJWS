package _20211129;

import javax.swing.*;
import java.awt.*;

public class UnitCalc extends JFrame {

    JTextField hpvalue = new JTextField();
    JTextField kwvalue = new JTextField();
    JTextField celvalue = new JTextField();
    JTextField kelvalue = new JTextField();

    public UnitCalc() {
        setBounds(new Rectangle(410, 150));
        getContentPane().setLayout(null);

        hpvalue.setBounds(0, 0, 100, 30);
        JLabel hptext = new JLabel("=HP");
        hptext.setBounds(100, 0, 100, 30);
        getContentPane().add(hptext);

        kwvalue.setBounds(200, 0, 100, 30);
        JLabel kwtext = new JLabel("=KW");
        kwtext.setBounds(300, 0, 100, 30);
        getContentPane().add(kwtext);

        celvalue.setBounds(0, 30, 100, 30);
        JLabel celtext = new JLabel("=°C Celsius");
        celtext.setBounds(100, 30, 100, 30);
        getContentPane().add(celtext);

        kelvalue.setBounds(200, 30, 100, 30);
        JLabel keltext = new JLabel("=Kelvin");
        keltext.setBounds(300, 30, 100, 30);
        getContentPane().add(keltext);

        getContentPane().add(hpvalue);
        getContentPane().add(kwvalue);
        getContentPane().add(celvalue);
        getContentPane().add(kelvalue);

        JButton calc = new JButton("Calculate");
        calc.setBounds(0, 80, 300, 30);
        calc.addActionListener(e -> {
            double hpvalue = Double.parseDouble(this.hpvalue.getText());
            double celvalue = Double.parseDouble(this.celvalue.getText());

            hpvalue = Math.round((hpvalue / 1.341)*100);

            kwvalue.setText(String.valueOf(hpvalue / 100));
            kelvalue.setText(String.valueOf(celvalue + 273.15));
        });
        getContentPane().add(calc);

        JButton close = new JButton("Close");
        close.setBounds(300, 80, 100, 30);
        close.addActionListener(e -> System.exit(1));
        getContentPane().add(close);

        setVisible(true);
    }

    public static void main(String[] args) {
        new UnitCalc();
    }
}
