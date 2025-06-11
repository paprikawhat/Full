package src.chapterTwo.AWT;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardLayoutDemo extends Frame {
    Checkbox Windows10, Windows7, Android, Linux, Mac;
    Panel cardsPanel;
    CardLayout cardLayout;
    Button win, other;
    CheckboxGroup cbg;
    public CardLayoutDemo() {
        setLayout(new FlowLayout());
        win = new Button("Windows");
        other = new Button("Other");
        add(win);
        add(other);
        cardLayout = new CardLayout();
        cardsPanel = new Panel();
        cardsPanel.setLayout(cardLayout);
        cbg = new CheckboxGroup();
        Windows7 = new Checkbox("Windows7", cbg,true);
        Windows10 = new Checkbox("Windows10", cbg,false);
        Android = new Checkbox("Android", cbg,false);
        Linux = new Checkbox("Linux", cbg,false);
        Mac = new Checkbox("Mac", cbg,false);
        Panel winPan = new Panel();
        winPan.add(Windows7);
        winPan.add(Windows10);
        Panel otherPan = new Panel();
        otherPan.add(Linux);
        otherPan.add(Android);
        otherPan.add(Mac);
        cardsPanel.add(winPan, "Windows");
        cardsPanel.add(otherPan, "Other");
        add(cardsPanel);
        win.addActionListener((e -> cardLayout.show(cardsPanel, "Windows")));
        other.addActionListener((e -> cardLayout.show(cardsPanel, "Other")));
        addWindowListener(new MyWindowAdapter());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.next(cardsPanel);
            }
        });
    }

    public static void main(String[] args) {
        CardLayoutDemo cld = new CardLayoutDemo();
        cld.setSize(300,300);
        cld.setVisible(true);
    }

}
