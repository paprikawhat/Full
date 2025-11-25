package src.algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current ) {
                array[j+1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array = ArrayOfRandom.createIntArray(100);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println(end - start);
    }
}
