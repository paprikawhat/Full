package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.*;

public class XORGraphics extends Frame {
    int chsX = 100, chsY = 100;
    public XORGraphics() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                chsX = x - 10;
                chsY = y - 10;
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(20,40,60,70);
        g.setColor(Color.BLUE);
        g.fillRect(110,40,60,70);
        g.setColor(Color.BLACK);
        g.fillRect(200,40,60,70);
        g.setColor(Color.RED);
        g.fillRect(60,120,160,110);

        g.setXORMode(Color.YELLOW);
        g.drawLine(chsX-10, chsY,chsX+10, chsY);
        g.drawLine(chsX, chsY-10, chsX,chsY+10);
        g.setPaintMode();
    }

    public static void main(String[] args) {
        XORGraphics xorg = new XORGraphics();
        xorg.setSize(new Dimension(300,300));
        xorg.setTitle("XOR graphics");
        xorg.setVisible(true);
    }
}
