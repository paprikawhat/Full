package src.algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array) {
        sortInternal(array, 0, array.length - 1);
    }
    public static void sortInternal(int[] array, int from, int to) {
        if (from < to) {
            int divide = partition(array, from, to);
            sortInternal(array, from, divide - 1);
            sortInternal(array, divide, to);
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
        int[] array = RandInt.createArray(100);
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
