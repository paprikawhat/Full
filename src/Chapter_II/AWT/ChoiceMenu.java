package src.Chapter_II.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceMenu extends Frame implements ItemListener {
    String msg = "";
    Choice os, browser;
    public ChoiceMenu() {
        setLayout(new FlowLayout());
        os = new Choice();
        browser = new Choice();
        os.add("Windows");
        os.add("Linux");
        os.add("Mac");
        os.add("Android");
        browser.add("Chrome");
        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Opera");
        add(os);
        add(browser);
        os.addItemListener(this);
        browser.addItemListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }
    public void paint(Graphics g) {
        msg = "Current OS: ";
        msg += os.getSelectedItem();
        g.drawString(msg, 20, 100);
        msg = "Current browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 20,120);
    }
    public static void main(String[] args) {
        ChoiceMenu cm = new ChoiceMenu();
        cm.setSize(300,300);
        cm.setTitle("Choice menu");
        cm.setVisible(true);
    }
}

class ListMenu extends Frame implements ActionListener {
    String msg = "";
    List os, browser;
    public ListMenu() {
        setLayout(new FlowLayout());
        os = new List(4, true);
        browser = new List(3);
        os.add("Windows");
        os.add("Linux");
        os.add("Mac");
        os.add("Android");
        browser.add("Chrome");
        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Opera");
        os.select(1);
        browser.select(0);
        add(os);
        add(browser);
        os.addActionListener(this);
        browser.addActionListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         repaint();
    }
    public void paint(Graphics g) {
        g.clearRect(0,100, getWidth(), 50);
        String[] selected = os.getSelectedItems();
        msg = "Current OS: ";
        for(String s : selected) {
            msg += s + " ";
            g.drawString(msg, 20, 120);
        }
        msg = "Current browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 20, 140);
    }

    public static void main(String[] args) {
        ListMenu lm = new ListMenu();
        lm.setSize(300,300);
        lm.setTitle("list menu");
        lm.setVisible(true);
    }
}