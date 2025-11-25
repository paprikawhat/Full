package src.algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] array) {
        if (array == null || array.length <=1) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }
    // Метод для рекурсивного разделения массива
    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) / 2);
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }
    // Метод слияния двух отсортированных подмассивов
    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        System.arraycopy(array, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] < temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayOfRandom.createIntArray(100);
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
