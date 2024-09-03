package Exception;

public class Exc0 {
    public static void main ( String [ ] args ) {
        int d = 0;
        try {
            int a = 42 / d;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        }
    }
}
