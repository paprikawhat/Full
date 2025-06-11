package src.chapterTwo.IO;

import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileReaderDemo {
    public static void main(String[] args) {
        String path = "C:\\Users\\papri\\Full\\src\\Chapter_II\\IO\\FileReaderWriter.java";
        try(FileReader fr = new FileReader(path)) {
            int c;
            while((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
class FileWriterDemo {
    public static void main(String[] args) {
        String str = "OMG not again! Another one string!";
        char[] chars = new char[str.length()];
        str.getChars(0, str.length(), chars, 0);
        try (FileWriter fr1 = new FileWriter("file1_RW_IO");
             FileWriter fr2 = new FileWriter("file2_RW_IO");
             FileWriter fr3 = new FileWriter("file3_RW_IO"))
        {
            fr1.write(chars);
            fr2.write(str + "   !!!   Injected string   !!!");
            fr3.write(chars, chars.length/2, chars.length/2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int i;
        try (CharArrayReader cr = new CharArrayReader(chars)) {
            while((i = cr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}