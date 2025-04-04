package src.Chapter_II.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        try (SeekableByteChannel fileChannel =
                     Files.newByteChannel(Path.of("file_1_ch2_IO.txt")))
        {
            ByteBuffer bb = ByteBuffer.allocate(128);
            do {
                count = fileChannel.read(bb);
                if (count != -1) {
                    bb.rewind();
                    for (int i = 0; i < count; i++)
                        System.out.print((char) bb.get());
                }
            } while (count != -1);
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
