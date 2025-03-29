package src.Chapter_II.Collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

class RIntArray {
    private final int[] array;
    Random random = new Random();
    RIntArray(int size) {
        array = new int[size];
        for(int i =0; i < size; i++) { array[i] = new Random().nextInt(1, 2000); }
    }
    int[] getArray() {return array;}
    void setElement(int index, int element) {
        array[index] = element;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
    String display() {
        return Arrays.toString(array);
    }
}

public class ArraysClass {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in, System.console().charset() ));
        START:
        try {
            System.out.print("Please enter tne number of elements that you want array to contain: ");
            RIntArray rIntArray = new RIntArray(Integer.parseInt(bf.readLine()));
            if (rIntArray.getArray().length > 0) {
                System.out.println(rIntArray);
                Arrays.sort(rIntArray.getArray());
                System.out.println(rIntArray);
                Arrays.fill(rIntArray.getArray(), 2,3, Integer.parseInt(bf.readLine()));
                System.out.println(rIntArray);
            } else {
                System.out.println("Please enter positive number: ");
            }
        } catch (NumberFormatException | NegativeArraySizeException e) {
            System.out.println("Wrong enter!");
        }


    }
}
