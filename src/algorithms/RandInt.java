package src.algorithms;

import java.util.Random;

public class RandInt {
    public static int[] createArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 100);
        }
        return array;
    }
}
