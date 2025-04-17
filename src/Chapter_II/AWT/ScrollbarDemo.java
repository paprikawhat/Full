package src.Chapter_II.AWT;

import java.awt.*;
import java.awt.event.*;

public class ScrollbarDemo extends Frame implements AdjustmentListener {
    String msg = "";
    Scrollbar sbH, sbV;
    public ScrollbarDemo() {
        setLayout(new FlowLayout());
        sbH = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        sbH.setPreferredSize(new Dimension(100,20));
        sbV = new Scrollbar(Scrollbar.VERTICAL,0,1,0,200);
        sbV.setPreferredSize(new Dimension(20,100));
        add(sbH);
        add(sbV);
        sbH.addAdjustmentListener(this);
        sbV.addAdjustmentListener(this);
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX(), y = e.getY();
                sbH.setValue(x);
                sbV.setValue(y);
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        msg = "Horizontal: " + sbH.getValue();
        msg +=" Vertical: " + sbV.getValue();
        g.drawString(msg, 20, 160);
        g.drawString("*", sbH.getValue(), sbV.getValue());
    }
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        repaint();
    }
    public static void main(String[] args) {
        ScrollbarDemo sbd = new ScrollbarDemo();
        sbd.setSize(300, 300);
        sbd.setTitle("Scrollbar demo");
        sbd.setVisible(true);
    }
}
