package src.algorithms;

import java.util.Random;

public class ArrayOfRandom {
    static Random random = new Random();

    public static int[] createIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 100);
        }
        return array;
    }
    public static double[] createDoubleArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble(1, 100);
        }
        return array;
    }
}