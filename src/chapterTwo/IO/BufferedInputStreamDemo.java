package src.chapterTwo.IO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String s = "One more and more and some -- &copy; -- much more string everywhere";
        byte[] buf = s.getBytes();
        ByteArrayInputStream bas = new ByteArrayInputStream(buf);
        int c;
        boolean marked = false;
        try (BufferedInputStream bin = new BufferedInputStream(bas)){
            while ((c = bin.read()) != -1) {
                switch (c) {
                    case '&' -> {
                        if (!marked) {
                            bin.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                    }
                    case ';' -> {
                        if (marked) {
                            marked = false;
                            System.out.print(" (c) ");
                        } else {
                            System.out.println((char) c);
                        }
                    }
                    case ' ' -> {
                        if (marked) {
                            marked = false;
                            bin.reset();
                            System.out.println("&");
                        } else {
                            System.out.print((char) c);
                        }
                    }
                    default -> {
                        if (!marked) System.out.print((char) c);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
