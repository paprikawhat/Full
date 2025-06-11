package src.chapterTwo.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        Path filePath = Path.of("file_NIO_write.txt");
        try (FileChannel fc = (FileChannel) Files.newByteChannel(Path.of("file_NIO_write.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING))
        {
            ByteBuffer bb = ByteBuffer.allocate(26);
            for (int i = 0; i < bb.capacity(); i++) {
                bb.put((byte) ('Z' + i));
            }
            bb.rewind();
            fc.write(bb);
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
