package src.Exception;

public class NestTry {
    static void nestTry( int a ) {
        try {  // вложенный блок try
         /* Если и споль зуете один ар гумент командной строки , тогда
            исключение делени на ноль сгенерирует следующий код . */
            if (a == 1) a = a / (0); // деление на ноль
            /* Если используются два аргумента командной строки , тогда генерируете-'!
               исключение выхода за допустимые пределы индекса в массиве . */
            if (a == 2) {
                int[] с = {1};
                с[42] = 99; // генерирует исключение ArrayindexOutOfBoundsException
            }
        }
        catch(ArrayIndexOutOfBoundsException e ){
                System.out.println("Выход за допустимые пределы индекса в массиве : " + e);
        }
    }

    public static void main(String[] args){
        try {
            int a = args.length;
            /* Если аргументы командной строки отсутствуют, то следующий
               оператор сгенерирует исключение деления на ноль . */
            int b = 42 / a;
            System.out.println("а = " + a);
            nestTry(a);
        }
        catch (ArithmeticException e) {
            System.out.println("Дeлeниe на ноль: " + e);
        }
    }
}
