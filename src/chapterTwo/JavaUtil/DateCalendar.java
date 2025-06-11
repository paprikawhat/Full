package src.chapterTwo.JavaUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class DateClass {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        long mils = date.getTime();
        System.out.println(mils);
    }
}

class CalendarDemo {
    public static void main(String[] args) {
        String[] months = {"Ja", "Fb", "Mr", "Ap", "Ma", "Jn", "Jl", "Ag", "Sp", "Ok", "Nv", "Dc"};
        int year;
        // Получение объекта календаря
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(months[calendar.get(Calendar.MONTH)]);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println("TIME : " + Calendar.HOUR + ":" + Calendar.MINUTE + ":" + Calendar.SECOND);
        calendar.set(Calendar.HOUR, 7);
        calendar.set(Calendar.MINUTE, 22);
        calendar.set(Calendar.SECOND, 22);
        System.out.println("TIME : " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(year = gregorianCalendar.get(Calendar.YEAR));
        if ((gregorianCalendar.isLeapYear(year))) {
            System.out.println("Its a leap year!");
        } else {
            System.out.println("Its not leap year!");
        }
    }
}