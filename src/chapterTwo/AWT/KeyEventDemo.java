package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventDemo  extends Frame implements KeyListener {
    String msg = "";
    String state = "";
    public  KeyEventDemo() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    @Override
    public void keyPressed(KeyEvent e) {
        state = "key down";
        int k = e.getKeyCode();
        switch (k) {
            case KeyEvent.VK_F1 -> msg += "<F!>";
            case KeyEvent.VK_F2 -> msg += "<F2>";
            case KeyEvent.VK_LEFT -> msg += "<LEFT>";
            case KeyEvent.VK_RIGHT -> msg += "<RIGHT>";
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        state = "key up";
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(state, 20 , 50);
    }
    public static void main(String[] args) {
        KeyEventDemo ked = new KeyEventDemo();
        ked.setSize(new Dimension(300,300));
        ked.setTitle("Key event");
        ked.setVisible(true);
    }
}

