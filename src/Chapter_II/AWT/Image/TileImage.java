package src.Chapter_II.AWT.Image;

import src.Chapter_II.AWT.MyWindowAdapter;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

public class TileImage extends Frame {
    Image img;
    Image[] cells = new Image[4*4];
    int iw, ih, tw, th;
    public TileImage() {
        try {
            File imageFile = new File("coloredTV.jpg");
            img = ImageIO.read(imageFile);
            iw = img.getWidth(null);
            ih = img.getHeight(null);
            tw = iw/4;
            th = ih/4;
            CropImageFilter f;
            FilteredImageSource fis;
            for(int y = 0; y < 4; y++) {
                for(int x = 0; x< 4; x++) {
                    f = new CropImageFilter(tw*x, th*y, tw, th);
                    fis = new FilteredImageSource(img.getSource(), f);
                    int i = y*4+x;
                    cells[i] = createImage(fis);
                }
            }
            for(int i = 0; i < 32; i++) {
                int si = (int) (Math.random() * 16);
                int di = (int) (Math.random() * 16);
                Image tmp = cells[si];
                cells[si] = cells[di];
                cells[di] = tmp;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g) {
        for(int y = 0; y < 4; y++) {
            for( int x = 0; x < 4; x++) {
                g.drawImage(cells[y*4+x], x * tw + getInsets().left,
                        y * th + getInsets().top, null);
            }
        }
    }

    public static void main(String[] args) {
        TileImage ti = new TileImage();
        ti.setSize(ti.img.getWidth(null) + ti.getInsets().left + ti.getInsets().right,
                ti.img.getHeight(null) + ti.getInsets().top + ti.getInsets().bottom);
        ti.setTitle("Tiled image");
        ti.setVisible(true);
    }
}
