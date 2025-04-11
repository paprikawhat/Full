package src.Chapter_II.NIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {
    static void p(String s) {System.out.println(s);}
    public static void main(String[] args) {
        Path path = Path.of("file_NIO_Write.txt");
        String dirPath = "C:\\Users\\papri\\Full\\src\\Chapter_II";
        p("name: " + path.getName(0));
        p("path: " + path);
        p("absolute path: " + path.toAbsolutePath());
        p("parent: " + path.getParent());
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Path.of(dirPath))) {
            if(Files.exists(path) && Files.isHidden(path)) {
                p("file is hidden");
            } else {
                p("file is not hidden");
            }
            System.out.println();
            for (Path p : ds) {
                BasicFileAttributes bfa = Files.readAttributes(p, BasicFileAttributes.class);
                if(bfa.isDirectory()) {
                    p( p + " is a directory");
                } else p(p + " is a file");
                System.out.println("Size of file: " + bfa.size());
                System.out.println(bfa.lastAccessTime());
            }
        } catch (IOException e) {
            p(e.getMessage());
        }
    }
}
