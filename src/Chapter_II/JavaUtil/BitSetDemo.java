package src.Chapter_II.JavaUtil;

import java.util.BitSet;

public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bs1 = new BitSet(16);
        BitSet bs2 = new BitSet(16);
        for (int i = 0; i < 16; i++) {
            if((i%2) == 0) bs1.set(i);
            if((i%3) == 0) bs2.set(i);
        }
        System.out.println("1: " + bs1);
        System.out.println("2: " + bs2);
        bs1.and(bs2);
        System.out.println("and: " + bs1);
        bs2.xor(bs1);
        System.out.println("xor: " + bs2);

    }
}
