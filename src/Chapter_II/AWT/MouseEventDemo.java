package src.Chapter_II.AWT;


import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener, MouseMotionListener {
       String msg = "";
       int mouseX = 0, mouseY = 0;
       public MouseEventDemo() {
              addMouseListener(this);
              addMouseMotionListener(this);
              addWindowListener(new MyWindowAdapter());
       }
       @Override
       public void mouseClicked(MouseEvent e) {
              msg = STR."\{msg}--click recived";
              repaint();
       }
       @Override
       public void mousePressed(MouseEvent e) {
              mouseX = e.getX();
              mouseY = e.getY();
              msg = "button down";
              repaint();
       }
       @Override
       public void mouseReleased(MouseEvent e) {
              mouseX = e.getX();
              mouseY = e.getY();
              msg = "button released";
              repaint();
       }
       @Override
       public void mouseEntered(MouseEvent e) {
              mouseX = 100;
              mouseY = 100;
              msg = "mouse entered";
              repaint();
       }
       @Override
       public void mouseExited(MouseEvent e) {
              mouseX = 100;
              mouseY = 100;
              msg = "mouse exited";
              repaint();
       }
       @Override
       public void mouseDragged(MouseEvent e) {
              mouseX = e.getX();
              mouseY = e.getY();
              msg = "* mouse at " + mouseX + ", " + mouseY;
              repaint();
       }
       @Override
       public void mouseMoved(MouseEvent e) {
              msg  = "moving mouse at " + e.getX() +", " + e.getY();
              repaint();
       }
       public void paint(Graphics g) {
              g.drawString(msg, mouseX, mouseY);
       }
       public static void main(String[] args) {
              MouseEventDemo med = new MouseEventDemo();
              med.setSize(new Dimension(300, 300));
              med.setTitle("Mouse event demo");
              med.setVisible(true);
       }
}
class MyWindowAdapter extends WindowAdapter {
       public void windowClosing(WindowEvent e) {
              System.exit(0);
       }
}
