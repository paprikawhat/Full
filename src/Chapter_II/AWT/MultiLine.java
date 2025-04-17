package src.Chapter_II.AWT;

import java.awt.*;

public class MultiLine extends Frame {
    int curX=20, curY=40;
    String[] strArr = {"String number one.",
                       "String number two",
                       "String number three",
                       "String number four"};
    public MultiLine() {
        Font f = new Font("Dialog", Font.PLAIN, 12);
        setFont(f);
        addWindowListener(new MyWindowAdapter());
    }
    void sameLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s);
    }
    void nextLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        curX = 20;
        curY += fm.getHeight();
        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s);
    }
    public void paint(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        nextLine(strArr[0], g);
        sameLine(strArr[1], g);
        sameLine(strArr[2], g);
        nextLine(strArr[3], g);
        curX = 20; curY = 60;
    }
    public static void main(String[] args) {
        MultiLine ml = new MultiLine();
        ml.setSize(500,300);
        ml.setTitle("Multi line");
        ml.setVisible(true);
    }
}
