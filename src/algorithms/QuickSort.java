package src.algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }
    private static void sort(int[] array, int from, int to) {
        if (from < to) {
            int divider = partition(array, from, to);
            sort(array, from, divider - 1);
            sort(array, divider, to);
        }
    }
    private static int partition(int[] array, int from, int to) {
        int pivot = array[from + (to - from) / 2];
        int leftIndex = from;
        int rightIndex = to;
        while (leftIndex <= rightIndex ) {
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
    private static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static void main(String[] args) {
        int[] array = RandomIntArray.createArray(100);
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
