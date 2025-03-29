package src.Chapter_II.Collections;

import java.util.Vector;

public class VectorClass {
    public static void main(String[] args) {
        Vector<Integer> myVector= new Vector<>(5,4);
        System.out.println("Size is: " + myVector.size());
        System.out.println("Capacity is: " + myVector.capacity());
        myVector.add(213);
        myVector.add(213);
        myVector.add(213);
        myVector.add(213);
        myVector.add(213);
        myVector.add(213);
        myVector.addElement(500);
        System.out.println("Size is: " + myVector.size());
        System.out.println("Capacity is: " + myVector.capacity());
    }
}
