package src.chapterTwo.NIO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        if(args.length != 1) {
            System.out.println("to use: ShowFile file-name");
            return;
        }
        try (InputStream fc =  Files.newInputStream(Path.of(args[0]))) {
            do {
                i = fc.read();
                if(i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
