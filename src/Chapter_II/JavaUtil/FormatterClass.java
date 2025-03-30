package src.Chapter_II.JavaUtil;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;
import java.util.Random;
class FormatterClass {
    public static void main(String[] args) {
        Random random = new Random();
        Formatter fmt = new Formatter();
        Calendar calendar = Calendar.getInstance();
        fmt.format("This is %s. This is for digits %d, %f    :    ", "for strings", 500, 100.5);
        System.out.println(fmt);
        fmt.format("%tr", calendar);
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format("New %x, %a, %tc ",random.nextInt(), random.nextDouble(), calendar);
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format("One more formated date %tl : %tM, %tb  %tB  %tm", calendar, calendar, calendar, calendar, calendar);
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format("%.2f, %12.2f, %012f", 27.99, 33.99,49.12345);
        System.out.println(fmt);
        fmt.close();
    }
}
// Флаги: - # + , ( 0
// Ссылки на аргументы через $ <
class FormatterClass2 {
    public static void main(String[] args) {
        Formatter fmt;
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i <= 10; i++) {
            fmt = new Formatter();
            fmt.format("%4d,%4d,%4d", i, i*i, i*i*i);
            System.out.println(fmt);
            fmt.close();
        }
        fmt = new Formatter();
        fmt.format(" %tD,\n %tF,\n %tR,\n %tT",calendar, calendar, calendar, calendar);
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format("%-,5.2f, %+,015.2f, %(d", 9876543.50, 123456.789, -400);
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format("%4.8s", "Why do you need to do this?");
        System.out.println(fmt);
        fmt.close();
    }
}

class FormatterClass3 {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        Calendar calendar = Calendar.getInstance(Locale.UK);
        fmt.format("\n %Hx \n %B \n %S,\n %1$d", 0xfffff, true, "This is just an example.");
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format("\n %3$+d,\n %1$s,\n %2$(f, \n %1$.6S","Example string", -4111.002, 899);
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format(" %d in hex looks like: %<x", 255);
        System.out.println(fmt);
        fmt.close();
        fmt = new Formatter();
        fmt.format(" Today is %te month %<tB %<tY, %<tT ", calendar);
        System.out.println(fmt);
        fmt.close();
        try (Formatter fmt2 = new Formatter()){
            fmt2.format(" %S, %tr", "Newest string ever!", calendar);
            System.out.println(fmt2);
        }
    }
}