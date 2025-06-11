package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo extends Frame implements ActionListener {
    TextField name, pass;
    public TextFieldDemo() {
        setLayout(new FlowLayout());
        Label nameL = new Label("Name", Label.LEFT);
        Label passL = new Label("Pass", Label.RIGHT);
        name = new TextField(12);
        pass = new TextField(8);
        pass.setEchoChar('○');
        add(nameL);
        add(name);
        add(passL);
        add(pass);
        name.addActionListener(this);
        pass.addActionListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    public void paint(Graphics g) {
        g.drawString("Name: " + name.getText(), 20, 100);
        g.drawString("Selected text in name: " + name.getSelectedText(), 20, 120);
        g.drawString("Password: " + pass.getText(), 20, 140);
    }
    public static void main(String[] args) {
        TextFieldDemo tfd = new TextFieldDemo();
        tfd.setSize(400,300);
        tfd.setTitle("Text field demo");
        tfd.setVisible(true);
    }
}
