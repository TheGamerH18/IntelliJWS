package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Objects;

public class GUI extends JFrame {
    FileHandler fileHandler = new FileHandler();

    // JTextField opentext = new JTextField();
    // JTextField savetext = new JTextField();

    JTextArea textField = new JTextArea();


    public GUI() {

        setMinimumSize(new Dimension(700, 500));
        setContentPane(new JPanel(null));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 700, 500);

        // JLabel openlabel = new JLabel("Open File");
        // openlabel.setBounds(10, 10, 100, 30);
        // getContentPane().add(openlabel);

        // opentext.setBounds(120, 10, 100, 30);
        // getContentPane().add(opentext);

        JButton openbtn = new JButton("Open");
        openbtn.setBounds(230, 10, 50, 30);
        openbtn.addActionListener(e -> open());
        getContentPane().add(openbtn);

        // JLabel savelabel = new JLabel("Save To");
        // savelabel.setBounds(290, 10, 100, 30);
        // getContentPane().add(savelabel);

        // savetext.setBounds(400, 10, 100, 30);
        // getContentPane().add(savetext);

        JButton savebtn = new JButton("Save");
        savebtn.setBounds(510, 10, 50, 30);
        savebtn.addActionListener(e -> save());
        getContentPane().add(savebtn);

        textField.setBounds(10, 50, getWidth() - 35, getHeight() - 100);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, getWidth()-35, getHeight()-100);
        scrollPane.setViewportView(textField);
        getContentPane().add(scrollPane);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int widths = (getWidth()-30) / 6;
                //openlabel.setBounds(10, 10, widths, 30);
                //opentext.setBounds(widths+10, 10, widths, 30);
                openbtn.setBounds(widths*2+10, 10, widths, 30);
                //savelabel.setBounds(widths*3+10, 10, widths, 30);
                //savetext.setBounds(widths*4+10, 10, widths, 30);
                savebtn.setBounds(widths*5+10, 10, widths, 30);
                textField.setBounds(10, 50, getWidth() - 35, getHeight() - 100);
                scrollPane.setBounds(10, 50, getWidth() - 35, getHeight() - 100);
            }
        });

        setVisible(true);
    }

    private void open() {
        FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile() == null) return;
        fileHandler.setInpath(fd.getDirectory() + fd.getFile());
        if(fileHandler.readfile()) textField.setText(fileHandler.getText());
        else textField.setText("Path Invalid");
    }

    private void save() {
        FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile() == null) return;
        fileHandler.setOutpath(fd.getFile());
        fileHandler.setText(textField.getText());
        if(fileHandler.savefile()) System.out.println("Success");
    }
}
