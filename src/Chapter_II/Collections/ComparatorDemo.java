package src.Chapter_II.Collections;


import org.jetbrains.annotations.NotNull;

import java.util.*;

class CompByLastName implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        // Защита от попытки присвоить Null значениям i и j при отсутствии пробела в строке
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
    public int compare(@NotNull String aStr, String bStr) {
       return aStr.compareToIgnoreCase(bStr);
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        System.out.println("  *******************");
        Comparator<String> compByLastNameThenFirst =
                new CompByLastName().thenComparing(new CompByFirstName());
        Map<String, Double> nameSalaryMap = new TreeMap<>(compByLastNameThenFirst);
        {
            nameSalaryMap.put("Alph Murz", 1900.0);
            nameSalaryMap.put("Sytastus Zoetghard", 4500.0);
            nameSalaryMap.put("Kont Jahoviche", 9100.0);
            nameSalaryMap.put("Bulk Murz", 1700.0);
            nameSalaryMap.put("Zoender Alz", 32000.0);
            nameSalaryMap.put("Yotie Kits", 2400.0);
            nameSalaryMap.put("Charles Lavas", 1800.0);
            nameSalaryMap.put("Dart Shiest", 5600.0);
            nameSalaryMap.put("Cloth Fault", 8800.0);
            nameSalaryMap.put("Synth Heilt", 4500.0);
            nameSalaryMap.put("Vard Vardensen", 9100.0);
            nameSalaryMap.put("Buk Quin", 1600.0);
            nameSalaryMap.put("Robert Alz", 900.0);
            nameSalaryMap.put("Bender Dots", 4300.0);
            nameSalaryMap.put("Gaven Shoes", 2500.0);
            nameSalaryMap.put("Bartolomey Est", 5000.0);
        }
        // Получение набора элементов карты
        Set<Map.Entry<String, Double>> set = nameSalaryMap.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": $");
            System.out.println(me.getValue());
        }
        System.out.println("  *******************");
        double balanceOfBulk = nameSalaryMap.get("Bulk Murz");
        System.out.println("New Bulk balance = " + (balanceOfBulk + 1000));
        System.out.println("  *******************");
        Comparator<String> mc = String::compareTo;
        TreeSet<String> treeSet = new TreeSet<>(mc.reversed());
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("E");
        treeSet.add("D");
        for (String e : treeSet) {
            System.out.println(e + " ");
        }
    }
}
