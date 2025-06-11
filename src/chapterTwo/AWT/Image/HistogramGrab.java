package src.chapterTwo.AWT.Image;

import src.chapterTwo.AWT.MyWindowAdapter;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

public class HistogramGrab extends Frame {
    Image img;
    int iw, ih;
    int[] pixels;
    int[] hist = new int[256];
    int max_hist = 0;
    Insets ins;
    public HistogramGrab() {
        try {
            File imgFile = new File("an.jpg");
            img = ImageIO.read(imgFile);
            iw = img.getWidth(null);
            ih = img.getHeight(null);
            pixels = new int[iw * ih];
            PixelGrabber pg = new PixelGrabber(img,0,0, iw, ih, pixels,0,iw);
            pg.grabPixels();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage() + "Interrupted");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Failed reading file");
            System.exit(0);
        }
        for(int p : pixels) {
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & (p);
            int y = (int) (.33*r +.56*g +.11*b);
            hist[y]++;
        }
        for(int j : hist) {
            if (j > max_hist) {
                max_hist = j;
            }
        }
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        ins = getInsets();
        g.drawImage(img, ins.left, ins.top, null);
        int barWidth = iw / hist.length;
        int lasty = ih - (ih * hist[0] / max_hist);
        for (int i = 0; i < hist.length; i++) {
            int x = i * barWidth;
            int y = ih - (ih * hist[i] / max_hist);
            g.setColor(new Color(i,i,i));
            g.fillRect(x + ins.left, y + ins.top, barWidth, ih - y);
            g.setColor(Color.RED);
            g.drawLine((x - 1) + ins.left, lasty + ins.top, x + ins.left, y + ins.top);
            lasty = y;
        }
    }

    public static void main(String[] args) {
        HistogramGrab hg = new HistogramGrab();
        hg.setSize(hg.img.getWidth(null),hg.img.getHeight(null));
        hg.setTitle("Histogram grab");
        hg.setVisible(true);
    }
}
