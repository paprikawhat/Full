package src.Chapter_II;

import java.util.Calendar;
import java.util.Date;

public class DateClass {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        long mils = date.getTime();
        System.out.println(mils);
    }
}

class CalendarDemo {
    public static void main(String[] args) {
        String[] months = {"J", "F", "M", "A", "M", "Jn", "Jl", "Ag", "S", "O", "N", "D"};
        // Получение объекта календаря
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(months[calendar.get(Calendar.DATE)]);
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR));


    }
}