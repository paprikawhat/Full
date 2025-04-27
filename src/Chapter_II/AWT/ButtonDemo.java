package src.Chapter_II.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo extends Frame implements ActionListener {
    String msg = "";
    Button yes, no, maybe;
    public ButtonDemo() {
        setLayout(new FlowLayout());
        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Maybe");
        add(yes);
        add(no);
        add(maybe);
        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Yes")) {msg = "You pressed yes";}
        else if(s.equals("No")) {msg = "You pressed no";}
        else {msg = "You pressed maybe";}
        repaint();
    }
    public void paint(Graphics g) {
        g.drawString(msg, 40,100);
    }
    public static void main(String[] args) {
        ButtonDemo bd = new ButtonDemo();
        bd.setSize(300, 200);
        bd.setTitle("Button demo");
        bd.setVisible(true);
    }
}

class ButtonList extends Frame implements ActionListener {
    String msg = "";
    Button[] bList = new Button[3];
    public ButtonList() {
        setLayout(new FlowLayout());
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Button maybe = new Button("Maybe");
        bList[0] = (Button) add(yes);
        bList[1] = (Button) add(no);
        bList[2] = (Button) add(maybe);
        for (int i = 0; i < 3; i++) {
            bList[i].addActionListener(this);
        }
        addWindowListener(new MyWindowAdapter());
    }
    public void actionPerformed(ActionEvent e) {
        for (Button button : bList) {
            if (e.getSource() == button) {
                msg = "You pressed " + button.getLabel();
            }
        }
        repaint();
    }
    public void paint(Graphics g) {
        g.drawString(msg, 60, 120);
    }

    public static void main(String[] args) {
        ButtonList bl = new ButtonList();
        bl.setSize(300,300);
        bl.setTitle("Button list");
        bl.setVisible(true);
    }
}