package src.Chapter_II.AWT;

import java.awt.*;
import java.awt.event.*;

public class ResizeMe extends Frame {
    final int inc = 25;
    int max = 500;
    int min = 200;
    Dimension d;
    public ResizeMe() {
        d  = new Dimension(200, 200);
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int w = (d.width + inc) > max ? min : (d.width + inc);
                int h = (d.height + inc) > max ? min : (d.height + inc);
                d = new Dimension(w, h);
                setSize(d);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        // Класс Insets инкапсулирует размеры вставок окна с четырёх сторон
        Insets i = getInsets();
        d.getSize();
        g.drawLine(i.left, i.top, d.width - i.right, d.height - i.bottom);
        g.drawLine(i.left, d.height - i.bottom, d.width - i.right, i.top);
    }

    public static void main(String[] args) {
        ResizeMe resizeMe = new ResizeMe();
        resizeMe.setSize(200,200);
        resizeMe.setTitle("Resize me");
        resizeMe.setVisible(true);
    }
}
