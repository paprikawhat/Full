package src.chapterTwo.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;


public class ExplicitChannelRead {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count;

        try (SeekableByteChannel fileChannel =
                     Files.newByteChannel(Path.of("file_1_ch2_IO.txt")))
        {
            ByteBuffer bb = ByteBuffer.allocate(128);
            do {
                count = fileChannel.read(bb);
                if (count != -1) {
                    bb.flip();
                    while (bb.hasRemaining()) {
                        System.out.print((char) bb.get());
                    }
                    bb.clear();
                }
            } while (count != -1);
        } catch (InvalidPathException | IOException e) {
            System.out.println(e.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("\n" + (end - start));
    }
}