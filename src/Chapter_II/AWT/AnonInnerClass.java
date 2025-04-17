package src.Chapter_II.AWT;

import java.awt.*;
import java.awt.event.*;

public class AnonInnerClass extends Frame {
    String msg = "";
    public AnonInnerClass() {
        // Внутренний анонимный класс для обработки событий мыши
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                msg = "mouse pressed on X: " + e.getX() +", Y: " + e.getY();
                repaint();
            }
            public void mouseReleased(MouseEvent e) {
                msg = "mouse release on X: " + e.getX() + ", Y: " + e.getY();
                repaint();
            }
        });
        // Ещё один анонимный класс для обработки событий окна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, 20, 60);
    }
    public static void main(String[] args) {
        AnonInnerClass demo = new AnonInnerClass();
        demo.setSize(300,200);
        demo.setTitle("Anon inner class demo");
        demo.setVisible(true);
    }
}
