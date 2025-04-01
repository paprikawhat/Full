package src.Chapter_II.IO;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "This is just a string to complete some space in case we need a string";
        byte[] buf = source.getBytes();
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;
        try {
            f0 = new FileOutputStream("file_1_ch2_IO.txt");
            f1 =  new FileOutputStream("file_2_ch2_IO.txt");
            f2 = new FileOutputStream("file_3_ch2_IO.txt");
            f0.write(buf);
            for (int i = 0; i < buf.length; i+=2)  f1.write(buf[i]);
            f2.write(buf, buf.length- buf.length/4, buf.length/4);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (f0 != null && f1 != null && f2 != null) {
                    f0.close();
                    f1.close();
                    f2.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

class FileOutputStreamDemo2 {
    public static void main(String[] args) {
        String source = "This is just a string to complete some space in case we need a string";
        byte[] buf = source.getBytes();
        try (FileOutputStream f0 = new FileOutputStream("file_11_ch2_IO.txt");
             FileOutputStream f1  = new FileOutputStream("file_21_ch2_IO.txt");
             FileOutputStream f2 = new FileOutputStream("file_31_ch2_IO.txt"))
        {
            f0.write(buf);
            for (int i = 0; i < buf.length; i += 2) f1.write(buf[i]);
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        String source = "This is just a string to complete some space in case we need a string";
        byte[] buf = source.getBytes();
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        try {
            bas.write(buf);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        try (FileOutputStream fos = new FileOutputStream("file_byteArray_IO")) {
            fos.write(bas.toByteArray());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(bas);
        System.out.println(Arrays.toString(bas.toByteArray()));
    }
}