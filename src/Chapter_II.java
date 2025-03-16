package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

class MyBox {
    static  int boxCount;
    private String name;
    private final float size;
    private boolean fragile;
    private float weight;
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }
    public void setWeight(float weight) { this.weight = weight; }
    public float getWeight() {
        return this.weight;
    }
    public float getPrice() {
        return fragile ? size * 1.25F : size;
    }
    @Override
    public String toString() {
        return name;
    }
    MyBox() {
        Random random = new Random();
        this.setName("Random box " + MyBox.boxCount);
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
    int boxesCount = boxes.size();
    private float price;
    float getPrice() {
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
    public void removeBox(String name) {
        for(MyBox box: boxes) {
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
    Boxes(){
        price = getPrice();
    }
}

public class Chapter_II {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in, System.console().charset()));
        Boxes myBoxes = new Boxes();
        for(int i =0; i <100; i++){
            myBoxes.addNewRandomBox();
           // boxes.addNamedBox(bufferedReader.readLine());
        }
        float price = myBoxes.getPrice();
        float weight = myBoxes.getTotalWeight();
        System.out.printf("%s\n%.2f\n%.1f\n",myBoxes, price, weight);
        System.out.printf("%.2f", new MyBox("*TEST*").getPrice());
        /*
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
          p = r.exec("explorer"); // Выполнение стандартных команд
        } catch (Exception e) {
          System.out.println("AAAAA!!!!");
        }
        */
    }
}
