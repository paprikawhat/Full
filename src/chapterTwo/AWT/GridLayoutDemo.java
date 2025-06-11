package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutDemo extends Frame implements ActionListener {
    static final int n = 4;
    Button[] buttons = new Button[16];
    String msg = "";
    public GridLayoutDemo() {
        setLayout(new GridLayout(n, n, 3,3));
        setFont(new Font("ComicSans", Font.BOLD, 24));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if(k > 0) {
                    buttons[j] = (Button) add(new Button("" + k));
                    buttons[j].addActionListener(this);
                }
            }
        }
        addWindowListener(new MyWindowAdapter());
    }
    public void actionPerformed(ActionEvent e) {
        for(Button b : buttons) {
            if(b == e.getSource()) {
                msg = "You pressed " + b.getLabel();
            }
        }
        repaint();
    }
    public void paint(Graphics g) {
        g.drawString(msg, 250,280);
    }
    public static void main(String[] args) {
        GridLayoutDemo gld = new GridLayoutDemo();
        gld.setSize(new Dimension(300,300));
        gld.setVisible(true);
    }
}
