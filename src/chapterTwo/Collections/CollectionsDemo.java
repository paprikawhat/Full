package src.chapterTwo.Collections;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class CompareByAge implements Comparator<Cat> {
    public int compare(Cat cat1, Cat cat2) {
        if (cat2.age == cat1.age) return 0;
        return cat1.age > cat2.age ? 1 : -1;
    }
}

class Cat implements Comparable<Cat>{
    String color;
    int age;
    Cat(String color, int age){
        this.color = color;
        this.age = age;
    }
    public String toString() {
        return color + " is " + age + "y.o.";
    }

    @Override
    public int compareTo(@NotNull Cat cat) {
        if(Objects.equals(this.color, cat.color))  return 0;
        return this.color.compareTo(cat.color);
    }
}

public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println();
        long start = System.currentTimeMillis();
        LinkedList<Cat> cats = new LinkedList<>();
        {
            cats.add(new Cat("Ginger", 5));
            cats.add(new Cat("Black", 3));
            cats.add(new Cat("White", 4));
            cats.add(new Cat("Multi-colored", 1));
            cats.add(new Cat("Dog", 7));
            cats.add(new Cat("Yellow", 1));
            cats.add(new Cat("Grey", 8));
            cats.add(new Cat("Brown", 4));
        } // Заполнение листа кошек
        System.out.println(cats.get(2));
        System.out.println("UNSORTED: " + cats + "\n");

        cats.sort(Comparator.naturalOrder());
        System.out.println("SORTED BY COMPARE: " + cats);
        System.out.println();

        System.out.println("SORTED BY AGE: " + cats);
        System.out.println();

        Collections.sort(cats);
        System.out.println("SORTED AGAIN: " + cats + "\n");

        System.out.println("MAX AND MIN: " + Collections.max(cats) + " " + Collections.min(cats));
        System.out.println();
        // Spliterator
        Spliterator<Cat> catSpliterator = cats.spliterator();
        for(Cat cat : cats) catSpliterator.tryAdvance(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Milliseconds from start to end " + (end - start));
    }
}
