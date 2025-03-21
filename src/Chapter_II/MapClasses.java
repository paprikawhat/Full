package src.Chapter_II;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class HashMapDemo {
    static void main(String[] args) {
        HashMap<String, Double> hm = new HashMap<>();
        hm.put("John James", 32.1);
        hm.put("Jin Jay", 31.7);
        hm.put("James J", 35.1);
        hm.put("Jolly James", 15.6);
        hm.put("Jakob James", 23.1);

        Set<Map.Entry<String, Double>> set = hm.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.print(STR."\{me.getKey()}: ");
            System.out.println(me.getValue());
        }
        System.out.println();
        double balance1 = hm.get("Jin Jay");
        double balance2 = hm.get("Jolly James");
        hm.put("Jin Jay", 60.0);
        hm.put("Jolly James", balance2 + 1000.0);
        System.out.println(STR."Jin Jay: \{hm.get("Jin Jay")}");
        System.out.println(STR."Jolly James: \{hm.get("Jolly James")}");
        System.out.println(hm.toString());
    }
}



public class MapClasses {
}
