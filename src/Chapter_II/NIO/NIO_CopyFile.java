package src.Chapter_II.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
// Запуск из командной строки
public class NIO_CopyFile {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("to use: copy source-file destination-file");
            return;
        }
        try {
            Path source = Path.of(args[0]);
            Path destination = Path.of(args[1]);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
