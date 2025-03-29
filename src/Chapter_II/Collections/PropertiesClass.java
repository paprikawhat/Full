package src.Chapter_II.Collections;

import java.io.*;
import java.util.Properties;
import java.util.Set;

class PhoneBook {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
        String name, number;
        boolean changed = false;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("phone-book.dat");
        } catch (FileNotFoundException e) {}
        try {
            if(fileInputStream != null) {
                ht.load(fileInputStream);
                fileInputStream.close();
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }
        do {
            System.out.print("\nEnter name(q to quit): ");
            name = br.readLine();
            if (name.equals("q")) continue;
            System.out.print("\nEnter number:");
            number = br.readLine();
            ht.setProperty(name, number);
            changed = true;
        } while (!name.equals("q"));
        if(changed) {
            FileOutputStream fileOutputStream = new FileOutputStream("phone-book.dat");
            ht.store(fileOutputStream, "Phone Book.");
            fileOutputStream.close();
        }
        do {
            System.out.print("Enter name to find(q to quit): ");
            name = br.readLine();
            if(name.equals("q")) continue;
            number = (String) ht.get(name);
            System.out.println(number);
        } while (!name.equals("q"));


    }
}


public class PropertiesClass {
    public static void main(String[] args) {
        Properties defCity = new Properties();
        defCity.setProperty("Московская область","Москва");
        defCity.setProperty("Ленинградская область","Санкт-Петербург");
        Properties cities = new Properties(defCity);
        cities.setProperty("Свердловская область","Екатеринбург");
        cities.setProperty("Самарская область","Самара");
        cities.setProperty("Тверская область","Тверь");
        cities.setProperty("Калужская область","Калуга");
        cities.setProperty("Волгоградская область","Волгоград");
        Set<?> states = cities.keySet();
        for(Object city : states) {
            System.out.println(STR."""
        [Регион: \{city}.Солица: \{cities.getProperty((String) city)}.]\
   """);
        }
        System.out.println();
        String str = cities.getProperty("Московская область","    ~!???~");
        String str2 = cities.getProperty("Киевская область","    ~!???~");
        System.out.println(str);
        System.out.println(str2);

    }
}
