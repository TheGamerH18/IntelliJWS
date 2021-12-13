package Calculator;

import javax.swing.*;
import java.awt.*;

public class ExtendedView extends JPanel {

    Worker worker = new Worker();

    JTextField output = new JTextField() {{
        setPreferredSize(new Dimension(100000, 50));
    }};
    
    public ExtendedView() {
        JPanel gridlayout = new JPanel(new GridLayout(5, 5));

        add(output, BorderLayout.NORTH);
        add(gridlayout, BorderLayout.CENTER);
        setVisible(true);
    }
}
