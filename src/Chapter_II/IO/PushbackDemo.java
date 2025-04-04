package src.Chapter_II.IO;

import java.io.*;

public class PushbackDemo {
    public static void main(String[] args) {

        String s = "if (a == 4) a = 0;\n";

        byte[] buf = s.getBytes();
        ByteArrayInputStream bin = new ByteArrayInputStream(buf);
        int c;
        try (PushbackInputStream pbs = new PushbackInputStream(bin))
        {
            while ((c = bin.read()) != -1) {
                if (c == '=') {
                    if ((c = bin.read()) == '=') {
                        System.out.print(".eq.");
                    } else {
                        System.out.print("<-");
                    }
                } else {
                    System.out.print((char) c);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        CharArrayReader car = new CharArrayReader(chars);
        int c1;
        try(PushbackReader pbr = new PushbackReader(car)) {
            while ((c1 = pbr.read()) != -1) {
                if (c1 == '=') {
                    if (pbr.read() == '=') {
                        System.out.print(".eq.");
                    } else {
                        System.out.print("<-");
                    }
                } else {
                    System.out.print((char) c1);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
