package src.Chapter_II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

class MyBox {
    static  int boxCount = 1;
    private String name;
    private final float size;
    private boolean fragile;
    private float weight;
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.toString();
    }
    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }
    public void setWeight(float weight) { this.weight = weight; }
    public float getWeight() {
        return this.weight;
    }
    public float getPrice() {
        return (fragile ? size * 1.25F : size);
    }
    @Override
    public String toString() {
        return STR."\{name} \{getPrice()}";
    }
    MyBox() {
        Random random = new Random();
        this.setName("RB " + MyBox.boxCount);
        final int height = (random.nextInt(20, 40));
        final int width = (random.nextInt(20, 40));
        final int depth = (random.nextInt(40, 60));
        setWeight(random.nextFloat(1F,5));
        setFragile(random.nextBoolean());
        this.size = (height + width + depth) * weight;
    }
    MyBox(String name) {
        this();
        this.name = name;
    }
}
class Boxes {;
    ArrayList<MyBox> boxes = new ArrayList<>();
    float getPrice() {
        float price = 0;
        for(MyBox myBox : boxes) {
           price+=myBox.getPrice();
        }
        return price;
    }
    public void addNewRandomBox() {
        MyBox newRandomBox = new MyBox();
        boxes.add(newRandomBox);
        MyBox.boxCount++;
    }
    public void addNamedBox(String name) {
        boxes.add(new MyBox(name));
        MyBox.boxCount++;
    }
    public void removeBoxByName(String name) {
        for(MyBox box : boxes) {
            if(box.getName().equals(name)) {
                boxes.remove(box);
                MyBox.boxCount--;
            }
        }
    }
    public float getTotalWeight() {
        float result = 0;
        for(MyBox myBox : boxes) {
            result += myBox.getWeight();
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder boxesString = new StringBuilder();
        for(MyBox myBox : boxes) {
            boxesString.append(myBox.getName()).append(" ");
        }
        return boxesString.toString();
    }
    Boxes() {}
    Boxes(int numberOfBoxes) {
        this();
        if(numberOfBoxes > 0) {
            for (int i = numberOfBoxes; i > 0; i--) {
                this.addNewRandomBox();
            }
        } else return;
    }
}

public class Chapter_II {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in, System.console().charset()));
        long start = System.currentTimeMillis();
        Boxes myBoxes = new Boxes(Integer.parseInt(bufferedReader.readLine()));
        long end = System.currentTimeMillis();
        long es = end - start;
        float price = myBoxes.getPrice();
        float weight = myBoxes.getTotalWeight();
        System.out.printf("%s\n%.2f\n%.2f\n%d\n",myBoxes, price, weight, es);

    }
}
