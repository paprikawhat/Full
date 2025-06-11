package src.chapterTwo.Collections;

import java.util.Arrays;
import java.util.Random;

public class ArrayClass2 {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000, 7999);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Arrays.fill(array, 3,4, Integer.parseInt("3500"));
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        int search = Arrays.binarySearch(array, 3500);
        System.out.println(search);
    }
}
