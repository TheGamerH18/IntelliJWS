package Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    String currentinput = "";
    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<Integer> operator = new ArrayList<>();

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
                    addActionListener(e -> setOperator('+'));
                }};
                differ ++;
            }
            else if(i == 7) {
                buttons[i] = new JButton("-") {{
                    addActionListener(e -> setOperator('-'));
                }};
                differ ++;
            }
            else if(i == 11) {
                buttons[i] = new JButton("/") {{
                    addActionListener(e -> setOperator('/'));
                }};
                differ ++;
            }
            else if((i-differ) < numbers.length){
                buttons[i] = numbers[i -differ];
            }
        }

        buttons[13] = new JButton("*") {{
            addActionListener(e -> setOperator('*'));
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
        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i));
            if(i < numbers.size() -1) stringBuilder.append((char) (int) operator.get(i));
            hasvalue = true;
        }
        if(!currentinput.equalsIgnoreCase("")) {
            if(hasvalue) stringBuilder.append((char) (int) operator.get(operator.size()-1));
            stringBuilder.append(currentinput);
        }
        return stringBuilder.toString();
    }

    private void inputnumbet(int value) {
        currentinput += String.valueOf(value);
        output.setText(setTextfield());
    }

    private void setOperator(char operator) {
        System.out.println(operator);
        validatecurrentinput();
        this.operator.add((int) operator);
    }

    private void calc() {
        try {
            validatecurrentinput();
            int value = numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {
                int usevalue = numbers.get(i);
                if(i-1 < operator.size()) {
                    switch(operator.get(i-1)) {
                        case((int) '+') -> value += usevalue;
                        case((int) '-') -> value -= usevalue;
                        case((int) '*') -> value *= usevalue;
                        case((int) '/') -> value /= usevalue;
                    }
                    System.out.println(value);
                }
            }
            output.setText(String.valueOf(value));
        } finally {
            numbers.clear();
            operator.clear();
            currentinput = "";
        }
    }

    private void validatecurrentinput() {
        int currentnumber = (!currentinput.equalsIgnoreCase("")) ? Integer.parseInt(currentinput) : 0;
        numbers.add(currentnumber);
        currentinput = "";
    }

    public static void main(String[] args) {
        new GUI();
    }
}
