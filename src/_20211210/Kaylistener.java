package _20211210;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Kaylistener implements KeyListener {
    int posy = 0;
    int posx = 0;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isActionKey())
            System.exit(0);
        switch (e.getKeyChar()) {
            case 'w' -> {
                if(posy != 0){
                    posy --;
                }
            }
            case 'a' -> {
                if(posx != 0){
                    posx --;
                }
            }
            case  's' -> {
                if(posy != 2){
                    posy ++;
                }
            }
            case 'd' -> {
                if(posx != 2){
                    posx ++;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        Frame f = new Frame("Demo");
        f.setLayout(new FlowLayout());
        f.setSize(500, 500);
        Label l = new Label();
        l.setText("This is a demonstration");
        f.add(l);
        f.setVisible(true);

        Kaylistener k = new Kaylistener();
        f.addKeyListener(k);
    }
}
