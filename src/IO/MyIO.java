package src.IO;

import java.io.*;

public class MyIO {

}
class BRRead {
    public static void main(String[] args)  throws IOException {
        char c;
        // Использовать объект BufferedReader для чтения символов с консоли
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
        System.out.println("Вводите символы. q для выхода");
        do {
            c = (char) br.read(); // read() для чтения символов
            System.out.println(c);
        } while(c != 'q');
    }
}
class  BREReadLine {
    public static void main(String[] args) throws  IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
        System.out.println("Введите строки.");
        System.out.println("Для завершения введите stop");
        do {
            str = br.readLine(); // readLine() для чтения строк
            System.out.println(str);
        } while(!str.equals("stop"));
    }
}
class TinyEdit {
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
        String[] strArray = new String[100];
        System.out.println("Введите строки.\nДля завершения введите stop");
        // Заполнить массив прочтенными строками
        for(int i = 0; i < strArray.length; i++) {
            strArray[i] = bw.readLine();
            if(strArray[i].equals("stop")) break; // Прерывание цикла при совпадении
        }
        System.out.println("\nВот что вы ввели:");
        for (String s : strArray) {
            if (s.equals("stop")) break;
            System.out.println(s);
        }
    }
}
// Символьный класс PrintWriter для консольного вывода
class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("Текстовая строка");
        int i = -7;
        pw.println(i);
        double d =  0x3fd34a1;
        pw.println(d);
    }
}