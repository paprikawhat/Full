package src.chapterTwo.AWT.Image;

import src.chapterTwo.AWT.MyWindowAdapter;
import java.awt.*;
import java.awt.image.MemoryImageSource;

public class MemoryImageGenerator  extends Frame {
    Image img;
    int w = 512, h = 512;
    public MemoryImageGenerator() {
        int[] pixels = new int[w * h];
        int i = 0;
        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                int r = (x^y) & 0xff;
                int g = (x*2^y*2) & 0xff;
                int b = (x*4^y*4) & 0xff;
                pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }
        img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }

    public static void main(String[] args) {
        MemoryImageGenerator mig = new MemoryImageGenerator();
        mig.setSize(512, 512);
        mig.setTitle("Memory image generator");
        mig.setVisible(true);
    }

}
