package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdapterDemo extends Frame {
    String msg = "";
    public AdapterDemo() {
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        g.drawString(msg, 30, 80);
        g.fillRect(150,150,120,120);
    }
    public static void main(String[] args) {
        AdapterDemo demo = new AdapterDemo();
        demo.setSize(new Dimension(300, 300));
        demo.setTitle("Adapter demo");
        demo.setVisible(true);
    }
}
// Класс можно вложить в главный для упрощения присваивания значения и
// вызова метода не через ссылку, а напрямую
class MyMouseAdapter extends MouseAdapter {
    AdapterDemo adapterDemo;
    public MyMouseAdapter(AdapterDemo adapterDemo) {
        this.adapterDemo = adapterDemo;
    }
    public void mouseClicked(MouseEvent e) {
        adapterDemo.msg = "mouse clicked";
        adapterDemo.repaint();
    }
    public void mouseDragged(MouseEvent e) {
        adapterDemo.msg = "mouse dragged";
        adapterDemo.repaint();
    }
}