package src.Chapter_II.NIO;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {
    public static void main(String[] args) {
        try(FileChannel fc =
                    (FileChannel) Files.newByteChannel(Path.of("file_NIO_Write1.txt"),
                            StandardOpenOption.READ,
                            StandardOpenOption.WRITE,
                            StandardOpenOption.CREATE,
                            StandardOpenOption.TRUNCATE_EXISTING))
        {
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE,  0, 26);
            for (int i = 0; i < 26; i++) {
                mbb.put((byte) ('A' + i));
            }
            mbb.force();
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
