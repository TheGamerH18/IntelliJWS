package _20211112.Zinsrechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

public class GUI extends JFrame {

    private final JTextArea output = new JTextArea();

    public GUI() {
        setContentPane(new JPanel(null));
        setBounds(100, 100, 500, 500);

        JLabel startcapitallabel = new JLabel("Start Capital in " + NumberFormat.getCurrencyInstance().getCurrency().getCurrencyCode());
        startcapitallabel.setBounds(10, 10, 150, 30);
        getContentPane().add(startcapitallabel);

        JTextField startcapital = new JTextField();
        startcapital.setBounds(160, 10, 150, 30);
        getContentPane().add(startcapital);

        JLabel interestratelabel = new JLabel("Interest Rate in %");
        interestratelabel.setBounds(10, 50, 150, 30);
        getContentPane().add(interestratelabel);

        JTextField interestrate = new JTextField();
        interestrate.setBounds(160, 50, 150, 30);
        getContentPane().add(interestrate);

        JLabel runtimelabel = new JLabel("Time in Years");
        runtimelabel.setBounds(10, 90, 150, 30);
        getContentPane().add(runtimelabel);

        JTextField runtime = new JTextField();
        runtime.setBounds(160, 90, 150, 30);
        getContentPane().add(runtime);

        JButton createnew = new JButton("New");
        createnew.setBounds(320, 10, 100, 30);
        createnew.addActionListener(e -> clear());
        getContentPane().add(createnew);

        JButton calc = new JButton("Calc");
        calc.setBounds(320, 50, 100, 30);
        calc.addActionListener(e -> calc(startcapital, interestrate, runtime));
        getContentPane().add(calc);

        JButton close = new JButton("Close");
        close.setBounds(320, 90, 100, 30);
        close.addActionListener(e -> System.exit(1));
        getContentPane().add(close);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(output);
        scrollPane.setBounds(10, 130, getWidth()-30, getHeight()-180);
        getContentPane().add(scrollPane);

        output.setBounds(10, 130, scrollPane.getWidth(), scrollPane.getHeight());
        output.setEditable(false);
        output.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                output.setBounds(10, 130, scrollPane.getWidth(), scrollPane.getHeight());
                scrollPane.setBounds(10, 130, getWidth()-30, getHeight()-180);
            }
        });

        setVisible(true);
    }

    private void calc(JTextField startcapital, JTextField interestrate, JTextField runtime) {
        Zinser zinser = new Zinser(Integer.parseInt(runtime.getText()),
                Double.parseDouble(interestrate.getText()) / 100,
                Long.parseLong(startcapital.getText()));
        ArrayList<String> lines = zinser.calculate();
        output.setText("");
        StringBuilder string = new StringBuilder();
        for (String line : lines) {
            string.append(line);
            string.append("\n");
        }
        output.setText(string.toString());
    }

    private void clear() {
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if(component instanceof JTextField) ((JTextField) component).setText("");
            else if (component instanceof JTextArea) ((JTextArea) component).setText("");
        }
    }
}
