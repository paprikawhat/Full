package src.algorithms;

import java.util.Arrays;
import java.util.Random;

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
        int[] array = new int[100];
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1,1_000);
        }
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
