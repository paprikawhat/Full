package src.Chapter_II.IO;

import java.io.*;

class MyClass implements Serializable {
    String s;
    int i;
    boolean b;
    MyClass() {
        s = "Some string";
        i = 420;
        b = false;
    }
    MyClass(String s, int i, boolean b) {
        this.s = s;
        this.i = i;
        this.b = b;
    }

    @Override
    public String toString() {
        return STR."\{s} : \{i} : \{b}";
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("Serializable_IO")))
        {
            MyClass mc = new MyClass();
            MyClass mc2 = new MyClass("Str", 69, true);
            System.out.println("Mc: " + mc);
            oos.writeObject(mc);
            oos.writeObject(mc2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("Serializable_IO"))) {
            ObjectInputFilter oif =
                    ObjectInputFilter.Config.createFilter("MyClass; !*;maxbytes=80");
            ois.setObjectInputFilter(oif);
            MyClass mc3 = (MyClass) ois.readObject();
            MyClass mc4 = (MyClass) ois.readObject();
            System.out.println("Mc2: " + mc3);
            System.out.println("Mc3: " + mc4);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
