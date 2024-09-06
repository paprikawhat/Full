package src.Enum;

public class Enum {
}
// Каждая константа списка является объектом класса в котором определен.
enum Apple {
    Red(20), Yellow(25), Sweet(40), Sour(25);
    private int price;
    int getPrice() {return price;}
    // Конструкторы для списка
    Apple(int p) {price = p;}
    Apple() {price = - 1;}
}
class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Все константы перечисления Apple: ");
        // Метод values() возвращает массив со списком констант.
        Apple[] allApples = Apple.values();
        for (Apple a : allApples) {
            System.out.println(a);
        }
        System.out.println();
        ap = Apple.valueOf("Red");
        System.out.println("ap содержит: " + ap);
    }
}
class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Все яблоки и цены:");
        for(Apple a : Apple.values()) {
            System.out.println("Яблоки " + a + " стоят " + a.getPrice() + " копеек.");

        }
    }
}
class EnumDemo3 {
    public static void main(String[] args) {
        Apple ap1, ap2, ap3;
        System.out.println("Все константы в Apple:");
        for(Apple a : Apple.values()) {
            System.out.println(a + " " + a.ordinal());
        }
        ap1 = Apple.Sweet;
        ap2 = Apple.Sour;
        ap3 = Apple.Sweet;
        System.out.println();
        if(ap1.compareTo(ap2) < 0) {
            System.out.println(ap1 + " находится перед " + ap2);
        }
        if(ap1.compareTo(ap2) > 0) {
            System.out.println(ap1 +  " находится после" + ap2);
        }
        if(ap1.compareTo(ap3) == 0) {
            System.out.println(ap1 + " равно " + ap3);
        }
        if(ap1.equals(ap2)){
            System.out.println("Это не будет выполнено");
        }
        if (ap1.equals(ap3)) {
            System.out.println(ap1 + " == " + ap3);
        }
    }
}
