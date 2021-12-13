package _20211213;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Menu extends JFrame {

    String Text = "";

    JTextArea textArea = new JTextArea() {{
        setBounds(0,0,500,500);
    }};

    private void save() {
        FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile() == null) return;
        String path = fd.getDirectory() + fd.getFile();
        Text = textArea.getText();
        if(savefile(path)) System.out.println("Success");
    }

    private void open() {
        FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile() == null) return;
        String path = fd.getDirectory() + fd.getFile();
        if(readfile(path)) textArea.setText(Text);
        else textArea.setText("Path Invalid");
    }


    public boolean savefile(String outpath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outpath))) {
            writer.write(Text);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean readfile(String inpath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inpath))) {
            StringBuilder string = new StringBuilder();
            while (reader.ready()) {
                string.append(reader.readLine());
                string.append("\n");
            }
            Text = string.toString();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Menu() {
        setBounds(new Rectangle(500, 500));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenu filemenu = new JMenu("File"){{
            add(new JMenuItem("Open") {{
                addActionListener(e -> open());
            }});
            add(new JMenuItem("Save") {{
                addActionListener(e -> save());
            }});
            add(new JMenuItem("Exit") {{
                addActionListener(e -> System.exit(1));
            }});
        }};
        JMenu editmenu = new JMenu("Edit"){{
            add(new JMenuItem("Cut") {{
                addActionListener(e -> textArea.cut());
            }});
            add(new JMenuItem("Copy") {{
                addActionListener(e -> textArea.copy());
            }});
            add(new JMenuItem("Paste") {{
                addActionListener(e -> textArea.paste());
            }});
            add(new JMenuItem("Select All") {{
                addActionListener(e -> textArea.selectAll());
            }});
        }};
        JMenu helpmenu = new JMenu("Help"){{
            add(new JMenuItem("No"));
        }};

        JMenuBar mb = new JMenuBar() {{
            add(filemenu);
            add(editmenu);
            add(helpmenu);
        }};

        add(textArea);
        setJMenuBar(mb);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
