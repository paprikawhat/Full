package src.Chapter_II.AWT;

import java.awt.*;

public class BorderLayoutDemo extends Frame {
    public BorderLayoutDemo() {
        add(new Button("Top"), BorderLayout.NORTH);
        add(new Button("Left"), BorderLayout.WEST);
        add(new Button("Right"), BorderLayout.EAST);
        add(new Label("Footer message"), BorderLayout.SOUTH);
        String msg = """
                The reasonable man adapts \
                himself to the world;
                the unreasonable one persists iп \
                trying to adapt the world to himself .
                There fore all progress depend s \
                on the unreasonable man.
                
                    - George Bernard Shaw""";
        add(new TextArea(msg), BorderLayout.CENTER);
        addWindowListener(new MyWindowAdapter());
    }
    // Для использования отступов
    public Insets getInsets() {
        return new Insets(40, 20,10,20);
    }
    public static void main(String[] args) {
        BorderLayoutDemo bld = new BorderLayoutDemo();
        bld.setSize(new Dimension(400,400));
        bld.setTitle("Border layout demo");
        bld.setVisible(true);
    }
}
