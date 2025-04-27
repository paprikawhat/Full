package src.Chapter_II.AWT.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class ImageFilterDemo extends Frame implements ActionListener {
    Image img, fImg, cImg;
    Label label;
    Button reset;
    BufferedImageFilter bif;
    String[] filters = {"GrayScale", "Invert", "Contrast", "Blur", "Sharpen"};
    public ImageFilterDemo() {
        Panel p = new Panel();
        add(p, BorderLayout.SOUTH);
        reset = new Button("Reset");
        reset.addActionListener(this);
        p.add(reset);
        for(String s : filters) {
            Button b = new Button(s);
            b.addActionListener(this);
            p.add(b);
        }
        label = new Label("");
        add(label, BorderLayout.NORTH);
        try {
            File fileImage = new File("coloredTV.jpg");
            img = ImageIO.read(fileImage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
class LoadedImage {
    private BufferedImage img;
    public LoadedImage(String path) {
        try {
            img = ImageIO.read(new File(path));
            int width = img.getWidth();
            int height = img.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return img;
    }

    public void applyFilter(BufferedImageOp filter) {
        img = filter.filter(img, null);
    }
}