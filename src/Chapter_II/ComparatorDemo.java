package src.Chapter_II;


import java.util.*;

class CompByLastName implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        //Защита от попытки присвоить Null
        if(!aStr.contains(" ") || !bStr.contains(" ")) {
            return aStr.compareToIgnoreCase(bStr);
        }
        int i, j , k;
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        if(k==0) {
            return aStr.compareToIgnoreCase(bStr);
        } else return k;
    }
}
class CompByFirstName implements Comparator<String> {
    public int compare(String aStr, String bStr) {
       return aStr.compareToIgnoreCase(bStr);
    }
}
class CompBySalary implements Comparator<Double> {
    public int compare (Double a, Double b) {
        return a.compareTo(b);
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        System.out.println("  *******************");
        Comparator<String> compByLastNameThenFirst =
                new CompByLastName().thenComparing(new CompByFirstName());
        TreeMap<String, Double> myTreeMap = new TreeMap<>(compByLastNameThenFirst);
        {
            myTreeMap.put("Alph Murz", 1900.0);
            myTreeMap.put("Sytastus Zoetghard", 4500.0);
            myTreeMap.put("Kont Jahoviche", 9100.0);
            myTreeMap.put("Bulk Murz", 1700.0);
            myTreeMap.put("Zoender Alz", 32000.0);
            myTreeMap.put("Yotie Kits", 2400.0);
            myTreeMap.put("Charles Lavas", 1800.0);
            myTreeMap.put("Dart Shiest", 5600.0);
            myTreeMap.put("Cloth Fault", 8800.0);
            myTreeMap.put("Synth Heilt", 4500.0);
            myTreeMap.put("Vard Vardensen", 9100.0);
            myTreeMap.put("Buk Quin", 1600.0);
            myTreeMap.put("Robert Alz", 900.0);
            myTreeMap.put("Bender Dots", 4300.0);
            myTreeMap.put("Gaven Shoes", 2500.0);
            myTreeMap.put("Bartolomey Est", 5000.0);
        }
        // Получение набора элементов
        Set<Map.Entry<String, Double>> set = myTreeMap.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.print(STR."\{me.getKey()}: $");
            System.out.println(me.getValue());
        }
        System.out.println("  *******************");
        double balanceOfBulk = myTreeMap.get("Bulk Murz");
        System.out.println(STR."New Bulk balance = \{balanceOfBulk + 1000}");
        System.out.println("  *******************");
        Comparator<String> mc = String::compareTo;
        TreeSet<String> treeSet = new TreeSet<>(mc.reversed());
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("E");
        treeSet.add("D");
        for (String e : treeSet) {
            System.out.println(STR."\{e} ");
        }
    }
}
