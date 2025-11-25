package src.algorithms;

import java.util.Arrays;


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
        int[] array = ArrayOfRandom.createIntArray(100);
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
