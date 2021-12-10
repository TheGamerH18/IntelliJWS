package Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    String currentinput = "";
    ArrayList<Integer> zahlen = new ArrayList<>();

    JTextField output;

    public GUI() {
        setLayout(new GridLayout(4,4));
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton[] buttons = new JButton[15];

        JButton[] numbers = new JButton[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numbers[i] = new JButton(String.valueOf(i)) {{
                addActionListener(e -> inputnumbet(finalI));
            }};
        }

        int differ = 0;
        for(int i = 0; i < 13; i++) {
            if(i == 3) {
                buttons[i] = new JButton("+") {{
                    addActionListener(e -> setPlus());
                }};
                differ ++;
            }
            else if(i == 7) {
                buttons[i] = new JButton("-") {{
                    addActionListener(null);
                }};
                differ ++;
            }
            else if(i == 11) {
                buttons[i] = new JButton("/") {{
                    addActionListener(null);
                }};
                differ ++;
            }
            else if((i-differ) < numbers.length){
                buttons[i] = numbers[i -differ];
            }
        }

        buttons[13] = new JButton("*") {{
            addActionListener(null);
        }};

        buttons[14] = new JButton("=") {{
            addActionListener(e -> calc());
        }};

        for (JButton button : buttons) {
            if(button != null) add(button);
        }

        output = new JTextField();
        add(output);

        setVisible(true);
    }

    private String setTextfield(){
        StringBuilder stringBuilder = new StringBuilder();
        boolean hasvalue = false;
        for (int i = 0; i < zahlen.size(); i++) {
            stringBuilder.append(zahlen.get(i));
            if(i < zahlen.size() -1) stringBuilder.append("+");
            hasvalue = true;
        }
        if(!currentinput.equalsIgnoreCase("")) {
            if(hasvalue) stringBuilder.append("+");
            stringBuilder.append(currentinput);
        }
        return stringBuilder.toString();
    }

    private void inputnumbet(int value) {
        currentinput += String.valueOf(value);
        output.setText(setTextfield());
    }

    private void setPlus(){
        System.out.println("Plus");
        int currentnumber = 0;
        if(!currentinput.equalsIgnoreCase("")) currentnumber = Integer.parseInt(currentinput);
        else return;
        currentinput = "";
        zahlen.add(currentnumber);
    }

    private void calc() {
        setPlus();
        int value = 0;
        for (Integer integer : zahlen) {
            value += integer;
        }
        output.setText(String.valueOf(value));
        zahlen.clear();
        currentinput = "";
    }

    public static void main(String[] args) {
        new GUI();
    }
}
