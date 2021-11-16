package _20211112.Zinsrechner;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class GUI extends JFrame {

    private JTextArea output = new JTextArea();

    public GUI() {
        setContentPane(new JPanel(null));
        setBounds(100, 100, 500, 500);

        JLabel startcapitallabel = new JLabel("Start Capital");
        startcapitallabel.setBounds(10, 10, 100, 30);
        getContentPane().add(startcapitallabel);

        JTextField startcapital = new JTextField();
        startcapital.setBounds(110, 10, 150, 30);
        getContentPane().add(startcapital);

        JLabel interestratelabel = new JLabel("Interest Rate");
        interestratelabel.setBounds(10, 50, 100, 30);
        getContentPane().add(interestratelabel);

        JTextField interestrate = new JTextField();
        interestrate.setBounds(110, 50, 150, 30);
        getContentPane().add(interestrate);

        JLabel runtimelabel = new JLabel("Time");
        runtimelabel.setBounds(10, 90, 100, 30);
        getContentPane().add(runtimelabel);

        JTextField runtime = new JTextField();
        runtime.setBounds(110, 90, 150, 30);
        getContentPane().add(runtime);

        JButton createnew = new JButton("New");
        createnew.setBounds(270, 10, 100, 30);
        getContentPane().add(createnew);

        JButton calc = new JButton("Calc");
        calc.setBounds(270, 50, 100, 30);
        calc.addActionListener(e -> {
            Zinser zinser = new Zinser(Integer.parseInt(runtime.getText()),
                    Double.parseDouble(interestrate.getText()),
                    Long.parseLong(startcapital.getText()));
            ArrayList<String> lines = zinser.calculate();
            output.setText("");
            StringBuilder string = new StringBuilder();
            for (String line : lines) {
                string.append(line);
                string.append("\n");
            }
            output.setText(string.toString());
        });
        getContentPane().add(calc);

        JButton close = new JButton("Close");
        close.setBounds(270, 90, 100, 30);
        close.addActionListener(e -> System.exit(1));
        getContentPane().add(close);

        output.setBounds(10, 130, getWidth()-10, getHeight()-140);
        output.setEditable(false);
        getContentPane().add(output);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                output.setBounds(10, 130, getWidth()-10, getHeight()-160);
            }
        });

        setVisible(true);
    }
}
