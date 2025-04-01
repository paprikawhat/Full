package src.Chapter_II.IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackInputStreamReaderDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n";
        byte[] buf = s.getBytes();
        ByteArrayInputStream bin = new ByteArrayInputStream(buf);
        int c;
        try (PushbackInputStream pbs = new PushbackInputStream(bin);)
        {
            while ((c = bin.read()) != -1) {
                switch (c) {
                    case '=' -> {
                        if ((c = bin.read()) == '=') {
                            System.out.print(".eq.");
                        } else {
                            System.out.print("<- ");
                        }
                    }
                    default -> System.out.print((char) c);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
