package src.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BubbleSort {
    public static void sort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 10_000);
        }
        long end = System.currentTimeMillis();
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(end - start);
    }
}
