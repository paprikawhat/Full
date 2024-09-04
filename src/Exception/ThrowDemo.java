package src.Exception;

public class ThrowDemo{
    static void demo() {
        try {
            throw new NullPointerException("Демонстрация.");
        }
        catch(NullPointerException e) {
            System.out.println("Прехвачено внутри demo().");
            throw e; // повторно сгенерировать исключение
        }
    }
    public static void main(String[] args) {
        try {
            demo();
        }
        catch(NullPointerException e) {
            System.out.println("Повторно перехвачено: " + e);
        }
    }

}
class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("Внутри throwOne().");
        throw new IllegalAccessException("Демонстрация");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println(" Перехвачено " + e);
        }
    }
}