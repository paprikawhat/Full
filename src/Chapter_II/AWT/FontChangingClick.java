package src.Chapter_II.AWT;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FontChangingClick extends Frame {
    Font f;
    int next = 0;
    String msg;
    public FontChangingClick() {
        f = new Font("Dialog", Font.BOLD, 12);
        msg = "Dialog";
        setFont(f);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                next++;
                switch (next) {
                    case 0 -> {
                        f = new Font("Dialog", Font.PLAIN, 12);
                        msg = "Dialog";
                    }
                    case 1 -> {
                        f = new Font("DialogInput", Font.PLAIN, 12);
                        msg = "DialogInput";
                    }
                    case 2 -> {
                        f = new Font("SansSerif", Font.PLAIN, 12);
                        msg = "SansSerif";
                    }
                    case 3 -> {
                        f = new Font("Serif", Font.PLAIN, 12);
                        msg = "Serif";
                    }
                    case 4 -> {
                        f = new Font("Monospaced", Font.PLAIN, 12);
                        msg = "Monospaced";
                        next = -1;
                    }
                    default -> {
                        return;
                    }
                }
                repaint();
            }
        });
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        g.drawString(msg, 20, 60);
    }
    public static void main(String[] args) {
        FontChangingClick f = new FontChangingClick();
        f.setSize(300, 200);
        f.setTitle("Font clicker");
        f.setVisible(true);
    }

}
