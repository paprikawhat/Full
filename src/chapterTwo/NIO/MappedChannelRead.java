package src.chapterTwo.NIO;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class MappedChannelRead {
    public static void main(String[] args) {
        try (FileChannel fc = (FileChannel) Files.newByteChannel(Path.of("Full.iml")))
        {
            long size = fc.size();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, size);
            while (mbb.hasRemaining()) {
                System.out.print((char) mbb.get());
            }
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}