package src.chapterTwo.NIO;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public @NotNull FileVisitResult visitFile(Path file, @NotNull BasicFileAttributes attrs) {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}

public class DirVisitor {
    public static void main(String[] args) {
        String dirPath = "C:\\Users\\papri\\Full\\src\\Chapter_II";
        try {
            Files.walkFileTree(Path.of(dirPath), new MyFileVisitor());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
