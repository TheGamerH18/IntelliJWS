package _20211029;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class GUI extends JFrame {

    // Normal font
    private Font globalFont = new Font("Tahoma", Font.PLAIN, 12);

    // Contentpane
    private JPanel contentPane;
    // Input Fields
    private JTextField fieldfirstname;
    private JTextField fieldlastname;
    private JTextField fieldweight;
    private JTextField fieldheight;
    // Output Fields
    private JTextField outfullname;
    private JTextField outbmi;
    private JTextField outevaluation;
    // Buttons
    private JButton calc;
    private JButton clear;
    private JButton close;

    GUI() {
        setTitle("Body Mass Index");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);

        contentPane = new JPanel(null);
        setContentPane(contentPane);

        JLabel image = new JLabel("");
        image.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/res/bmiimage.png"))));
        image.setBounds(10, 10, 155, 155);
        contentPane.add(image);

        JLabel labelfirstname = new JLabel("Firstname: ");
        labelfirstname.setBounds(175, 21, 155, 31);
        contentPane.add(labelfirstname);

        fieldfirstname = new JTextField();
        fieldfirstname.setBounds(340, 22, 155, 31);
        contentPane.add(fieldfirstname);

        JLabel labellastname = new JLabel("Lastname:");
        labellastname.setBounds(175, 58, 155, 31);
        contentPane.add(labellastname);

        fieldlastname = new JTextField();
        fieldlastname.setBounds(340, 58, 155, 31);
        contentPane.add(fieldlastname);

        JLabel labelweight = new JLabel("Weight in kg:");
        labelweight.setBounds(175, 94, 155, 31);
        contentPane.add(labelweight);

        fieldweight = new JTextField();
        fieldweight.setBounds(340, 94, 155, 31);
        contentPane.add(fieldweight);

        JLabel labelheight = new JLabel("Height in m");
        labelheight.setBounds(175, 130, 155, 31);
        contentPane.add(labelheight);

        fieldheight = new JTextField();
        fieldheight.setBounds(340, 130, 155, 31);
        contentPane.add(fieldheight);

        JLabel labeloutfullname = new JLabel("Fullname");
        labeloutfullname.setBounds(10, 180, 155, 31);
        contentPane.add(labeloutfullname);

        outfullname = new JTextField();
        outfullname.setBounds(175, 180, 320, 31);
        outfullname.setEnabled(false);
        contentPane.add(outfullname);

        JLabel labeloutbmi = new JLabel("Your BMI is:");
        labeloutbmi.setBounds(10, 216, 155, 31);
        contentPane.add(labeloutbmi);

        outbmi = new JTextField();
        outbmi.setBounds(175, 216, 320, 31);
        outbmi.setEnabled(false);
        contentPane.add(outbmi);

        JLabel labeloutevaluation = new JLabel("Evaluation:");
        labeloutevaluation.setBounds(10, 252, 155, 31);
        contentPane.add(labeloutevaluation);

        outevaluation = new JTextField();
        outevaluation.setBounds(175, 252, 320, 31);
        outevaluation.setEnabled(false);
        contentPane.add(outevaluation);

        clear = new JButton("Clear");
        clear.setBounds(10, 308, 155, 40);
        contentPane.add(clear);

        calc = new JButton("Calculate");
        calc.setBounds(175, 308, 155, 40);
        contentPane.add(calc);

        close = new JButton("Close");
        close.setBounds(340, 308, 155, 40);
        close.addActionListener(e -> {
            System.exit(1);
        });
        contentPane.add(close);
    }
}
