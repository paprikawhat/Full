package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxDemo extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, linux, mac, android;
    CheckboxGroup cbg;
    public CheckBoxDemo() {
        setLayout(new FlowLayout());
        cbg = new CheckboxGroup();
        windows = new Checkbox("Windows", cbg,true);
        linux = new Checkbox("Linux", cbg, false);
        mac = new Checkbox("Mac", cbg,false);
        android = new Checkbox("Android", cbg, false);
        add(windows);
        add(linux);
        add(mac);
        add(android);
        windows.addItemListener(this);
        linux.addItemListener(this);
        mac.addItemListener(this);
        android.addItemListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        msg = "Current state: ";
        msg += cbg.getSelectedCheckbox().getLabel();
        g.drawString(msg,30, 100);

    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }
    public static void main(String[] args) {
        CheckBoxDemo cbd = new CheckBoxDemo();
        cbd.setSize(300,300);
        cbd.setTitle("Checkbox demo");
        cbd.setVisible(true);
    }
}
