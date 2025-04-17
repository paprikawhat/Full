package src.Chapter_II.AWT;

import java.awt.*;

public class LabelDemo extends Frame {
        public LabelDemo() {
            setLayout(new FlowLayout());
            Label one = new Label("One");
            Label two = new Label("Two");
            Label three = new Label("Three");
            add(one);
            add(two);
            add(three);
            addWindowListener(new MyWindowAdapter());
        }

    public static void main(String[] args) {
        LabelDemo ld = new LabelDemo();
        ld.setSize(300,100);
        ld.setTitle("Label demo");
        ld.setVisible(true);
    }

}
