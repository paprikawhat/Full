package src.Chapter_II;


import java.util.*;

class MyComp implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j , k;
        // Небезопасный поиск кидает исключение при отсутствии пробела в строке
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        if(k==0) {
            return aStr.compareToIgnoreCase(bStr);
        } else return k;
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        System.out.println("  *******************");
        TreeMap<String, Double> myTreeMap = new TreeMap<>(new MyComp());
        myTreeMap.put("Alph Murz", 1900.0);
        myTreeMap.put("Sytastus Zoetghard", 4500.0);
        myTreeMap.put("Kont Jahoviche", 9100.0);
        myTreeMap.put("Bulk Murz", 1400.0);
        myTreeMap.put("Zoender Kiest", 2000.0);
        // Получение набора элементов
        Set<Map.Entry<String, Double>> set = myTreeMap.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.print(STR."\{me.getKey()} ");
            System.out.println(me.getValue());
        }
        System.out.println("  *******************");
        double balanceOfBulk = myTreeMap.get("Bulk Murz");
        System.out.println(STR."New balance = \{balanceOfBulk + 1000}");
        System.out.println("  *******************");
        Comparator<String> mc = String::compareTo;
        TreeSet<String> treeSet = new TreeSet<>(mc);
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("E");
        treeSet.add("D");
        for(String e : treeSet) {
            System.out.println(STR."\{e} ");
        }
    }
}
