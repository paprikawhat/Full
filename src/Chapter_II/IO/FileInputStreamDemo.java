package src.Chapter_II.IO;

import java.io.*;

class ByteArrayInputStreamReset {
    public static void main(String[] args) {
        String str = "How more times i'll have to rewrite those strings?";
        byte[] buf = str.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        for (int i = 0; i < 2; i++) {
            int c;
            while ((c = in.read()) != -1) {
                if(i==0) {
                    System.out.print((char) c);
                } else {
                    System.out.print(Character.toUpperCase((char) c));
                }
            }
            System.out.println();
            in.reset();
        }


    }
}

class FileInputStreamDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\papri\\Full\\tv.png");
        int size;
        try (FileInputStream f = new FileInputStream(file))
        {
            System.out.println("Available bytes: " + (size = f.available()));
            int n = size/1024;
            System.out.println("First " + n + " bytes");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }
            System.out.println("Still available: " + f.available());
            byte[] bytes = new byte[n];
            if(f.read(bytes) != n) {
                System.err.println("!!!  WRONG  !!!");
            }
            System.out.println(new String(bytes, 0, n));
            System.out.println("Still available: " + (f.available()));
            f.skip(size/2);
            System.out.println("After skip: " + f.available());
            System.out.println("More bytes: ");
            while (f.available() > 100000) System.out.print((char) f.read());
            System.out.println("\nTotal read:" + (size-f.available()) +"\n" + size);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
