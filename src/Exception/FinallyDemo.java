package src.Exception;

public class FinallyDemo {
    // Сгенерировать исключение в нутри метода .
    static void procA() {
        try {
            System.out.println("Внутри метода procA()");
            throw new RuntimeException("демонстрация");
        }
        finally {
            System.out.println("Блок finally метода procA()");
        }
    }
    // Возвратить управление изнутри блока try .
    static void procB() {
        try {
            System.out.println("Внутри метода procB ( ) ");
            return;
        } finally {
            System.out.println("Блок finally метода procB ()");
        }
    }
    // Выполнить блок try обычным образом .
    static void procC() {
        try {
            System.out.println("Внутри метода procC ( ) ");
        } finally {
            System.out.println("Блок finally метода procC().");
        }
    }
    public static void main( String[] args) {
        try {
            procA() ;
        } catch (Exception e) {
            System.out.println("Исключение перехвачено");
        }
        procB ();
        procC();
    }
}


