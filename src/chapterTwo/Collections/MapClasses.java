package src.chapterTwo.Collections;

import java.util.*;

class HashMapDemo {
    static void main(String[] args) {

        HashMap<String, Double> hm = new HashMap<>();
        hm.put("John James", 32.1);
        hm.put("Jin Jay", 31.7);
        hm.put("James J", 35.1);
        hm.put("Jolly James", 15.6);
        hm.put("Jakob James", 23.1);

        Hashtable<String, Double> ht = new Hashtable<>(5,0.6f);
        ht.put("John James", 32.1);
        ht.put("Jin Jay", 31.7);
        ht.put("James J", 35.1);
        ht.put("Jolly James", 15.6);
        ht.put("Jakob James", 23.1);

        Set<Map.Entry<String, Double>> set = hm.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        Set<String> htNameSet = ht.keySet();
        Iterator<String> stringIterator = htNameSet.iterator();
        for(String s : htNameSet.toArray(new String[0])) {
            System.out.println(s + "       ~W|W|W~");
        }
        System.out.println();
        // Получение доступа к значению ключа через присваивание ссылки.
        double balance1 = hm.get("Jin Jay");
        double balance2 = ht.get("Jolly James");
        hm.put("Jin Jay", balance1 + 1000.0);
        ht.put("Jolly James", balance2 + 1000.0);
        System.out.println("Jin Jay: " + hm.get("Jin Jay"));
        System.out.println("Jolly James: " + ht.get("Jolly James"));
        System.out.println(hm);
    }
}

public class MapClasses {
}
