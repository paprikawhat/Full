package src.Chapter_II.AWT.Image;

import src.Chapter_II.AWT.MyWindowAdapter;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SimpleImageLoad extends Frame {
    Image img;
    public SimpleImageLoad() {
        try {
            File imgFile = new File("coloredTV.jpg");
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }
    public static void main(String[] args) {
        SimpleImageLoad sml = new SimpleImageLoad();
        sml.setSize(sml.img.getWidth(null) + sml.getInsets().left + sml.getInsets().right,
                    sml.img.getHeight(null) + sml.getInsets().top + sml.getInsets().bottom);
        sml.setTitle("Image load demo");
        sml.setVisible(true);
    }
}
