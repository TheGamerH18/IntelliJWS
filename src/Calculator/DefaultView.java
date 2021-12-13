package Calculator;

import javax.swing.*;
import java.awt.*;

public class DefaultView extends JPanel {

    JTextField output;

    Worker worker = new Worker();

    public DefaultView() {
        JPanel gridpanel = new JPanel(new GridLayout(4, 4));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 10000));

        JButton[] buttons = new JButton[15];

        JButton[] numbers = new JButton[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numbers[i] = new JButton(String.valueOf(i)) {{
                addActionListener(e -> output.setText(worker.inputnumber(finalI)));
            }};
        }

        int differ = 0;
        for(int i = 0; i < 13; i++) {
            if(i == 3) {
                buttons[i] = new JButton("+") {{
                    addActionListener(e -> output.setText(worker.setOperator('+')));
                }};
                differ ++;
            }
            else if(i == 7) {
                buttons[i] = new JButton("-") {{
                    addActionListener(e -> output.setText(worker.setOperator('-')));
                }};
                differ ++;
            }
            else if(i == 11) {
                buttons[i] = new JButton("/") {{
                    addActionListener(e -> output.setText(worker.setOperator('/')));
                }};
                differ ++;
            }
            else if((i-differ) < numbers.length){
                buttons[i] = numbers[i -differ];
            }
        }

        buttons[13] = new JButton("*") {{
            addActionListener(e -> output.setText(worker.setOperator('*')));
        }};

        buttons[14] = new JButton("=") {{
            addActionListener(e -> output.setText(worker.calc()));
        }};

        for (JButton button : buttons) {
            if(button != null) gridpanel.add(button);
        }

        output = new JTextField() {{
            setPreferredSize(new Dimension(100000, 50));
        }};
        add(output, BorderLayout.NORTH);
        add(gridpanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
