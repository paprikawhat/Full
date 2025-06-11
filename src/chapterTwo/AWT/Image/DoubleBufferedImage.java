package src.chapterTwo.AWT.Image;

import src.chapterTwo.AWT.MyWindowAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DoubleBufferedImage extends Frame {
    int gap = 3;
    int mx, my;
    Image buffer = null;
    int w = 400, h = 400;
    boolean flicker = false;

    public DoubleBufferedImage() {
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = false;
                repaint();
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = true;
                repaint();
            }
        });
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        if(buffer == null) {
            buffer = createImage(w, h);
        }
        Graphics screenGC = null;
        if(!flicker) {
            screenGC = g;
            g = buffer.getGraphics();
        }
        g.setColor(Color.blue);
        g.fillRect(0,0, w, h);
        g.setColor(Color.white);
        for (int i = 0; i < w; i+=gap) {
            g.drawLine(i,0, w - i, h);
        }
        for (int i = 0; i < h; i+=gap) {
            g.drawLine(0, i, w, h - i);
        }
        g.setColor(Color.black);
        g.drawString("Press mouse button to double buffer", 80, h/2);
        g.setColor(Color.yellow);
        g.fillOval(mx - gap, my - gap, gap*2+1, gap*2+1);
        if(!flicker) {
            if(screenGC != null) {
                screenGC.drawImage(buffer, 0, 0, null);
            }
        }
    }
    public void update(Graphics g) {
        paint(g);
    }
    public static void main(String[] args) {
        DoubleBufferedImage dbi = new DoubleBufferedImage();
        dbi.setSize(400,400);
        dbi.setTitle("Double buffered image");
        dbi.setVisible(true);
    }
}
